--------------------------------------------------------------------------------
--                           MYSQL PROGRAMMING CHEATSHEET
--  Copia y pega este script en MySQL Workbench para tener a mano
--  ejemplos de Rutinas, Control de Flujo, Cursores, Handlers, Triggers, Events…
--------------------------------------------------------------------------------

-- 0) PREPARACIÓN GLOBAL
-- Permitir creación de funciones en binlog estrictos (si usas replication)
SET GLOBAL log_bin_trust_function_creators = 1;

-- Selecciona o crea una base de datos de pruebas
CREATE DATABASE IF NOT EXISTS Cheatsheet;
USE Cheatsheet;

--------------------------------------------------------------------------------
-- 1) DELIMITADORES
-- Cada vez que crees funciones/procedimientos/triggers con ; en el cuerpo:
DELIMITER $$

-- Al terminar vuelve al delimitador estándar:
-- DELIMITER ;

--------------------------------------------------------------------------------
-- 2) VARIABLES LOCALES vs VARIABLES DE SESIÓN
-- Dentro de rutinas (FUNCTION/PROCEDURE/TRIGGER) uso DECLARE:
CREATE PROCEDURE _demo_variables()
BEGIN
  DECLARE x INT DEFAULT 1;
  DECLARE y VARCHAR(20);
  SET y = CONCAT('Valor: ', x);
  SELECT x, y;
END$$

-- Variables de sesión (fuera de rutinas) con @:
SET @a = 10;
SET @b = 20;
SELECT @a + @b AS suma_session;

--------------------------------------------------------------------------------
-- 3) CONTROL DE FLUJO
-- 3.1) IF … ELSEIF … ELSE … END IF
CREATE PROCEDURE _demo_if(IN n INT)
BEGIN
  IF n < 0 THEN
    SELECT 'negativo' AS tipo;
  ELSEIF n = 0 THEN
    SELECT 'cero' AS tipo;
  ELSE
    SELECT 'positivo' AS tipo;
  END IF;
END$$

-- 3.2) CASE … WHEN … THEN … ELSE … END CASE
CREATE PROCEDURE _demo_case(IN dia INT)
BEGIN
  CASE dia
    WHEN 1 THEN SELECT 'Lunes'   AS dia_semana;
    WHEN 2 THEN SELECT 'Martes'  AS dia_semana;
    WHEN 3 THEN SELECT 'Miércoles' AS dia_semana;
    ELSE         SELECT 'Otro'   AS dia_semana;
  END CASE;
END$$

--------------------------------------------------------------------------------
-- 4) BUCLES / ITERACIONES
-- 4.1) WHILE … DO … END WHILE
CREATE PROCEDURE _demo_while(IN hasta INT)
BEGIN
  DECLARE i INT DEFAULT 1;
  DECLARE suma INT DEFAULT 0;
  WHILE i <= hasta DO
    SET suma = suma + i;
    SET i = i + 1;
  END WHILE;
  SELECT suma AS suma_while;
END$$

-- 4.2) REPEAT … UNTIL … END REPEAT
CREATE PROCEDURE _demo_repeat(IN hasta INT)
BEGIN
  DECLARE i INT DEFAULT 1;
  DECLARE suma INT DEFAULT 0;
  REPEAT
    SET suma = suma + i;
    SET i = i + 1;
  UNTIL i > hasta
  END REPEAT;
  SELECT suma AS suma_repeat;
END$$

-- 4.3) LOOP … END LOOP con LEAVE
CREATE PROCEDURE _demo_loop(IN hasta INT)
BEGIN
  DECLARE i INT DEFAULT 1;
  DECLARE suma INT DEFAULT 0;
  calculo: LOOP
    IF i > hasta THEN
      LEAVE calculo;
    END IF;
    SET suma = suma + i;
    SET i = i + 1;
  END LOOP calculo;
  SELECT suma AS suma_loop;
END$$

--------------------------------------------------------------------------------
-- 5) FUNCIONES ALMACENADAS
-- Sintaxis básica: CREATE FUNCTION … RETURNS TIPO
CREATE FUNCTION EsPar(n INT)
  RETURNS TINYINT(1)
  DETERMINISTIC
  NO SQL
BEGIN
  RETURN (n % 2 = 0);
END$$

CREATE FUNCTION Mayor3(a INT, b INT, c INT)
  RETURNS INT
  DETERMINISTIC
  NO SQL
BEGIN
  RETURN GREATEST(a, b, c);
END$$

-- Uso dentro de SELECT:
SELECT EsPar(5) AS es_par, Mayor3(4,9,2) AS mayor_valor;

--------------------------------------------------------------------------------
-- 6) PROCEDIMIENTOS ALMACENADOS
-- Sintaxis básica: CREATE PROCEDURE … (IN/OUT/INOUT) … BEGIN … END

-- 6.1) IN y OUT
CREATE PROCEDURE SumarYMultiplicar(
    IN  x INT,
    IN  y INT,
    OUT suma INT,
    OUT producto INT
)
DETERMINISTIC
NO SQL
BEGIN
  SET suma     = x + y;
  SET producto = x * y;
END$$

-- Llamada y lectura de OUT:
CALL SumarYMultiplicar(3,5, @s, @p);
SELECT @s AS suma, @p AS producto;

-- 6.2) PROCEDIMIENTO DE EJEMPLO COMPLETO
CREATE TABLE IF NOT EXISTS Operaciones (
  num1     INT UNSIGNED,
  num2     INT UNSIGNED,
  suma     BIGINT UNSIGNED,
  producto BIGINT UNSIGNED
)$$

DROP PROCEDURE IF EXISTS Calcular_Operaciones$$
CREATE PROCEDURE Calcular_Operaciones(
    IN numero INT UNSIGNED,
    IN tope   INT UNSIGNED
)
MODIFIES SQL DATA
BEGIN
  DECLARE s BIGINT UNSIGNED DEFAULT 0;
  DECLARE p BIGINT UNSIGNED DEFAULT 1;
  DECLARE i INT UNSIGNED;

  DELETE FROM Operaciones;
  SET i = numero;

  WHILE i <= tope DO
    SET s = s + i;
    SET p = p * i;
    SET i = i + 1;
  END WHILE;

  INSERT INTO Operaciones (num1, num2, suma, producto)
  VALUES (numero, tope, s, p);
END$$

-- Prueba:
CALL Calcular_Operaciones(1,5);
SELECT * FROM Operaciones;

--------------------------------------------------------------------------------
-- 7) CURSORES
-- Recorre filas de un SELECT dentro de un PROCEDURE

DROP PROCEDURE IF EXISTS _demo_cursor$$
CREATE PROCEDURE _demo_cursor()
READS SQL DATA
BEGIN
  DECLARE done  INT DEFAULT FALSE;
  DECLARE eid   INT;
  DECLARE curs  CURSOR FOR SELECT id FROM Operaciones;
  DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;

  OPEN curs;
  read_loop: LOOP
    FETCH curs INTO eid;
    IF done THEN
      LEAVE read_loop;
    END IF;
    -- Aquí podrías procesar eid
    SELECT CONCAT('Procesando id=', eid) AS mensaje;
  END LOOP read_loop;
  CLOSE curs;
END$$

-- Prueba:
CALL _demo_cursor();

--------------------------------------------------------------------------------
-- 8) MANEJO DE ERRORES Y SIGNAL
-- Señala errores personalizados
CREATE PROCEDURE _demo_signal(IN x INT)
BEGIN
  IF x < 0 THEN
    SIGNAL SQLSTATE '45000'
      SET MESSAGE_TEXT = 'x no puede ser negativo';
  END IF;
  SELECT x AS valor;
END$$

-- Prueba (debería fallar):
-- CALL _demo_signal(-5);

--------------------------------------------------------------------------------
-- 9) TRIGGERS
-- Ejemplo de trigger BEFORE INSERT
DROP TABLE IF EXISTS Clientes;
CREATE TABLE Clientes (
  id     INT AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(50),
  creado DATETIME
)$$

DROP TRIGGER IF EXISTS trg_before_clientes$$
CREATE TRIGGER trg_before_clientes
BEFORE INSERT ON Clientes
FOR EACH ROW
BEGIN
  SET NEW.creado = NOW();
END$$

-- Prueba:
INSERT INTO Clientes (nombre) VALUES ('Ana');
SELECT * FROM Clientes;

-- Vuelve al delimitador estándar para ejecutar sentencias normales
DELIMITER ;

--------------------------------------------------------------------------------
-- 10) EVENTOS (si tienes el scheduler habilitado)
-- Ejecuta algo periódicamente
DROP EVENT IF EXISTS evento_demo;
CREATE EVENT evento_demo
  ON SCHEDULE EVERY 1 DAY
  STARTS CURRENT_TIMESTAMP + INTERVAL 1 HOUR
DO
  INSERT INTO Operaciones (num1,num2,suma,producto)
  VALUES (0,0,0,0);

--------------------------------------------------------------------------------
-- FIN CHEATSHEET
-- Ahora tienes un resumen de:
--   • Delimiters  • Variables  • Control flow  
--   • Bucles      • Funciones   • Procedimientos
--   • Cursores    • Handlers    • Triggers   • Eventos
--------------------------------------------------------------------------------