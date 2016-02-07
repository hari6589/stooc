create database ims;

use ims;

create table contact_type (id int(5) not null primary key auto_increment, name varchar(25));

create table contact (id int(5) not null primary key auto_increment, name varchar(25),
company varchar(25), type int(5), address varchar(50), city varchar(25),
country varchar(25), phone varchar(15), email varchar(25), description varchar(50));

create table user (id int(5) not null primary key auto_increment, contact_id int(5),
username varchar(25), password varchar(25), status int(1));

create table item_type (id int(5) not null primary key auto_increment, name varchar(25),
description varchar(50));

create table item (id int(5) not null primary key auto_increment, name varchar(25),
type int(5), image varchar(25), model varchar(25), description varchar(50));

create table product (id int(5) not null primary key auto_increment, name varchar(25),
description varchar(25), due datetime, description varchar(50));

create table product_item (id int(5) not null primary key auto_increment, product_id int(5),
item_id int(5));

create table transaction_type (id int(5) not null primary key auto_increment, name int(5),

create table stock (id int(5) not null primary key auto_increment, transaction_type_id int(1),
item_id int(5), purchase_date datetime, supplier varchar(25), status int(1), description varchar(25));
