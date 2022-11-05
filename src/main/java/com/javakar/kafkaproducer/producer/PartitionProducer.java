package com.javakar.kafkaproducer.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class PartitionProducer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    //kafka-topics --bootstrap-server localhost:9092 --topic topic-multipart --create --partitions 3 --replication-factor 1
    public void sendPartitionMessage(String key, String value){
        kafkaTemplate.send("topic-multipart", key, value);

    }
}
