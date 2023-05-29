package ru.joker.spring.PetSpringProject.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.joker.spring.PetSpringProject.repositories.MeasurementRepository;

@Service
public class MeasurementService {

    private MeasurementRepository measurementRepository;

    @Autowired
    public MeasurementService(MeasurementRepository measurementRepository) {
        this.measurementRepository = measurementRepository;
    }
}
