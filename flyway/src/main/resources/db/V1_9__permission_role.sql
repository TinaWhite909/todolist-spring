create table permission_role(
"ROLES_ID" int,
"PERMISSION_ID" int,
primary key ("ROLES_ID", "PERMISSION_ID"),
foreign key ("ROLES_ID") references roles (role_id),
foreign key ("PERMISSION_ID") references permissions (id)
);