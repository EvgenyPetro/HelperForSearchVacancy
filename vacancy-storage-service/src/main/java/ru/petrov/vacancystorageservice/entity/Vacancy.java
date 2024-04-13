package ru.petrov.vacancystorageservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import ru.petrov.vacancystorageservice.dto.fieldHH.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vacancy {

    @Id
    private String id;
    private String name;
    private Area area;
    private Salary salary;
    private Type type;
    private String publishedAt;
    private String createdAt;
    private Boolean archived;
    private String alternateUrl;
    private Employer employer;
    private Snippet snippet;
    private Experience experience;
    private Employment employment;
}
