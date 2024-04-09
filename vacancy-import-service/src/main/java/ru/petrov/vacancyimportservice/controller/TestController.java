package ru.petrov.vacancyimportservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.petrov.vacancyimportservice.client.VacancyRestClient;
import ru.petrov.vacancyimportservice.dto.fieldHH.Vacancy;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TestController {

    private final VacancyRestClient client;

    @GetMapping("/test")
    public List<Vacancy> getPayloadDtoList() {
        return client.getVacancy();
    }
}
