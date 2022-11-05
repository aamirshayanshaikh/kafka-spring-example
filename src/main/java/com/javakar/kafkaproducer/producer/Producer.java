package com.javakar.kafkaproducer.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class Producer {

    private Logger logger = LoggerFactory.getLogger(Producer.class);

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sayHello(String name){
        kafkaTemplate.send("topic-hello", "hello "+name);
    }

   /* private int i = 0;
    @Scheduled(fixedRate = 1000)
    public void sendRealtime(){
        i++;
        logger.info("message" +i);
        kafkaTemplate.send("topic-real-time", "message "+i);
    }*/
}
