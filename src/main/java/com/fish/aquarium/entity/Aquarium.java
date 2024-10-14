package com.fish.aquarium.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Aquarium {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private double temperature;
    private String description;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "aquarium", cascade = CascadeType.ALL)
    private List<Fish> fishes;

    @OneToMany(mappedBy = "aquarium", cascade = CascadeType.ALL)
    private List<Plant> plants;

    // getters and setters
}