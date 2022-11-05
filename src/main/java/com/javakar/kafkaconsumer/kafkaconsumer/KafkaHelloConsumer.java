package com.javakar.kafkaconsumer.kafkaconsumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaHelloConsumer {

    private static final Logger log = LoggerFactory.getLogger(KafkaHelloConsumer.class);

    @KafkaListener(topics = "topic-hello")
    public void ConsumeHelloMessage(String message){
        System.out.println(message);
    }

    /*@KafkaListener(topics = "topic-real-time")
    public void ConsumeRealtime(String message){
        System.out.println(message);
    }*/

    // Create partitions
    //kafka-topics --bootstrap-server localhost:9092 --topic topic-multipart --create --partitions 3 --replication-factor 1
    @KafkaListener(topics = "topic-multipart", concurrency = "3")
    public void ConsumeRealtime(ConsumerRecord<String, String> message) throws InterruptedException {
        log.info("#key= " + message.key() + " #value= "+message.value() + " #partition= "+message.partition()+ " #topic= "+message.topic()+ " #offset= "+message.offset());
        Thread.sleep(1000);
    }
}
