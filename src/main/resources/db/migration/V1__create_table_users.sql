CREATE TABLE users (
    id bigint not null auto_increment,
    username VARCHAR(255),
    passwordUser VARCHAR(255) ,
    bio VARCHAR(255) ,
    primary key (id)
);