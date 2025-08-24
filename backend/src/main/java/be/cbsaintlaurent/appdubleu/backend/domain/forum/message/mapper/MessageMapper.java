package be.cbsaintlaurent.appdubleu.backend.domain.forum.message.mapper;

import be.cbsaintlaurent.appdubleu.backend.domain.forum.message.dto.Message;
import be.cbsaintlaurent.appdubleu.backend.domain.forum.message.entity.MessageEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MessageMapper {
    MessageEntity toEntity(Message dto);

    Message toDto(MessageEntity entity);

}
