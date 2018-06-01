drop table tickets;
drop table sessions;
drop table films;
drop table halls;
drop table users;



create table films(
 id serial primary key,
 duration_minuts integer,
 name varchar(100),
 baseprice integer,
 archived boolean default false
);

--create type place as (c integer, r integer, vip boolean);

create table halls(
id serial primary key,
name varchar(100),
placecoeff real,
places integer[][],
hall_number integer
);

create table sessions(
id serial primary key,
film_id integer references films(id),
date timestamp,
hall_id integer references halls(id),
price integer check(price > 0)
);

create table users(
id serial primary key,
login varchar(100) unique not null,
password varchar(100),
birthday timestamp 
);

create table tickets(
id serial primary key,
session_id integer references sessions(id),
price integer,
place_row integer,
place_column integer
);