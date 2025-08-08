--liquibase formatted sql

--changeset question-schema:7
CREATE TABLE question_entity (
  id UUID PRIMARY KEY DEFAULT gen_random_uuid(),



  created_by_id INTEGER,
  created_at DATE,
  active BOOLEAN NOT NULL DEFAULT FALSE,
  CONSTRAINT fk_folklore_created_by
      FOREIGN KEY (created_by_id)
          REFERENCES st_lo_user_entity(id)
);
