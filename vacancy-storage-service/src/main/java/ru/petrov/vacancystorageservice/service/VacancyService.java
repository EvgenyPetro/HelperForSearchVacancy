package ru.petrov.vacancystorageservice.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Primary;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import ru.petrov.vacancystorageservice.entity.Vacancy;
import ru.petrov.vacancystorageservice.repository.VacancyRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
@Primary
public class VacancyService {

    private final VacancyRepository vacancyRepository;

    private final NewTopic topic;
    private final KafkaTemplate<String, Vacancy> kafkaTemplate;

    void save(Vacancy vacancy) {

        Optional<Vacancy> byId = vacancyRepository.findById(vacancy.getId());
        if (byId.isEmpty()) {
            vacancyRepository.insert(vacancy);
            log.info("Vacancy {}, insert", vacancy.getId());
            kafkaTemplate.send(topic.name(), vacancy);

        }
    }


}
