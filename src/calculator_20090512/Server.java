package calculator_20090512;

import org.mortbay.jetty.Handler;
import org.mortbay.jetty.servlet.ServletHandler;
import org.mortbay.jetty.servlet.ServletHolder;

public class Server {

  private org.mortbay.jetty.Server server;

  public boolean isHealthy() {
    return true;
  }

  public void start(int port) throws Exception {
    server = new org.mortbay.jetty.Server(port);
    ServletHandler servletHandler = new ServletHandler();
    servletHandler.addServletWithMapping(
        new ServletHolder(new HealthServlet()), "/healthz");
    servletHandler.addServletWithMapping(
        new ServletHolder(new CalculatorServlet()), "/calc");
    server.addHandler(servletHandler);
    server.start();
  }

  public void stop() throws Exception {
    server.stop();
    
  }
  
}
