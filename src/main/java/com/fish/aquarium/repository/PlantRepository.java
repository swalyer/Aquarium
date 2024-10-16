package com.fish.aquarium.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fish.aquarium.entity.Plant;

public interface PlantRepository extends JpaRepository<Plant, Long> {
}