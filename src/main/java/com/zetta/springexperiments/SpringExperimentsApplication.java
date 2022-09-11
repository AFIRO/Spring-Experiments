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

@SpringBootApplication
public class SpringExperimentsApplication{
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
