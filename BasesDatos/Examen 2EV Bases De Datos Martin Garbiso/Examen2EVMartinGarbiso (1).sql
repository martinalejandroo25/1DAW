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

insert into usuario values
('U01', 'PEDRO PÉREZ', 'pedro@example.com', 654321987),
('U02', 'MARÍA MARTÍNEZ', 'maria@example.com', 612345678),
('U03', 'LUIS FERNÁNDEZ', 'luis@example.com', 687654321),
('U04', 'ANA LÓPEZ', 'ana@example.com', 699876543),
('U05', 'JUAN GARCÍA', 'juan@example.com', 623456789),
('U06', 'SARA TORRES', 'sara@example.com', 655432198),
('U07', 'CARLOS RODRÍGUEZ', 'carlos@example.com', 661234567),
('U08', 'LAURA FERRER', 'laura@example.com', 677654321),
('U09', 'PABLO HERNÁNDEZ', 'pablo@example.com', 690987654),
('U10', 'NATALIA PASCUAL', 'natalia@example.com', 645678321);

insert into region values
(01, 'MADRID'),
(02, 'BARCELONA'),
(03, 'SEVILLA'),
(04, 'VALENCIA');

insert into ciudad values
('28001','MADRID', 01),
('28002','MADRID', 01),
('08001','BARCELONA', 02),
('08002','BARCELONA', 02),
('41001','SEVILLA', 03),
('46001','VALENCIA', 04);

insert into hoteles values
('H01', 'HOTEL CASTILLA', 150, '****', '28001'),
('H02', 'HOTEL CATALUNYA', 200, '***', '08001'),
('H03', 'HOTEL SEVILLANO', 120, '*****', '41001'),
('H04', 'HOTEL MEDITERRÁNEO', 180, '***', '46001'),
('H05', 'HOTEL ANDALUCÍA', 100, '***', '41001'),
('H06', 'HOTEL SOL', 250, '*****', '08002'),
('H07', 'HOTEL DELUXE', 50, '*****', '28002');

insert into reservas values
('U01', 'H01', '2024-05-01',  '2024-05-05', 500),
('U02', 'H01', '2024-06-10',  '2024-06-15', 600),
('U03', 'H02', '2024-07-01',  '2024-07-05', 450),
('U04', 'H03', '2024-08-15',  '2024-08-20', 900),
('U05', 'H03', '2024-09-10',  '2024-09-12', 850),
('U06', 'H04', '2024-10-05',  '2024-10-08', 300),
('U07', 'H05', '2024-11-12',  '2024-11-15', 400),
('U08', 'H06', '2024-12-01',  '2024-12-05', 1000),
('U09', 'H07', '2024-12-10',  '2024-12-12', 1500),
('U10', 'H06', '2025-01-15',  '2025-01-20', 1200),
('U03', 'H03', '2025-02-10',  '2025-02-15', 750),
('U04', 'H02', '2025-03-01',  '2025-03-06', 550),
('U05', 'H01', '2025-04-20',  '2025-04-25', 620),
('U06', 'H02', '2025-05-10',  '2025-05-15', 700),
('U07', 'H03', '2025-06-20',  '2025-06-25', 650),
('U08', 'H05', '2025-07-01',  '2025-07-05', 550);

insert into empleado values
('E01', 'ANDRÉS TORRES', 	1400, 'H01'),
('E02', 'BEATRIZ ROJAS', 	1300, 'H02'),
('E03', 'CARLOS FERNÁNDEZ', 1100, 'H03'),
('E04', 'DIANA LÓPEZ', 		1250, 'H04'),
('E05', 'EDUARDO SÁNCHEZ',  1500, 'H05'),
('E06', 'FÁTIMA PÉREZ', 	1600, 'H06'),
('E07', 'GABRIEL MARTÍN', 	1200, 'H06'),
('E08', 'HUGO GONZÁLEZ', 	1700, 'H07');

-- CONSULTAS

-- 1. Nombre del hotel o de los hoteles con cinco estrellas que tienen mayor número de habitaciones.
 select nom_hotel, categoria, habitaciones from hoteles
 where categoria like '*****' and habitaciones = (select habitaciones from hoteles
													order by 1 desc limit 1);
-- 2. Datos de los empleados cuyo salario está entre 1200 y 1600 euros, ordenados de mayor a menor salario.
 select * from empleado
 where salario >= 1200 and salario <= 1600
 order by salario desc;
-- 3. Datos de los empleados cuyo salario es mayor que el salario medio de todos los empleados.
 select * from empleado
 where salario > (select avg(salario) from empleado);
-- 4. Nombre de los usuarios que se han hospedado en la región de Barcelona.
 select u.nom_user, r.nom_reg from usuario u
 inner join reservas re on re.id_user = u.id_user
 inner join hoteles h on h.id_hotel = re.id_hotel 
 inner join ciudad c on c.codigo_postal = h.codigo_postal
 inner join region r on r.id_reg = c.id_reg
 where r.nom_reg like 'barcelona';
-- 5. Nombre de los usuarios y dinero total gastado en alojarse cada uno de ellos.
 select u.nom_user, sum(r.costo) as 'dinero total' from usuario u
 inner join reservas r on r.id_user = u.id_user
 group by u.nom_user;
-- 6. Nombre de los hoteles y fechas en que se ha hospedado el usuario PEDRO PÉREZ, ordenados por nombre del hotel.
 select h.nom_hotel, r.fecha_llegada, r.fecha_salida ,u.nom_user from hoteles h
 inner join reservas r on r.id_hotel = h.id_hotel
 inner join usuario u on r.id_user = u.id_user
 where u.nom_user like 'pedro pérez'
 order by h.nom_hotel;
-- 7. Datos del usuario que ha visitado más hoteles.
 select u.*, count(r.id_hotel) from usuario u
 inner join reservas r on r.id_user = u.id_user
 group by u.id_user
 having count(r.id_hotel) = (select count(r.id_hotel)from reservas r
						group by r.id_user
                        order by 1 desc limit 1
                        );
-- 8. Listado de hoteles con el nombre del hotel y el dinero ganado en los hospedajes, ordenados por nombre del hotel.
 select h.nom_hotel, sum(r.costo) as 'Dinero Total Ganado' from hoteles h
 inner join reservas r on r.id_hotel = h.id_hotel
 group by 1
 order by 1 asc;
-- 9. Nombre del empleado y nombre del hotel donde trabaja el empleado con mayor salario.
 select e.nom_emp, h.nom_hotel, e.salario from empleado e
 inner join hoteles h on h.id_hotel = e.id_hotel
 where e.salario = (select salario from empleado
					order by 1 desc limit 1);
-- 10.Nombre del hotel con mayor número de empleados.
 select h.nom_hotel, count(e.id_emp) from hoteles h
 inner join empleado e on e.id_hotel = h.id_hotel
 group by 1
 having count(e.id_emp) = (select count(e.id_emp) from empleado e
							inner join hoteles h on h.id_hotel = e.id_hotel
                            group by h.id_hotel
							order by 1 desc limit 1);
-- 11.Nombre de la región con menor número de hoteles.
 select r.nom_reg, count(h.id_hotel) as 'num de hoteles' from region r
 inner join ciudad c on c.id_reg = r.id_reg
 inner join hoteles h on h.codigo_postal = c.codigo_postal
 group by 1
 having count(h.id_hotel) = (select count(h.id_hotel) from hoteles h
							inner join ciudad c on h.codigo_postal = c.codigo_postal
                            inner join region r on r.id_reg = c.id_reg
                            group by c.id_reg
                            order by 1 asc limit 1
                            );
-- 12.Número de hoteles por cada región. Mostrar el nombre de la región y el número de hoteles.
 select r.nom_reg, count(h.id_hotel) as 'Num Hoteles' from hoteles h
							inner join ciudad c on h.codigo_postal = c.codigo_postal
                            inner join region r on r.id_reg = c.id_reg
                            group by c.id_reg;
                            
-- 13.Media del salario de los empleados por cada hotel. Mostrar el nombre del hotel y la media del salario de sus empleados.
 select h.nom_hotel, avg(e.salario) 'media de salario' from hoteles h
 inner join empleado e on e.id_hotel = h.id_hotel
 group by h.id_hotel;
-- 14.Actualiza la tabla empleados para incrementar el salario de los empleados de la región de Madrid en un 10%.

 update empleado set salario = (salario * 1.10)
 where id_emp = (select e.id_emp from empleado e
				inner join hoteles h on e.id_hotel = h.id_hotel
				inner join ciudad c on c.codigo_postal = h.codigo_postal
				inner join region r on r.id_reg = c.id_reg
				where r.nom_reg like 'madrid');
                
-- 15.Actualiza la tabla hoteles para incrementar las habitaciones del "Hotel Mediterráneo" a 200.
 update hoteles set habitaciones = 200
 where nom_hotel like 'hotel mediterraneo';
 
-- 16.Borra a los empleados que trabajen en el "Hotel Castilla".
 delete from empleado
 where id_emp = (select e.id_emp from empleado e
				inner join hoteles h on h.id_hotel = e.id_hotel
                where h.nom_hotel like 'hotel castilla');