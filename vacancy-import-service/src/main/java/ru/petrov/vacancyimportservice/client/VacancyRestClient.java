package ru.petrov.vacancyimportservice.client;

import ru.petrov.vacancyimportservice.dto.fieldHH.Vacancy;

import java.util.List;

public interface VacancyRestClient {

    List<Vacancy> getVacancy(String lang);
}
