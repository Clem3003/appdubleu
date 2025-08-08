--liquibase formatted sql

--changeset baptismal_season-schema:1
CREATE TABLE baptismal_season_entity (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    start_year INTEGER,
    end_year INTEGER,
    title VARCHAR(255),
    picture_url VARCHAR(1024),
    creator_id INTEGER,
    creation_date DATE,
    active BOOLEAN NOT NULL DEFAULT FALSE,
    CONSTRAINT fk_baptismal_creator FOREIGN KEY (creator_id) REFERENCES st_lo_user_entity(id)
);