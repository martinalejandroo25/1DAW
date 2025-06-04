Create database if not exists Hospitales;
use Hospitales;

Create table if not exists clinica(
idClinica char(2),
nombre varchar(30),
ciudad varchar(20),
primary key (idClinica)
)Engine=InnoDB;

Create table if not exists investigacion(
idInvestigacion char(3),
nombre varchar(60),
idClinica char(2),
primary key (idInvestigacion),
foreign key (idClinica) references clinica(idClinica) on delete restrict on update cascade
)Engine=InnoDB;

Create table if not exists doctor(
idDoctor char(3),
nombre varchar(30),
fechaIngreso date,
salario double,
idSupervisor char(3),
idClinica char(2),
primary key (idDoctor),
foreign key (idClinica) references clinica(idClinica) on delete restrict on update cascade,
foreign key (idSupervisor) references doctor(idDoctor) on delete set null on update cascade
)Engine=InnoDB;

Create table if not exists participa(
idDoctor char(3),
idInvestigacion char(3),
horas integer,
primary key (idDoctor, idInvestigacion),
foreign key (idDoctor) references doctor(idDoctor) on delete cascade on update cascade,
foreign key (idInvestigacion) references investigacion(idInvestigacion) on delete cascade on update cascade
)Engine=InnoDB;

Insert into clinica values
('01', "Clínica Central", "Madrid"),
('02', "Clínica Universitaria", "Salamanca"),
('03', "Clínica del Sur", "Valencia"),
('04', "Clínica General", "Bilbao"),
('05', "Clínica del Mar", "Barcelona"),
('06', "Clínica Horizonte", "Sevilla");

Insert into doctor values
('D01', "Ana Gómez", '2000-05-10', 2700, null, '03'),
('D02', "Luis Torres", '2003-07-12', 1800, 'D01', '03'),
('D03', "Eva Sánchez", '2008-09-15', 2200, 'D01', '03'),
('D04', "Daniel Pérez", '2010-01-01', 1600, 'D01', '03'),
('D05', "Marta Ruiz", '2012-02-20', 1500, 'D01', '03'),
('D08', "Jorge Molina", '1995-03-30', 3000, null, '01'),
('D06', "Iván Herrera", '2005-11-11', 2400, 'D08', '01'),
('D07', "Nuria Morales", '2007-06-08', 2300, 'D08', '01'),
('D09', "Teresa Lázaro", '1999-12-25', 2900, null, '06'),
('D10', "Elena Cano", '2004-10-10', 1800, 'D09', '06'),
('D11', "Raúl Muñoz", '2011-09-09', 2100, null, '02'),
('D12', "Clara Navas", null, 1700, 'D11', '02'),
('D13', "Hugo García", '2001-08-08', 2400, 'D09', '06'),
('D14', "Javier Romero", '2016-04-04', 1900, 'D08', null),
('D15', "Patricia Díaz", '2018-12-01', 1700, null, '05'),
('D16', "Adrián Gil", '2019-03-15', 2000, 'D15', '05');

Insert into investigacion values
('GEN', "Genética y Cáncer", '05'),
('NEU', "Neurodegenerativas", '01'),
('SAL', "Saluud Pública", '01'),
('ALM', "Alimentación y Diabetes", '03'),
('TRS', "Trasplantes", '06');

Insert into participa values
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
