package net.coatli.java.microhelloworld;

import org.xnio.Options;

import io.undertow.Undertow;
import io.undertow.UndertowOptions;
import io.undertow.util.Headers;

public class UndertowHelloWorldApplication {

  public static void main(final String[] args) {

    Undertow.builder()
      .addHttpListener(8080, "0.0.0.0")
      .setBufferSize(1024 * 16)
      .setIoThreads(Runtime.getRuntime().availableProcessors() * 2) //this seems slightly faster in some configurations
      .setSocketOption(Options.BACKLOG, 10000)
      .setServerOption(UndertowOptions.ALWAYS_SET_KEEP_ALIVE, false) //don't send a keep-alive header for HTTP/1.1 requests, as it is not required
      .setServerOption(UndertowOptions.ALWAYS_SET_DATE, true)
      .setServerOption(UndertowOptions.RECORD_REQUEST_START_TIME, false)
      .setWorkerThreads(200)
      .setHandler((exchange) -> {
        exchange.getResponseHeaders().put(Headers.CONTENT_TYPE, "text/plain");
        exchange.getResponseSender().send("Hello World");
      })
      .build().start();

  }

}
