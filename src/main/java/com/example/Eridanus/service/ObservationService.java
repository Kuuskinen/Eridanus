package com.example.Eridanus.service;

import com.example.Eridanus.dto.ObservationDTO;
import com.example.Eridanus.entity.ObservationEntity;
import com.example.Eridanus.repository.ObservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Service
public class ObservationService {

    @Autowired
    ObservationRepository observationRepository;

    public void addObservation(ObservationDTO observationDTO) {
        ObservationEntity observationEntity = new ObservationEntity();

        observationEntity.setObservationDate(observationDTO.getObservationDate());
        observationEntity.setObservationMethod(observationDTO.getObservationMethod());
        observationEntity.setObservationTarget(observationDTO.getObservationTarget());
        observationEntity.setObservationStart(observationDTO.getObservationStart());
        observationEntity.setObservationEnd(observationDTO.getObservationEnd());

        if (!observationDTO.getObservationDetails().isEmpty()) {
            observationEntity.setObservationDetails(observationDTO.getObservationDetails());
        }

        observationRepository.save(observationEntity);
    }

    public List<ObservationEntity> getAllObservations() {
        return observationRepository.findAll();
    }
}
