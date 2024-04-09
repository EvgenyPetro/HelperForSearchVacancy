package ru.petrov.vacancyimportservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VacancyImportServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(VacancyImportServiceApplication.class, args);
    }

//    @Bean
//    CommandLineRunner run(HHVacancyRestClient client) {
//        return args -> client.getVacancy();
//    }
}
