package net.coatli.java;

import org.rapidoid.setup.On;

public class Application {

  public static void main(String[] args) {

	On.get("/").json(() -> "Hello World!");
  
  }
}

