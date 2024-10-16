package com.fish.aquarium.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fish.aquarium.entity.Aquarium;

import java.util.List;

public interface AquariumRepository extends JpaRepository<Aquarium, Long> {
    List<Aquarium> findByUserId(Long userId);
}