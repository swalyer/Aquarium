package com.fish.aquarium.service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.fish.aquarium.dto.RegisterRequest;
import com.fish.aquarium.entity.User;
import com.fish.aquarium.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void registerUser(RegisterRequest registerRequest) {
        User user = new User();
        user.setEmail(registerRequest.getEmail());
        String hashedPassword = passwordEncoder.encode(registerRequest.getPassword());
        user.setPasswordHash(hashedPassword);
        userRepository.save(user);
    }
}


