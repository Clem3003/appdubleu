--liquibase formatted sql

--changeset question-schema:8
CREATE TABLE question_entity (
  id UUID PRIMARY KEY DEFAULT gen_random_uuid(),

  prompt VARCHAR(1024),

  baptismal_song_entity_id UUID,
  folklore_subject_entity_id UUID,
  pins_entity_id UUID,

  suggested_answer_1 VARCHAR(255),
  suggested_answer_2 VARCHAR(255),
  suggested_answer_3 VARCHAR(255),
  suggested_answer_4 VARCHAR(255),

  created_by_id INTEGER,
  created_at DATE,
  active BOOLEAN NOT NULL DEFAULT FALSE,
  CONSTRAINT fk_folklore_created_by
      FOREIGN KEY (created_by_id)
          REFERENCES st_lo_user_entity(id),
  CONSTRAINT fk_question_baptismal_song
      FOREIGN KEY (baptismal_song_entity_id)
          REFERENCES baptismal_song_entity(id),
  CONSTRAINT fk_question_folklore_subject
      FOREIGN KEY (folklore_subject_entity_id)
          REFERENCES folklore_subject_entity(id),
  CONSTRAINT fk_question_pins
      FOREIGN KEY (pins_entity_id)
          REFERENCES pins_entity(id)
);
