drop database if exists Relacion1Tema5;
create database if not exists Relacion1Tema5;
use Relacion1Tema5;

create table if not exists alumno(
	id_al char(3) primary key,
	nom_al varchar(40),
	fech_al date,
	telf_al varchar(9)
);
create table if not exists profesor (
	id_prof char(3) primary key,
    nom_prof varchar(40),
    fech_prof date,
    telf_prof varchar(9)
);
create table if not exists relacion (
	id_al char(3) ,
    id_prof char(3),
    nota double,
	primary key (id_al, id_prof),
    foreign key (id_al) references alumno(id_al),
    foreign key (id_prof) references profesor(id_prof)
);

insert into alumno values
("A01", "JUAN MUÑOZ", "1978/09/04", "676543456"),
("A02", "ANA TORRES", "1980/12/05", "654786756"),
("A03", "PEPE GARCIA", "1982/08/09", "950441234"),
("A04", "JULIO GOMEZ", "1983/12/23", "678909876"),
("A05", "KIKO ANDRADE", "1979/01/30", "666123456");

insert into profesor values
("P01", "CARMEN TORRES", "1966/09/08", "654789654"),
("P02", "FERNANDO GARCIA", "1961/07/09", "656894123");

insert into relacion VALUES
("A01", "P01", 3.56),
("A01", "P02", 4.57),
("A02", "P01", 5.78),
("A02", "P02", 7.80),
("A03", "P01", 4.55),
("A03", "P02", 5),
("A04", "P02", 10),
("A05", "P01", 2.75),
("A05", "P02", 8.45);

-- 3.- Mostrar todos los nombres de los alumnos con sus teléfonos
select nom_al, telf_al from alumno;

-- 4.- Mostrar los nombres de los alumnos ordenados en orden creciente y decreciente.
select nom_al as ascendente from alumno order by nom_al desc; 
select nom_al as descendente from alumno order by nom_al asc;
-- 5.- Mostrar los alumnos ordenados por edad.
select nom_al from alumno order by fech_al asc;
-- 6.- Mostrar nombre de alumnos que contengan alguna ‘A’ en el nombre.
 select nom_al from alumno where nom_al like "%a%";
-- 7.- Mostrar id_al ordenado por nota.
select id_al from relacion order by nota;
-- 8.- Mostrar nombre alumno y nombre de sus respectivos profesores.
select nom_al, nom_prof from alumno a
join relacion r on r.id_al = a.id_al
join profesor p on p.id_prof = p.id_prof;
-- 9.- Mostrar el nombre de los alumnos que les de clase el profesor P01
select nom_al, id_prof from relacion r
join alumno a on r.id_al = a.id_al
where r.id_prof like "p01";
-- 10.- Mostrar el nombre y la nota de los alumnos que les de clase el profesor ‘FERNAND0 GARCIA’.
select nom_al, r.nota from alumno a
join relacion r on r.id_al = a.id_al
join profesor p on r.id_prof = p.id_prof
where p.nom_prof like "FERNANDO GARCIA";
-- 11.- Mostrar todos los alumnos (codigo) que hayan aprobado con el profesor P01.
select a.id_al, r.nota from alumno a
join relacion r on r.id_al = a.id_al
join profesor p on p.id_prof = r.id_prof
where p.id_prof = "p01" and r.nota >= 5;
-- 12.- Mostrar todos los alumnos (nombre) que hayan aprobado con el profesor P01.
select nom_al from alumno a
join relacion r on r.id_al = a.id_al
join profesor p on p.id_prof = r.id_prof
where r.nota >= 5 and p.id_prof = "p01";
-- 13.- Mostrar todos los alumnos (nombre) que hayan aprobado con el profesor ‘CARMEN TORRES’.
select nom_al from alumno a
join relacion r on r.id_al = a.id_al
join profesor p on p.id_prof = r.id_prof
where r.nota >= 5 and nom_prof like "CARMEN TORRES";
-- 14.- Mostrar el alumno/s que haya obtenido la nota más alta con ‘P01’,
select nom_al, nota from alumno a
join relacion r on r.id_al = a.id_al
join profesor p on p.id_prof = r.id_prof
where r.id_prof like "p01" order by r.nota desc limit 1;

select nom_al, nota from alumno a
join relacion r on r.id_al = a.id_al
join profesor p on p.id_prof = r.id_prof
where nota=(select max(nota) from relacion r where r.id_prof like "p01");

-- 15.- Mostrar los alumnos (nombre y codigo) que hayan aprobado todo.
select distinct a.nom_al, a.id_al, r.nota from alumno a
join relacion r on r.id_al = a.id_al
where r.id_al not in (select id_al from relacion where nota < 5);

-- EXTRA
-- cuantos alumnos tiene cada profesor
select count(id_al) Alumnos, p.nom_prof 'Profesor Asignado' from relacion r
join profesor p on p.id_prof = r.id_prof
group by p.id_prof;

-- media de la nota
select avg(r.nota), id_prof from relacion r
group by r.id_prof;
-- media de la nota con nombre del profesor
-- media de la nota
select avg(r.nota), nom_prof from relacion r
join profesor p on p.id_prof = r.id_prof
group by r.id_prof