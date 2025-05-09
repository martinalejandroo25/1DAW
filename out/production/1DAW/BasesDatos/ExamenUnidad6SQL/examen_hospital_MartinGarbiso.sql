drop database if exists examen_hospital_MartinGarbiso;
create database if not exists examen_hospital_MartinGarbiso;
use examen_hospital_MartinGarbiso;

create table if not exists clinica(
    IdClinica CHAR(2) primary key,
    Nombre VARCHAR(30),
    Ciudad VARCHAR(20)
);
create table if not exists investigacion(
    IdInvestigacion CHAR(3) primary key,
    Nombre VARCHAR(60),
    IdClinica CHAR(2),
    foreign key(IdClinica) references clinica(IdClinica)
    on delete restrict on update cascade
);

create table if not exists doctor(
    IdDoctor CHAR(3) primary key,
    Nombre VARCHAR(30),
    FechaIngreso DATE,
    Salario double,
    IdSupervisor CHAR(3),
    IdClinica CHAR(2),
    foreign key (IdClinica) references clinica(IdClinica)
    on delete restrict on update cascade,
    foreign key(IdSupervisor) references doctor(IdDoctor)
    on delete set null on update cascade
);

create table if not exists participa(
    IdDoctor CHAR(3),
    IdInvestigacion CHAR(3),
    Horas INTEGER,
    primary key(IdDoctor, IdInvestigacion),
    foreign key(IdDoctor) references doctor(IdDoctor)
    on delete cascade on update cascade,
    foreign key(IdInvestigacion) references investigacion(IdInvestigacion)
    on delete cascade on update cascade
);


insert into clinica value

(01, 'Clínica Central'      , 'Madrid'),
(02, 'Clínica Universitaria', 'Salamanca'),
(03, 'Clínica del Sur'      , 'Valencia'),
(04, 'Clínica General'      , 'Bilbao'),
(05, 'Clínica del Mar'      , 'Barcelona'),
(06, 'Clínica Horizonte'    , 'Sevilla');

insert into doctor values
('D01', 'Ana Gómez',      '2000-05-10', 2700, NULL, 03),
('D08', 'Jorge Molina',   '1995-03-30', 3000, NULL, 01),
('D09', 'Teresa Lázaro',  '1999-12-25', 2900, NULL, 06),
('D11', 'Raúl Muñoz',     '2011-09-09', 2100, NULL, 02),
('D15', 'Patricia Díaz',  '2018-12-01', 1700, NULL, 05),
('D02', 'Luis Torres',    '2003-07-12', 1800, 'D01', 03),
('D03', 'Eva Sánchez',    '2008-09-15', 2200, 'D01', 03),
('D04', 'Daniel Pérez',   '2010-01-01', 1600, 'D01', 03),
('D05', 'Marta Ruiz',     '2012-02-20', 1500, 'D01', 03),
('D06', 'Iván Herrera',   '2005-11-11', 2400, 'D08', 01),
('D07', 'Nuria Morales',  '2007-06-08', 2300, 'D08', 01),
('D10', 'Elena Cano',     '2004-10-10', 1800, 'D09', 06),
('D12', 'Clara Navas',    NULL      , 1700, 'D11', 02),
('D13', 'Hugo García',    '2001-08-08', 2400, 'D09', 06),
('D14', 'Javier Romero',  '2016-04-04', 1900, 'D08', NULL),
('D16', 'Adrián Gil',     '2019-03-15', 2000, 'D15', 05);

insert into investigacion value

('GEN', 'Genética y Cáncer', 05),
('NEU', 'Neurodegenerativas', 01),
('SAL', 'Salud Pública', 01),
('ALM', 'Alimentación y Diabetes', 03),
('TRS', 'Trasplantes', 06);

insert into participa values
('D01', 'ALM', 110),
('D01', 'NEU', 25),
('D02', 'ALM', 40),
('D04', 'ALM', 70),
('D08', 'SAL', 50),
('D07', 'SAL', 10),
('D06', 'SAL', 140),
('D08', 'NEU', 20),
('D09', 'TRS', 160),
('D13', 'TRS', 190),
('D14', 'GEN', 20),
('D15', 'GEN', 15),
('D16', 'GEN', 45);

-- CONSULTAS


-- 1. Nombres de doctores que han trabajado más de 200 horas en total.
-- revisar
select d.nombre, sum(horas) from doctor d
inner join participa p on p.IdDoctor = d.IdDoctor
group by d.nombre
having sum(p.Horas) > 200;
-- no hay doctores que hayan trabajado mas de 200 horas

-- 2. Nombre de las clínicas que tienen doctores cuyo apellido sea “García”.
select c.nombre, d.nombre from clinica c
inner join doctor d on d.IdClinica = c.IdClinica
where d.nombre like '%garcia';
-- 3. Nombre de las investigaciones en las que participan más de dos doctores.
select i.nombre, count(p.IdDoctor) from participa p
inner join investigacion i on i.IdInvestigacion = p.IdInvestigacion
group by p.IdInvestigacion
having count(p.IdDoctor) > 2;
-- 4. Lista de todos los doctores junto al nombre de la clínica a la que pertenecen y el total de dinero que reciben por participar en investigaciones (a razón de 50 € por hora).Si no pertenecen a ninguna clínica, debe aparecer el texto “Sin Clínica Asignada”. Ordenar alfabéticamente por el nombre del doctor.
select d.nombre, ifnull(c.nombre, 'sin clinica asignada'), salario  from doctor d;

-- 5. Lista con el nombre de todos los doctores y el número de investigaciones en las que participan. Si no participa en ninguna, debe aparecer la frase “Sin investigación asignada”.
select d.nombre, ifnull(count(i.IdInvestigacion), 'Sin investigacion asignada')
from doctor d
inner join participa p on p.IdDoctor = d.IdDoctor
inner join investigacion i on i.IdInvestigacion = p.IdInvestigacion
group by d.nombre;
-- 6. Lista de los doctores que trabajan en clínicas ubicadas en Madrid o Valencia.
select d.nombre, c.nombre, c.ciudad from doctor d
inner join clinica c on c.IdClinica = d.IdClinica
where c.ciudad in('madrid', 'valencia');
-- 7. Lista alfabética de nombres de doctores y nombres de sus supervisores. Si el doctor no tiene supervisor, debe aparecer el texto “Sin Supervisor”.
select d.nombre, ifnull(s.nombre, 'Sin Supervisor') from doctor d
inner join doctor s on d.IdSupervisor = s.IdDoctor;
-- 8. Calcular el promedio del año de ingreso de los doctores que participan en al menos una investigación.

-- 9. Nombres de los doctores cuyo apellido sea “Díaz” o “Morales” y simultáneamente su supervisor sea Jorge Molina.
select d.nombre, s.nombre from doctor d
inner join doctor s on d.IdSupervisor = s.IdDoctor
where (d.nombre like'%diaz' or d.nombre like '%morales') and s.nombre like 'Jorge Molina';
-- 10. Listado de todas las clínicas, mostrando:
    -- ● nombre de la clínica,
    -- ● ciudad,
    -- ● número de doctores que trabajan allí.
    -- Ordenar por nombre de clínica y en caso de coincidencia por ciudad.
select c.nombre, c.ciudad, count(d.IdDoctor) from clinica c
inner join doctor d on d.IdClinica = c.IdClinica
group by 1, 2
order by 1, 2;
-- 11. Nombres de los doctores que han trabajado entre 10 y 100 horas en total sumando todas sus investigaciones.
select d.nombre, sum(p.horas) from doctor d
inner join participa p on p.IdDoctor = p.IdDoctor
group by p.IdDoctor
having (sum(p.horas) > 10);
-- 12. Nombres de los doctores que no son supervisores de ningún otro doctor.
select nombre from doctor
where isnull(IdSupervisor);
-- 13. Determinar qué clínica es la más productiva, entendiendo productividad como el número total de horas trabajadas por los doctores en investigaciones dividido entre el número de doctores de la clínica.

-- 14. Listado de todos los doctores. En el listado debe aparecer el nombre de los doctores, nombres de sus clínicas y nombres de las investigaciones en las que participan. Los doctores sin clínica aparecerán “Sin centro Hospitalario”, y los que no participen en investigaciones aparecerán “Sin Investigación”.

-- 15. Lista de los doctores con el número de días que llevan trabajando. Si no tienen fecha, mostrar “Sin fecha de ingreso”. Ordenar por días trabajados y nombre.
select d.nombre, ifnull(datediff(curdate(), FechaIngreso), 'Sin fecha de ingreso') from doctor d; 
-- 16. Lista de doctores que son supervisores de más de dos doctores, junto con el número de doctores que supervisan.
select s.nombre, count(d.nombre) from doctor d
inner join doctor s on d.IdSupervisor = s.IdDoctor
group by s.nombre
having count(d.nombre) > 2;
-- 17. Nombre de las investigaciones que contienen “Neuro”, junto con el nombre de la clínica organizadora.
select i.nombre, c.nombre from investigacion i
inner join clinica c on c.IdClinica = i.IdClinica
where i.nombre like '%neuro%';
-- 18. Asignar al doctor Javier Romero a la clínica que más gasta en sueldos.

-- 19. Eliminar todas las clínicas sin ningún doctor asignado.
delete from clinica where IdClinica = (select d.IdClinica from doctor d
                                        where isnull(d.IdDoctor));
                                        
                                        select d.nombre, d.IdClinica from doctor d
                                        where not(d.IdDoctor);
-- 20. Asignar a todos los doctores de la clínica 02 a la investigación SAL.
update participa set IdInvestigacion = 'SAL'
where IdDoctor = (select IdDoctor from doctor
					where IdClinica = 2
                    order by 1 limit 1);
                    

-- pruebas en sucio                    
select IdDoctor from doctor
where IdDoctor = (select IdDoctor from doctor
					where IdClinica = 2
                    order by 1 limit 1);
select IdDoctor from doctor
where IdClinica = 2;