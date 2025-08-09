package be.cbsaintlaurent.appdubleu.backend.domain.season.mapper;

import be.cbsaintlaurent.appdubleu.backend.domain.season.dto.BaptismalSeason;
import be.cbsaintlaurent.appdubleu.backend.domain.season.entity.BaptismalSeasonEntity;
import be.cbsaintlaurent.appdubleu.backend.user.mapper.StLoUserMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {StLoUserMapper.class})
public interface BaptismalSeasonMapper {

    BaptismalSeasonEntity toEntity(BaptismalSeason dto);

    @Mapping(source = "createdBy", target = "createdBy", qualifiedByName = "toReducedDto")
    BaptismalSeason toDto(BaptismalSeasonEntity entity);

}
