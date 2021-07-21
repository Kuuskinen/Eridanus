package com.example.Eridanus.repository;

import com.example.Eridanus.entity.ObservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ObservationRepository extends JpaRepository<ObservationEntity,Long> {
}
