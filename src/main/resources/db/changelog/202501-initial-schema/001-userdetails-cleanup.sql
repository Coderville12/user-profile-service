--liquibase formatted sql

--changeset gunjan:001-delete-null-entries
DELETE FROM au_userdetails
WHERE name IS NULL ;
--rollback /* optional: restore deleted rows from backup if needed */

--changeset gunjan:002-add-not-null-constraints
ALTER TABLE au_userdetails
MODIFY name VARCHAR(255) NOT NULL,
MODIFY department VARCHAR(255) NOT NULL;

--rollback ALTER TABLE au_userdetails MODIFY first_name VARCHAR(255) NULL;
--rollback ALTER TABLE au_userdetails MODIFY last_name VARCHAR(255) NULL;


----changeset gunjan:003-update-existing-entries
--CREATE TABLE customers (
--    id BIGINT PRIMARY KEY AUTO_INCREMENT,
--    name VARCHAR(255) NOT NULL,
--    email VARCHAR(255) NOT NULL UNIQUE,
--    mobile VARCHAR(15) UNIQUE,
--    status VARCHAR(20) DEFAULT 'ACTIVE',
--    version BIGINT DEFAULT 0,
--    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
--    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
--);
--rollback DROP TABLE customers;