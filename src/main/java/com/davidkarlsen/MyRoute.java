package com.davidkarlsen;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyRoute {

  @Bean
  RouteBuilder myRouteBuilder() {
    return new RouteBuilder() {
      @Override
      public void configure() {
        from("platform-http://mypath")
            .streamCache(true)
            .to(
                "log:mycategory?showExchangeId=true&showHeaders=true&showBody=true&multiline=true");
      }
    };
  }
}
