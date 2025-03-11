drop database if exists Carteros;
create database if not exists Carteros;
use Carteros;

-- Creación de las tablas con claves primarias y foráneas

CREATE TABLE provincia (
    id_prov CHAR(3) PRIMARY KEY NOT NULL,
    nom_prov VARCHAR(15) NOT NULL
);

CREATE TABLE ciudad (
    id_ciud CHAR(3) PRIMARY KEY NOT NULL,
    nom_ciud VARCHAR(20) NOT NULL,
    num_hab INT NOT NULL,
    id_prov CHAR(3) NOT NULL,
    FOREIGN KEY (id_prov) REFERENCES provincia(id_prov) ON DELETE CASCADE
);

CREATE TABLE zona (
    id_zona CHAR(3) NOT NULL,
    nom_zona VARCHAR(10) NOT NULL,
    id_ciud CHAR(3) NOT NULL,
    PRIMARY KEY (id_zona, id_ciud),
    FOREIGN KEY (id_ciud) REFERENCES ciudad(id_ciud) ON DELETE CASCADE
);

CREATE TABLE cartero (
    id_cart CHAR(3) PRIMARY KEY NOT NULL,
    nom_cart VARCHAR(25) NOT NULL,
    sueldo INT NOT NULL
);

CREATE TABLE periodos (
    id_per CHAR(3) PRIMARY KEY NOT NULL,
    fecha_ini DATE NOT NULL,
    fecha_fin DATE NOT NULL
);

CREATE TABLE relacion2 (
    id_zona CHAR(3) NOT NULL,
    id_ciud CHAR(3) NOT NULL,
    id_cart CHAR(3) NOT NULL,
    id_per CHAR(3) NOT NULL,
    PRIMARY KEY (id_zona, id_ciud, id_cart, id_per),
    FOREIGN KEY (id_zona, id_ciud) REFERENCES zona(id_zona, id_ciud) ON DELETE CASCADE,
    FOREIGN KEY (id_ciud) REFERENCES ciudad(id_ciud) ON DELETE CASCADE,
    FOREIGN KEY (id_cart) REFERENCES cartero(id_cart) ON DELETE CASCADE,
    FOREIGN KEY (id_per) REFERENCES periodos(id_per) ON DELETE CASCADE
);
INSERT INTO provincia (id_prov, nom_prov) VALUES
('P01', 'SEVILLA'),
('P02', 'GRANADA'),
('P03', 'ALMERIA');

INSERT INTO ciudad (id_ciud, nom_ciud, num_hab, id_prov) VALUES
('C01', 'CIUDAD1', 890000, 'P01'),
('C02', 'CIUDAD2', 110000, 'P02'),
('C03', 'CIUDAD3', 98000, 'P03'),
('C04', 'CIUDAD4', 65000, 'P01');

INSERT INTO zona (id_zona, nom_zona, id_ciud) VALUES
('Z01', 'CENTRO', 'C01'),
('Z02', 'ESTE', 'C01'),
('Z03', 'OESTE', 'C01'),
('Z04', 'NORTE', 'C01'),
('Z05', 'SUR', 'C01'),
('Z01', 'CENTRO', 'C02'),
('Z02', 'POLIGONO', 'C02'),
('Z03', 'OESTE', 'C02'),
('Z04', 'NORTE', 'C02'),
('Z05', 'SUR', 'C02'),
('Z01', 'CENTRO', 'C03'),
('Z02', 'ESTE', 'C03'),
('Z03', 'BARRIADAS', 'C03'),
('Z04', 'NORTE', 'C03'),
('Z05', 'SUR', 'C03'),
('Z01', 'CENTRO', 'C04'),
('Z02', 'BULEVARD', 'C04'),
('Z03', 'OESTE', 'C04'),
('Z04', 'NORTE', 'C04'),
('Z05', 'RIVERA', 'C04');

INSERT INTO periodos (id_per, fecha_ini, fecha_fin) VALUES
('PE1', '2000-05-01', '2000-03-30'),
('PE2', '2000-03-30', '2000-08-15'),
('PE3', '2000-08-15', '2000-11-20'),
('PE4', '2000-11-20', '2000-12-25'),
('PE5', '2000-12-25', '2001-03-03');

INSERT INTO cartero (id_cart, nom_cart, sueldo) VALUES
('CT1', 'JUAN PEREZ', 1100),
('CT2', 'ANA TORRES', 1080),
('CT3', 'PEPA FERNANDEZ', 1100),
('CT4', 'VICENTE VALLES', 1790),
('CT5', 'FERNANDO GINES', 1013),
('CT6', 'LISA TORMES', 897),
('CT7', 'WALDO PEREZ', 899),
('CT8', 'KIKA GARCIA', 987),
('CT9', 'LOLA JIMENEZ', 1123);

INSERT INTO relacion2 (id_zona, id_ciud, id_cart, id_per) VALUES
('Z01', 'C01', 'CT1', 'PE1'),
('Z01', 'C02', 'CT2', 'PE1'),
('Z01', 'C03', 'CT3', 'PE1'),
('Z01', 'C04', 'CT4', 'PE1'),
('Z02', 'C01', 'CT5', 'PE1'),
('Z02', 'C02', 'CT6', 'PE1'),
('Z02', 'C03', 'CT7', 'PE1'),
('Z02', 'C04', 'CT8', 'PE1'),
('Z03', 'C01', 'CT9', 'PE1'),
('Z03', 'C02', 'CT1', 'PE2'),
('Z03', 'C03', 'CT2', 'PE2'),
('Z03', 'C04', 'CT3', 'PE2'),
('Z04', 'C01', 'CT4', 'PE2'),
('Z04', 'C02', 'CT5', 'PE2'),
('Z04', 'C03', 'CT6', 'PE2'),
('Z04', 'C04', 'CT7', 'PE2'),
('Z05', 'C01', 'CT8', 'PE2'),
('Z05', 'C02', 'CT9', 'PE2'),
('Z05', 'C03', 'CT1', 'PE3'),
('Z05', 'C04', 'CT2', 'PE3'),
('Z01', 'C01', 'CT3', 'PE3'),
('Z02', 'C02', 'CT4', 'PE3'),
('Z03', 'C01', 'CT5', 'PE3'),
('Z04', 'C01', 'CT6', 'PE3'),
('Z05', 'C01', 'CT7', 'PE3'),
('Z01', 'C01', 'CT8', 'PE4'),
('Z02', 'C03', 'CT9', 'PE3'),
('Z03', 'C04', 'CT1', 'PE4'),
('Z04', 'C01', 'CT2', 'PE4'),
('Z05', 'C01', 'CT3', 'PE4');
-- 1.-NOMBRE DE CIUDAD CON MÁS HABITANTES.
select nom_ciud from ciudad order by num_hab desc limit 1;
-- 2.- NOMBRE DEL CARTERO CON MAYOR SUELDO
select nom_cart from cartero order by sueldo desc limit 1;
-- 3.- NOMBRE CIUDADES, Nº HABITANTES DE LA PROVINCIA DE SEVILLA
select c.nom_ciud, c.num_hab from ciudad c
join provincia p on p.id_prov = c.id_prov
where p.nom_prov like "sevilla";
-- 4.- CARTEROS ORDENADOS POR SULEDO.
select nom_cart, sueldo from cartero order by sueldo desc;
-- 5.- NOMBRE DE CIUDAD Y NOMBRE DE ZONA
select c.nom_ciud, z.nom_zona from ciudad c
join zona z on z.id_ciud = c.id_ciud;
-- 6.- ZONAS DE LA „C02‟
select nom_zona from zona where id_ciud like 'c01';
-- 7.- ZONAS DE LA CIUDAD “CIUDAD3”.
select z.nom_zona from zona z 
join ciudad c on c.id_ciud like z.id_ciud 
where c.nom_ciud like 'ciudad3';
-- 8.- NOMBRE DE LOS CARTEROS QUE HAN TRABAJADO EN LA ZONA “Z01,C02”
select c.nom_cart, z.id_zona, z.id_ciud from cartero c
join relacion2 r on r.id_cart = c.id_cart
join zona z on z.id_zona = r.id_zona
where z.id_zona like 'z01' and z.id_ciud like 'c02';
-- 9.- NOMBRE DE LOS CARTEROS QUE HAN TRABAJADO EN LA ZONA CENTRO DE LA CIUDAD1
select c.nom_cart, z.nom_zona, ci.nom_ciud from cartero c
join relacion2 r on r.id_cart = c.id_cart
join zona z on z.id_zona = r.id_zona
join ciudad ci on ci.id_ciud = r.id_ciud
where z.nom_zona like "centro" and ci.nom_ciud like "ciudad1";
-- 10.- NOMBRE DE LOS CARTEROS (Y FECHAS DE INICIO Y FIN) QUE HAN TRABAJADO EN LA RIVERA DE LA CIUDAD 4.
select c.nom_cart, p.fecha_ini, p.fecha_fin, z.nom_zona, ci.nom_ciud
from cartero c
join relacion2 r on r.id_cart = c.id_cart
join zona z on z.id_zona = r.id_zona
join ciudad ci on ci.id_ciud = r.id_ciud
join periodos p on p.id_per = r.id_per
where z.nom_zona like "rivera" and ci.nom_ciud like "ciudad4";
-- 11.- NOMBRE DE LOS CARTEROS QUE HAN TRABAJADO EN LA PROVINCIA DE SEVILLA
select c.nom_cart, p.nom_prov from cartero c
join relacion2 r on r.id_cart = c.id_cart
join ciudad ci on ci.id_ciud = r.id_ciud
join provincia p on p.id_prov = ci.id_prov
where p.nom_prov like "sevilla";
-- 12.- NOMBRE DE LOS CARTEROS QUE HAN TRABAJADO EN EL PERIODO PE4 Y NOMBRE DE LA CIUDAD EN QUE ESTABAN TRABAJANDO.
select c.nom_cart ;
-- 13.- CARTEROS QUE HAN TRABAJADO EN LA CIUDAD CIUDAD1 Y FECHA DE INICIO Y FIN EN QUE LO HAN HECHO.
-- 14.- CARTEROS QUE HAN TRABAJADO EN LA PROVINCIA DE ALMERIA NOMBRE DE ZONA Y CIUDAD Y FECHAS EN QUE LO HAN HECHO.
-- 15.- NUMERO DE HABITANTES DE CADA PROVINCIA.
select count(num_hab) as 'Numero Habitantes' from ciudad ;
-- 16.- NOMBRE Y SUELDO DEL CARTERO QUE MÁS PERIODOS HA TRABAJADO
-- 17.- NOMBRE DE LACIUDAD QUE MAS CARTEROS HA TENIDO.
select count(id_cart), nom_ciud
from relacion2 r
inner join ciudad c
on r.id_ciud = c.id_ciud 
group by r.id_ciud
having count(id_cart)=(select count(id_cart)
						from relacion2
                        group by id_ciud
                        order by 1 desc limit 1);
-- 18.- NOMBRE DE LA ZONA QUE MAS CARTEROS HA TENIDO (Y Nº DE CARTEROS)
select count(id_cart) as 'Num carteros', z.nom_zona, r.id_ciud
from relacion2 r
join zona z on z.id_zona = r.id_zona
group by z.nom_zona, r.id_ciud
having count(id_cart) = (select count(id_cart)
							from relacion2 r
                            group by id_zona
                            order by 1 desc limit 1);
-- 19.- NOMBRE/S Y SUELDO/S DEL CARTERO QUE HA REPARTIDO EN EL ESTE DE LA CIUDAD3.
select nom_cart, sueldo, ci.nom_ciud, z.nom_zona
from cartero c
join relacion2 r on r.id_cart = c.id_cart
join ciudad ci on ci.id_ciud = r.id_ciud
join zona z on z.id_zona = r.id_zona
where (ci.nom_ciud like 'ciudad3' and z.nom_zona like 'este');
-- 20.- NOMBRE DE LOS CARTEROS QUE NO HAN TRABAJADO EN LA PROVINCIA DE SEVILLA
select nom_cart, ci.nom_ciud, p.nom_prov
from cartero c
join relacion2 r on r.id_cart = c.id_cart
join ciudad ci on ci.id_ciud = r.id_ciud
join provincia p on p.id_prov = ci.id_prov
where p.nom_prov not like 'sevilla';

select nom_cart
from cartero c
where id_cart not in (select id_cart
						from relacion2 r, ciudad ci , provincia p
						where r.id_ciud = ci.id_ciud
                        and ci.id_prov = p.id_prov
                        and nom_prov = 'sevilla');
-- 21.- NOMBRE Y SUELDO DE LOS CARTEROS QUE NO HAN TRABAJADO EN LA RIVERA DE LA CIUDAD4.
select nom_cart, sueldo, ci.nom_ciud, z.nom_zona
from cartero c
join relacion2 r on r.id_cart = c.id_cart
join ciudad ci on ci.id_ciud = r.id_ciud
join zona z on z.id_zona = r.id_zona
where not (z.nom_zona like 'rivera' and ci.nom_ciud like 'ciudad4');
-- 22.- FECHA DE INICIO Y FIN DE LOS PERIODOS EN QUE MAS CARTEROS HAN TRABAJADO.
select count(r.id_cart), fecha_ini, fecha_fin from periodos p
join relacion2 r on r.id_per like p.id_per
group by p.id_per
having count(r.id_cart) = (select count(r.id_cart)
							from relacion2 r
                            group by p.id_per
                            order by 1 desc limit 1);