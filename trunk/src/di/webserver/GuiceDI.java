package di.webserver;

import org.mortbay.jetty.Server;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class GuiceDI {

  public static void main(String[] args) throws Exception {
    Injector injector = Guice.createInjector(new CalculatorServerModule(args));
    Server server = injector.getInstance(Server.class);
    server.start();
  }
  
}
