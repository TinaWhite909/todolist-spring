--CREATE TABLE role_users
--(
--    "ID" serial primary key,
--    "USER_ID" int,
--    "ROLES_ID" int
--);
--
--INSERT INTO role_users ("USER_ID", "ROLES_ID") VALUES (1,1),(2,2);

create table role_users(
id int,
role int,
primary key (id, role),
foreign key (id) references users (user_id),
foreign key (role) references role (role_id)
);