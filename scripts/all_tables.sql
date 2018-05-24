drop table sessions;
drop table films;
drop table halls;
--drop type place;



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
places integer[][]
);

create table sessions(
id serial primary key,
film_id integer references films(id),
date timestamp,
hall_id integer references halls(id),
price integer check(price > 0)
);