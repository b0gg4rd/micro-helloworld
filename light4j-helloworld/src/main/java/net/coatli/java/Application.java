package net.coatli.java;

import static io.undertow.Handlers.path;

import com.networknt.server.HandlerProvider;
import io.undertow.server.HttpHandler;

public class Application implements HandlerProvider {

  public HttpHandler getHandler() {
    
    return path().addPrefixPath("/", (exchange) -> exchange.getResponseSender().send("Hello World!"));
  
  }
}
