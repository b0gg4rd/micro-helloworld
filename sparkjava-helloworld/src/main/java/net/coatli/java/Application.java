package net.coatli.java;

import static spark.Spark.get;

public class Application {

  public static void main(final String[] args) {

	get("/", (req, res) -> "Hello World!");
  
  }
}

