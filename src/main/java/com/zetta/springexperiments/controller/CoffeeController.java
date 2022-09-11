package com.zetta.springexperiments.controller;

import com.zetta.springexperiments.entity.Coffee;
import com.zetta.springexperiments.repository.CoffeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RequestMapping(value = "/coffees")
@RestController
public class CoffeeController {
    @Autowired
    private CoffeeRepository coffeeRepository;

    @GetMapping("")
    private List<Coffee> getAll(){
        return coffeeRepository.findAll();
    }

    @GetMapping("/{id}")
    private Optional<Coffee> getCoffeeById(@PathVariable("id") String id){
        return coffeeRepository.findById(id);
    }

    @PostMapping()
    private void addCoffee(@RequestBody(required = true) Coffee coffee){
        coffeeRepository.save(coffee);
    }

    @PutMapping("/{id}")
    private void addCoffee(@PathVariable String id, @RequestBody(required = true) Coffee coffee){
        Optional<Coffee> optionalCoffee = coffeeRepository.findById(id);
        if (optionalCoffee.isPresent()){
            Coffee coffeeInDb = optionalCoffee.get();
            coffeeInDb.setName(coffee.getName());
            coffeeRepository.save(coffeeInDb);
        }
    }

    @DeleteMapping("/{id}")
    private void deleteCoffee(@PathVariable String id){
        coffeeRepository.deleteById(id);
    }

}
