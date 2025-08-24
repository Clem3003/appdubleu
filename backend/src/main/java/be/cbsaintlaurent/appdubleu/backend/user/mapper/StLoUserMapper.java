package be.cbsaintlaurent.appdubleu.backend.user.mapper;

import be.cbsaintlaurent.appdubleu.backend.user.dto.StLoUser;
import be.cbsaintlaurent.appdubleu.backend.user.entity.StLoUserEntity;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StLoUserMapper {
    StLoUserEntity toEntity(StLoUser dto);

    StLoUser toDto(StLoUserEntity entity);

    // ✅ mapping réduit : ne prend que id et username
    @Named("toReducedDto")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "username", source = "username")
    StLoUser toReducedDto(StLoUserEntity entity);

    // ✅ mapping réduit : ne prend que id et username
    @Named("toUsernameOnlyDto")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "username", source = "username")
    @Mapping(target = "firstname", source = "firstname")
    @Mapping(target = "lastname", source = "lastname")
    @Mapping(target = "nickname", source = "nickname")
    StLoUser toUsernameOnlyDto(StLoUserEntity entity);

    List<StLoUser> toUsernameOnlyDtoList(List<StLoUserEntity> entities);
}
