package com.zetta.springexperiments.controller;

import com.zetta.springexperiments.entity.Coffee;
import com.zetta.springexperiments.repository.CoffeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CoffeeController {
    @Autowired
    private CoffeeRepository coffeeRepository;

    @GetMapping("/coffees")
    private List<Coffee> getAll(){
        return coffeeRepository.findAll();
    }

    @GetMapping("/coffees/{id}")
    private Coffee getCoffeeById(@PathVariable("id") String id){
        return coffeeRepository.getReferenceById(id);
    }
}
