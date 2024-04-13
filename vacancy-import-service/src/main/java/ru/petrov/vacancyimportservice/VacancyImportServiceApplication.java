package ru.petrov.vacancyimportservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class VacancyImportServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(VacancyImportServiceApplication.class, args);
    }

//    @Bean
//    CommandLineRunner run(KafkaTemplate<String, String> kafkaTemplate) {
//        return args -> {
//            for (int i = 0; i < 10; i++) {
//
//                kafkaTemplate.send("headHunterVacancy", "Hello, world!");
//            }
//        };
//    }
}
