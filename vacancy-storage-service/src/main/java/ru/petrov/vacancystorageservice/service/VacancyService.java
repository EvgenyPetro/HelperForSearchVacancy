package ru.petrov.vacancystorageservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.petrov.vacancystorageservice.entity.Vacancy;
import ru.petrov.vacancystorageservice.repository.VacancyRepository;

@Service
@RequiredArgsConstructor
public class VacancyService {

    private final VacancyRepository vacancyRepository;

    void save(Vacancy vacancy){
        vacancyRepository.save(vacancy);
    }

}
