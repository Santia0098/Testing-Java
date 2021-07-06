CREATE table if NOT EXISTS movies (
    id int auto_increment primary key,
    name varchar(50) not null,
    minutes int not null,
    genre varchar(50) not null
);

insert into movies(name, minutes, genre) values
 ('dark', 152, 'ACTION'),
 ('dark', 113, 'THRILLER'),
 ('dark', 136, 'ACTION');
