drop database if exists biblioteca;
create database if not exists biblioteca;

use biblioteca;

CREATE TABLE IF NOT EXISTS editorial (
    claveEditorial SMALLINT NOT NULL,
    nombre VARCHAR(60),
    direccion VARCHAR(60),
    telefono VARCHAR(15),
    PRIMARY KEY (claveEditorial)
)  ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS libro (
    claveLibro INT NOT NULL,
    titulo VARCHAR(60),
    idioma VARCHAR(15),
    formato VARCHAR(15),
    categoria CHAR,
    claveEditorial SMALLINT,
    PRIMARY KEY (claveLibro),
    KEY (claveEditorial),
    FOREIGN KEY (claveEditorial)
        REFERENCES editorial (claveEditorial)
        ON DELETE SET NULL ON UPDATE CASCADE
)  ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS tema (
    claveTema SMALLINT NOT NULL,
    nombre VARCHAR(40),
    PRIMARY KEY (claveTema)
)  ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS autor (
    claveAutor INT NOT NULL,
    nombre VARCHAR(40),
    PRIMARY KEY (claveAutor)
)  ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS ejemplar (
    claveLibro INT NOT NULL,
    numeroOrden SMALLINT,
    edicion SMALLINT,
    ubicacion VARCHAR(15),
    PRIMARY KEY (claveLibro , numeroOrden),
    FOREIGN KEY (claveLibro)
        REFERENCES libro (claveLibro)
        ON DELETE CASCADE ON UPDATE CASCADE
)  ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS socio (
    claveSocio INT NOT NULL,
    nombre VARCHAR(60),
    direccion VARCHAR(60),
    telefono VARCHAR(15),
    categoria CHAR,
    PRIMARY KEY (claveSocio)
)  ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS prestamo (
    claveSocio INT,
    claveLibro INT,
    numeroOrden SMALLINT,
    fechaPrestamo DATE NOT NULL,
    fechaDevolucion DATE DEFAULT NULL,
    notas BLOB,
    FOREIGN KEY (claveSocio)
        REFERENCES socio (claveSocio)
        ON DELETE SET NULL ON UPDATE CASCADE,
	FOREIGN KEY (claveLibro)
        REFERENCES libro (claveLibro)
        ON DELETE SET NULL ON UPDATE CASCADE
)  ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS trataSobre (
    claveLibro INT NOT NULL,
    claveTema SMALLINT NOT NULL,
    FOREIGN KEY (claveLibro)
        REFERENCES libro (claveLibro)
        ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (claveTema)
        REFERENCES tema (claveTema)
        ON DELETE CASCADE ON UPDATE CASCADE
)  ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS escritoPor (
    claveLibro INT NOT NULL,
    claveAutor INT NOT NULL,
    FOREIGN KEY (claveLibro)
        REFERENCES libro (claveLibro)
        ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (claveAutor)
        REFERENCES autor (claveAutor)
        ON DELETE CASCADE ON UPDATE CASCADE
)  ENGINE=INNODB;

describe editorial;
describe libro;
describe tema;
describe autor;
describe ejemplar;
describe socio;
describe prestamo;
describe trataSobre;
describe escritoPor;
