// src/main/java/com/fish/aquarium/controller/AquariumController.java

package com.fish.aquarium.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fish.aquarium.dto.AquariumDTO;
import com.fish.aquarium.dto.CreateAquariumRequest;
import com.fish.aquarium.service.AquariumService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/aquariums")
@CrossOrigin(origins = "http://localhost:3000")
public class AquariumController {

    @Autowired
    private AquariumService aquariumService;

    // Получение всех аквариумов
    @GetMapping
    public ResponseEntity<List<AquariumDTO>> getAllAquariums() {
        List<AquariumDTO> aquariums = aquariumService.getAllAquariums();
        return ResponseEntity.ok(aquariums);
    }

    // Получение аквариумов по ID пользователя
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<AquariumDTO>> getAquariumsByUserId(@PathVariable Long userId) {
        List<AquariumDTO> aquariums = aquariumService.getAquariumsByUserId(userId);
        return ResponseEntity.ok(aquariums);
    }

    // Создание нового аквариума
    @PostMapping
    public ResponseEntity<AquariumDTO> createAquarium(@Valid @RequestBody CreateAquariumRequest request) {
        AquariumDTO aquariumDTO = aquariumService.createAquarium(request);
        return ResponseEntity.ok(aquariumDTO);
    }

    // Другие эндпоинты (обновление, удаление) по необходимости
}
