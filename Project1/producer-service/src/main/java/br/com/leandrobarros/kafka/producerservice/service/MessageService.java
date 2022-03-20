package br.com.leandrobarros.kafka.producerservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    @Value("${topic.producer")
    private String topicProducer;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void setMessageTopicProducer(String message) {
        this.kafkaTemplate.send(topicProducer, message);
    }
}
