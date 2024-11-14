package com.fish.aquarium.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.fish.aquarium.dto.EventDTO;
import com.fish.aquarium.entity.Event;

@Mapper(componentModel = "spring", uses = {AquariumMapper.class})
public interface EventMapper {

    EventMapper INSTANCE = Mappers.getMapper(EventMapper.class);

    @Mapping(source = "aquarium.id", target = "aquariumId")
    EventDTO toDTO(Event event);

    @Mapping(source = "aquariumId", target = "aquarium.id")
    Event toEntity(EventDTO eventDTO);
}
