package be.cbsaintlaurent.appdubleu.backend.user.mapper;

import be.cbsaintlaurent.appdubleu.backend.user.dto.StLoUser;
import be.cbsaintlaurent.appdubleu.backend.user.entity.StLoUserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StLoUserMapper {
    StLoUserEntity toEntity(StLoUser dto);

    StLoUser toDto(StLoUserEntity entity);
}
