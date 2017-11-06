package net.coatli.java.microhelloworld;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.AbstractHandler;

public class JettyHelloWorldApplication extends AbstractHandler {

  @Override
  public void handle(final String target,
                     final Request baseRequest,
                     final HttpServletRequest request,
                     final HttpServletResponse response)
      throws IOException, ServletException {

    response.setContentType("text/plain");
    response.setStatus(HttpServletResponse.SC_OK);
    baseRequest.setHandled(true);
    response.getWriter().println("Hello World");
  }

  public static void main(final String[] args) throws Exception {
    final Server server = new Server(8080);
    server.setHandler(new JettyHelloWorldApplication());
    server.start();
    server.join();
  }

}
