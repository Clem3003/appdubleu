--liquibase formatted sql

--changeset folklore_subject-schema:7
CREATE TABLE folklore_subject_entity (
  id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
  title VARCHAR(255) NOT NULL,
  content TEXT,
  picture_url VARCHAR(1024),
  created_by_id INTEGER,
  created_at DATE,
  baptismal_season_entity_id UUID,
  active BOOLEAN NOT NULL DEFAULT FALSE,
  CONSTRAINT fk_folklore_created_by
      FOREIGN KEY (created_by_id)
          REFERENCES st_lo_user_entity(id),
  CONSTRAINT fk_folklore_baptismal_season_entity
      FOREIGN KEY (baptismal_season_entity_id)
          REFERENCES baptismal_season_entity(id)
);
