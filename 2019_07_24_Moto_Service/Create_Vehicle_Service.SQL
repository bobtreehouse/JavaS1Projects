create schema if not exists vehicle_service;

use vehicle_service;

create table if not exists vehicle (
   vin varchar(20) not null primary key,
   vehicle_type varchar(20) not null,
   make varchar(20) not null,
   model varchar(20) not null,
   year varchar(4) not null,
   color varchar(20) not null
);