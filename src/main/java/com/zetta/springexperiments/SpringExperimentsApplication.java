package com.zetta.springexperiments;

import com.zetta.springexperiments.repository.CarRepository;
import com.zetta.springexperiments.repository.CoffeeRepository;
import com.zetta.springexperiments.repository.OwnerRepository;
import com.zetta.springexperiments.security.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringExperimentsApplication {
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
}
