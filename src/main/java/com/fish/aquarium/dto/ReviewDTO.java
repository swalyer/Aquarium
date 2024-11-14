// src/main/java/com/fish/aquarium/dto/ReviewDTO.java

package com.fish.aquarium.dto;

public class ReviewDTO {
    private Long id;
    private String content;
    private int rating;
    private Long userId;
    private Long aquariumId;

    // Конструкторы

    public ReviewDTO() {}

    public ReviewDTO(Long id, String content, int rating, Long userId, Long aquariumId) {
        this.id = id;
        this.content = content;
        this.rating = rating;
        this.userId = userId;
        this.aquariumId = aquariumId;
    }

    // Геттеры и сеттеры

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getAquariumId() {
        return aquariumId;
    }

    public void setAquariumId(Long aquariumId) {
        this.aquariumId = aquariumId;
    }
}
