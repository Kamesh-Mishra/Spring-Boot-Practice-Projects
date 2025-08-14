package com.consumer.demo.consumer;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.consumer.demo.dto.Customer;

@Service
public class KafkaMessageListener {

    Logger log = LoggerFactory.getLogger(KafkaMessageListener.class);

    @KafkaListener(topics = "kafka-demo",groupId = "k-group")
    public void consumeEvents(Customer customer) {
        log.info("consumer consume the events {} ", customer.toString());
    }

    @KafkaListener(topics = "kafka-demo",groupId = "k-group")
    public void consume2(String message) {
        log.info("consumer consume the message {} ", message);
    }
//
//    @KafkaListener(topics = "kafka-demo",groupId = "k-group-new")
//    public void consume3(String message) {
//        log.info("consumer3 consume the message {} ", message);
//    }
//
//    @KafkaListener(topics = "kafka-demo",groupId = "k-group-new")
//    public void consume4(String message) {
//        log.info("consumer4 consume the message {} ", message);
//    }
}
