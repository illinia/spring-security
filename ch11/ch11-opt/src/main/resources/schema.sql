create schema if not exists spring;

create table if not exists otp (username varchar(255) not null, code varchar(255), primary key (username));
create table if not exists user (username varchar(255) not null, password varchar(255), primary key (username));