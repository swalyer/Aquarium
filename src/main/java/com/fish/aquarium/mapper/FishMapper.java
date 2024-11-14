// src/main/java/com/fish/aquarium/mapper/FishMapper.java

package com.fish.aquarium.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.fish.aquarium.dto.FishDTO;
import com.fish.aquarium.entity.Fish;

@Mapper(componentModel = "spring")
public interface FishMapper {

    FishMapper INSTANCE = Mappers.getMapper(FishMapper.class);

    @Mapping(source = "aquarium.id", target = "aquariumId")
    FishDTO toDTO(Fish fish);

    @Mapping(source = "aquariumId", target = "aquarium.id")
    Fish toEntity(FishDTO dto);
}
