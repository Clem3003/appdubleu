package be.cbsaintlaurent.appdubleu.backend.domain.forum.message.entity;

import be.cbsaintlaurent.appdubleu.backend.user.entity.StLoUserEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "message_entity")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MessageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(length = 255)
    private String message;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "from_user_id", referencedColumnName = "id")
    private StLoUserEntity fromUser;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "to_user_id", referencedColumnName = "id")
    private StLoUserEntity toUser;

    @Column(nullable = false)
    private boolean isSent = false;

    @Column(nullable = false)
    private boolean isRead = false;

    @Column(nullable = false)
    private boolean isReplyable = false;

    @Column(nullable = false)
    private boolean areFriends = false;

    @Column(nullable = false)
    private boolean isContact = false;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by_id", referencedColumnName = "id")
    private StLoUserEntity createdBy;
}
