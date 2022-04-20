package br.com.leandrobarros.kafka.consumerservice.consumer;

import br.com.leandrobarros.kafka.consumerservice.dto.CarDto;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CarConsumer {

    @Value("${topic.name}")
    private String topicName;

    @Value("${spring.kafka.group-id}")
    private String groupId;

    @KafkaListener(topics = "${topic.name}", groupId = "${spring.kafka.group-id}", containerFactory = "carKafkaListenerContainerFactory")
    public void listenTopicCar(ConsumerRecord<String, CarDto> consumerRecord) {
        log.info("Received message " + consumerRecord.partition());
        log.info("Received message: " + consumerRecord.value());
    }

    @KafkaListener(topics = "${topic.name}", groupId = "${spring.kafka.group-id}", containerFactory = "carKafkaListenerContainerFactory", concurrency = "2")
    public void listenWithHeaders(ConsumerRecord<String, CarDto> consumerRecord,
                                  @Header(KafkaHeaders.RECEIVED_TOPIC) String topic,
                                  @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition) {
        log.info("Topic {} Pt {}: {}", topic, partition, consumerRecord.value().getColor());
    }
}
