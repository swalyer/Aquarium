// src/main/java/com/fish/aquarium/dto/UserDTO.java

package com.fish.aquarium.dto;

import java.util.Set;

public class UserDTO {
    private Long id;
    private String username;
    private String email;
    private Set<String> roles;
    // Добавляем необходимые поля, если требуется
    // private List<AquariumDTO> aquariums;
    // private Set<GrantedAuthority> authorities;

    // Конструкторы

    public UserDTO() {}

    public UserDTO(Long id, String username, String email, Set<String> roles) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.roles = roles;
    }

    // Геттеры и сеттеры

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }

   
}
