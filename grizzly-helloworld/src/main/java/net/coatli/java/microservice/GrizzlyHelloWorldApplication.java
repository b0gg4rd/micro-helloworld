package net.coatli.java.microservice;

import java.io.IOException;

import org.glassfish.grizzly.http.server.HttpHandler;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.grizzly.http.server.Request;
import org.glassfish.grizzly.http.server.Response;

public class GrizzlyHelloWorldApplication {

  public static void main(final String[] args) throws IOException {

    final HttpServer server = HttpServer.createSimpleServer();
    server.getServerConfiguration().addHttpHandler(new HttpHandler() {
      @Override
      public void service(final Request request, final Response response) throws Exception {
          response.getWriter().write("Hello World!");
      }
    }, "/");
    server.start();
    System.out.println("Press any key to stop the server...");
    System.in.read();
  }

}
