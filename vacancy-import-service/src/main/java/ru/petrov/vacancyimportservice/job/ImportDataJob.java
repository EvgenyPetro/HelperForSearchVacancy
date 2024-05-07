package ru.petrov.vacancyimportservice.job;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ru.petrov.vacancyimportservice.client.VacancyRestClient;
import ru.petrov.vacancyimportservice.dto.fieldHH.Vacancy;

import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
@EnableScheduling
@ConditionalOnProperty(name = "scheduler.enabled", matchIfMissing = true)
public class ImportDataJob {

    private final VacancyRestClient vacancyRestClient;
    private final NewTopic topic;
    private final KafkaTemplate<String, Vacancy> kafkaTemplate;
    private static final List<String> LANGUAGES = List.of("Java", "Kotlin", "Android", "Javascript",
            "React", "PHP", "iOS", ".NET", "Python");

    @Scheduled(fixedDelay = 30 * 60 * 1000, initialDelay = 1000)
    public void runImportDataJob() throws InterruptedException {

        for (String lang : LANGUAGES) {
            List<Vacancy> vacancies = vacancyRestClient.getVacancy(lang);
            for (Vacancy vacancy : vacancies) {
                vacancy.setLang(lang);
                kafkaTemplate.send(topic.name(), vacancy)
                        .whenComplete((res, ex) -> {
                            if (ex == null) {
                                log.info("vacancy id:{} was sent", vacancy.getId());
                            } else {
                                log.error("vacancy id:{} was not sent", vacancy.getId(), ex);
                            }
                        });
            }
            Thread.sleep(3000);
        }
    }
}
