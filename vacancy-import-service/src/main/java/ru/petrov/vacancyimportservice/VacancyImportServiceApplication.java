package ru.petrov.vacancyimportservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ru.petrov.vacancyimportservice.client.HHVacancyRestClient;

@SpringBootApplication
public class VacancyImportServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(VacancyImportServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner run(HHVacancyRestClient client) {
        return args -> client.getVacancy();
    }
}
