package ru.petrov.notificationservice.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.petrov.notificationservice.dto.fieldHH.*;
import ru.petrov.notificationservice.service.CustomerService;

@RestController
@RequiredArgsConstructor
public class TestController {

    private final CustomerService customerService;

    Vacancy vacancy1 = new Vacancy("1",
            "Cool vacancy",
            new Area(), new Salary(), new Type(), "asdad",
            "sadad", true, "sadad", new Employer(),
            new Snippet(), new Experience(), new Employment(),
            "Java");
    Vacancy vacancy2 = new Vacancy("1",
            "Cool vacancy",
            new Area(), new Salary(), new Type(), "asdad",
            "sadad", true, "sadad", new Employer(),
            new Snippet(), new Experience(), new Employment(),
            "Go");

    @GetMapping("/test")
    private void testCustomerService() {
        customerService.getSubscribes(vacancy1);
        customerService.getSubscribes(vacancy2);
    }
}
