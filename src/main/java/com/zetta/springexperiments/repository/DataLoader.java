package com.zetta.springexperiments.repository;

import com.zetta.springexperiments.entity.Car;
import com.zetta.springexperiments.entity.Coffee;
import com.zetta.springexperiments.entity.Owner;
import com.zetta.springexperiments.security.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Component
@AllArgsConstructor
public class DataLoader {
    @Autowired
    public CarRepository carRepository;
    @Autowired
    public OwnerRepository ownerRepository;
    @Autowired
    public UserRepository userRepository;
    @Autowired
    public CoffeeRepository coffeeRepository;

    @PostConstruct
    private void loadData(){
        Owner owner1 = new Owner("John", "Johnson");
        Owner owner2 = new Owner("Mary", "Robinson");
        ownerRepository.saveAll(Arrays.asList(owner1,
                owner2));

        Car car1 = new Car("Ford", "Mustang", "Red",
                "ADF-1121", 2021, 59000, owner1);
        Car car2 = new Car("Nissan", "Leaf", "White",
                "SSJ-3002", 2019, 29000, owner2);
        Car car3 = new Car("Toyota", "Prius", "Silver",
                "KKO-0212", 2020, 39000, owner2);
        carRepository.saveAll(Arrays.asList(car1, car2,
                car3));

        coffeeRepository.save(new Coffee("Black"));
        coffeeRepository.save(new Coffee("Mocha"));
    }
}
