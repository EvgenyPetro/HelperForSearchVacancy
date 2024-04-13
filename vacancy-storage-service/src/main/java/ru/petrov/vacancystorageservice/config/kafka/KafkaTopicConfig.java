package ru.petrov.vacancystorageservice.config.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    private final String kafkaTopic;

    public KafkaTopicConfig(@Value("${kafka.topic}") String kafkaTopic) {
        this.kafkaTopic = kafkaTopic;
    }

    @Bean
    public NewTopic newTopic() {
        return TopicBuilder.name(kafkaTopic)
                .partitions(1)
                .replicas(1)
                .build();
    }
}
