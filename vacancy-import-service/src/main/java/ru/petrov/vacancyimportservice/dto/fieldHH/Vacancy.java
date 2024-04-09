package ru.petrov.vacancyimportservice.dto;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import lombok.ToString;
import ru.petrov.vacancyimportservice.dto.fieldHH.*;


@Data
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Vacancy {
    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("area")
    private Area area;
    @JsonProperty("salary")
    private Salary salary;
    @JsonProperty("type")
    private Type type;
    @JsonProperty("published_at")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private String publishedAt;
    @JsonProperty("created_at")
    private String createdAt;
    @JsonProperty("archived")
    private Boolean archived;
    @JsonProperty("alternate_url")
    private String alternateUrl;
    @JsonProperty("employer")
    private Employer employer;
    @JsonProperty("snippet")
    private Snippet snippet;
    @JsonProperty("experience")
    private Experience experience;
    @JsonProperty("employment")
    private Employment employment;

}
