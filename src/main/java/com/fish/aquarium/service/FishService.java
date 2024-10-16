package com.fish.aquarium.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fish.aquarium.entity.Fish;
import com.fish.aquarium.repository.FishRepository;
@Service
public class FishService {

    @Autowired
    private FishRepository fishRepository;

    public Fish addFish(Fish fish) {
        return fishRepository.save(fish);
    }

    public void deleteFish(Long id) {
        fishRepository.deleteById(id);
    }
}