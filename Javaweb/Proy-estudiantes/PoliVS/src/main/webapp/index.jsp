<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Gestión Polideportivo</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <img src="Recursos/poliFoto.jpg" alt="El Polideportivo de La Paz."  width=1300 height=600>
    <br>
    <a href="https://www.instagram.com/poli_la_paz/?hl=es"><img src="Recursos/Instagram_icono.png" height=50 width=50></a>
    <h1>Gestión del Polideportivo</h1>
    <h2>Menú Principal</h2>

    <div class="menu">
        <a href="AlumnoServlet?accion=nuevo">Agregar Alumno</a>
        <a href="AlumnoServlet?accion=listar">Mostrar Alumnos</a>
        <br>
        <a href="ProfesorServlet?accion=nuevo">Agregar Profesor</a>
        <a href="ProfesorServlet?accion=listar">Mostrar Profesores</a>
        <br>
        <a href="DisciplinaServlet?accion=nuevo">Agregar Disciplina</a>
        <a href="DisciplinaServlet?accion=listar">Mostrar Disciplina</a>

        <a href="EmpleadoServlet?accion=nuevo">Agregar Empleado</a>
        <a href="EmpleadoServlet?accion=listar">Mostrar Empleado</a>
   <!-- <br>
        <a href="DisciplinaServlet?accion=tomarAsistencias">Tomar Asistencias</a> -->
    </div>
</body>
</html>
