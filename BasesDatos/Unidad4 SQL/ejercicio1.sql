drop database if exists ejercicio1;
create database if not exists ejercicio1;
use ejercicio1;

create table if not exists cliente (
	nif char(9) primary key,
    nombre varchar(100) not null,
    domicilio varchar(100),
    tlf varchar(25),
    ciudad varchar(50)
);

create table if not exists producto(
	codigo char(4) primary key,
    descripcion varchar(100) not null,
    precio float,
    stock float,
    minimo float,
    check(precio > 0)
);

create table if not exists factura(
	numero int primary key,
    fecha date,
    pagado bool,
    total_precio float,
    nif char(9),
    foreign key(nif) references cliente(nif) on delete cascade
);

create table detalle(
	numero int,
    codigo char(4),
    unidades int,
    foreign key (numero) references factura(numero) on delete cascade,
    primary key (numero, codigo)
);

insert into cliente values 	("43434343A", "DELGADO PEREZ MARISA'","C/ MIRAMAR,84 3ºA","925-200-967","TOLEDO"),
							("51592939K", "LOPEZ VAL SOLEDAD", "C/PEZ, 54 4ºC", "915-829-394", "MADRID"),
                            ("51639989K", "DELGADO ROBLES MIGUEL","C/ OCA, 54 5ºC", "913-859-293", "MADRID"),
							("51664372R","GUTIERREZ PEREZ ROSA'","C/ CASTILLA, 4 4ºA'","919-592-932","MADRID");

INSERT INTO producto (codigo, descripcion, precio, stock, minimo) VALUES
('CAJ1', 'CAJA DE HERRAMIENTAS DE PLASTICO', 8.50, 4, 3),
('CAJ2', 'CAJA DE HERRAMIENTAS DE METAL', 12.30, 3, 2),
('MAR1', 'MARTILLO PEQUEÑO', 3.50, 5, 10),
('MAR2', 'MARTILLO GRANDE', 6.50, 12, 10),
('TOR7', 'CAJA 100 TORNILLOS DEL 7', 0.80, 20, 100),
('TOR8', 'CAJA 100 TORNILLOS DEL 9', 0.80, 25, 100),
('TUE1', 'CAJA 100 TUERCAS DEL 7', 0.50, 40, 100),
('TUE2', 'CAJA 100 TUERCAS DEL 9', 0.50, 54, 100),
('TUE3', 'CAJA 100 TUERCAS DEL 12', 0.50, 60, 100);

INSERT INTO factura (numero, fecha, pagado, nif, total_precio) VALUES
(5440, '2017-09-05', TRUE,  '51664372R', 345),
(5441, '2017-09-06', FALSE, '51592939K', 1000),
(5442, '2017-09-07', FALSE, '43434343A', 789),
(5443, '2017-09-08', TRUE,  '51639989K', 123.78),
(5444, '2017-09-09', TRUE,  '51639989K', 567),
(5445, '2017-09-10', TRUE,  '51592939K', 100);

INSERT INTO detalle (numero, codigo, unidades) VALUES
(5440, 'CAJ2',  2),
(5440, 'MAR1',  1),
(5440, 'TOR7',  2),
(5440, 'TOR8',  2),
(5441, 'CAJ1',  1),
(5442, 'CAJ1',  1),
(5442, 'MAR1',  2),
(5443, 'TOR7',  1),
(5443, 'TUE1',  1),
(5444, 'MAR2',  1),
(5445, 'TOR7',  5),
(5445, 'TOR8',  5),
(5445, 'TUE2',  5),
(5445, 'TUE3',  5);
-- a. Mostrar todos los datos introducidos en cada una de las tablas
select * from cliente;
select * from producto;
select * from factura;
select * from detalle;

-- b. Reemplazar la ciudad del cliente con DNI 51664372R por Granada.
update cliente set ciudad = "GRANADA" where cliente.nif = "51664372R";
-- c. Actualizar todos los precios de los productos con un aumento del 10%
update producto set precio = precio * 1.10;
-- d. Aumentar el stock en 20 unidades para todos los productos y disminuir el precio de los productos en un 30% 
update producto set stock = stock + 20, precio = precio - precio* 0.30;
-- e. A los productos en los que haya un mínimo de 100 unidades, hacerle un descuento al precio del 50%
update producto
set precio = precio*0.5
where minimo >= 100;
-- f. Eliminar al cliente cuyo dni sea 51664372R
delete from cliente where nif like '51664372R';

-- nombre de los clientes cuyo nombre empieza por una d 
select *
from cliente
where nombre like 'd%';

-- vamos a utilizar un alias
select nombre as cliente, tlf from cliente;
select distinct nombre from cliente;
-- mostrar el precio del producto con iva y sin iva
select precio as 'precio sin IVA', precio + precio * 0.21 as 'precio con IVA' from producto;

-- muestra los clientes de madrid y toledo
select *
from cliente
where ciudad in ('Madrid','Toledo');

-- muestra los clientes cuya fecha de alta es null
select * from cliente
where nombre is null;