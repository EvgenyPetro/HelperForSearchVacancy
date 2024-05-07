package ru.petrov.notificationservice.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import ru.petrov.notificationservice.dto.fieldHH.Vacancy;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaListeners {

    private final CustomerService service;

    @KafkaListener(topics = "headhunterVacancyNotification", containerFactory = "listenerContainerFactory")
    void listen(@Payload List<Vacancy> data) {
        data.stream()
                .forEach(vacancy -> {
                    log.info("values, values.size:{}", data.size());
                    service.getSubscribes(vacancy);
                });
    }

}
