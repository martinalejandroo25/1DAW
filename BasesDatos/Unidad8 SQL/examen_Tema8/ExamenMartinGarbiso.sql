-- Ejercicios procedimientos y Funciones.

SET GLOBAL log_bin_trust_function_creators = 1;
use Hospitales;

-- 1.​ Crea un procedimiento que actualice la fecha de ingreso del doctor que le pasaremos como parámetro de entrada. Para ello pasaremos dos parámetros de entrada uno será el nombre del Doctor y el otro será la nueva fecha de ingreso. Usa la base de datos HOSPITALES. (1 punto)
delimiter $$
drop procedure if exists ejercicio1$$
create procedure ejercicio1(in doctorNombre varchar(30), in nuevaFecha date)
modifies sql data
begin
	update doctor set fechaIngreso = nuevaFecha 
	where nombre = doctorNombre;
end
$$
delimiter ;
call ejercicio1("Ana Gómez", '2000-06-12');
select nombre, fechaIngreso from doctor
where nombre like "ana gómez";
-- 2.​ Haz un procedimiento para dar de alta nuevas clínicas, con las siguientes características. El procedimiento recibe 3 parámetros de entrada idClinica char(2), nombre varchar(30), ciudad varchar(20) y devolverá como salida un parámetro llamado error que tendrá valor igual a 0 si la inserción se ha podido realizar con éxito y un valor igual a 1 en caso contrario. Deberá manejar el siguiente error que pueda ocurrir durante el proceso de inserción .ERROR 1062 (Duplicate entry for PRIMARY KEY). (1.5 puntos) Usa la base de datos HOSPITALES .
delimiter $$
drop procedure if exists ejercicio2$$
create procedure ejercicio2(
							in idClinica char(2), 
                            in nombre varchar(30), 
                            in ciudad varchar(20))
deterministic
modifies sql data
	
begin
	declare comprobacion tinyint(1);
	insert into clinica values(idClinica, nombre, ciudad);
    if 
end
delimiter ;    
-- 3.​ Haz un procedimiento donde introduzcas el nombre de un doctor como parámetro de entrada y que te devuelva como salida el nombre de la clínica en la que trabaja . Usa la base de datos HOSPITALES. (1 punto)
delimiter $$
drop procedure if exists ejercicio3$$
create procedure ejercicio3(in nombreDoctor varchar(30))
reads sql data
begin
	declare nombreClinica varchar(30);
	set nombreClinica = (select c.nombre from clinica c 
						join doctor d on d.idClinica = c.idClinica
                        where d.nombre like nombreDoctor);
	select nombreClinica;
end
$$
delimiter ;
call ejercicio3("Luis Torres");
	

-- 4.​ Haz un procedimiento donde te muestre un listado de todos los nombres de los Doctores, y el número de investigaciones en las que participa (ten en cuenta que algunos doctores no participan en ningúna investigación). Usa la base de datos HOSPITALES . (1 punto)

-- 5.​ Crea un procedimiento para borrar las clínicas que no tienen Doctores. Usa la base de datos HOSPITALES . (1 punto)
delimiter $$
drop procedure if exists ejercicio5$$
create procedure ejercicio5()
modifies sql data
begin

end
$$
delimiter ;
select c.idClinica from clinica c
right join doctor d on d.idClinica = c.idClinica
where c.idClinica;
-- 6.​ Crea una base de datos llamada ExamenTema8 que contenga una tabla llamada divisores, la tabla tendrá una única columna llamada número y el tipo de dato de esta columna debe ser INT UNSIGNED. (1 punto) 
drop database if exists ExamenTema8;
create database if not exists ExamenTema8;
use ExamenTema8;

create table if not exists divisores(
	numero int unsigned
);
-- Crear un procedimiento llamado Calculardivisores con las siguientes características. El procedimiento recibe un parámetro de entrada llamado número y deberá almacenar en la tabla divisores sus divisores. Ej. 16 -> sus divisores son: 1, 2, 4, 6,16 Ten en cuenta que el procedimiento deberá eliminar el contenido actual de la tabla antes de insertar los nuevos valores que va a calcular. Utiliza un bucle WHILE para resolver el procedimiento. (1,25 punto)
delimiter $$
drop procedure if exists Calculardivisores$$
create procedure Calculardivisores(in numero int unsigned)
modifies sql data
begin
	declare i int unsigned default 1;
	delete from divisores;
	while i <= numero do
		if (numero % i) = 0 then
				insert into divisores values(i);
		end if;
        set i = i + 1;
    end while;
end
$$
delimiter ;
call Calculardivisores(24);
select * from divisores;
-- 7.​ Haz una función que introduzcas el nombre de un doctor y te devuelva el número de años que lleva trabajando. Usa la base de datos HOSPITALES . (1 punto)
use Hospitales;
delimiter $$
drop function if exists ejercicio7$$
create function ejercicio7(nombreDoctor varchar(30))
returns int
begin
	declare TiempoTrabajado int;
    declare fechaActual date;
    set TiempoTrabajado = (select truncate(datediff(fechaIngreso, date.now()), 2)
							from doctor
                            where nombre like nombreDoctor);
end
$$
delimiter ;
    select datediff(date.n ,fechaIngreso) from doctor
					where nombre like "Javier Romero";
-- 8.​ Un número perfecto es aquel en el que la suma de todos sus divisores, sin incluirlo a él mismo, da como resultado ese número. Por ejemplo, el número 6 es perfecto ya que los divisores de 6: 1, 2 y 3 (sin contar el 6) sumados dan 6. Hacer una función que lea un número y diga si es o no perfecto. Usa la base de datos ExamenTema8. (1.25 punto)
use ExamenTema8;
delimiter $$
drop function if exists numeroPerfecto$$
create function numeroPerfecto(num int unsigned)
returns varchar(10)
begin
	declare i int unsigned default 1;
    declare suma int unsigned default 0;
	delete from divisores;
	while i <= num do
		if (num % i) = 0 then
				insert into divisores values(i);
		end if;
        set i = i + 1;
    end while;
    select sum(numero) into suma from divisores;
    
    if suma = num then
		return "Es un numero perfecto";
    elseif suma != num then
		return "NO es un numero perfecto";
    end if;
end
$$
delimiter ;
select numeroPerfecto(6);
-- 59.​ Escribe una función para la base de datos HOSPITALES que le pases el nombre de un doctor y te diga si es supervisor o no, que devuelva un valor booleano true o false. Usa la base de datos HOSPITALES . (1 punto)