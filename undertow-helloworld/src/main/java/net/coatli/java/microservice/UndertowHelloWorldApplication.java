package net.coatli.java.microservice;

import io.undertow.Undertow;
import io.undertow.util.Headers;

public class UndertowHelloWorldApplication {

  public static void main(final String[] args) {

    Undertow.builder()
      .addHttpListener(8080, "localhost")
      .setHandler((exchange) -> {
        exchange.getResponseHeaders().put(Headers.CONTENT_TYPE, "text/plain");
        exchange.getResponseSender().send("Hello World");
      })
      .build().start();

  }

}
