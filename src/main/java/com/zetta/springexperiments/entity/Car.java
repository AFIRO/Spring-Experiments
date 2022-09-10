package com.zetta.springexperiments.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String brand, model, color, registerNumber;
    @Column(name = "explanation", nullable = false, length = 512)
    private String description;
    private int buildYear, price;
    @ManyToOne
    @JoinColumn(name = "owner")
    private Owner owner;

    public Car(String brand, String model, String registerNumber, String description, int buildYear, int price, Owner owner) {
        this.brand = brand;
        this.model = model;
        this.registerNumber = registerNumber;
        this.description = description;
        this.buildYear = buildYear;
        this.price = price;
        this.owner = owner;
    }
}

