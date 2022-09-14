package com.zetta.springexperiments.controller;

import com.zetta.springexperiments.entity.Car;
import com.zetta.springexperiments.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CarController {
    @Autowired
    private CarRepository carRepository;

    @GetMapping("/cars")
    List<Car> getAllCars() {
        return carRepository.findAll();
    }
}
