// src/main/java/com/fish/aquarium/mapper/DeviceMapper.java

package com.fish.aquarium.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.fish.aquarium.dto.DeviceDTO;
import com.fish.aquarium.entity.Device;

@Mapper(componentModel = "spring")
public interface DeviceMapper {

    DeviceMapper INSTANCE = Mappers.getMapper(DeviceMapper.class);

    @Mapping(source = "aquarium.id", target = "aquariumId")
    DeviceDTO toDTO(Device device);

    @Mapping(source = "aquariumId", target = "aquarium.id")
    Device toEntity(DeviceDTO dto);
}
