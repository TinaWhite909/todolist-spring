CREATE TABLE roles
(
    "ROLE_ID" serial primary key,
    "NAME" varchar(255)
);

INSERT INTO roles ("NAME") VALUES ('ROLE_ADMIN'),('ROLE_USER');