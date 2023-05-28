package ru.joker.spring.PetSpringProject.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;

import java.time.LocalDateTime;

@Entity
@Table(name = "Measurement")
public class Measurement {


    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "value")
    @NotEmpty(message = "Value shouldn't be empty!")
    private Double value;

    @Column(name = "raining")
    @NotEmpty(message = "Raining field shouldn't be empty!")
    private boolean raining;

    @Column(name = "measurement_date_time")
    @NotEmpty(message = "Date and time shouldn't be empty!")
    private LocalDateTime measurementDateTime;

    private Sensor sensor;
}
