package be.cbsaintlaurent.appdubleu.backend.domain.season.mapper;

import be.cbsaintlaurent.appdubleu.backend.domain.season.dto.BaptismalSeason;
import be.cbsaintlaurent.appdubleu.backend.domain.season.entity.BaptismalSeasonEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BaptismalSeasonMapper {

    BaptismalSeasonEntity toEntity(BaptismalSeason dto);

    BaptismalSeason toDto(BaptismalSeasonEntity entity);

}
