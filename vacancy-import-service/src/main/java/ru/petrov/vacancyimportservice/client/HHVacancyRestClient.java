package ru.petrov.vacancyimportservice.client;

import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.client.RestClient;
import ru.petrov.vacancyimportservice.dto.HHPayloadDto;
import ru.petrov.vacancyimportservice.dto.fieldHH.Vacancy;

import java.util.List;

@RequiredArgsConstructor
public class HHVacancyRestClient implements VacancyRestClient {

    private static final ParameterizedTypeReference<List<HHPayloadDto>> VACANCY_TYPE_REF =
            new ParameterizedTypeReference<>() {
            };

    private final RestClient restClient;

    @Override
    public List<Vacancy> getVacancy(String lang) {

        var result = restClient
                .get()
                .uri("/vacancies?text={lang}", lang)
                .retrieve()

                .body(HHPayloadDto.class);
        return result.getVacancies();
    }
}
