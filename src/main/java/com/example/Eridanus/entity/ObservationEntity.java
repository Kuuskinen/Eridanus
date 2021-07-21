package com.example.Eridanus.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "observations")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ObservationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "observation_date", nullable = false)
    private LocalDate observationDate;

    @Column(name = "observation_method", nullable = false)
    private String observationMethod;

    @Column(name = "observation_target", nullable = false)
    private String observationTarget;

    @Column(name = "observation_start", nullable = false)
    private LocalTime observationStart;

    @Column(name = "observation_end", nullable = false)
    private LocalTime observationEnd;

    @Column(name = "observation_details")
    private String observationDetails;
}
