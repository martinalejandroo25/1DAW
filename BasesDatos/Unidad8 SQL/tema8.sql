--------------------------------------------------------------------------------
--                           MYSQL PROGRAMMING CHEATSHEET
--      Copia y pega en MySQL Workbench para tener a mano ejemplos de:
--      Variables, Control de Flujo, Bucles, Funciones, Procedimientos,
--      Cursores, Handlers, Triggers y Events.
--------------------------------------------------------------------------------

-- 0) Permitir creación de funciones en entornos con binlog estrictos
SET GLOBAL log_bin_trust_function_creators = 1;

-- 1) Crear y usar una base de datos de pruebas
CREATE DATABASE IF NOT EXISTS Cheatsheet;
USE Cheatsheet;

--------------------------------------------------------------------------------
-- 2) DEMO: Variables de sesión vs locales

-- 2.1 Variables de sesión (@var)
SET @a = 10;
SET @b = 20;
SELECT @a + @b AS suma_session;

-- 2.2 Variables locales en un procedimiento
DELIMITER $$
DROP PROCEDURE IF EXISTS _demo_variables$$
CREATE PROCEDURE _demo_variables()
BEGIN
  DECLARE x INT DEFAULT 1;
  DECLARE y VARCHAR(20);
  SET y = CONCAT('Valor: ', x);
  SELECT x, y;
END$$
DELIMITER ;

CALL _demo_variables();

--------------------------------------------------------------------------------
-- 3) CONTROL DE FLUJO

-- 3.1 IF … ELSEIF … ELSE … END IF
DELIMITER $$
DROP PROCEDURE IF EXISTS _demo_if$$
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
DELIMITER ;

CALL _demo_if(-5);
CALL _demo_if(0);
CALL _demo_if(7);

-- 3.2 CASE … WHEN … THEN … ELSE … END CASE
DELIMITER $$
DROP PROCEDURE IF EXISTS _demo_case$$
CREATE PROCEDURE _demo_case(IN dia INT)
BEGIN
  CASE dia
    WHEN 1 THEN SELECT 'Lunes'     AS dia_semana;
    WHEN 2 THEN SELECT 'Martes'    AS dia_semana;
    WHEN 3 THEN SELECT 'Miércoles' AS dia_semana;
    ELSE         SELECT 'Otro'      AS dia_semana;
  END CASE;
END$$
DELIMITER ;

CALL _demo_case(1);
CALL _demo_case(4);

--------------------------------------------------------------------------------
-- 4) BUCLES / ITERACIONES

-- 4.1 WHILE … DO … END WHILE
DELIMITER $$
DROP PROCEDURE IF EXISTS _demo_while$$
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
DELIMITER ;

CALL _demo_while(5);

-- 4.2 REPEAT … UNTIL … END REPEAT
DELIMITER $$
DROP PROCEDURE IF EXISTS _demo_repeat$$
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
DELIMITER ;

CALL _demo_repeat(5);

-- 4.3 LOOP … END LOOP con LEAVE
DELIMITER $$
DROP PROCEDURE IF EXISTS _demo_loop$$
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
DELIMITER ;

CALL _demo_loop(5);

--------------------------------------------------------------------------------
-- 5) FUNCIONES ALMACENADAS

DELIMITER $$
DROP FUNCTION IF EXISTS EsPar$$
CREATE FUNCTION EsPar(n INT)
RETURNS TINYINT(1)
DETERMINISTIC
NO SQL
BEGIN
  RETURN (n % 2 = 0);
END$$

DROP FUNCTION IF EXISTS Mayor3$$
CREATE FUNCTION Mayor3(a INT, b INT, c INT)
RETURNS INT
DETERMINISTIC
NO SQL
BEGIN
  RETURN GREATEST(a, b, c);
END$$
DELIMITER ;

SELECT EsPar(5) AS es_par, Mayor3(4,9,2) AS mayor_valor;

--------------------------------------------------------------------------------
-- 6) PROCEDIMIENTO “OPERACIONES”

CREATE TABLE IF NOT EXISTS Operaciones (
  num1     INT UNSIGNED,
  num2     INT UNSIGNED,
  suma     BIGINT UNSIGNED,
  producto BIGINT UNSIGNED
);

DELIMITER $$
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
DELIMITER ;

CALL Calcular_Operaciones(1,5);
SELECT * FROM Operaciones;

--------------------------------------------------------------------------------
-- 7) CURSORES

DELIMITER $$
DROP PROCEDURE IF EXISTS _demo_cursor$$
CREATE PROCEDURE _demo_cursor()
READS SQL DATA
BEGIN
  DECLARE done      INT DEFAULT FALSE;
  DECLARE val_num1  INT;
  DECLARE cur1      CURSOR FOR SELECT num1 FROM Operaciones;
  DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;
  OPEN cur1;
  read_loop: LOOP
    FETCH cur1 INTO val_num1;
    IF done THEN
      LEAVE read_loop;
    END IF;
    SELECT CONCAT('Procesando num1=', val_num1) AS mensaje;
  END LOOP read_loop;
  CLOSE cur1;
END$$
DELIMITER ;

CALL _demo_cursor();

--------------------------------------------------------------------------------
-- 8) MANEJO DE ERRORES (SIGNAL)

DELIMITER $$
DROP PROCEDURE IF EXISTS _demo_signal$$
CREATE PROCEDURE _demo_signal(IN x INT)
BEGIN
  IF x < 0 THEN
    SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'x no puede ser negativo';
  END IF;
  SELECT x AS valor;
END$$
DELIMITER ;

-- Para probar (descomentar):
-- CALL _demo_signal(-5);

--------------------------------------------------------------------------------
-- 9) TRIGGERS

CREATE TABLE IF NOT EXISTS Clientes (
  id     INT AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(50),
  creado DATETIME
);

DELIMITER $$
DROP TRIGGER IF EXISTS trg_before_clientes$$
CREATE TRIGGER trg_before_clientes
BEFORE INSERT ON Clientes
FOR EACH ROW
BEGIN
  SET NEW.creado = NOW();
END$$
DELIMITER ;

INSERT INTO Clientes (nombre) VALUES ('Ana');
SELECT * FROM Clientes;

--------------------------------------------------------------------------------
-- 10) EVENTOS (Event Scheduler debe estar ON)

DROP EVENT IF EXISTS evento_demo;
CREATE EVENT evento_demo
  ON SCHEDULE EVERY 1 DAY
  STARTS CURRENT_TIMESTAMP + INTERVAL 1 HOUR
DO
  INSERT INTO Operaciones (num1,num2,suma,producto)
  VALUES (0,0,0,0);

--------------------------------------------------------------------------------
-- FIN CHEATSHEET
--------------------------------------------------------------------------------