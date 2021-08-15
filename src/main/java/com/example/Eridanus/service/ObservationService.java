package com.example.Eridanus.service;

import com.example.Eridanus.dto.ObservationDTO;
import com.example.Eridanus.entity.ObservationEntity;
import com.example.Eridanus.repository.ObservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Service
public class ObservationService {

    @Autowired
    ObservationRepository observationRepository;

    public void addObservation(ObservationDTO observationDTO, LocalDateTime startDateTime, LocalDateTime endDateTime) {
        ObservationEntity observationEntity = new ObservationEntity();

        Date startDTAsDate = convertToDateViaInstant(startDateTime);
        Date endDTAsDate = convertToDateViaInstant(endDateTime);

        observationEntity.setObservationStart(startDTAsDate);
        observationEntity.setObservationEnd(endDTAsDate);
        observationEntity.setObservationMethod(observationDTO.getObsMethod());
        observationEntity.setObservationTarget(observationDTO.getObsTarget());

        if (!observationDTO.getObsDetails().isEmpty()) {
            observationEntity.setObservationDetails(observationDTO.getObsDetails());
        }

        observationRepository.save(observationEntity);
    }

    public List<ObservationEntity> getAllObservations() {
        return observationRepository.findAll();
    }

    public void deleteObservation(long id) {
        observationRepository.deleteById(id);
    }

    //SPECIAL METHODS
    //REF: https://www.baeldung.com/java-date-to-localdate-and-localdatetime
    public LocalDateTime convertToLocalDateTimeViaInstant(Date dateToConvert) {
        return dateToConvert.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
    }

    //REF: https://www.baeldung.com/java-date-to-localdate-and-localdatetime
    Date convertToDateViaInstant(LocalDateTime dateToConvert) {
        return java.util.Date
                .from(dateToConvert.atZone(ZoneId.systemDefault())
                        .toInstant());
    }
}
