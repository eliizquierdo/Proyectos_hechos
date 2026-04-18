-- script de Duran
CREATE DATABASE LIBRERIA;
USE LIBRERIA;


CREATE TABLE LIBRO(
nombreAutor INT (8),
ISBN INT (10),
Titulo VARCHAR (20),
Cant_libros INT (5),
Editorial VARCHAR (15),
F_edicion DATE,
Nro_paginas INT (3),
PRIMARY KEY (ISBN)
);

CREATE TABLE COPIA(
ISBN INT (10),
ISBN_copia INT (10),
Estado VARCHAR (12),
PRIMARY KEY (ISBN, ISBN_copia),
INDEX (ISBN_copia), -- Utilicé este comando, ya que sin él no se creaba la tabla de la relación "pide".
FOREIGN KEY (ISBN) REFERENCES LIBRO (ISBN)
);

CREATE TABLE pide(
ISBN INT (10),
ISBN_copia INT (10),
CI INT (8),
f_prestamo DATE,
f_devolucion DATE,
PRIMARY KEY (ISBN, ISBN_copia, CI),
FOREIGN KEY (ISBN_copia) REFERENCES COPIA (ISBN_copia)
);

CREATE TABLE SOCIO(
CI INT (8),
Nombre VARCHAR (15),
Direccion VARCHAR (30),
Telefono INT (9),
PRIMARY KEY (CI)
);

CREATE TABLE ALUMNO(
CI INT (8),
F_nac DATE,
Edad INT (3),
Grupo VARCHAR (3),
PRIMARY KEY (CI),
FOREIGN KEY (CI) REFERENCES SOCIO (CI)
);

CREATE TABLE DOCENTE(
CI INT (8),
f_ing DATE,
Asignatura VARCHAR (15),
PRIMARY KEY (CI),
FOREIGN KEY (CI) REFERENCES SOCIO (CI)
);