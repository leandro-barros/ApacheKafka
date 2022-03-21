package br.com.leandrobarros.kafka.consumerservice.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ConsumerListener {

    @KafkaListener(topics = "${topic.topic-practice}", groupId = "group_id")
    public void consumerMessage(String message) {
        log.info("--> Consumed message: " + message);
    }

}
