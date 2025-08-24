--liquibase formatted sql

--changeset user-schema:2
CREATE TABLE message_entity (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    message VARCHAR(255),
    from_user_id UUID,
    to_user_id UUID,
    is_sent BOOLEAN NOT NULL DEFAULT FALSE,
    is_read BOOLEAN NOT NULL DEFAULT FALSE,
    is_replyable BOOLEAN NOT NULL DEFAULT FALSE,
    are_friends BOOLEAN NOT NULL DEFAULT FALSE,
    is_contact BOOLEAN NOT NULL DEFAULT FALSE,
    created_at DATE,
    created_by_id UUID,
    CONSTRAINT fk_message_created_by_id
        FOREIGN KEY (created_by_id)
          REFERENCES st_lo_user_entity(id),
    CONSTRAINT fk_message_from_user_id
        FOREIGN KEY (from_user_id)
            REFERENCES st_lo_user_entity(id),
    CONSTRAINT fk_message_to_user_id
        FOREIGN KEY (to_user_id)
            REFERENCES st_lo_user_entity(id)
);
