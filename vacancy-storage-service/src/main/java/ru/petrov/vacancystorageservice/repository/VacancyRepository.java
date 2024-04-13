package ru.petrov.vacancystorageservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.petrov.vacancystorageservice.entity.Vacancy;

public interface VacancyRepository extends MongoRepository<Vacancy, String> {
}
