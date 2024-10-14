package com.fish.aquarium.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AquariumService {

    @Autowired
    private AquariumRepository aquariumRepository;

    public Aquarium createAquarium(Aquarium aquarium) {
        return aquariumRepository.save(aquarium);
    }

    public Aquarium getAquariumById(Long id) {
        return aquariumRepository.findById(id).orElse(null);
    }

    public List<Aquarium> getAquariumsByUserId(Long userId) {
        return aquariumRepository.findByUserId(userId);
    }
}