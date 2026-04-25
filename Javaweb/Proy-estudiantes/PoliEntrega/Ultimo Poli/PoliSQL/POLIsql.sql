drop database poli;
create database poli;
use poli;

create table personas(
	ci int(8) primary key,
    nombre varchar(30),
    telefono int(9)
);

create table empleado(
	ci int primary key,
	categoria varchar(20),
    sueldo double,
    FOREIGN KEY (ci) REFERENCES personas(ci)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);

create table disciplina(
	id int(4) primary key,
    nombre varchar(30),
    cupo int
);
CREATE TABLE alumno (
    ciA INT(8) PRIMARY KEY,
    edad int,
    calle varchar(30),
    nro int(4),
    FOREIGN KEY (ciA) REFERENCES personas(ci)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);
/*Para agregar un alumno con primero hay que agregar una persona por la FK :)
INSERT INTO personas (ci, nombre, telefono)
VALUES (12345678, 'Juan', 879654678);

INSERT INTO alumno (ciA, edad, calle, nro)
VALUES (12345678, 8, 'calle', 2333);*/
CREATE TABLE Profesor (
    ciP INT(8) PRIMARY KEY,
    especialidad varchar(30),
    FOREIGN KEY (ciP) REFERENCES personas(ci)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);

CREATE TABLE dicta (
	ciP INT(8),
    id INT(4),
	FOREIGN KEY (ciP) REFERENCES profesor(ciP)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    FOREIGN KEY (id) REFERENCES disciplina(id)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    PRIMARY KEY (ciP, id)
);
CREATE TABLE practican (
	ciA INT(8),
    id INT(4),
    ciP INT(8),
	FOREIGN KEY (ciP) REFERENCES profesor(ciP)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    FOREIGN KEY (id) REFERENCES disciplina(id)
	ON DELETE CASCADE
    ON UPDATE CASCADE,
    FOREIGN KEY (ciA) REFERENCES alumno(ciA)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    PRIMARY KEY (ciP, id, ciA)
);
/* La mejor opcion es sacar la fk y dejarlo lo mas sencillo posible*/

select * from personas;
select * from alumno;
select * from profesor;
select * from disciplina;
select * from empleado;

-- delete from personas;

-- UPDATE personas SET ci = 12, nombre = 'Hola', telefono = 12456782 WHERE ci = 123;

-- update alumno SET ciA = 12, edad = 43, calle = 'segundapartealgo', nro = 6 WHERE ciA = 123;

-- set sql_safe_updates = 0;

-- set foreign_key_checks = 0;

-- INSERT INTO profesor(ciP,Nombre,telefono, especialidad) VALUES (444,"jua",333,"aaa");

