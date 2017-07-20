package net.coatli.java;

import static org.rapidoid.setup.On.get;

public class Application {

  public static void main(String[] args) {

  get("/").json(() -> "Hello World!");

  }
}

