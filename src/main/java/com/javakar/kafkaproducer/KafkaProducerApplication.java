package com.javakar.kafkaproducer;

import com.javakar.kafkaproducer.producer.PartitionProducer;
import com.javakar.kafkaproducer.producer.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
/*@EnableScheduling*/
public class KafkaProducerApplication implements CommandLineRunner {

    @Autowired
    private Producer producer;

    @Autowired
    private PartitionProducer partitionProducer;

    public static void main(String[] args) {
        SpringApplication.run(KafkaProducerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //producer.sayHello("Aamir "+Math.random());

        for (int i = 0; i < 1000; i++) {
            String key = "key-" + (i%4);
            String value = "value " +i;
            partitionProducer.sendPartitionMessage(key, value);
            Thread.sleep(500);
        }
        
    }

    
}
