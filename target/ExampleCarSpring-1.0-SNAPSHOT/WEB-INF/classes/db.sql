create schema test;
create table cars
(
    id           int auto_increment
        primary key,
    state_number varchar(20)  not null,
    uin          varchar(50)  null,
    park_name    varchar(100) null
);

