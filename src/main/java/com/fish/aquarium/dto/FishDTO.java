package com.fish.aquarium.dto;

public class FishDTO {
    private Long id;
    private String name;
    private String species;
    private String imageUrl;
    private String position;
    private Long aquariumId;

    // Конструкторы

    public FishDTO() {}

    public FishDTO(Long id, String name, String species, String imageUrl, String position, Long aquariumId) {
        this.id = id;
        this.name = name;
        this.species = species;
        this.imageUrl = imageUrl;
        this.position = position;
        this.aquariumId = aquariumId;
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

    public Long getAquariumId() {
        return aquariumId;
    }

    public void setAquariumId(Long aquariumId) { // Добавлен сеттер
        this.aquariumId = aquariumId;
    }
}
