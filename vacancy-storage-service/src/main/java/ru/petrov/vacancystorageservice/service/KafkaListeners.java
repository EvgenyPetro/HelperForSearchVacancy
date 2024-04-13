package ru.petrov.vacancystorageservice.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import ru.petrov.vacancystorageservice.entity.Vacancy;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaListeners {


    @KafkaListener(topics = "headhunterVacancy", containerFactory = "listenerContainerFactory")
    void listen(@Payload List<Vacancy> data) {
        log.info("values, values.size:{}", data.size());
        System.out.println(data);
    }

}
