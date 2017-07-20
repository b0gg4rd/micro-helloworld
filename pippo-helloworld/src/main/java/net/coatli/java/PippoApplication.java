package net.coatli.java;

import ro.pippo.core.Application;
import ro.pippo.core.Pippo;

public class PippoApplication {

  public static void main(String[] args) {

    new Pippo(new Application() {

      @Override
      protected void onInit() {

        GET("/", (routeContext) -> routeContext.send("Hello World!"));

      }
    }).start();;

  }

}
