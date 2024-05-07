package ru.petrov.notificationservice.service;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.petrov.notificationservice.dto.fieldHH.Vacancy;
import ru.petrov.notificationservice.entity.Customer;
import ru.petrov.notificationservice.repository.CustomerRepository;

import java.util.Set;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

//    @PostConstruct
//    void init() {
//        customerRepository.save(new Customer(
//                UUID.randomUUID().toString(),
//                "John", "john@mail.ru",
//                Set.of("Java")));
//    }

    public void getSubscribes(Vacancy vacancy) {
        customerRepository.findAll()
                .stream()
                .filter(customer -> customer.getLanguages().contains(vacancy.getLang()))
                .forEach(customer -> sendMessage(vacancy, customer.getEmail()));
    }


    void sendMessage(Vacancy vacancy, String email) {
        System.out.printf("Messsage send to %s, %s \n",
                email, vacancy);
    }


}
