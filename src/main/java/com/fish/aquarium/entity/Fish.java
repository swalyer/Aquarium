// src/main/java/com/fish/aquarium/entity/Fish.java

package com.fish.aquarium.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "fishes")
public class Fish {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String species;
    private String imageUrl;
    private String position;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "aquarium_id")
    private Aquarium aquarium;

    // Конструкторы

    public Fish() {}

    public Fish(String name, String species, String imageUrl, String position, Aquarium aquarium) {
        this.name = name;
        this.species = species;
        this.imageUrl = imageUrl;
        this.position = position;
        this.aquarium = aquarium;
    }

    // Геттеры и сеттеры

    public Long getId() {
        return id;
    }

    public void setId(Long id) { // Добавлен сеттер
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) { // Добавлен сеттер
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) { // Добавлен сеттер
        this.species = species;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) { // Добавлен сеттер
        this.imageUrl = imageUrl;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) { // Добавлен сеттер
        this.position = position;
    }

    public Aquarium getAquarium() {
        return aquarium;
    }

    public void setAquarium(Aquarium aquarium) { // Добавлен сеттер
        this.aquarium = aquarium;
    }
}
