create table role_users(
id serial primary key,
user_id int,
role_id int,
foreign key (user_id) references users (id),
foreign key (role_id) references roles (id)
);
