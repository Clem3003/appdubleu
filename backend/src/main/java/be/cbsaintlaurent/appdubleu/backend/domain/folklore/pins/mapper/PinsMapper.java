package be.cbsaintlaurent.appdubleu.backend.domain.folklore.pins.mapper;

import be.cbsaintlaurent.appdubleu.backend.domain.folklore.pins.dto.Pins;
import be.cbsaintlaurent.appdubleu.backend.domain.folklore.pins.entity.PinsEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PinsMapper {
    PinsEntity toEntity(Pins dto);

//    @Mapping(source = "createdBy", target = "createdBy", qualifiedByName = "toReducedDto")
    Pins toDto(PinsEntity entity);

}
