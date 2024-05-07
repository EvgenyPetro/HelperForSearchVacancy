package ru.petrov.vacancystorageservice.config.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.boot.ssl.SslBundles;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;
import ru.petrov.vacancystorageservice.entity.Vacancy;

import java.util.Map;

@Configuration
public class KafkaProducerConfig {


    @Bean
    public ProducerFactory<String, Vacancy> getProducerFactory(KafkaProperties kafkaProperties,
                                                               ObjectMapper objectMapper,
                                                               SslBundles sslBundles) {
        Map<String, Object> props = kafkaProperties.buildProducerProperties(sslBundles);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        DefaultKafkaProducerFactory<String, Vacancy> producerFactory =
                new DefaultKafkaProducerFactory<>(props);
        producerFactory.setValueSerializer(new JsonSerializer<>(objectMapper));
        return producerFactory;
    }

    @Bean
    public KafkaTemplate<String, Vacancy> getKafkaTemplate(ProducerFactory<String, Vacancy> producerFactory) {
        return new KafkaTemplate<>(producerFactory);
    }
}
