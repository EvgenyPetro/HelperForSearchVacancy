package ru.petrov.vacancyimportservice.dto.fieldHH;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Salary {
    @JsonProperty("from")
    private int from;
    @JsonProperty("to")
    private int to;
    @JsonProperty("currency")
    private String currency;
    @JsonProperty("gross")
    private boolean gross;

}


