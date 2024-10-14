package com.fish.aquarium.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AquariumRepository extends JpaRepository<Aquarium, Long> {
    List<Aquarium> findByUserId(Long userId);
}