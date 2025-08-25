 --liquibase formatted sql

 --changeset user-schema:24
 CREATE TABLE st_lo_user_entity (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    lastname VARCHAR(255),
    firstname VARCHAR(255),
    username VARCHAR(255) UNIQUE NOT NULL,
    date_of_birth DATE,
    email VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(50),
    deleted BOOLEAN NOT NULL DEFAULT FALSE,
    is_public BOOLEAN NOT NULL DEFAULT FALSE,
    active BOOLEAN NOT NULL DEFAULT TRUE,
    last_login_date DATE,
    register_date DATE,
    profile_picture_url VARCHAR(1024),
    nickname VARCHAR(255)
 );

 --changeset user-schema:4
-- Table de jointure pour représenter la liste de contacts
 CREATE TABLE st_lo_user_contacts_entity (
    user_id UUID NOT NULL,
    contact_id UUID NOT NULL,
    PRIMARY KEY (user_id, contact_id),
    CONSTRAINT fk_user_contacts_user FOREIGN KEY (user_id) REFERENCES st_lo_user_entity (id) ON DELETE CASCADE,
    CONSTRAINT fk_user_contacts_contact FOREIGN KEY (contact_id) REFERENCES st_lo_user_entity (id) ON DELETE CASCADE
 );