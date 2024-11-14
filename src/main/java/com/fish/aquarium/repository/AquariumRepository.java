package com.fish.aquarium.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fish.aquarium.entity.Aquarium;

@Repository
public interface AquariumRepository extends JpaRepository<Aquarium, Long> {
    List<Aquarium> findByUserId(Long userId);
}
