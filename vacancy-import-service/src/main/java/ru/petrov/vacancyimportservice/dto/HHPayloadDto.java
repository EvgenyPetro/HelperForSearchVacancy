package ru.petrov.vacancyimportservice.dto;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import lombok.ToString;
import ru.petrov.vacancyimportservice.dto.fieldHH.Vacancy;

import java.util.List;


@Data
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "items",
        "found",
        "pages",
        "page",
        "per_page"
})
public class HHPayloadDto {
        @JsonProperty("items")
        private List<Vacancy> vacancies;
        @JsonProperty("found")
        private Integer found;
        @JsonProperty("pages")
        private Integer pages;
        @JsonProperty("per_page")
        private Integer perPage;
        @JsonProperty("page")
        private Integer page;

}
