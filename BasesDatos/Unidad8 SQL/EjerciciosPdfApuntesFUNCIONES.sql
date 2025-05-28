set global log_bin_trust_function_creators = 1;  -- Para ejecutar funciones
drop database if exists ejercicios_tema8;
create database if not exists ejercicios_tema8;
use ejercicios_tema8;


-- 1.8.3 Funciones sin sentencias SQL

-- 1. Escribe una función que reciba un número entero de entrada y devuelva TRUE si el número es par o FALSE en caso contrario.
delimiter $$
drop function if exists Es_par$$
create function Es_Par(numero int)
returns boolean
begin
declare par boolean;
if numero%2 = 0 then
	set par = true;
else
	set par = false;
end if;
return par;
end
$$

select Es_Par(3);
select Es_Par(2);


-- 2. Escribe una función que devuelva el valor de la hipotenusa de un triángulo a partir de los valores de sus lados.
delimiter $$
drop function if exists hipotenusa$$
create function hipotenusa(lado1 float, lado2 float)
returns float
begin
	declare hipotenusa float;
    set hipotenusa = sqrt((pow(lado1, 2) + (pow(lado2, 2))));
	return hipotenusa;
end

$$
delimiter ;
    select hipotenusa(8, 23);
-- 3. Escribe una función que reciba como parámetro de entrada un valor numérico que represente un día de la semana y que devuelva una cadena de caracteres con el nombre del día de la semana correspondiente. Por ejemplo, para el valor de entrada 1 debería devolver la cadena lunes.
delimiter $$
drop function if exists diaSemana$$
create function diaSemana(dia int)
returns varchar(16)
begin
	declare diaSemana varchar(16);
    case dia
		when 1 then
			set diaSemana = "Lunes";
		when 2 then
			set diaSemana = "Martes";
		when 3 then
			set diaSemana = "Miercoles";
		when 4 then
			set diaSemana = "Jueves";
		when 5 then
			set diaSemana = "Viernes";
		when 6 then
			set diaSemana = "Sabado";
		when 7 then
			set diaSemana = "Domingo";
		else
			set diaSemana = "Valor Incorrecto";
		end case;
	return diaSemana; 
end
$$
delimiter ;
select diaSemana(6);
-- 4. Escribe una función que reciba tres números reales como parámetros de entrada y devuelva el mayor de los tres.
drop function if exists mayorQue$$
delimiter $$
create function mayorQue(num1 int, num2 int, num3 int)
returns int
begin
			declare mayor int;
			set mayor = num1;
			if mayor < num2 then
				set mayor = num2;
			end if;
			if mayor < num3 then
				set mayor = num3;
			end if;
	return mayor;
end
$$
delimiter ;
select mayorQue(1, 9, 4);
-- 5. Escribe una función que devuelva el valor del área de un círculo a partir del valor del radio que se recibirá como parámetro de entrada.
delimiter $$
drop function if exists areaCirculo$$
create function areaCirculo(radio float)
returns float
begin
	declare area float;
    set area = pi()*pow(radio, 2);
    return area;
    end
    $$
delimiter ;
select areaCirculo(12);
-- 6. Escribe una función que devuelva como salida el número de años que han transcurrido entre dos fechas que se reciben como parámetros de entrada. Por ejemplo, si pasamos como parámetros de entrada las
-- fechas 2018-01-01 y 2008-01-01 la función tiene que devolver que han pasado 10 años. Para realizar esta función puede hacer uso de las siguientes funciones que nos proporciona MySQL:

-- • DATEDIFF

-- • TRUNCATE
delimiter $$
drop function if exists transcurridoFecha$$
create function transcurridoFecha(fecha1 date, fecha2 date)
returns float
begin
	declare dias float;
    set dias = truncate((datediff(fecha1, fecha2)/365), 2);
    return dias;
    end$$
delimiter ;
    select transcurridoFecha(' 2018-01-01', '2008-01-01') as "Años transcurridos" ;
-- 7. Escribe una función que reciba una cadena de entrada y devuelva la misma cadena pero sin acentos. La función tendrá que reemplazar todas las vocales que tengan acento por la misma vocal pero sin acento. Por ejemplo, si la función recibe como parámetro de entrada la cadena María la función debe devolver la cadena Maria.
delimiter $$
drop function if exists SinAcentos$$
create function SinAcentos(cadena varchar(255))
returns varchar(255)
deterministic
begin
	declare sinAcentos varchar(100);
	set sinAcentos = replace(cadena, 'á', 'a');
    set sinAcentos = replace(sinAcentos, 'é', 'e');
    set sinAcentos = replace(sinAcentos, 'í', 'i');
    set sinAcentos = replace(sinAcentos, 'ó', 'o');
    set sinAcentos = replace(sinAcentos, 'ú', 'u');
    
	set sinAcentos = replace(sinAcentos, 'Á', 'A');
    set sinAcentos = replace(sinAcentos, 'É', 'E');
    set sinAcentos = replace(sinAcentos, 'Í', 'I');
    set sinAcentos = replace(sinAcentos, 'Ó', 'O');
    set sinAcentos = replace(sinAcentos, 'Ú', 'U');
return sinAcentos;
end
$$
delimiter ;
select SinAcentos("Hola qué tal estás todo bién, está haciendo frío");
delimiter ;
-- 	FUNCIONES CON SENTENCIA SQL

-- 6. Escribe una función para la base de datos Gestión de relación6 que devuelva la fecha de ingreso mínima de los empleados de un determinado departamento. El paramento de entrada será el nombre del departamento.
use GestionEmpleados;
delimiter $$
drop function if exists ejercicio6$$
create function ejercicio6(NombreDep varchar(30))
returns date
deterministic
reads sql data
begin
	declare fechaIngresoMinima date;
    
    select min(fecha_ingreso) 
    into fechaIngresoMinima 
    from empleado e
    join departamento d 
    on d.cddep = e.cddep
    where d.nombre = NombreDep;
    return fechaIngresoMinima;
end
$$
delimiter ; 
select ejercicio6("Ventas");
-- 7. Escribe una función para la base de datos relación6 que le pases el nombre de un empleado y te diga si es jefe o no, que devuelva un valor booleano true o false.
delimiter $$
drop function if exists ejercicio7$$
create function ejercicio7(NombreEmp varchar (30))
returns tinyint(1)
deterministic
reads sql data
begin
	declare esJefe boolean;
    if exists(
		select 1 from empleado e2
        where e2.cdjefe = (
			select e1.cdemp
			from empleado e1
            where e1.nombre = NombreEmp
			) 
        )then
			return 1;
        else
			return 0;
		end if;
		return esJefe;
end
$$
delimiter ;
    select ejercicio7("Esperanza Amarillo");

-- 8. Escribe una función para la base de datos relación6 que devuelva el número total de empleados.
delimiter $$
drop function if exists ejercicio8$$
create function ejercicio8()
returns float
begin
	declare num_total float;
    select count(cdemp) into num_total from empleado;
return num_total;
end
$$
delimiter ;
select ejercicio8();
-- 9. Usa a base de datos relación3 mecánicos y escribe una función que devuelva el número de veces que un coche ha ido al taller. El parámetro de Entrada será la matrícula del coche.
use Relacion4_Mecanicos;
delimiter $$
drop function if exists ejercicio9$$
create function ejercicio9(matricula char(8))
returns int
begin
	declare veces int;
    select count(*) into veces
    from relacion4
    where mat_co = matricula;
	return veces;
end
$$
delimiter ;
select ejercicio9('1456-BNL');


-- Procedimientos con sentencias SQL.

-- 1. Crea una base de datos llamada procedimientos que contenga una tabla llamada Operaciones. La tabla debe de contener cuatro columnas de tipo int unsigned, cuatro columnas llamadas num1, num2, suma y producto. Una vez creada la base de datos y la tabla crear un procedimiento llamado Calcular_Operaciones con las siguientes características. El procedimiento recibe dos parámetro, uno llamado número y otro tope de tipo int unsigned y calculara el valor de la suma y del producto de los números naturales comprendidos entre número y tope. Ten en cuenta que el procedimiento deberá eliminar el contenido actual de la tabla antes de insertar los nuevos valores de la suma y el producto que va a calcular.

-- 2. Una vez creada la base de datos ejerccios_Tema_7 y la tabla crear un procedimiento llamado Calcular_Operaciones con las siguientes características. El procedimiento recibe dos parámetro, uno llamado número y otro tope de tipo int unsigned y calculara el valor de la suma y del producto de los números naturales comprendidos entre número y tope. Ten en cuenta que el procedimiento deberá eliminar el contenido actual de la tabla antes de insertar los nuevos valores de la suma y el producto que va a calcular. Utiliza un bucle WHILE para resolver el procedimiento.

-- 3. Utiliza un bucle REPEAT para resolver el procedimiento del ejercicio anterior.

-- 4. Utiliza un bucle LOOP para resolver el procedimiento del ejercicio anterior.

-- 5. Escribe un procedimiento que reciba el nombre de un departamento como parámetro de entrada y realice una consulta para obtener todos los empleados de ese departamento. Usa base de datos relacion6.

-- 6. Haga un procedimiento que muestre un listado de todos los empleados y el número de horas total que ha trabajado en proyectos (ten en cuenta que algunos han trabajado en más de un proyecto).Usa la base de datos relacion6.

-- 7. Escribe un procedimiento que modifique la localidad de un departamento. El procedimiento recibirá como parámetros el código del departamento y la nuev localidad. Usa la base de datos relacion6.

-- 8. Escribe un procedimiento que reciba como parámetro de entrada el nombre de un proyecto y que devuelva como salida el nombre de los departamentos al que pertenece. Usa la base de datos relacion6.

-- 9. Codifica un procedimiento que permita borrar un empleado cuyo código se pasara en la llamada al procedimiento. Usa la base de datos relacion6.

-- 10. Haz un procedimiento que borre los departamentos que no tienen empleados. Usa la base de datos relacion6.