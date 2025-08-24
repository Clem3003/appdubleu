package be.cbsaintlaurent.appdubleu.backend.domain.forum.message.repository;

import be.cbsaintlaurent.appdubleu.backend.domain.forum.message.dto.Message;
import be.cbsaintlaurent.appdubleu.backend.domain.forum.message.entity.MessageEntity;
import be.cbsaintlaurent.appdubleu.backend.domain.quiz.question.dto.Question;
import be.cbsaintlaurent.appdubleu.backend.domain.quiz.question.entity.QuestionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface MessageRepository extends JpaRepository<MessageEntity, Message> {

}
