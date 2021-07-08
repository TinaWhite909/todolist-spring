create table role_users(
id int,
role int,
primary key (id, role),
foreign key (id) references users (id),
foreign key (role) references roles (id)
);