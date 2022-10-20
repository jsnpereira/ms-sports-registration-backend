package com.sports.registration.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sports.registration.enums.RegisterStatus;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
public class RegistrationDTO {
    @NotNull
    @NotEmpty
    @JsonProperty("category")
    private String categoryId;
    @NotNull
    @NotEmpty
    @JsonProperty("user")
    private String userId;
    private LocalDate date;
    @NotNull
    private RegisterStatus registerStatus;

}
