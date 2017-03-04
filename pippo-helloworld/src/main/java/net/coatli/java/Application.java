package net.coatli.java;

import ro.pippo.core.Pippo;

public class Application {

  public static void main(String[] args) {

    Pippo pippo = new Pippo();
    pippo.GET("/", (routeContext) -> routeContext.send("Hello World!"));
    pippo.start();

  }
}

