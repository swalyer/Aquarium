package com.fish.aquarium.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CreateAquariumRequest {

    @NotBlank(message = "Название аквариума не должно быть пустым")
    @Size(max = 100, message = "Название аквариума должно содержать не более 100 символов")
    private String name;

    @Size(max = 500, message = "Описание аквариума должно содержать не более 500 символов")
    private String description;

    @NotNull(message = "ID пользователя обязателен")
    private Long userId;

    // Геттеры и сеттеры

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
