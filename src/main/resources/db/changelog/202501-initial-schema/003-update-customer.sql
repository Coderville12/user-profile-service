--liquibase formatted sql
--changeset gunjan:003-update-customer
ALTER TABLE customers
ADD COLUMN password VARCHAR(255) NOT NULL DEFAULT 'changeme';