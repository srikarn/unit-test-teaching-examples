package di.webserver;

import org.mortbay.jetty.Server;

public class ManualDI {
    public static void main(String[] args) throws Exception {
      Server server = new ServerBuilder(args).buildServer();
      server.start();
    }
}
