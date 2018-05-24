drop table sessions;
drop table films;
drop table halls;
--drop type place;



create table films(
 id serial primary key,
 duration integer,
 name varchar(100),
 baseprice integer
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
film integer references films(id),
date timestamp,
hall integer references halls(id),
price integer check(price > 0)
);