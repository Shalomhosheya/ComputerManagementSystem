create database computerManagement;

use computerManagement;

create table user(
 id int(225)primary key,
 name varchar(100)not null,
 password varchar(100)not null,
 email varchar(100)not null,
 tel int(10)not null
    );
