package ru.petrov.notificationservice.dto.fieldHH;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;


@Data
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
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
    @JsonProperty("lang")
    private String lang;

}
