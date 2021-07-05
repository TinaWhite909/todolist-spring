CREATE TABLE permissions
(
    "ID" serial primary key,
    "NAME" varchar(255),
    "DESCRIPTION" varchar(255),
    "URL" varchar(255),
    "PID" int
);

INSERT INTO permissions ("NAME", "DESCRIPTION", "URL" , "PID")
VALUES ('ROLE_HOME', 'home', '/', null),
        ('ROLE_ADMIN', 'user' , '/admin', null);