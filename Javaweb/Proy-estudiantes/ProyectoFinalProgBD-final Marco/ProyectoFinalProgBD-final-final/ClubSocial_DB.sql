#drop database ClubSocial;
create database ClubSocial;
use ClubSocial;

create table PERSONA(
cedula int(8) primary key not null,
nombre varchar(25) not null,
apellido varchar(25) not null,
fechaNacimiento date not null,
email varchar(50) not null,
calle varchar(50) not null,
numero int(15) not null,
especificacion text not null
);

create table TELEFONO_PERSONA(
cedula int(8) not null,
numeroTelefono varchar(20),
primary key(cedula, numeroTelefono),
foreign key (cedula) references PERSONA (cedula)
);

create table SOCIO(
cedula int(8) primary key not null,
mensualidad double not null,
foreign key (cedula) references PERSONA (cedula)
);

create table PERSONAL(
cedula int(8) primary key not null,
salario double not null,
areaTrabajo text not null,
foreign key (cedula) references PERSONA (cedula)
);

create table ACTIVIDAD(
id_Actividad int(8) primary key not null,
nombre varchar(25) not null,
cedula int(8) not null,
foreign key (cedula) references PERSONAL (cedula)
);

create table FRANJA_HORARIA(
id_Actividad int(8) not null,
dia varchar(10) not null,
horaInicio time not null,
horaFin time not null,
categoria varchar(15),
foreign key (id_Actividad) references ACTIVIDAD (id_Actividad),
primary key (id_Actividad, dia, horaInicio, horaFin)
);

create table PARTICIPACION(
cedula int(8) not null,
id_Actividad int(8) not null,
primary key (cedula, id_Actividad),
foreign key (cedula) references SOCIO (cedula),
foreign key (id_Actividad) references ACTIVIDAD (id_Actividad)
);

create table MATERIAL(
id_Material int(8) primary key not null,
nombre varchar(25) not null,
cantidad int not null,
descripcion text not null,
ubicacion varchar(50) not null
);

create table UTILIZA(
id_Actividad int(8) not null,
id_Material int(8) not null,
foreign key (id_Actividad) references ACTIVIDAD (id_Actividad),
foreign key (id_Material) references MATERIAL (id_Material),
primary key (id_Actividad, id_Material)
);

create table EMPLEADO(
cedula int(8) primary key not null,
salario int not null,
areaTrabajo text not null,
foreign key (cedula) references PERSONA (cedula)
);

create table EMPLEADO(
cedula int(8) primary key not null,
sueldo int not null,
categoria text not null,
foreign key (cedula) references PERSONA (cedula)
);

select * from PERSONA;
select * from TELEFONO_PERSONA;
select * from SOCIO;
select * from PERSONAL;
select * from ACTIVIDAD;

delete from PERSONA;
delete from TELEFONO_PERSONA;
delete from SOCIO;

set SQL_SAFE_UPDATES=0;