 --liquibase formatted sql

 --changeset user-schema:2
 CREATE TABLE st_lo_user_entity (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    lastname VARCHAR(255),
    firstname VARCHAR(255),
    username VARCHAR(255) UNIQUE NOT NULL,
    date_of_birth DATE,
    email VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(50),
    active BOOLEAN NOT NULL DEFAULT TRUE,
    register_date DATE,
    profile_picture_url VARCHAR(1024),
    nickname VARCHAR(255)
 );

