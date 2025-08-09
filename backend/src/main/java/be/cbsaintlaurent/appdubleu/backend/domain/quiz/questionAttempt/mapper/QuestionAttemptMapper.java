package be.cbsaintlaurent.appdubleu.backend.domain.quiz.questionAttempt.mapper;

import be.cbsaintlaurent.appdubleu.backend.domain.quiz.questionAttempt.dto.QuestionAttempt;
import be.cbsaintlaurent.appdubleu.backend.domain.quiz.questionAttempt.entity.QuestionAttemptEntity;
import be.cbsaintlaurent.appdubleu.backend.user.mapper.StLoUserMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {StLoUserMapper.class, QuestionAttemptMapper.class})
public interface QuestionAttemptMapper {

    QuestionAttemptEntity toEntity(QuestionAttempt dto);

    QuestionAttempt toDto(QuestionAttemptEntity entity);

}