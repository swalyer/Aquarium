// src/main/java/com/fish/aquarium/dto/CreateFishRequest.java

package com.fish.aquarium.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CreateFishRequest {

    @NotBlank(message = "Название рыбы не должно быть пустым")
    @Size(max = 100, message = "Название рыбы должно содержать не более 100 символов")
    private String name;

    @NotBlank(message = "Вид рыбы не должен быть пустым")
    @Size(max = 100, message = "Вид рыбы должен содержать не более 100 символов")
    private String species;

    @Size(max = 255, message = "URL изображения не должен превышать 255 символов")
    private String imageUrl;

    @Size(max = 50, message = "Позиция не должна превышать 50 символов")
    private String position;

    @NotNull(message = "ID аквариума обязателен")
    private Long aquariumId;

   // Геттеры и сеттеры

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
