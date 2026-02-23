package com.davidkarlsen;

import org.apache.camel.micrometer.observability.starter.CamelMicrometerObservability;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@CamelMicrometerObservability
@SpringBootApplication
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
