package com.fish.aquarium.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fish.aquarium.entity.Plant;
import com.fish.aquarium.repository.PlantRepository;

@Service
public class PlantService {

    @Autowired
    private PlantRepository plantRepository;

    public Plant addPlant(Plant plant) {
        return plantRepository.save(plant);
    }

    public void deletePlant(Long id) {
        plantRepository.deleteById(id);
    }
}