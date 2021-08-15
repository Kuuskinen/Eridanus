package com.example.Eridanus.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "main_observations")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ObservationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "observation_start", nullable = false)
    private Date observationStart;

    @Column(name = "observation_end", nullable = false)
    private Date observationEnd;

    @Column(name = "observation_target", nullable = false)
    private String observationTarget;

    @Column(name = "observation_method", nullable = false)
    private String observationMethod;

    @Column(name = "observation_details")
    private String observationDetails;
}
