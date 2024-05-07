package ru.petrov.notificationservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.petrov.notificationservice.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, String> {

}
