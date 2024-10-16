package com.fish.aquarium.controller;

import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fish.aquarium.entity.User;
import com.fish.aquarium.repository.UserRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
@Autowired
private UserRepository userRepository;

@Autowired
private PasswordEncoder passwordEncoder;
@PostMapping("/register")
public ResponseEntity<String> registerUser(@RequestBody User user){
    try{
        // gen unique personal number
        if(user.getPersonalNumber() ==null || user.getPersonalNumber().isEmpty()){
            Random random = new Random();
            user.setPersonalNumber(String.format("%010d", random.nextInt(1_000_000_000)));

        }// email unique
        Optional<User> existingUser = userRepository.findByEmail(user.getEmail());
        if(existingUser.isPresent()){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("User with this email is exists");
        }
        if(user.getPasswordHash() == null || user.getPasswordHash().isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Password can't be null");

        }
        String encodedPassword = passwordEncoder.encode(user.getPassword());

        user.setRole("USER");
        userRepository.save(user);
        return ResponseEntity.ok("User is succesfuly registeged");




    }catch(Exception e){
        e.printStackTrace();//create log
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Registration Error");
        

    }
}
}
