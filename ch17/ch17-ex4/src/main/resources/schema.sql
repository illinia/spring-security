create table if not exists product (
    id int not null auto_increment,
    name varchar(45) null,
    owner varchar(45) null,
    primary key (`id`));