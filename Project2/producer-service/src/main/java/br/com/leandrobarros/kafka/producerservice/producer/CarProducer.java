package br.com.leandrobarros.kafka.producerservice.producer;

import br.com.leandrobarros.kafka.producerservice.dto.CarDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CarProducer {

    @Value("${topic.name}")
    private String topicName;

    @Autowired
    private KafkaTemplate<String, CarDto> kafkaTemplate;

    public void sendMessage(CarDto carDto) {
        kafkaTemplate.send(topicName, carDto).addCallback(
                success -> log.info("Message send " + success.getProducerRecord().value()),
                failure -> log.error("Message failure " + failure.getMessage())
        );
    }

}
