package com.zetta.springexperiments.controller;

import com.zetta.springexperiments.entity.Coffee;
import com.zetta.springexperiments.repository.CoffeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping(value = "/coffees")
@RestController
public class CoffeeController {
    @Autowired
    private CoffeeRepository coffeeRepository;

    @GetMapping("")
    private ResponseEntity<List<Coffee>> getAll() {
        return new ResponseEntity<>(coffeeRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    private Optional<Coffee> getCoffeeById(@PathVariable("id") String id) {
        return coffeeRepository.findById(id);
    }

    @PostMapping()
    private Coffee addCoffee(@RequestBody(required = true) Coffee coffee) {
        return coffeeRepository.save(coffee);
    }

    @PutMapping("/{id}")
    private ResponseEntity<Coffee> updateCoffee(@PathVariable String id, @RequestBody(required = true) Coffee coffee) {
        return coffeeRepository.existsById(id)
                ? new ResponseEntity<>(coffeeRepository.save(coffee), HttpStatus.OK)
                : new ResponseEntity<>(coffeeRepository.save(coffee),HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    private void deleteCoffee(@PathVariable String id) {
        coffeeRepository.deleteById(id);
    }

}
