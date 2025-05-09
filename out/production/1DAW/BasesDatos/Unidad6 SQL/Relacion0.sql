drop database if exists relacion0;
create database if not exists relacion0;
use relacion0;

create table if not exists cliente(
	nif char(9) primary key,
    nombre VARCHAR(25) NOT NULL, 
    domicilio VARCHAR(100),
	tlf VARCHAR(25),
	ciudad VARCHAR(50)
);
create table if not exists producto(
	codigo CHAR(4) primary key,
	descripcion VARCHAR(100) NOT NULL,
	precio FLOAT,
	stock FLOAT,
	minimo FLOAT,
	CHECK (precio > 0)
);

create table if not exists factura(
	numero int primary key,
    fecha date,
    pagado bool,
    nif char(9),
    total_precio float,
    foreign key(nif) references cliente(nif)
    on delete cascade on update cascade
);
create table if not exists detalle(
	numero int,
    codigo char(4),
    unidades int,
    primary key(numero, codigo),
    foreign key(codigo) references producto(codigo)
    on delete cascade on update cascade,
    foreign key(numero) references factura(numero)
    on delete cascade on update cascade
);


insert into cliente values
("43434343A", "DELGADO PEREZ MARISA", "C/ MIRAMAR, 84 3ºA", "925-200-967", "TOLEDO"),
("51592939K", "LOPEZ VAL SOLEDAD", "C/PEZ, 54 4ºC", "915-829-394", "MADRID"),
("51639989K", "DELGADO ROBLES MIGUEL", "C/ OCA, 54 5ºC", "913-859-293", "MADRID"),
("51664372R", "GUTIERREZ PEREZ ROSA", "C/ CASTILLA, 4 4ºA", "919-592-932", "MADRID");

insert into producto values
('CAJ1', 'CAJA DE HERRAMIENTAS DE PLASTICO', 8.50, 4.00, 3),
('CAJ2', 'CAJA DE HERRAMIENTAS DE METAL', 12.30, 3.00, 2),
('MAR1', 'MARTILLO PEQUEÑO', 3.50, 5, 10),
('MAR2', 'MARTILLO GRANDE', 6.50, 12, 10),
('TOR7', 'CAJA 100 TORNNILLOS DEL 7', 0.80, 20, 100),
('TOR8', 'CAJA 100 TORNNILLOS DEL 9', 0.80, 25, 100),
('TUE1', 'CAJA 1OO TUERCAS DEL 7', 0.50, 40, 100),
('TUE2', 'CAJA 1OO TUERCAS DEL 9', 0.50, 54, 100),
('TUE3', 'CAJA 1OO TUERCAS DEL 12', 0.50, 60, 100);

insert into factura values
(5440, '2017-09-05', TRUE, '51664372R', 345),
(5441, '2017-09-06', FALSE, '51592939K', 1000),
(5442, '2017-09-07', FALSE, '43434343A', 789),
(5443, '2017-09-08', TRUE, '51639989K', 12378),
(5444, '2017-09-09', TRUE, '51639989K', 567),
(5445, '2017-09-10', TRUE, '51592939K', 100);

insert into detalle values
(5440, 'CAJ2', 2),
(5440, 'MAR1', 1),
(5440, 'TOR7', 2),
(5440, 'TOR8', 2),
(5441, 'CAJ1', 1),
(5442, 'CAJ1', 1),
(5442, 'MAR1', 2),
(5443, 'TOR7', 1),
(5443, 'TUE1', 1),
(5444, 'MAR2', 1),
(5445, 'TOR7', 5),
(5445, 'TOR8', 5),
(5445, 'TUE2', 5),
(5445, 'TUE3', 5);

-- CONSULTAS
-- a. Mostrar todos los datos introducidos en cada una de las tablas
 select * from cliente, producto, factura, detalle;
-- b. Reemplazar la ciudad del cliente con DNI 51664372R por Granada.
 update cliente set ciudad = 'Granada' where nif like '51664372R';
-- c. Actualizar todos los precios de los productos con un aumento del 10%
 update producto set precio = precio * 1.10;
-- d. Aumentar el stock en 20 unidades para todos los productos y disminuir el precio de los productos en un 30%
 update producto set stock = stock + 20 and precio = precio * 0.70;
-- e. A los productos en los que haya un mínimo de 100 unidades, hacerle un descuento al precio del 50%
update producto set precio = precio * 0.5 where stock >= 100;
-- f. Eliminar al cliente cuyo dni sea 51664372R
delete from cliente where nif like '51664372R';