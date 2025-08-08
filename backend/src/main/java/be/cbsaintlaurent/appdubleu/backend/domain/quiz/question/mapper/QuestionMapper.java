package be.cbsaintlaurent.appdubleu.backend.domain.quiz.question.mapper;

import be.cbsaintlaurent.appdubleu.backend.domain.folklore.baptismal_song.mapper.BaptismalSongMapper;
import be.cbsaintlaurent.appdubleu.backend.domain.folklore.folklore_subject.mapper.FolkloreSubjectMapper;
import be.cbsaintlaurent.appdubleu.backend.domain.folklore.pins.mapper.PinsMapper;
import be.cbsaintlaurent.appdubleu.backend.domain.quiz.question.dto.Question;
import be.cbsaintlaurent.appdubleu.backend.domain.quiz.question.entity.QuestionEntity;
import be.cbsaintlaurent.appdubleu.backend.user.mapper.StLoUserMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {StLoUserMapper.class, PinsMapper.class, BaptismalSongMapper.class, FolkloreSubjectMapper.class})
public interface QuestionMapper {

    QuestionEntity toEntity(Question dto);

    Question toDto(QuestionEntity entity);

}