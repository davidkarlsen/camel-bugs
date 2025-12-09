package com.davidkarlsen;


import org.apache.camel.FailedToCreateProducerException;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.test.spring.junit5.CamelSpringBootTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.kafka.KafkaContainer;
import org.testcontainers.utility.DockerImageName;

@SpringBootTest
@CamelSpringBootTest
@Testcontainers
public class AppTest {

    @Autowired
    private ProducerTemplate producerTemplate;

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @Container
    static KafkaContainer kafka =
        new KafkaContainer(DockerImageName.parse("apache/kafka-native:4.1.1"));

    @DynamicPropertySource
    static void registerProps(DynamicPropertyRegistry registry) {
        registry.add("spring.kafka.bootstrap-servers", kafka::getBootstrapServers);
    }

    @Test
    public void springWorks() {
        Assertions.assertNotNull(kafkaTemplate);
        kafkaTemplate.send("topic1", "hello");
    }

    @Test
    public void camelFails() {
        Assertions.assertThrows(FailedToCreateProducerException.class, () -> {
            producerTemplate.sendBody("kafka:some-topic", "someMessage");
        });
    }
}
