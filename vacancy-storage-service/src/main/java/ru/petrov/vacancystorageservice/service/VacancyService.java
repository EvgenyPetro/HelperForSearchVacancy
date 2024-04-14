package ru.petrov.vacancystorageservice.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.petrov.vacancystorageservice.entity.Vacancy;
import ru.petrov.vacancystorageservice.repository.VacancyRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class VacancyService {

    private final VacancyRepository vacancyRepository;

    void save(Vacancy vacancy) {

        Optional<Vacancy> byId = vacancyRepository.findById(vacancy.getId());
        if (byId.isEmpty()) {
            vacancyRepository.insert(vacancy);
            log.info("Vacancy {}, insert", vacancy.getId());
        }
    }


}
