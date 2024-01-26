create database computerManagement;

use computerManagement;

create table user(
 id int(225)primary key,
 name varchar(100)not null,
 password varchar(100)not null,
 email varchar(100)not null,
 tel int(10)not null
    );

create table Storage(
  id varchar(224)primary key,
  brand varchar(100)not null,
  Type varchar(100)not null,
  price DOUBLE ,
  Quantity int,
  status VARCHAR(250),
  image varchar(500)
);
insert into Storage values (?,?,?,?,?,?,?);