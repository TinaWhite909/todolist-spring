CREATE TABLE roles
(
    "ID" serial primary key,
    "ROLE" varchar(255)
);

INSERT INTO roles ("ROLE") VALUES ('ROLE_ADMIN'),('ROLE_USER');