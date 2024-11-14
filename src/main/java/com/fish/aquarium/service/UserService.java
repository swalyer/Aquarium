// src/main/java/com/fish/aquarium/service/UserService.java

package com.fish.aquarium.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fish.aquarium.dto.CreateUserRequest;
import com.fish.aquarium.dto.UserDTO;
import com.fish.aquarium.entity.User;
import com.fish.aquarium.mapper.UserMapper;
import com.fish.aquarium.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    // Получение всех пользователей
    public List<UserDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                    .map(userMapper::toDTO)
                    .collect(Collectors.toList());
    }

    // Создание нового пользователя
    public UserDTO createUser(CreateUserRequest request) {
        User user = new User();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPasswordHash(request.getPasswordHash());

        User savedUser = userRepository.save(user);
        return userMapper.toDTO(savedUser);
    }

    // Другие методы (обновление, удаление) по необходимости
}
