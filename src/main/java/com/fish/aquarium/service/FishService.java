// src/main/java/com/fish/aquarium/service/FishService.java

package com.fish.aquarium.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fish.aquarium.dto.CreateFishRequest;
import com.fish.aquarium.dto.FishDTO;
import com.fish.aquarium.entity.Aquarium;
import com.fish.aquarium.entity.Fish;
import com.fish.aquarium.mapper.FishMapper;
import com.fish.aquarium.repository.AquariumRepository;
import com.fish.aquarium.repository.FishRepository;

@Service
public class FishService {

    @Autowired
    private FishRepository fishRepository;

    @Autowired
    private AquariumRepository aquariumRepository;

    @Autowired
    private FishMapper fishMapper;

    // Получение всех рыб
    public List<FishDTO> getAllFish() {
        List<Fish> fishes = fishRepository.findAll();
        return fishes.stream()
                     .map(fishMapper::toDTO)
                     .collect(Collectors.toList());
    }

    // Получение рыб по ID аквариума
    public List<FishDTO> getFishByAquariumId(Long aquariumId) {
        List<Fish> fishes = fishRepository.findByAquariumId(aquariumId);
        return fishes.stream()
                     .map(fishMapper::toDTO)
                     .collect(Collectors.toList());
    }

    // Создание новой рыбы
    public FishDTO createFish(CreateFishRequest request) {
        Aquarium aquarium = aquariumRepository.findById(request.getAquariumId())
                                              .orElseThrow(() -> new RuntimeException("Аквариум не найден"));

        Fish fish = new Fish();
        fish.setName(request.getName());
        fish.setSpecies(request.getSpecies());
        fish.setImageUrl(request.getImageUrl());
        fish.setPosition(request.getPosition());
        fish.setAquarium(aquarium);

        Fish savedFish = fishRepository.save(fish);
        return fishMapper.toDTO(savedFish);
    }

    // Другие методы (обновление, удаление) по необходимости
}
