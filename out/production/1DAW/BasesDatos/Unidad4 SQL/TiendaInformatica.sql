drop database if exists TiendaInformática;
create database if not exists TiendaInformática;
use TiendaInformática;

create table if not exists fabricantes(
	clave_fab int primary key,
    nombre varchar(30)
    );
create table if not exists articulos(
	clave_art int primary key,
    nombre varchar(30),
    precio int,
    clave_fab int,
    foreign key(clave_fab) references fabricantes(clave_fab)
);

insert into fabricantes values
(1, "Kingston"),
(2, "Adata"),
(3, "Logitech"),
(4, "Lexar"),
(5, "Seagate");

insert into articulos values
(1,"Teclado", 100, 3),
(2, "Disco duro 300gb", 500, 5),
(3,"Mouse", 80, 3),
(4, "Memoria USB", 140, 4),
(5,"Memoria RAM", 290, 1),
(6, "Disco duro extraíble 250 Gb", 650, 5),
(7, "Memoria USB", 279, 1),
(8, "DVD Rom", 450, 2),
(9,"CD Rom", 200, 2),
(10,"Tarjeta de red", 180, 3);


-- a) Obtener todos los datos de los productos de la tienda
select * from articulos;
-- b) Obtener los nombres de los productos de la tienda
select nombre from articulos;
-- c) Obtener los nombres y precio de los productos de la tienda
select nombre, precio from articulos;
-- d) Obtener los nombres de los artículos sin repeticiones
select distinct nombre from articulos;
-- e) Obtener todos los datos del artículo cuya clave de producto es ‘5’
select * from articulos where clave_art = 5;
-- f) Obtener todos los datos del artículo cuyo nombre del producto es ‘’Teclado”
select * from articulos where nombre like "teclado";
-- g) Obtener todos los datos de la Memoria RAM y memorias USB
select * from articulos where nombre like "memoria ram" or "memorias usb";
-- h) Obtener todos los datos de los artículos que empiezan con ‘M’
select * from articulos where nombre like "M%";
-- i) Obtener el nombre de los productos donde el precio sea $ 100
select * from articulos where precio = 100;
-- j) Obtener el nombre de los productos donde el precio sea mayor a $ 200
select nombre from articulos where precio > 200;
-- k) Obtener todos los datos de los artículos cuyo precio este entre $100 y $350
select * from articulos where precio >=100 and precio <=350;
-- l) Obtener el precio medio de todos los productos
select avg(precio) from articulos;
-- m) Obtener el precio medio de los artículos cuyo código de fabricante sea 2
select avg(precio) from articulos where clave_fab = 2;
-- n) Obtener el nombre y precio de los artículos ordenados por Nombre
select nombre, precio from articulos order by nombre;
-- o) Obtener todos los datos de los productos ordenados descendentemente por Precio
select * from articulos order by precio desc;
-- p) Obtener el nombre y precio de los artículos cuyo precio sea mayor a $ 250 y ordenarlos descendentemente por precio
select nombre, precio from articulos where precio > 250 order by precio desc;
-- y luego ascendentemente por nombre
select nombre, precio from articulos where precio > 250 order by nombre asc;
-- q) Obtener un listado completo de los productos, incluyendo por cada articulo los datos del articulo y del fabricante
select a.*, f.* from articulos a
join fabricantes f on f.clave_fab = a.clave_fab;
-- r) Obtener la clave de producto, nombre del producto y nombre del fabricante de todos los productos en venta
select a.clave_art, a.nombre, f.nombre from articulos a
join fabricantes f on f.clave_fab = a.clave_fab;
-- s) Obtener el nombre y precio de los artículos donde el fabricante sea Logitech ordenarlos alfabéticamente por nombre del producto
select a.nombre, a.precio from articulos a
join fabricantes f on f.clave_fab = a.clave_fab
where f.nombre like 'logitech'
order by a.nombre asc;

-- t) Obtener el nombre, precio y nombre de fabricante de los productos que son marca Lexar o Kingston ordenados descendentemente por precio
select a.nombre, a.precio, f.nombre from articulos a
join fabricantes f on f.clave_fab = a.clave_fab
where f.nombre like 'lexar' or  f.nombre like 'kingston'
order by a.precio desc;


-- u) Añade un nuevo producto: Clave del producto 11, Altavoces de $ 120 del fabricante 2
insert into articulos values ("11", "altavoces", 120, 2);
-- v) Cambia el nombre del producto 6 a ‘Impresora Laser’
-- update nombreTabla set nombre_columna = nuevoNombre where condicion;
update articulos set nombre = 'Impresora Laser' where clave_art = 6;
-- w) Aplicar un descuento del 10% a todos los productos.
update articulos set precio = precio * 1.10;
-- x) Aplicar un descuento de $ 10 a todos los productos cuyo precio sea mayor o igual a $ 300
update articulos set precio = precio - 10 where precio >= 300;
-- y) Borra el producto numero 6
-- delete from tabla where condicion;
delete from articulos where clave_art = 6;