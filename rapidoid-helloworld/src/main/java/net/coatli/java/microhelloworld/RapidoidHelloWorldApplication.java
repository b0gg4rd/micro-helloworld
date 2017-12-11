package net.coatli.java.microhelloworld;

import static org.rapidoid.setup.On.get;

public class RapidoidHelloWorldApplication {

  public static void main(String[] args) {

  get("/").json(() -> "Hello World!");

  }
}

