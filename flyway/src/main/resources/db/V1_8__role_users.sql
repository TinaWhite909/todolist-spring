CREATE TABLE role_users
(
    "ID" serial primary key,
    "USER_ID" int,
    "ROLES_ID" int
);

INSERT INTO role_users ("USER_ID", "ROLES_ID") VALUES (1,1),(2,2);