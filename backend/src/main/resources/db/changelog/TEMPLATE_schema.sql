--liquibase formatted sql

--changeset template-schema:7
CREATE TABLE _entity (
  id UUID PRIMARY KEY DEFAULT gen_random_uuid(),


    
  created_by_ VARCHAR(255),
  created_at DATE,
  active BOOLEAN NOT NULL DEFAULT FALSE,
  CONSTRAINT fk_folklore_created_by
      FOREIGN KEY (created_by)
          REFERENCES st_lo_user_entity(username)
);
