CREATE DATABASE clientes;
USE clientes;

CREATE TABLE cliente (
	Apellido VARCHAR(25),
	Edad int,
	Antiguedad int,
	Salario DOUBLE
);

INSERT INTO cliente(Apellido,Edad,Antiguedad,Salario) values 
('Perez',19,7,20000.0),
('Rodriguez',17,9,25000.0);