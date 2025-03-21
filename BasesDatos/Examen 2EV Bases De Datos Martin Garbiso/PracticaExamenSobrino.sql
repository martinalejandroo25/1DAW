drop database if exists examenMartinGarbiso;
create database if not exists examenMartinGarbiso;
use examenMartinGarbiso;

create table if not exists usuario (
    id_user char(3) primary key,
    nom_user varchar(25), 
    email_user varchar(50), 
    telefono_user varchar(9)
    );
create table if not exists region (
    id_reg char(2) primary key,
    nom_reg varchar(25)
    );
create table if not exists ciudad (
    codigo_postal char(5) primary key,
    nom_ciudad varchar(25), 
    id_reg char(2),
    foreign key (id_reg) references region(id_reg)
    on delete cascade on update cascade
    );

create table if not exists hoteles (
    id_hotel char(3) primary key,
    nom_hotel varchar(25), 
    habitaciones int, 
    categoria varchar(5), 
    codigo_postal char(5),
    foreign key(codigo_postal) references ciudad(codigo_postal)
    on delete cascade on update cascade
    );

create table if not exists reservas (
    id_user char(3),
    id_hotel char(3), 
    fecha_llegada date, 
    fecha_salida date, 
    costo double,
    primary key(id_user, id_hotel),
    foreign key (id_user) references usuario(id_user)
    on delete cascade on update cascade,
    foreign key (id_hotel) references hoteles(id_hotel)
    on delete cascade on update cascade
    );

create table if not exists empleado (
    id_emp char(3) primary key,
    nom_emp varchar(25), 
    salario double, 
    id_hotel char(3),
    foreign key (id_hotel) references hoteles(id_hotel)
    );

("U01", "PEDRO PÉREZ", "pedro@example.com", "654321987")
("U02", "MARÍA MARTÍNEZ", "maria@example.com", "612345678")
("U03", "LUIS FERNÁNDEZ", "luis@example.com", "687654321")
("U04", "ANA LÓPEZ", "ana@example.com", "699876543")
("U05", "JUAN GARCÍA", "juan@example.com", "623456789")
("U06", "SARA TORRES", "sara@example.com", "655432198")
("U07", "CARLOS RODRÍGUEZ", "carlos@example.com", "661234567")
("U08", "LAURA FERRER", "laura@example.com", "677654321")
("U09", "PABLO HERNÁNDEZ", "pablo@example.com", "690987654")
("U10", "NATALIA PASCUAL", "natalia@example.com", "645678321")
    







