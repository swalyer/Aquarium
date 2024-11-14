package com.fish.aquarium.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fish.aquarium.entity.Fish;

@Repository
public interface FishRepository extends JpaRepository<Fish, Long> {
    List<Fish> findByAquariumId(Long aquariumId);
}
