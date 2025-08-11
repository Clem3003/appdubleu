package be.cbsaintlaurent.appdubleu.backend.domain.quiz.quiz.mapper;

import be.cbsaintlaurent.appdubleu.backend.domain.folklore.baptismal_song.mapper.BaptismalSongMapper;
import be.cbsaintlaurent.appdubleu.backend.domain.folklore.folklore_subject.mapper.FolkloreSubjectMapper;
import be.cbsaintlaurent.appdubleu.backend.domain.folklore.pins.mapper.PinsMapper;
import be.cbsaintlaurent.appdubleu.backend.domain.quiz.question.dto.Question;
import be.cbsaintlaurent.appdubleu.backend.domain.quiz.question.entity.QuestionEntity;
import be.cbsaintlaurent.appdubleu.backend.domain.quiz.quiz.dto.Quiz;
import be.cbsaintlaurent.appdubleu.backend.domain.quiz.quiz.entity.QuizEntity;
import be.cbsaintlaurent.appdubleu.backend.user.mapper.StLoUserMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {StLoUserMapper.class, PinsMapper.class, BaptismalSongMapper.class, FolkloreSubjectMapper.class})
public interface QuizMapper {

    QuizEntity toEntity(Quiz dto);

    @Mapping(source = "createdBy", target = "createdBy", qualifiedByName = "toReducedDto")
    Quiz toDto(QuizEntity entity);

    List<Quiz> toDto(List<QuizEntity> entity);

}