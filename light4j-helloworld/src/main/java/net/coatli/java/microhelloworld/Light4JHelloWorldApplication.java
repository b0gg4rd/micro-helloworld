package net.coatli.java.microhelloworld;

import static io.undertow.Handlers.path;

import com.networknt.server.HandlerProvider;
import io.undertow.server.HttpHandler;

public class Light4JHelloWorldApplication implements HandlerProvider {

  public HttpHandler getHandler() {

    return path().addPrefixPath("/", (exchange) -> exchange.getResponseSender().send("Hello World!"));

  }
}

