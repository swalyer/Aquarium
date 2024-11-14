package com.fish.aquarium.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.fish.aquarium.dto.PlantDTO;
import com.fish.aquarium.entity.Plant;

@Mapper(componentModel = "spring")
public interface PlantMapper {

    PlantMapper INSTANCE = Mappers.getMapper(PlantMapper.class);

    @Mapping(source = "aquarium.id", target = "aquariumId")
    PlantDTO toDTO(Plant plant);

    @Mapping(source = "aquariumId", target = "aquarium.id")
    Plant toEntity(PlantDTO dto);
}
