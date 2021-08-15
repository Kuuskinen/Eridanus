package com.example.Eridanus.dto;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class ObservationDTO {

    @DateTimeFormat(pattern="yyyy-MM-dd")
    LocalDate obsStartDate;

    @NotNull(message = "{empty.error}")
    LocalTime obsStartTime;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    LocalDate obsEndDate;

    @NotNull(message = "{empty.error}")
    LocalTime obsEndTime;

    @NotEmpty(message = "{empty.error}")
    String obsMethod;

    @NotEmpty(message = "{empty.error}")
    String obsTarget;

    String obsDetails;
}
