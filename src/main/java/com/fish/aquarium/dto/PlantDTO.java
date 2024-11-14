package com.fish.aquarium.dto;

public class PlantDTO {
    private Long id;
    private String name;
    private String species;
    private String imageUrl;
    private String position;
    private Long aquariumId;

    // Конструкторы
    public PlantDTO() {}

    public PlantDTO(Long id, String name, String species, String imageUrl, String position, Long aquariumId) {
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

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Long getAquariumId() {
        return aquariumId;
    }

    public void setAquariumId(Long aquariumId) {
        this.aquariumId = aquariumId;
    }

    
}
