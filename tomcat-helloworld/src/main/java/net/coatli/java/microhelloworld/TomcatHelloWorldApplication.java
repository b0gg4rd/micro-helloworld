package net.coatli.java.microhelloworld;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

public class TomcatHelloWorldApplication {

  public static void main(final String[] args) throws LifecycleException {

    final Tomcat tomcat = new Tomcat();
    tomcat.setPort(8080);

    final Context context = tomcat.addContext("", new File(".").getAbsolutePath());

    Tomcat.addServlet(context, "helloworld", new HttpServlet() {

      private static final long serialVersionUID = 7247048349189525846L;

      @Override
      protected void service(final HttpServletRequest req, final HttpServletResponse resp)
          throws ServletException, IOException {
        resp.getWriter().write("Hello World");
        resp.getWriter().flush();
      }

    });

    context.addServletMappingDecoded("/", "helloworld");

    tomcat.start();
    tomcat.getServer().await();
  }
}
