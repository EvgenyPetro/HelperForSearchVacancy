package ru.petrov.vacancystorageservice.config.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    private final String kafkaTopicConsume;
    private final String kafkaTopicProduce;

    public KafkaTopicConfig(@Value("${kafka.topic.consume}") String kafkaTopicConsume,
                            @Value("${kafka.topic.produce}") String kafkaTopicProduce) {
        this.kafkaTopicConsume = kafkaTopicConsume;
        this.kafkaTopicProduce = kafkaTopicProduce;
    }

    @Bean
    public NewTopic newTopicConsume() {
        return TopicBuilder.name(kafkaTopicConsume)
                .partitions(1)
                .replicas(1)
                .build();
    }

    @Bean
    @Primary
    public NewTopic newTopicProduce() {
        return TopicBuilder.name(kafkaTopicProduce)
                .partitions(1)
                .replicas(1)
                .build();
    }
}
