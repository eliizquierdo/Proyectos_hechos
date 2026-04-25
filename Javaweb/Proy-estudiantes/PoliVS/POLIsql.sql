-- drop database poli;
create database poli;

use poli;

create table personas (
    ci int(8) primary key,
    nombre varchar(30),
    telefono int(9)
);

create table disciplinas (
    id int(4) primary key,
    nombre varchar(30),
    cupo int
);

CREATE TABLE alumnos (
    ciA INT(8) PRIMARY KEY,
    edad int,
    calle varchar(30),
    nro int(4),
    FOREIGN KEY (ciA) REFERENCES personas (ci) ON DELETE CASCADE ON UPDATE CASCADE
);
/*Para agregar un alumno con primero hay que agregar una persona por la FK :)
INSERT INTO personas (ci, nombre, telefono)
VALUES (12345678, 'Juan', 879654678);

INSERT INTO alumno (ciA, edad, calle, nro)
VALUES (12345678, 8, 'calle', 2333);*/
CREATE TABLE profesores (
    ciP INT(8) PRIMARY KEY,
    especialidad varchar(30),
    FOREIGN KEY (ciP) REFERENCES personas (ci) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE dictan (
    ciP INT(8),
    id INT(4),
    FOREIGN KEY (ciP) REFERENCES profesores (ciP) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (id) REFERENCES disciplinas (id) ON DELETE CASCADE ON UPDATE CASCADE,
    PRIMARY KEY (ciP, id)
);

CREATE TABLE practican (
    ciA INT(8),
    id INT(4),
    ciP INT(8),
    FOREIGN KEY (ciP) REFERENCES profesores (ciP) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (id) REFERENCES disciplinas (id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (ciA) REFERENCES alumnos (ciA) ON DELETE CASCADE ON UPDATE CASCADE,
    PRIMARY KEY (ciP, id, ciA)
);

CREATE TABLE empleados (
    ciE INT(8) PRIMARY KEY,
    categoria varchar(30),
    sueldo double(4, 1),
    FOREIGN KEY (ciE) REFERENCES personas (ci) ON DELETE CASCADE ON UPDATE CASCADE
);

select * from disciplina;

select * from personas;

SELECT p.ci, p.nombre, p.telefono, a.categoria, a.sueldo
FROM personas p
    INNER JOIN empleados a ON p.ci = a.ciE;
-- delete from personas;

-- delete from alumno;

-- UPDATE personas SET ci = 12, nombre = 'Hola', telefono = 12456782 WHERE ci = 123;

-- update alumno SET ciA = 12, edad = 43, calle = 'segundapartealgo', nro = 6 WHERE ciA = 123;

-- set sql_safe_updates = 0;

-- set foreign_key_checks = 0;

-- INSERT INTO profesor(ciP,Nombre,telefono, especialidad) VALUES (444,"jua",333,"aaa");