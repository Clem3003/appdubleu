package be.cbsaintlaurent.appdubleu.backend.domain.forum.message.dto;

import be.cbsaintlaurent.appdubleu.backend.user.dto.StLoUser;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Message {

    private UUID id;

    private String message;

    private StLoUser fromUser;
    private StLoUser toUser;

    private boolean isSent;
    private boolean isRead;
    private boolean isReplyable;
    private boolean areFriends;
    private boolean isContact;

    private LocalDateTime createdAt;
    private StLoUser createdBy;
}
