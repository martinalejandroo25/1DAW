-- PROCEDIMIENTOS CON SENTENCIA SQL

-- 1. Crea una base de datos llamada procedimientos
drop database if exists PracticaProcedimientos;
create database if not exists PracticaProcedimientos;
use PracticaProcedimientos;

-- que contenga una tabla llamada Operaciones.
create table if not exists Operaciones(
-- La tabla debe de contener cuatro columnas de tipo int unsigned, cuatro columnas llamadas num1, num2, suma y producto.
num1 int unsigned,
num2 int unsigned,
suma int unsigned,
producto int unsigned
);
-- Procedimientos con sentencias SQL.
-- Una vez creada la base de datos y la tabla crear un procedimiento llamado Calcular_Operaciones con las siguientes características.
-- El procedimiento recibe dos parámetro, uno llamado número y otro tope de tipo int unsigned y calculara el valor de la suma y del producto de los números naturales comprendidos entre número y tope. Ten en cuenta que el procedimiento deberá eliminar el contenido actual de la tabla antes de insertar los nuevos valores de la suma y el producto que va a calcular.
delimiter $$
drop procedure if exists Calcular_Operaciones$$
create procedure Calcular_Operaciones(in numero int unsigned, 
										in tope int unsigned
										)
	modifies sql data
    begin
    declare sumaVal bigint unsigned default 0;
    declare productoVal bigint unsigned default 1;
    declare i int unsigned;
    
    delete from Operaciones;
    set i = numero;
    
    while i <= tope DO
		set sumaVal = sumaVal + i;
        set productoVal = productoVal + i;
        set i = i + 1;
	end while;
    
	insert into Operaciones values
    (numero, tope, sumaVal, productoVal);
end$$
delimiter ;
call Calcular_Operaciones(1, 5);
select * from Operaciones;
-- 2. Una vez creada la base de datos ejerccios_Tema_7 y la tabla crear un procedimiento llamado Calcular_Operaciones con las siguientes características. El procedimiento recibe dos parámetro, uno llamado número y otro tope de tipo int unsigned y calculara el valor de la suma y del producto de los números naturales comprendidos entre número y tope. Ten en cuenta que el procedimiento deberá eliminar el contenido actual de la tabla antes de insertar los nuevos valores de la suma y el producto que va a calcular. Utiliza un bucle WHILE para resolver el procedimiento.

-- 3. Utiliza un bucle REPEAT para resolver el procedimiento del ejercicio anterior.

-- 4. Utiliza un bucle LOOP para resolver el procedimiento del ejercicio anterior.

-- 5. Escribe un procedimiento que reciba el nombre de un departamento como parámetro de entrada y realice una consulta para obtener todos los empleados de ese departamento. Usa base de datos relacion6.

-- 6. Haga un procedimiento que muestre un listado de todos los empleados y el número de horas total que ha trabajado en proyectos (ten en cuenta que algunos han trabajado en más de un proyecto).Usa la base de datos relacion6.

-- 7. Escribe un procedimiento que modifique la localidad de un departamento. El procedimiento recibirá como parámetros el código del departamento y la nuev localidad. Usa la base de datos relacion6.

-- 8. Escribe un procedimiento que reciba como parámetro de entrada el nombre de un proyecto y que devuelva como salida el nombre de los departamentos al que pertenece. Usa la base de datos relacion6.

-- 9. Codifica un procedimiento que permita borrar un empleado cuyo código se pasara en la llamada al procedimiento. Usa la base de datos relacion6.

-- 10. Haz un procedimiento que borre los departamentos que no tienen empleados. Usa la base de datos relacion6.