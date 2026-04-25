
CREATE database instituto;
USE instituto ;

-- -----------------------------------------------------
-- Table `instituto`.`persona`
-- -----------------------------------------------------
Para saber en que puerto esta mysql
show variables where variable_name in ('hostname','port');


CREATE  TABLE persona (
  cedula INT(8) NOT NULL ,
  nombre VARCHAR(15)  NOT NULL ,
  apellido VARCHAR(15)  NOT NULL ,
  
  PRIMARY KEY (`cedula`) );



-- -----------------------------------------------------
-- Table `instituto`.`alumno`
-- -----------------------------------------------------
CREATE  TABLE alumno (
  cedula INT(8)  NOT NULL ,
   grupo VARCHAR(8)  NOT NULL ,
  PRIMARY KEY (cedula) ,
  FOREIGN KEY (cedula)  REFERENCES persona (cedula));

insert into persona (cedula, nombre, apellido) values (1,'alumno1','apellido1');
INSERT INTO alumno (cedula, grupo) VALUES (1,'A');

-- -----------------------------------------------------
-- CONSULTAS
-- -----------------------------------------------------

select * from alumno;

--agregado para el escrito final

-- -----------------------------------------------------
-- Table `instituto`.`alumno`
-- -----------------------------------------------------
CREATE  TABLE libro (
  codigo INT(8)  NOT NULL ,
  titulo VARCHAR(8)  NOT NULL ,
  PRIMARY KEY (codigo));


insert into persona (cedula, nombre, apellido) values (1,'alumno1','apellido1');
INSERT INTO alumno (cedula, grupo) VALUES (1,'A');


