drop database if exists agencia;
create database agencia charset utf8mb4;
use agencia;

create table turista (
	id int unsigned auto_increment primary key,
    nombre varchar(50) not null,
    apellidos varchar(100) not null,
    direccion varchar(100) not null,
    telefono varchar(9) not null
    );
    
create table hotel (
	id int unsigned auto_increment primary key,
    nombre varchar(50) not null,
    direccion varchar(100) not null,
    ciudad varchar(25) not null,
    plazas integer not null,
    telefono varchar(9) not null
    );