create table permission_role(
"ID" serial primary key,
"ROLE_ID" int,
"PERMISSION_ID" int,
foreign key ("ROLE_ID") references role (id),
foreign key ("PERMISSION_ID") references permissions (id)
);