package com.zetta.springexperiments.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class Coffee {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @Column(name = "id", nullable = false)
    private String id;
    private String name;

    public Coffee(String name) {
        this.name = name;
    }
}
