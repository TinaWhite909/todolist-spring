create table role_users(
id int,
role int,
primary key (id, role),
foreign key (id) references users (user_id),
foreign key (role) references roles (role_id)
);