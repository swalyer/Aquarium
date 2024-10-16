package com.fish.aquarium.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fish.aquarium.entity.Fish;

public interface FishRepository extends JpaRepository<Fish, Long> {
}