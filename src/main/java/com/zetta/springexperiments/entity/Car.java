package com.zetta.springexperiments.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Getter
@Setter
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String brand, model, registerNumber;
    @Column(name = "explanation", nullable = false, length = 512)
    private String description;
    private int buildYear, price;
}
