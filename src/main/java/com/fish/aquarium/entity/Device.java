// src/main/java/com/fish/aquarium/entity/Device.java

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
@Table(name = "devices")
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;
    private String brand;
    private String model;
    private String imageUrl;
    private String status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "aquarium_id")
    private Aquarium aquarium;

    // Конструкторы

    public Device() {}

    public Device(String type, String brand, String model, String imageUrl, String status, Aquarium aquarium) {
        this.type = type;
        this.brand = brand;
        this.model = model;
        this.imageUrl = imageUrl;
        this.status = status;
        this.aquarium = aquarium;
    }

    // Геттеры и сеттеры

    public Long getId() {
        return id;
    }

    public void setId(Long id) { 
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) { // Добавлен сеттер
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) { // Добавлен сеттер
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) { // Добавлен сеттер
        this.model = model;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) { // Добавлен сеттер
        this.imageUrl = imageUrl;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) { // Добавлен сеттер
        this.status = status;
    }

    public Aquarium getAquarium() {
        return aquarium;
    }

    public void setAquarium(Aquarium aquarium) {
        this.aquarium = aquarium;
    }
}
