// src/main/java/com/fish/aquarium/dto/CreateUserRequest.java

package com.fish.aquarium.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CreateUserRequest {

    @NotBlank(message = "Имя пользователя не должно быть пустым")
    @Size(max = 100, message = "Имя пользователя должно содержать не более 100 символов")
    private String username;

    @NotBlank(message = "Email не должен быть пустым")
    @Email(message = "Неверный формат email")
    @Size(max = 100, message = "Email должен содержать не более 100 символов")
    private String email;

    @NotBlank(message = "Пароль не должен быть пустым")
    @Size(min = 6, max = 100, message = "Пароль должен содержать от 6 до 100 символов")
    private String password;

    // Геттеры и сеттеры

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
