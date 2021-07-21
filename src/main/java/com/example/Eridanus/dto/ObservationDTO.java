package com.example.Eridanus.dto;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@Data
public class ObservationDTO {

    //@NotEmpty(message = "{empty.error}")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    LocalDate observationDate;

    @NotEmpty(message = "{empty.error}")
    String observationMethod;

    @NotEmpty(message = "{empty.error}")
    String observationTarget;

    @NotNull(message = "{empty.error}")
    LocalTime observationStart;

    @NotNull(message = "{empty.error}")
    LocalTime observationEnd;

    String observationDetails;
}
