package be.cbsaintlaurent.appdubleu.backend.domain.forum.message.service;

import be.cbsaintlaurent.appdubleu.backend.domain.folklore.folklore_subject.repository.FolkloreSubjectRepository;
import be.cbsaintlaurent.appdubleu.backend.domain.forum.message.mapper.MessageMapper;
import be.cbsaintlaurent.appdubleu.backend.domain.forum.message.repository.MessageRepository;
import be.cbsaintlaurent.appdubleu.backend.domain.quiz.question.dto.NewQuestionRequest;
import be.cbsaintlaurent.appdubleu.backend.domain.quiz.question.dto.Question;
import be.cbsaintlaurent.appdubleu.backend.domain.quiz.question.entity.QuestionEntity;
import be.cbsaintlaurent.appdubleu.backend.domain.quiz.question.mapper.QuestionMapper;
import be.cbsaintlaurent.appdubleu.backend.domain.quiz.question.repository.QuestionRepository;
import be.cbsaintlaurent.appdubleu.backend.user.entity.StLoUserEntity;
import be.cbsaintlaurent.appdubleu.backend.user.repository.StLoUserRepository;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class MessageService {

    @Getter(AccessLevel.PROTECTED)
    private final MessageRepository repository;
    @Getter(AccessLevel.PROTECTED)
    private final MessageMapper mapper;


}