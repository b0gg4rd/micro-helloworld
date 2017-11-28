package net.coatli.java.microhelloworld;

import static io.undertow.Handlers.path;

import org.xnio.Options;

import io.undertow.Undertow;
import io.undertow.UndertowOptions;
import io.undertow.util.Headers;

public class UndertowHelloWorldApplication {

  public static void main(final String[] args) {

    System.setProperty("org.jboss.logging.provider", "slf4j");

    Undertow.builder()
      .addHttpListener(8080, "0.0.0.0")
      .setBufferSize(1024 * 16)
      .setIoThreads(Runtime.getRuntime().availableProcessors() * 2)
      .setSocketOption(Options.BACKLOG, 10000)
      .setServerOption(UndertowOptions.ALWAYS_SET_KEEP_ALIVE, false)
      .setServerOption(UndertowOptions.ALWAYS_SET_DATE, true)
      .setServerOption(UndertowOptions.RECORD_REQUEST_START_TIME, false)
      .setWorkerThreads(200)
      .setHandler(path().addPrefixPath("/", (exchange) -> {
        exchange.getResponseHeaders().put(Headers.CONTENT_TYPE, "text/plain");
        exchange.getResponseSender().send("Hello World");
      }))
      .build().start();

  }

}
