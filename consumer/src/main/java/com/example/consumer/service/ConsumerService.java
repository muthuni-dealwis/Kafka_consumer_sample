package com.example.consumer.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {

    @KafkaListener(topics = "${kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void listen(ConsumerRecord<String,String> record){
        System.out.println("Reached to service");
        System.out.println("Received message: "+ record.value());
        System.out.println("Partition: " + record.partition() + ", Offset: " + record.offset());

    }


}
