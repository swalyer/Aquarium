package com.fish.aquarium.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.fish.aquarium.dto.AquariumDTO;
import com.fish.aquarium.entity.Aquarium;

@Mapper(componentModel = "spring", uses = {FishMapper.class, PlantMapper.class, DeviceMapper.class, EventMapper.class, ReviewMapper.class})
public interface AquariumMapper {

    AquariumMapper INSTANCE = Mappers.getMapper(AquariumMapper.class);

    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "fishes", target = "fishes")
    @Mapping(source = "plants", target = "plants")
    @Mapping(source = "devices", target = "devices")
    @Mapping(source = "events", target = "events")
    @Mapping(source = "reviews", target = "reviews")
    AquariumDTO toDTO(Aquarium aquarium);

    @Mapping(source = "userId", target = "user.id")
    @Mapping(source = "fishes", target = "fishes")
    @Mapping(source = "plants", target = "plants")
    @Mapping(source = "devices", target = "devices")
    @Mapping(source = "events", target = "events")
    @Mapping(source = "reviews", target = "reviews")
    Aquarium toEntity(AquariumDTO dto);
}
