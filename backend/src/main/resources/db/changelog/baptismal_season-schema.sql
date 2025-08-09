--liquibase formatted sql

--changeset baptismal_season-schema:10
CREATE TABLE baptismal_season_entity (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    start_year INTEGER,
    end_year INTEGER,
    title VARCHAR(255),
    picture_url VARCHAR(1024),
    created_by_id UUID,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    active BOOLEAN NOT NULL DEFAULT FALSE,
    CONSTRAINT fk_baptismal_created_by_id FOREIGN KEY (created_by_id) REFERENCES st_lo_user_entity(id)
);