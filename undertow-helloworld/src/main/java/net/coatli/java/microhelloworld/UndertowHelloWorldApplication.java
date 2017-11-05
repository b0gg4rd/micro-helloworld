package net.coatli.java.microhelloworld;

import io.undertow.Undertow;
import io.undertow.util.Headers;

public class UndertowHelloWorldApplication {

  public static void main(final String[] args) {

    Undertow.builder()
      .addHttpListener(8080, "0.0.0.0")
      .setHandler((exchange) -> {
        exchange.getResponseHeaders().put(Headers.CONTENT_TYPE, "text/plain");
        exchange.getResponseSender().send("Hello World");
      })
      .build().start();

  }

}