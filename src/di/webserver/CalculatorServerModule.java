package di.webserver;

import org.mortbay.jetty.Server;
import org.mortbay.jetty.bio.SocketConnector;

import com.google.inject.AbstractModule;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;

public class CalculatorServerModule extends AbstractModule {

  static class ServerProvider implements Provider<Server> {
    @Inject CalculatorServlet calculatorServlet;
    @Inject TimeServlet timeServlet;
    private Server server = new Server();
    public Server get() {

      SocketConnector socketConnector = new SocketConnector();
      socketConnector.setPort(8080);
      server.addConnector(socketConnector);

      new ServletBuilder(server)
        .addServlet("/calc", calculatorServlet)
        .addServlet("/time", timeServlet);

      return server;
    }

  }

  public CalculatorServerModule(String...args) {
  }

  @Override
  protected void configure() {
    bind(Server.class).toProvider(ServerProvider.class).in(Singleton.class);
  }

}
