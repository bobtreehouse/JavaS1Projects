create schema if not exists coffee_inventory_test;
use coffee_inventory_test;

create table if not exists coffee (
coffee_id int not null auto_increment primary key,
  roaster_id int not null,
  name varchar(50) not null,
  count int not null,
  unit_price decimal(5,2) not null,
  description varchar(255),
  type varchar(50)
);

create table if not exists roaster (
roaster_id int not null auto_increment primary key,
  name varchar(50) not null,
  street varchar(50) not null,
  city varchar(50) not null,
  state char(2) not null,
  postal_code varchar(25) not null,
  phone varchar(15) not null,
  email varchar(60) not null,
  note varchar(255)
);