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


    @GetMapping("/test")
    public List<Vacancy> getPayloadDtoList() {


        return Collections.emptyList();
    }
}
