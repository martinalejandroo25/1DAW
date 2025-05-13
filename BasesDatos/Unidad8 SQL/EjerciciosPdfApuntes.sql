set global log_bin_trust_function_creators = 1;  -- Para ejecutar funciones
drop database if exists ejercicios_tema8;
create database if not exists ejercicios_tema8;
use ejercicios_tema8;
delimiter $$
drop function if exists Es_par$$

-- 1.8.3 Funciones sin sentencias SQL

-- 1. Escribe una función que reciba un número entero de entrada y devuelva TRUE si el número es par o FALSE en caso contrario.
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

select Es_par(3);
select Es_par(2);



-- 2. Escribe una función que devuelva el valor de la hipotenusa de un triángulo a partir de los valores de sus lados.
/*drop function if exists hipotenusa$$
create function if not exists hipotenusa(lado1 float, lado2 float);
return;8 */
-- 3. Escribe una función que reciba como parámetro de entrada un valor numérico que represente un día de la semana y que devuelva una cadena de caracteres con el nombre del día de la semana correspondiente. Por ejemplo, para el valor de entrada 1 debería devolver la cadena lunes.
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

select diaSemana(6);
-- 4. Escribe una función que reciba tres números reales como parámetros de entrada y devuelva el mayor de los tres.
drop function if exists mayorQue$$
create function mayorQue(num1 int, num2 int, num3 int)
returns int
begin
			declare mayor int;
			set mayor = 0;
			
			if mayor <= num1 then
				set mayor = num1;
			end if;
			if mayor <= num2 then
				set mayor = num2;
			end if;
			if mayor <= num3 then
				set mayor = num3;
			end if;
	return mayor;
end
$$
select mayorQue(1, 9, 4);
-- 5. Escribe una función que devuelva el valor del área de un círculo a partir del valor del radio que se recibirá como parámetro de entrada.

-- 6. Escribe una función que devuelva como salida el número de años que han transcurrido entre dos fechas que se reciben como parámetros de entrada. Por ejemplo, si pasamos como parámetros de entrada las

-- fechas 2018-01-01 y 2008-01-01 la función tiene que devolver que han pasado 10 años. Para realizar esta función puede hacer uso de las siguientes funciones que nos proporciona MySQL:

-- • DATEDIFF

-- • TRUNCATE

-- 7. Escribe una función que reciba una cadena de entrada y devuelva la misma cadena pero sin acentos. La función tendrá que reemplazar todas las vocales que tengan acento por la misma vocal pero sin acento. Por ejemplo, si la función recibe como parámetro de entrada la cadena María la función debe devolver la cadena Maria.