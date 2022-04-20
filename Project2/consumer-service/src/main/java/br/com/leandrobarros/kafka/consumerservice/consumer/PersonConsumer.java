package br.com.leandrobarros.kafka.consumerservice.consumer;

import br.com.leandrobarros.kafka.consumerservice.custom.PersonCustomerListener;
import br.com.leandrobarros.kafka.consumerservice.dto.CarDto;
import br.com.leandrobarros.kafka.consumerservice.dto.PersonDto;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PersonConsumer {

//    @KafkaListener(topics = "topic-person", groupId = "AppPerson", containerFactory = "personKafkaListenerContainerFactory")
    @PersonCustomerListener(groupId = "AppPerson")
    public void criarPerson(PersonDto personDto) {
        log.info("Thread: {}", Thread.currentThread().getId());
        log.info("Create Person: {} ", personDto);
    }

    @PersonCustomerListener(groupId = "AppPerson2")
    public void historyPerson(PersonDto personDto) {
        log.info("Thread: {}", Thread.currentThread().getId());
        log.info("History: {} ", personDto);
    }

}
