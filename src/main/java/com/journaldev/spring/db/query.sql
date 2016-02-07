create database stooc;

use stooc;

create table contact_type (id int(5) not null primary key auto_increment, name varchar(25));

create table contact (id int(5) not null primary key auto_increment, name varchar(25),
company varchar(25), address varchar(50), city varchar(25),
country varchar(25), phone varchar(15), email varchar(25), description varchar(50));

create table contact_type_map (id int(5) not null primary key auto_increment, contact_id int(5), contact_type_id int(5));

create table user (id int(5) not null primary key auto_increment, contact_id int(5),
username varchar(25), password varchar(25), status int(1));

create table item_category (id int(5) not null primary key auto_increment, name varchar(25),
description varchar(50));

create table item (id int(5) not null primary key auto_increment, name varchar(25),
image varchar(25), model varchar(25), description varchar(50));

create table item_category_map (id int(5) not null primary key auto_increment, item_id int(5), contact_category_id int(5));

create table product (id int(5) not null primary key auto_increment, name varchar(25),
description varchar(50));

create table product_item_map (id int(5) not null primary key auto_increment, product_id int(5),
item_id int(5));

create table transaction_type (id int(5) not null primary key auto_increment, name int(5));

create table stock_status (id int(5) not null primary key auto_increment, name int(5));

create table stock (id int(5) not null primary key auto_increment, transaction_type_id int(1),
item_id int(5), purchase_date datetime, supplier varchar(25), status int(1), description varchar(25));

create table orders (id int(5) not null primary key auto_increment, name int(5), contact_id int(5), order_date datetime);

create table order_item (id int(5) not null primary key auto_increment, order_id int(5), stock_id int(5));