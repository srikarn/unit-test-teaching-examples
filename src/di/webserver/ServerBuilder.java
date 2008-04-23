package di.webserver;

import java.util.Date;

import org.mortbay.jetty.Server;
import org.mortbay.jetty.bio.SocketConnector;

import com.google.inject.Provider;

public class ServerBuilder {


  public ServerBuilder(String... args) {
  }

  public Server buildServer() {
    Server server = new Server();

    SocketConnector socketConnector = new SocketConnector();
    socketConnector.setPort(8080);
    server.addConnector(socketConnector);

    new ServletBuilder(server)
      .addServlet("/calc", new CalculatorServlet(new Calculator()))
      .addServlet("/time", new TimeServlet(new Provider<Date>() {
        public Date get() {
          return new Date();
        }
      }));

    return server;
  }

}
