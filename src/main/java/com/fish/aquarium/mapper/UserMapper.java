import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.fish.aquarium.dto.UserDTO;
import com.fish.aquarium.entity.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "passwordHash", ignore = true)
    @Mapping(target = "aquariums", ignore = true)
    @Mapping(target = "authorities", ignore = true)
    UserDTO toDTO(User user);

    @Mapping(target = "passwordHash", ignore = true)
    @Mapping(target = "aquariums", ignore = true)
    @Mapping(target = "authorities", ignore = true)
    User toEntity(UserDTO userDTO);
}
