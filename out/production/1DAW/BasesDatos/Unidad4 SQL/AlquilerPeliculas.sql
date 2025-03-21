drop database if exists AlquilerPeliculas;
create database if not exists AlquilerPeliculas;
use AlquilerPeliculas;

create table if not exists categoria(
	codigo_cat int auto_increment primary key, 
    nom_cat varchar(15) not null
);

create table if not exists formato(
	codigo_formato int auto_increment primary key,
    tipo varchar(15) not null
);

create table if not exists pelicula(
	id_pelicula int auto_increment primary key,
	titulo varchar(50) not null,
	fecha_adquisicion date not null,
	precio double not null,
	estreno char(1),
	codigo_cat int,
	codigo_formato int,
	foreign key(codigo_cat) references categoria(codigo_cat)
	on update cascade on delete cascade,
	foreign key(codigo_formato) references formato(codigo_formato)
	on delete cascade on update cascade
);

create table if not exists cliente(
	id_cliente int auto_increment primary key,
	nombre varchar(10) not null,
	apellidos varchar(25) not null,
	dni varchar(9) not null,
	poblacion varchar(10),
	telefono varchar(9) not null,
	fecha_alta date not null

);

create table if not exists alquiler(
	codigo_alquiler int auto_increment primary key,
	id_cliente int,
	id_pelicula int,
	fecha_alquiler date not null,
	fecha_devolucion date,
	devolucion char(1),
	foreign key(id_cliente) references cliente(id_cliente)
	on delete cascade on update cascade,
	foreign key(id_pelicula) references pelicula(id_pelicula)
	on delete cascade on update cascade

);

insert into categoria values
(1, "Acción"),
(2, "Drama"),
(3, "Comedia"),
(4, "Terror"),
(5, "Animación"),
(6, "Suspense"),
(7, "Documental");

insert into formato values
(1, "DVD"),
(2, "CD"),
(3, "BLUE RAY"),
(4, "VHS"),
(5, "MPE4");

insert into pelicula values
(1, "10 razones para odiarte", 			str_to_date('30-01-2018', '%d-%m-%Y'), 45, "N", 1, 1),
(2, "A los cirujanos se le va la mano", str_to_date('14-02-2018', '%d-%m-%Y'), 33, "N", 2, 2),
(3, "Terminator", 						str_to_date('22-03-2018', '%d-%m-%Y'), 22, "N", 3, 3),
(4, "La vida es Bella", 				str_to_date('31-03-2018', '%d-%m-%Y'), 45, "N", 4, 4),
(5, "Arma letal", 						str_to_date('12-04-2018', '%d-%m-%Y'), 15, "N", 5, 5),
(6, "Suite Habana", 					str_to_date('20-04-2018', '%d-%m-%Y'), 12, "N", 7, 5),
(7, "Guerra Sucia", 					str_to_date('18-05-2018', '%d-%m-%Y'), 11, "N", 6, 4),
(8, "El coleccionista de huesos",		str_to_date('06-05-2018', '%d-%m-%Y'), 34, "N", 3, 3),
(9, "Mozilla", 							str_to_date('05-06-2018', '%d-%m-%Y'), 23, "N", 4, 2),
(10, "Marx Attach", 					str_to_date('13-07-2018', '%d-%m-%Y'), 24, "N", 5, 5),
(11, "Un dia después", 					str_to_date('14-07-2018', '%d-%m-%Y'), 25, "N", 2, 4),
(12, "La momia", 						str_to_date('06-09-2018', '%d-%m-%Y'), 23, "N", 3, 1),
(13, "El último samuray", 				str_to_date('14-10-2018', '%d-%m-%Y'), 45, "N", 7, 3),
(14, "Black panther", 					str_to_date('19-11-2018', '%d-%m-%Y'), 50, "S", 6, 5),
(15, "Roma", 							str_to_date('30-12-2018', '%d-%m-%Y'), 50, "S", 2, 2);

insert into cliente values
(1, "Alberto","Hernández Hernández", "34783627Z", "Cuevas", "678953424", "2018-03-23"),
(2, "Amparo", "García García", "19099925N", "Vera", "654321237", "2018-02-12"),
(3, "Amparo", "García García", "22462627E", "Cuevas", "654789023", "2018-03-07"),
(4, "Ana Mª", "García Hernández", "29070115R", "Vera", "666999888", "2018-06-09"),
(5, "Angel",  "García García", "29039781G", "Garrucha", "652134563", "2018-11-11"),
(6, "Angel",  "García García", "22932963P", "Cuevas", "611234567", "2018-12-02"),
(7, "Angel",  "García Martínez", "27449231L", "Vera", "600987345", "2018-07-14"),
(8, "Antonia", "Hernández Hernández", "23219850Q", "Garrucha", "607654321", "2019-04-15"),
(9, "Antonio", "Flores García", "23212594M", "Antas", "694567234", "2018-05-18"),
(10, "Antonio", "García Hernández", "05198715W", "Vera", "653457895", "2019-02-19"),
(11, "Antonio", "García Hernández", "27475738F", "Cuevas", "654234127", "2017-02-20"),
(12, "Antonio", "García Hernández", "34784990C", "Antas", "654789531", "2019-01-27"),
(13, "Armin", "García Hernández", "22454413L", "Vera", "622345789", "2018-10-29"),
(14, "Asun", "García Martínez", "45418363X", "Cuevas", "689095623", "2018-08-31"),
(15, "Asun", "Hernández Hernández", "56789043V", "Antas", "677894123", "2018-09-30");

insert into alquiler (codigo_alquiler, id_cliente, id_pelicula, fecha_alquiler, devolucion)
values 
(1, 1, 1, 		"2018-03-23", "S"),
(2, 3, 2, 		"2018-02-12", "N"),
(3, 5, 3, 		"2018-03-07", "S"),
(4, 2, 4, 		"2018-06-09", "N"),
(5, 6, 5, 		"2018-11-11", "N"),
(6, 7, 6, 		"2018-12-02", "S"),
(7, 8, 7, 		"2018-07-14", "S"),
(8, 9, 8, 		"2019-04-15", "S"),
(9, 12, 9, 		"2018-05-18","S"),
(10, 13, 10, 	"2019-02-19", "S"),
(11, 15, 11, 	"2017-02-20", "S"),
(12, 2, 12, 	"2019-01-27", "S"),
(13, 4, 13, 	"2018-10-29", "S"),
(14, 5, 14, 	"2018-08-31", "S"),
(15, 8, 15, 	"2018-09-30", "S");
-- actualizar la fecha de devolución sumando 7 dias a fecha alquiler
update alquiler set fecha_devolucion = date_add(fecha_alquiler, interval 7 day);


-- a) Películas de comedia y suspense (Datos a mostrar: nombre de la película, precio y nombre de la categoría)
select p.titulo, p.precio, c.nom_cat from pelicula p
inner join categoria c on c.codigo_cat = p.codigo_cat
where c.nom_cat like 'comedia' or c.nom_cat like 'suspense';
-- b) Películas con precio menor a 20€ (Datos a mostrar, nombre de la película, precio y nombre de la categoría)
select p.titulo, c.nom_cat, p.precio from pelicula p
inner join categoria c on c.codigo_cat = p.codigo_cat
where p.precio < 20;
-- c) Películas con precio entre a 20€ y 50€ (Datos a mostrar, nombre de la película, precio y nombre de la categoría)
select p.titulo, c.nom_cat, p.precio from pelicula p
inner join categoria c on c.codigo_cat = p.codigo_cat
where p.precio > 20 and p.precio < 50;
-- d) Películas en formato DVD Y BLUE RAY (Datos a mostrar: nombre de la película, precio y nombre de la categoría).
select p.titulo, c.nom_cat, p.precio, f.tipo from pelicula p
inner join categoria c on c.codigo_cat = p.codigo_cat
inner join formato f on f.codigo_formato = p.codigo_formato
where f.tipo like 'DVD' or f.tipo like 'BLUE RAY';
-- e) Películas adquiridas durante los meses de enero y mayo de 2018 (Datos a mostrar: nombre de la película, estreno y nombre de la categoría)
select p.titulo, p.estreno, c.nom_cat, p.fecha_adquisicion from pelicula p
inner join categoria c on c.codigo_cat = p.codigo_cat
where ( month(p.fecha_adquisicion) = 1 and year(p.fecha_adquisicion) = 2018) 
or (month(p.fecha_adquisicion) = 5 and year(p.fecha_adquisicion) = 2018);
-- f) Clientes que solo han alquilado películas de suspense o de tipo blue ray
select c.* from cliente c
inner join alquiler a on a.id_cliente = c.id_cliente
inner join pelicula p on p.id_pelicula = a.id_pelicula
inner join formato f on f.codigo_formato = p.codigo_formato
inner join categoria ca on ca.codigo_cat = p.codigo_cat
where f.tipo like 'blue ray' or ca.nom_cat like 'suspense';
-- g) Películas alquiladas por el socio número 09
select p.titulo, c.id_cliente from cliente c
inner join alquiler a on a.id_cliente = c.id_cliente
inner join pelicula p on p.id_pelicula = a.id_pelicula
where c.id_cliente = 09;
-- h) Todas las películas alquiladas en el mes de febrero del año 2018.
select p.titulo, a.fecha_alquiler from pelicula p
inner join alquiler a on a.id_pelicula = p.id_pelicula
where month(a.fecha_alquiler) = 2 
and year(a.fecha_alquiler) = 2018;
-- i) Ordenar la tabla películas por orden alfabético
select * from pelicula
order by titulo asc;
-- j) Descontar un 5% al precio de las películas de suspense.
update pelicula set precio = (precio / 1.05)
where codigo_cat in (select codigo_cat from categoria
					where nom_cat like 'suspense');
-- k) Incluir un nuevo cliente dado de alta el 31/12/2018.
insert into cliente (nombre, apellidos, dni, poblacion, telefono, fecha_alta)
values
("clienteK", "apellidoK1 apellidoK2", "12345678T", "Almeria", "987654321", "2018-12-31");
-- l) Borrar la película el último samuray.
delete from pelicula where titulo like 'el ultimo samuray';
-- m) Suma total del dinero gastado en la adquisición de películas.
select round(sum(precio), 2) from pelicula;
select * from pelicula;
-- n) Precio medio de las películas
select round(avg(precio), 2) from pelicula;
-- o) Nombre del cliente que más películas ha adquirido, mostrando las fechas de alquiler.
select c.id_cliente, c.nombre, c.apellidos, count(a.codigo_alquiler) from cliente c
inner join alquiler a on a.id_cliente = c.id_cliente
group by c.id_cliente
having count(a.codigo_alquiler) = (select count(codigo_alquiler) from alquiler
									group by id_cliente 
									order by 1 desc limit 1);
-- p) Nombre de la película más cara
select titulo, precio from pelicula
where precio = (select precio from pelicula
				order by 1 desc limit 1); 
-- q) Nombre de la película más barata.
select titulo, precio from pelicula
where precio = (select precio from pelicula
				order by 1 asc limit 1);
-- r) Añade una nueva película con los datos que quieras menos el precio que será la media de todas las películas que ya tenemos.
set @avg_precio = (select round(avg(precio)) from pelicula);
insert into pelicula (titulo, fecha_adquisicion, precio, estreno, codigo_cat, codigo_formato) values
("Terminator Genesis", curdate(), @avg_precio, 'S', 6, 3);
select * from pelicula where titulo like 'terminator genesis';
-- s) Datos de los Clientes que aún no han devuelto las películas alquiladas.
select c.* from cliente c
inner join alquiler a on a.id_cliente = c.id_cliente
where a.devolucion like 'n';
-- t) El cliente más antiguo del videoclub.
select * from cliente
where fecha_alta = (select fecha_alta from cliente
					order by 1 asc limit 1);
-- u) Tiempo que lleva el cliente 3 dado de alta en el videoclub.
select (datediff(curdate(), fecha_alta)/365) as años 
from cliente
where id_cliente = 3;
-- v) Número de películas de la categoría suspense.
select count(p.id_pelicula), c.nom_cat from pelicula p
inner join categoria c on c.codigo_cat = p.codigo_cat
where c.nom_cat like 'suspense'
group by c.nom_cat;

-- w) Insertar una nueva categoría Ciencia Ficción.
insert into categoria(nom_cat)
values("Ciencia Ficción");
-- x) Sumar a todos los clientes 5 días más a su fecha de devolución actual.
update alquiler set fecha_devolucion = date_add(fecha_devolucion, interval 5 day);
-- y) Implementar una consulta donde se muestre el número total de socios ordenados por localidad.
select poblacion, count(id_cliente) from cliente
group by poblacion;