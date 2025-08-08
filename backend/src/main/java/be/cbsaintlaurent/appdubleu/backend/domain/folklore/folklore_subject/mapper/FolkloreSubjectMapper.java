package be.cbsaintlaurent.appdubleu.backend.domain.folklore.folklore_subject.mapper;

import be.cbsaintlaurent.appdubleu.backend.domain.folklore.folklore_subject.dto.FolkloreSubject;
import be.cbsaintlaurent.appdubleu.backend.domain.folklore.folklore_subject.entity.FolkloreSubjectEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FolkloreSubjectMapper {

    FolkloreSubjectEntity toEntity(FolkloreSubject dto);

    FolkloreSubject toDto(FolkloreSubjectEntity entity);

}
