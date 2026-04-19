create  database Nefliz;

use nefliz;

CREATE TABLE Clientes (
    Email VARCHAR(30) PRIMARY KEY NOT NULL,
    Password VARCHAR(30) NOT NULL,
    Nombre VARCHAR(30) NOT NULL,
    Apellido VARCHAR(30) NOT NULL,
    Ciudad VARCHAR(30) NOT NULL,
    Pais VARCHAR(30) NOT NULL,
	nombrePropietario VARCHAR(30) NOT NULL,
    numeroTarjeta VARCHAR(16) NOT NULL,
    codigoTarjeta VARCHAR(3) NOT NULL
);

CREATE TABLE Contenido (
    Nombre VARCHAR(30) NOT NULL,
    Descripcion VARCHAR(100) NOT NULL,
    Genero VARCHAR(30) NOT NULL
);

CREATE TABLE Serie (
    Nombre VARCHAR(30) PRIMARY KEY NOT NULL,
    Descripcion VARCHAR(100) NOT NULL,
    Genero VARCHAR(30) NOT NULL,
    Capitulos VARCHAR(3) NOT NULL,
    Temporadas VARCHAR(2) NOT NULL
);

CREATE TABLE Pelicula (
	Nombre VARCHAR(30) PRIMARY KEY NOT NULL,
    Descripcion VARCHAR(100) NOT NULL,
    Genero VARCHAR(30) NOT NULL
);

CREATE TABLE Administrador (
    Nombre_Admin VARCHAR(30) PRIMARY KEY NOT NULL,
    Apellido_Admin VARCHAR(30) NOT NULL,
    Password_Admin VARCHAR(30) NOT NULL
);