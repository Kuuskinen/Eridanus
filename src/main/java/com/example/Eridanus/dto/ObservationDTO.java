package com.example.Eridanus.dto;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.time.LocalDate;
import java.time.LocalTime;

public class ObservationDTO {

    @NotEmpty
    @DateTimeFormat(pattern="yyyy-MM-dd")
    String observationDate;

    @NotEmpty
    @Size(min = 5, message = "{empty.error}")
    String observationMethod;

    @NotEmpty
    String observationTarget;

    @NotNull
    LocalTime observationStart;

    @NotNull
    LocalTime observationEnd;

    String observationDetails;

    public ObservationDTO(String observationDate, String observationMethod, String observationTarget,
                          LocalTime observationStart, LocalTime observationEnd, String observationDetails) {
        this.observationDate = observationDate;
        this.observationMethod = observationMethod;
        this.observationTarget = observationTarget;
        this.observationStart = observationStart;
        this.observationEnd = observationEnd;
        this.observationDetails = observationDetails;
    }

    public ObservationDTO() {

    }

    public String getObservationDate() {
        return observationDate;
    }

    public void setObservationDate(String observationDate) {
        this.observationDate = observationDate;
    }

    public String getObservationMethod() {
        return observationMethod;
    }

    public void setObservationMethod(String observationMethod) {
        this.observationMethod = observationMethod;
    }

    public String getObservationTarget() {
        return observationTarget;
    }

    public void setObservationTarget(String observationTarget) {
        this.observationTarget = observationTarget;
    }

    public LocalTime getObservationStart() {
        return observationStart;
    }

    public void setObservationStart(LocalTime observationStart) {
        this.observationStart = observationStart;
    }

    public LocalTime getObservationEnd() {
        return observationEnd;
    }

    public void setObservationEnd(LocalTime observationEnd) {
        this.observationEnd = observationEnd;
    }

    public String getObservationDetails() {
        return observationDetails;
    }

    public void setObservationDetails(String observationDetails) {
        this.observationDetails = observationDetails;
    }

}
