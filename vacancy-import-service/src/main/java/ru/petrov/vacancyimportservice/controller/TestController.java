package ru.petrov.vacancyimportservice.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.petrov.vacancyimportservice.client.VacancyRestClient;
import ru.petrov.vacancyimportservice.dto.fieldHH.Vacancy;

import java.util.Collections;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class TestController {

    private final VacancyRestClient client;
    private final NewTopic topic;
    private final KafkaTemplate<String, Vacancy> kafkaTemplate;

    @GetMapping("/test")
    public List<Vacancy> getPayloadDtoList() {

        List<Vacancy> vacancy = client.getVacancy();
        for (int i = 0; i < 10; i++) {

            kafkaTemplate.send(topic.name(), vacancy.get(i));
            log.info("send {}", vacancy.get(i).getId());
        }
        return Collections.emptyList();
    }
}
