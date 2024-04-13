package ru.petrov.vacancystorageservice.config.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.boot.ssl.SslBundles;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import ru.petrov.vacancystorageservice.entity.Vacancy;

import java.util.Map;

import static org.springframework.kafka.support.serializer.JsonDeserializer.TYPE_MAPPINGS;

@Configuration
public class KafkaConsumerConfig {

    @Bean
    public ConsumerFactory<String, Vacancy> consumerFactory(KafkaProperties properties,
                                                            ObjectMapper objectMapper,
                                                            SslBundles bundles) {
        Map<String, Object> props = properties.buildConsumerProperties(bundles);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        props.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, 2);
        props.put(ConsumerConfig.MAX_POLL_INTERVAL_MS_CONFIG, 3000);
        props.put(TYPE_MAPPINGS, "ru.petrov.vacancyimportservice.dto.fieldHH.Vacancy:ru.petrov.vacancystorageservice.entity.Vacancy");

        DefaultKafkaConsumerFactory<String, Vacancy> kafkaConsumerFactory = new DefaultKafkaConsumerFactory<>(props);
        kafkaConsumerFactory.setValueDeserializer(new JsonDeserializer<>(objectMapper));
        return kafkaConsumerFactory;
    }

    @Bean("listenerContainerFactory")
    public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, Vacancy>> listenerContainerFactory(
            ConsumerFactory<String, Vacancy> consumerFactory) {
        ConcurrentKafkaListenerContainerFactory<String, Vacancy> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory);
        factory.setBatchListener(true);
//        factory.setConcurrency(1);
//        factory.getContainerProperties().setIdleBetweenPolls(1_000);
//        factory.getContainerProperties().setPollTimeout(1_000);
//
//        var executor = new SimpleAsyncTaskExecutor("vacancy-consumer-");
//        executor.setConcurrencyLimit(10);
//        var listenerTaskExecutor = new ConcurrentTaskExecutor(executor);
//        factory.getContainerProperties().setListenerTaskExecutor(listenerTaskExecutor);

        return factory;
    }
}
