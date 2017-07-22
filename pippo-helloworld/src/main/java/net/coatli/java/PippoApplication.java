package net.coatli.java;

import ro.pippo.core.Application;
import ro.pippo.core.Pippo;

public class PippoApplication extends Application {

  public static void main(String[] args) {
    
    new Pippo(new PippoApplication()).start();;
  
  }
  
  @Override
  protected void onInit() {

    GET("/", (routeContext) -> routeContext.send("Hello World!"));

  }

}
