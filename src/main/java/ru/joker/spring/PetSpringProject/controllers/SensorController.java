package ru.joker.spring.PetSpringProject.controllers;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ru.joker.spring.PetSpringProject.dto.SensorDTO;
import ru.joker.spring.PetSpringProject.models.Sensor;
import ru.joker.spring.PetSpringProject.services.SensorService;
import org.modelmapper.ModelMapper;

import java.util.List;

@RestController
@RequestMapping("/sensors")
public class SensorController {

    private SensorService sensorService;

    private ModelMapper modelMapper;

    @Autowired
    public SensorController(SensorService sensorService, ModelMapper modelMapper) {
        this.sensorService = sensorService;
        this.modelMapper = modelMapper;
    }

    @PostMapping("/registration")
    public ResponseEntity<HttpStatus> register(@RequestBody @Valid SensorDTO sensorDTO,
                                               BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            StringBuilder stringBuilder = new StringBuilder();

            List<FieldError> errors = bindingResult.getFieldErrors();

            for (FieldError error : errors) {
                stringBuilder.append(error.getField())
                    .append(" - ").append(error.getDefaultMessage())
                    .append(";");
            }

            //TODO exception
        }

        sensorService.register(convertDTOToSensor(sensorDTO));

        return ResponseEntity.ok(HttpStatus.OK);
    }


    private SensorDTO convertSensorToDTO(Sensor sensor) {
        return modelMapper.map(sensor, SensorDTO.class);
    }

    private Sensor convertDTOToSensor(SensorDTO sensorDTO) {
        return modelMapper.map(sensorDTO, Sensor.class);
    }

}
