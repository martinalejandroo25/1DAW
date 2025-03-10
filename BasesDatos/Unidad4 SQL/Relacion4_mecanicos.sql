drop database if exists Relacion4_Mecanicos;
create database if not exists Relacion4_Mecanicos;
use Relacion4_Mecanicos;

create table if not exists mecanico(
	id_mec char(3)primary key,
    nom_mec char(20),
    sueldo int,
    fec_nac date
);

create table if not exists coche(
	mat_co char(8)primary key,
	mod_co char(20),
	color char(10),
	tipo char(10)
);
create table if not exists periodos(
	id_per char(3) primary key,
    fec_ini date,
    fec_fin date
);
create table if not exists tipo(
id_tipo char(3) primary key,
nom_tipo char(20)
);

create table if not exists pieza(
id_piez char(3) primary key,
nom_piez char(20),
id_tipo char(3),
foreign key (id_tipo) references tipo(id_tipo)
on delete cascade on update cascade
);

create table if not exists relacion4(
	id_mec char(3),
    mat_co char(8),
    id_per char(3),
    id_piez char(3),
    precio int,
    primary key(id_mec, mat_co, id_per, id_piez),
    foreign key (id_mec) references mecanico(id_mec)
    on delete cascade on update cascade,
    foreign key (mat_co) references coche(mat_co)
    on delete cascade on update cascade,
    foreign key (id_per) references periodos(id_per)
    on delete cascade on update cascade,
    foreign key (id_piez) references pieza(id_piez)
    on delete cascade on update cascade

);

insert into mecanico values
('ME1', 'JUAN ROMUALDO', 1289, '1970/09/05'),
('ME2', 'RAMON FERNANDEZ', 1678, '1976/07/05'),
('ME3', 'ANA LUCAS', 1100, '1968/09/04');

insert into coche values
('1234-CDF', 'SEAT LEON', 'GRIS','DIESEL'),
('0987-CCC', 'RENAULT MEGANE', 'BLANCO','GASOLINA'),
('0123-BVC', 'OPEL ASTRA', 'AZUL','DIESEL'),
('1456-BNL', 'FORD FOCUS', 'VERDE','DIESEL'),
('1111-CSA', 'SEAT TOLEDO', 'ROJO','GASOLINA'),
('4567-BCB', 'VOLKSWAGEN POLO', 'BLANCO','DIESEL'),
('0987-BFG', 'FORD FIESTA', 'NEGRO','GASOLINA');

insert into periodos values
('PE1', '2003/04/09', '2003/04/10'),
('PE2', '2004/05/12', '2004/05/17'),
('PE3', '2004/06/17', '2004/06/27'),
('PE4', '2005/08/22', '2005/09/1'),
('PE5', '2005/09/10', '2005/09/15'),
('PE6', '2005/10/1', '2005/10/17');

insert into tipo values
('TI1', 'CHAPA'),
('TI2', 'MECANICA'),
('TI3', 'ELECTRICIDAD'),
('TI4', 'ACCESORIOS');

insert into pieza values
('PI1', 'FILTRO', 'TI4'),
('PI2', 'BATERIA', 'TI3'),
('PI3', 'ACEITE', 'TI2'),
('PI4', 'RADIO', 'TI4'),
('PI5', 'EMBRAGE', 'TI2'),
('PI6', 'ALETA', 'TI1'),
('PI7', 'PILOTO', 'TI3'),
('PI8', 'CALENTADOR', 'TI2'),
('PI9', 'CORREAS', 'TI4');

insert into relacion4 values
('ME1', '1234-CDF', 'PE1', 'PI1', 23),
('ME1', '0123-BVC', 'PE2', 'PI2', 98),
('ME1', '1456-BNL', 'PE3', 'PI6', 124),
('ME1', '4567-BCB', 'PE4', 'PI5', 245),
('ME2', '0987-CCC', 'PE1', 'PI9', 345),
('ME2', '0987-CCC', 'PE1', 'PI8', 232),
('ME2', '0987-BFG', 'PE2', 'PI1', 17),
('ME2', '4567-BCB', 'PE3', 'PI7', 99),
('ME2', '1111-CSA', 'PE4', 'PI4', 124),
('ME2', '1111-CSA', 'PE4', 'PI2', 153),
('ME3', '1456-BNL', 'PE6', 'PI3', 89),
('ME3', '1456-BNL', 'PE1', 'PI4', 232),
('ME3', '1234-CDF', 'PE2', 'PI8', 235),
('ME3', '1111-CSA', 'PE3', 'PI9', 567),
('ME3', '0123-BVC', 'PE5', 'PI6', 232),
('ME3', '0987-CCC', 'PE4', 'PI2', 78),
('ME1', '0987-BFG', 'PE5', 'PI3', 64),
('ME2', '1234-CDF', 'PE6', 'PI5', 234),
('ME1', '0987-BFG', 'PE6', 'PI9', 345),
('ME2', '1234-CDF', 'PE6', 'PI1', 12),
('ME1', '1234-CDF', 'PE1', 'PI6', 187),
('ME3', '1111-CSA', 'PE3', 'PI4', 345),
('ME1', '0123-BVC', 'PE2', 'PI3', 72),
('ME2', '0123-BVC', 'PE6', 'PI3', 89);


-- 1.- DATOS DEL EMPLEADO DE MAYOR SUELDO.
select nom_mec, sueldo from mecanico
where sueldo = (select sueldo from mecanico
				order by 1 desc limit 1);
-- 2.- DATOS DEL EMPLEADO MAYOR.
select nom_mec, fec_nac from mecanico
where fec_nac = (select fec_nac from mecanico
				order by fec_nac asc limit 1);
-- 3.- DATOS DEL EMPLEADO MENOR.
select nom_mec, fec_nac from mecanico
where fec_nac = (select fec_nac from mecanico
				order by fec_nac desc limit 1);
-- 4.- DATOS DE TODOS LOS COCHES DIESEL.
select * from coche
where tipo like 'diesel';
-- 5.- DATOS DEL COCHE QUE MAS HA IDO AL TALLER.
SELECT c.*, COUNT(p.id_per) -- Selecciona todas las columnas de la tabla 'coche' (c) y cuenta el número de períodos asociados a cada coche
FROM relacion4 r
INNER JOIN coche c ON c.mat_co = r.mat_co -- Une 'relacion4' con 'coche' usando la matrícula del coche como clave de unión
INNER JOIN periodos p ON p.id_per = r.id_per -- Une 'relacion4' con 'periodos' utilizando el identificador de período
GROUP BY r.mat_co -- Agrupa por la matrícula del coche para poder contar cuántos períodos están asociados a cada uno
HAVING COUNT(r.mat_co) = ( -- Filtra los coches que tengan el número máximo de períodos asociados
    SELECT COUNT(mat_co) -- Cuenta cuántas veces aparece cada matrícula en 'relacion4'
    FROM relacion4
    GROUP BY mat_co -- Agrupa por matrícula para contar cuántas veces aparece cada coche
    ORDER BY 1 DESC -- Ordena de mayor a menor la cantidad de veces que aparece cada matrícula
    LIMIT 1 -- Obtiene el valor máximo de períodos asociados a un coche
);

-- 6.- PRECIO TOTAL DE TODAS LAS REPARACIONES.
select sum(precio) from relacion4;
-- 7.- NOMBRE DE PIEZA Y TIPO DE LA PIEZA MAS USADA.
-- rehacer para entenderlo
select count(r.id_piez), p.nom_piez, t.nom_tipo
from relacion4 r
inner join pieza p on r.id_piez = p.id_piez
inner join tipo t on t.id_tipo = p.id_tipo
group by r.id_piez
having count (r.id_piez) = (select count(id_piez ) from relacion4
							group by id_piez
                            order by 1 limit 1);
-- 8.- NOMBRE Y TIPO DE LA PIEZA MENOS USADA.
select count(r.id_piez), p.nom_piez, t.nom_tipo
from relacion4 r
inner join pieza p on p.id_piez = r.id_piez
inner join tipo t on t.id_tipo = p.id_tipo
group by r.id_piez
having count(r.id_piez)=(select count(id_piez) from relacion4
							group by id_piez
                            order by 1 limit 1);
-- 9.- MATRICULA, MARCA, MODELO COLOR PIEZA Y TIPO DE TODOS LOS COCHES REPARADOS.
select r.mat_co, c.mod_co, c.color, p.nom_piez, t.nom_tipo from relacion4 r
inner join coche c on c.mat_co = r.mat_co
inner join pieza p on p.id_piez = r.id_piez
inner join tipo t on t.id_tipo = p.id_tipo
order by r.mat_co;
-- 10.- MODELO DE PIEZA Y TIPO PUESTAS A ‘0123-BVC’
select distinct r.mat_co, p.id_piez, p.nom_piez, t.nom_tipo
from relacion4 r
inner join pieza p on p.id_piez = r.id_piez
inner join tipo t on t.id_tipo = p.id_tipo
where r.mat_co like '0123-BVC';
-- 11.-DINERO QUE HA GASTADO EN REPARACIONES 1234-CDF
   select mat_co, sum(precio) as 'Gastos totales'from relacion4
   where mat_co like '1234-CDF'
   group by 1;
-- 12.- DATOS DEL COCHE QUE MAS HA GASTADO EN REPARACIONES
select c.*, sum(precio) from relacion4 r
inner join coche c on c.mat_co = r.mat_co
group by r.mat_co
having sum(precio) = (select sum(precio) from relacion4
					group by mat_co
					order by 1 desc limit 1);
-- 13- DATOS DEL COCHE QUE MENOS HA GASTADO EN REPARACIONES.
select c.*, sum(precio) from relacion4 r
inner join coche c on c.mat_co = r.mat_co
group by r.mat_co
having sum(precio) = (select sum(precio) from relacion4
					group by mat_co
                    order by 1 asc limit 1);
-- 14.- DATOS DEL COCHE QUE MENOS HA GASTADO EN EL TALLER.
-- la respuesta es la misma que la 13
-- 15.- TOTAL DE TODAS LAS REPARACIONES DE ‘ANA LUCAS’.
select m.nom_mec, count(r.mat_co) as 'Total reparaciones' from mecanico m
inner join relacion4 r on r.id_mec = m.id_mec
where m.nom_mec like 'ana lucas'
group by 1;

-- me confundí con el enunciado
/*select m.nom_mec, count(r.mat_co) from relacion4 r
inner join mecanico m on m.id_mec = r.id_mec
group by nom_mec
having count(r.mat_co) = (select count(r.mat_co) from relacion4
						order by 1 desc limit 1); */
-- 16.- DATOS DE LOS COCHES Y LAS PIEZAS PUESTAS POR ‘JUAN ROMUALDO’.
select c.*, p.* /*, m.nom_mec */ from relacion4 r
inner join coche c on c.mat_co = r.mat_co
inner join pieza p on p.id_piez = r.id_piez
-- comprobacion inner join mecanico m on m.id_mec = r.id_mec
 where r.id_mec=(select id_mec from mecanico 
				where nom_mec like 'JUAN ROMUALDO');
-- 17.- FECHA DE INICIO Y FIN DEL PERIODO EN QUE MAS SE HA TRABAJADO.
select count(r.id_per), p.* from relacion4 r
inner join periodos p on p.id_per = r.id_per
group by r.id_per
having count(r.id_per)=(select count(r.id_per)
						from relacion4 r
                        group by r.id_per
                        order by 1 desc limit 1);

-- 18.- FECHA DE INICIO Y FIN DEL PERIODO QUE MENOS SE HA TRABAJADO.
select count(r.id_per), p.* from relacion4 r
inner join periodos p on p.id_per = r.id_per
group by r.id_per
having count(r.id_per)=(select count(id_per)
						from relacion4 r
                        group by id_per
                        order by 1 asc limit 1);

-- 19.-DINERO QUE SE HA HECHO EN EL PERIODO PE2
select id_per, sum(precio) from relacion4
where id_per = 'pe2';
-- 20.- DATOS DE LOS COCHES LA QUE SE LE HALLA PUESTO UN EMBRAGE
select c.*, p.nom_piez from coche c
inner join relacion4 r on r.mat_co = c.mat_co
inner join pieza p on p.id_piez = r.id_piez
where p.nom_piez like 'embrage';
-- 21.- DATOS DE LOS COCHES A LOS QUE SE LES HALLA CAMBIADO EL ACEITE.
select c.*, p.nom_piez from coche c
inner join relacion4 r on r.mat_co = c.mat_co
inner join pieza p on p.id_piez = r.id_piez
where p.nom_piez like 'aceite';
-- 22.- DATOS DE LOS MECANICOS QUE HALLAN PUESTO ALGUNA PIEZA DE TIPO ‘ELECTRICIDAD’.
select distinct m.*, t.nom_tipo from mecanico m
inner join relacion4 r on r.id_mec = m.id_mec
inner join pieza p on p.id_piez = r.id_piez
inner join tipo t on t.id_tipo = p.id_tipo
where t.nom_tipo like 'electricidad';

-- 23.- MONTANTE ECONOMICO DE TODAS LAS PIEZAS DE TIPO CHAPA.
select t.nom_tipo, sum(r.precio) from relacion4 r
inner join pieza p on p.id_piez = r.id_piez
inner join tipo t on t.id_tipo = p.id_tipo
where t.nom_tipo like 'chapa'
group by 1;
-- 24.- TIPO DE PIEZA QUE MAS DINERO HA DEJADO EN EL TALLER.
select t.nom_tipo, sum(r.precio) from relacion4 r
inner join pieza p on p.id_piez = r.id_piez
inner join tipo t on t.id_tipo = p.id_tipo
group by 1
having sum(r.precio) = (select sum(r.precio) from relacion4 r
						inner join pieza p on p.id_piez = r.id_piez
                        inner join tipo t on t.id_tipo = p.id_tipo
                        group by t.id_tipo
                        order by 1 desc limit 1);
-- 25.-DATOS DEL MECANICO QUE MENOS HA TRABAJADO.
select m.*, count(r.id_per) from relacion4 r
inner join mecanico m on m.id_mec = r.id_mec
inner join periodos p on p.id_per = r.id_per
group by 1
having count(r.id_per)=(select count(r.id_per) from periodos p
						inner join relacion4 r on r.id_per = p.id_per
                        group by r.id_mec
                        order by 1 asc limit 1);