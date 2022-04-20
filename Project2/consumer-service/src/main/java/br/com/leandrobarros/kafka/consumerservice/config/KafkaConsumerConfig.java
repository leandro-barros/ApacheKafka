package br.com.leandrobarros.kafka.consumerservice.config;

import br.com.leandrobarros.kafka.consumerservice.dto.CarDto;
import br.com.leandrobarros.kafka.consumerservice.dto.PersonDto;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConsumerConfig {

    @Value("${spring.kafka.bootstrap-servers}")
    private String booststrapAddress;

    @Value("${spring.kafka.group-id}")
    private String groupId;

    @Bean
    public ConsumerFactory<String, CarDto> carConsumerFactory() {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, booststrapAddress);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonSerializer.class);

        return new DefaultKafkaConsumerFactory<>(props, new StringDeserializer(),
                new JsonDeserializer<>(CarDto.class, false));
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, CarDto> carKafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, CarDto> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(carConsumerFactory());
        return factory;
    }

    // Config Person

    @Bean
    public ConsumerFactory<String, PersonDto> personConsumerFactory() {
        var props = new HashMap<String, Object>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, booststrapAddress);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonSerializer.class);

        var jsonDeserializer = new JsonDeserializer<>(PersonDto.class)
                .trustedPackages("*")
                .forKeys();

        return new DefaultKafkaConsumerFactory<>(props, new StringDeserializer(),
                jsonDeserializer);
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, PersonDto> personKafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, PersonDto> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(personConsumerFactory());
        factory.setConcurrency(2);
        return factory;
    }
}
