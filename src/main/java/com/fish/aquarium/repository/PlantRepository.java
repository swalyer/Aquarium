package com.fish.aquarium.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fish.aquarium.entity.Plant;

@Repository
public interface PlantRepository extends JpaRepository<Plant, Long> {

}
