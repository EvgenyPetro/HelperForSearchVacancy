package ru.petrov.vacancyimportservice.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import ru.petrov.vacancyimportservice.client.HHVacancyRestClient;

@Configuration
public class ClientBeans {

    @Bean
    public HHVacancyRestClient hHVacancyRestClient(
            @Value("${api.hh}")
            String HHBaseUri
    ) {
        return new HHVacancyRestClient(RestClient.builder()
                .baseUrl(HHBaseUri)
                .build());
    }
}
