package di.webserver;

import javax.servlet.Servlet;

import org.mortbay.jetty.Server;
import org.mortbay.jetty.servlet.ServletHandler;
import org.mortbay.jetty.servlet.ServletHolder;

public class ServletBuilder {

  private final ServletHandler servletHandler;

  public ServletBuilder(Server server) {
    servletHandler = new ServletHandler();
    server.addHandler(servletHandler);
  }

  public ServletBuilder addServlet(String path, Servlet servlet) {
    servletHandler.addServletWithMapping(new ServletHolder(servlet), path);
    return this;
  }


}
