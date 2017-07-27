package net.coatli.java.microservice;

import ro.pippo.core.Application;
import ro.pippo.core.Pippo;

public class PippoHelloWorldApplication extends Application {

  public static void main(final String[] args) {

    new Pippo(new PippoHelloWorldApplication()).start();;

  }

  @Override
  protected void onInit() {

    GET("/", (routeContext) -> routeContext.send("Hello World!"));

  }

}
