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

import com.fish.aquarium.dto.CreateFishRequest;
import com.fish.aquarium.dto.FishDTO;
import com.fish.aquarium.service.FishService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/fishes")
@CrossOrigin(origins = "http://localhost:3000")
public class FishController {

    @Autowired
    private FishService fishService;

    // Получение всех рыб
    @GetMapping
    public ResponseEntity<List<FishDTO>> getAllFish() {
        List<FishDTO> fishes = fishService.getAllFish();
        return ResponseEntity.ok(fishes);
    }

    // Получение рыб по ID аквариума
    @GetMapping("/aquarium/{aquariumId}")
    public ResponseEntity<List<FishDTO>> getFishByAquariumId(@PathVariable Long aquariumId) {
        List<FishDTO> fishes = fishService.getFishByAquariumId(aquariumId);
        return ResponseEntity.ok(fishes);
    }

    // Создание новой рыбы
    @PostMapping
    public ResponseEntity<FishDTO> createFish(@Valid @RequestBody CreateFishRequest request) {
        FishDTO fishDTO = fishService.createFish(request);
        return ResponseEntity.ok(fishDTO);
    }

    // Другие эндпоинты (обновление, удаление) по необходимости
}
