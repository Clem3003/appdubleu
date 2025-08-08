package be.cbsaintlaurent.appdubleu.backend.domain.folklore.folklore_subject.mapper;

import be.cbsaintlaurent.appdubleu.backend.domain.folklore.folklore_subject.dto.FolkloreSubject;
import be.cbsaintlaurent.appdubleu.backend.domain.folklore.folklore_subject.entity.FolkloreSubjectEntity;
import be.cbsaintlaurent.appdubleu.backend.domain.folklore.pins.mapper.PinsMapper;
import be.cbsaintlaurent.appdubleu.backend.domain.season.mapper.BaptismalSeasonMapper;
import be.cbsaintlaurent.appdubleu.backend.user.mapper.StLoUserMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses =  {StLoUserMapper.class, PinsMapper.class, FolkloreSubjectMapper.class, BaptismalSeasonMapper.class})
public interface FolkloreSubjectMapper {

    @Mapping(source = "baptismalSeason", target = "baptismalSeasonEntity")
    @Mapping(source = "createdBy", target = "createdBy")
    FolkloreSubjectEntity toEntity(FolkloreSubject dto);

    FolkloreSubject toDto(FolkloreSubjectEntity entity);

}
