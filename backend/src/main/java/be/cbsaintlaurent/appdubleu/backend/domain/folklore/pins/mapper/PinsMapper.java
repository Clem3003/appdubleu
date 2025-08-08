package be.cbsaintlaurent.appdubleu.backend.domain.folklore.pins.mapper;

import be.cbsaintlaurent.appdubleu.backend.domain.folklore.pins.dto.Pins;
import be.cbsaintlaurent.appdubleu.backend.domain.folklore.pins.entity.PinsEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PinsMapper {
    PinsEntity toEntity(Pins dto);

    Pins toDto(PinsEntity entity);

}
