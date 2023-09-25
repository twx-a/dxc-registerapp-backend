create table users
(
    id int not null,
    firstName varchar(255) not null,
    lastName varchar(255),
    email varchar(255) not null,
    password varchar(255) not null,
    manager char(1) not null,
    createdAt date,
    primary key (id)
);