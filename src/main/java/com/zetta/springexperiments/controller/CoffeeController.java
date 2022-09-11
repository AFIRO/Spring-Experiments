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
    private ResponseEntity<List<Coffee>> getAll(){
        return new ResponseEntity<>(coffeeRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    private Optional<Coffee> getCoffeeById(@PathVariable("id") String id){
        return coffeeRepository.findById(id);
    }

    @PostMapping()
    private Coffee addCoffee(@RequestBody(required = true) Coffee coffee){
        coffeeRepository.save(coffee);
        return coffee;
    }

    @PutMapping("/{id}")
    private ResponseEntity<Coffee> updateCoffee(@PathVariable String id, @RequestBody(required = true) Coffee coffee){
        Optional<Coffee> optionalCoffee = coffeeRepository.findById(id);
        if (optionalCoffee.isPresent()){
            Coffee coffeeInDb = optionalCoffee.get();
            coffeeInDb.setName(coffee.getName());
            coffeeRepository.save(coffeeInDb);
            return new ResponseEntity<>(coffeeInDb,HttpStatus.OK);
        } else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Coffee> deleteCoffee(@PathVariable String id){
        if (coffeeRepository.existsById(id)){
        coffeeRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);}
        else return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}
