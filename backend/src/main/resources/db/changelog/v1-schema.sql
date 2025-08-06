 --liquibase formatted sql

 --changeset mychange:5
 CREATE TABLE Liquibase_User (
     id SERIAL PRIMARY KEY,
     name VARCHAR(255) NOT NULL,
     email VARCHAR(255) NOT NULL
 );
