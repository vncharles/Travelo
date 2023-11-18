package com.fit.Travelo.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private ERole name;
    private String description;

    public Role() {

    }

    public Role(ERole name) {
        this.name = name;
    }
}