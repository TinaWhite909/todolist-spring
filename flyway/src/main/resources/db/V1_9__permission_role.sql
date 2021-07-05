CREATE TABLE permission_role
(
    "ID" serial primary key,
    "ROLES_ID" int,
    "PERMISSION_ID" int
);

INSERT INTO permission_role ("ROLES_ID", "PERMISSION_ID")
VALUES (1,1),(1,2),(2,1);