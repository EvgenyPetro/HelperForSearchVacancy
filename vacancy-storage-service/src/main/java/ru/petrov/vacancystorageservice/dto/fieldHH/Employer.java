package ru.petrov.vacancystorageservice.dto.fieldHH;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "name",
        "url",
        "alternate_url",
        "vacancies_url",
        "accredited_it_employer",
        "trusted"
})
public class Employer {

    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("url")
    private String url;
    @JsonProperty("alternate_url")
    private String alternateUrl;
    @JsonProperty("vacancies_url")
    private String vacanciesUrl;
    @JsonProperty("accredited_it_employer")
    private Boolean accreditedItEmployer;
    @JsonProperty("trusted")
    private Boolean trusted;

}