// src/main/java/com/fish/aquarium/mapper/ReviewMapper.java

package com.fish.aquarium.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.fish.aquarium.dto.ReviewDTO;
import com.fish.aquarium.entity.Review;

@Mapper(componentModel = "spring", uses = {UserMapper.class, AquariumMapper.class})
public interface ReviewMapper {

    ReviewMapper INSTANCE = Mappers.getMapper(ReviewMapper.class);

    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "aquarium.id", target = "aquariumId")
    ReviewDTO toDTO(Review review);

    @Mapping(source = "userId", target = "user.id")
    @Mapping(source = "aquariumId", target = "aquarium.id")
    Review toEntity(ReviewDTO reviewDTO);
}
