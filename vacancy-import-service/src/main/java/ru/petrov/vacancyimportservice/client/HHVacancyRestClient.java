package ru.petrov.vacancyimportservice.client;

import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.client.RestClient;
import ru.petrov.vacancyimportservice.dto.Vacancy;

import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
public class HHVacancyRestClient implements VacancyRestClient {

    private final RestClient restClient;

    @Override
    public List<Vacancy> getVacancy() {

        String result = restClient
                .get()
                .uri("/vacancies?text=java")
                .retrieve()
                .body(String.class);
        System.out.println(result);
        return Collections.emptyList();
    }
}
