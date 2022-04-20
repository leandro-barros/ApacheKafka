package br.com.leandrobarros.kafka.producerservice.producer;

import br.com.leandrobarros.kafka.producerservice.dto.PersonDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Slf4j
@Service
public class PersonProducer {

    @Autowired
    private KafkaTemplate<String, Serializable> jsonObjectkafkaTemplate;

    public void sendMessage(PersonDto personDto) {
        jsonObjectkafkaTemplate.send("topic-person", personDto).addCallback(
                success -> log.info("Message send " + success.getProducerRecord().value()),
                failure -> log.error("Message failure " + failure.getMessage())
        );
    }

    public void sendMessageMyTopic(PersonDto personDto) {
        jsonObjectkafkaTemplate.send("my-topic", personDto);
    }

}
