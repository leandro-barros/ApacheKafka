package br.com.leandrobarros.kafka.producerservice.config;

import br.com.leandrobarros.kafka.producerservice.dto.CarDto;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaAdmin;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaProducerConfig {

    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapAddress;

    @Value("${topic.name}")
    private String topicName;

//    @Bean
//    public NewTopic createTopic() {
//        return new NewTopic(topicName, 3, (short) 1);
//    }

    @Bean
    public KafkaAdmin.NewTopics createTopic() {
        return new KafkaAdmin.NewTopics(
                TopicBuilder.name(topicName).partitions(3).replicas(1).build(),
                TopicBuilder.name("topic-person").partitions(3).replicas(1).build()
        );
    }

    @Bean
    public ProducerFactory<String, CarDto> carProducerFactory() {
        Map<String, Object> configProps = new HashMap<>();
        configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
        configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);

        return new DefaultKafkaProducerFactory<>(configProps);
    }

    @Bean
    public KafkaTemplate<String, CarDto> kafkaTemplate() {
        return new KafkaTemplate<>(carProducerFactory());
    }

    @Bean
    public ProducerFactory<String, Object> jsonObjectProducerFactory() {
        var configProps = new HashMap<String, Object>();
        configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
        configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);

        return new DefaultKafkaProducerFactory<>(configProps, new StringSerializer(), new JsonSerializer<>());
    }

    @Bean
    public KafkaTemplate<String, Serializable> jsonObjectkafkaTemplate() {
        return new KafkaTemplate(jsonObjectProducerFactory());
    }
}
