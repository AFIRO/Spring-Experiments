package com.zetta.springexperiments;

import com.zetta.springexperiments.entity.Car;
import com.zetta.springexperiments.entity.Coffee;
import com.zetta.springexperiments.entity.Owner;
import com.zetta.springexperiments.repository.CarRepository;
import com.zetta.springexperiments.repository.CoffeeRepository;
import com.zetta.springexperiments.repository.OwnerRepository;
import com.zetta.springexperiments.security.InternalUser;
import com.zetta.springexperiments.security.UserRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@Log4j2
@SpringBootApplication
public class SpringExperimentsApplication implements CommandLineRunner {
    @Autowired
    public CarRepository repository;
    @Autowired
    public OwnerRepository ownerRepository;
    @Autowired
    public UserRepository userRepository;
    @Autowired
    public CoffeeRepository coffeeRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringExperimentsApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
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
        repository.saveAll(Arrays.asList(car1, car2,
                car3));

        for (Car car : repository.findAll()) {
            log.info(car.getBrand() + " " + car
                    .getModel() + " " + car
                    .getOwner().getFirstName());
        }


        coffeeRepository.save(new Coffee("Black"));
        coffeeRepository.save(new Coffee("Mocha"));
    }
}
