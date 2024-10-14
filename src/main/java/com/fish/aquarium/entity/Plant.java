package com.fish.aquarium.entity;

import jakarta.persistence.*;

@Entity
public class Plant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String type;

    @ManyToOne
    @JoinColumn(name = "aquarium_id", nullable = false)
    private Aquarium aquarium;

    // getters and setters
}