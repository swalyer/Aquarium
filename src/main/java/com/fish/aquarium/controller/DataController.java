package com.fish.aquarium.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fish.aquarium.entity.Aquarium;
import com.fish.aquarium.entity.Fish;
import com.fish.aquarium.entity.Plant;
import com.fish.aquarium.repository.AquariumRepository;
import com.fish.aquarium.repository.FishRepository;
import com.fish.aquarium.repository.PlantRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class DataController {

    @Autowired
    private FishRepository fishRepository;

    @Autowired
    private PlantRepository plantRepository;

    @GetMapping("/fish")
    public List<Fish> getAllFish() {
        return fishRepository.findAll();
    }

    @GetMapping("/plants")
    public List<Plant> getAllPlants() {
        return plantRepository.findAll();
    }

    @GetMapping("/aquariums")
    public List<Aquarium> getAllAquariums() {
        return aquariumRepository.findAll();
    }

    @Autowired
    private AquariumRepository aquariumRepository;
}
