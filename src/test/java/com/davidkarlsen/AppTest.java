package com.davidkarlsen;


import lombok.extern.slf4j.Slf4j;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.test.spring.junit5.CamelSpringBootTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@CamelSpringBootTest
@Slf4j
public class AppTest {

    @Autowired
    private ProducerTemplate producerTemplate;

    @Test
    public void camelFails() {
        //curl -v -XPOST -H"someheader=somevalue" -v http://localhost:8080/mypath
        log.info("Camel fails");
    }
}
