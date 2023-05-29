package ru.joker.spring.PetSpringProject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.joker.spring.PetSpringProject.models.Sensor;


@Repository
public interface SensorRepository extends JpaRepository<Sensor, Integer> {
}
