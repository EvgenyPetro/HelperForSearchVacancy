package ru.petrov.vacancyimportservice.client;

import com.fasterxml.jackson.core.type.TypeReference;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.client.RestClient;
import ru.petrov.vacancyimportservice.dto.HHPayloadDto;
import ru.petrov.vacancyimportservice.dto.Vacancy;

import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
public class HHVacancyRestClient implements VacancyRestClient {

    private static final ParameterizedTypeReference<List<HHPayloadDto>> VACANCY_TYPE_REF =
            new ParameterizedTypeReference<>() {
            };

    private final RestClient restClient;

    @Override
    public List<Vacancy> getVacancy() {

        var result = restClient
                .get()
                .uri("/vacancies?text=java")
                .retrieve()

                .body(HHPayloadDto.class);
        System.out.println(result.getItems().get(1));
        return Collections.emptyList();
    }
}
