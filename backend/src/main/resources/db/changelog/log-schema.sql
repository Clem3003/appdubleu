--liquibase formatted sql


--changeset user-schema:7
CREATE TABLE st_lo_user_log (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    user_id UUID,
    username VARCHAR(255),
    action VARCHAR(255) NOT NULL,
    description TEXT,
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    CONSTRAINT fk_user_log_user FOREIGN KEY (user_id) REFERENCES st_lo_user_entity (id) ON DELETE CASCADE
);
