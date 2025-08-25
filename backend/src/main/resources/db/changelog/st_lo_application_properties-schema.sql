--liquibase formatted sql

--changeset app-schema:1
CREATE TABLE st_lo_application_properties (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    property_key VARCHAR(255) NOT NULL UNIQUE,
    property_value VARCHAR(255) NOT NULL,
    description TEXT,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_by UUID,
CONSTRAINT fk_app_properties_user FOREIGN KEY (updated_by) REFERENCES st_lo_user_entity (id) ON DELETE SET NULL
);