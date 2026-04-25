<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Gestión RPG</title>
    <link rel="stylesheet" href="css/style1.css">
</head>
<body>
    
    <div class="encabezado">
    <h1>MENÚ PRINCIPAL</h1>
    <a href="informacion.jsp">
    <img src="recursos\informacion.png" width="40"  height="40" alt="Información">
    </a>
    </div>
    
    <div class="separador"></div>
    
    <div class="menuAgregar">
        <label>AGREGAR:</label>
        <a href="SocioServlet?accion=nuevo">Socio</a>
        <a href="PersonalServlet?accion=nuevo">Personal</a>
        <a href="ActividadServlet?accion=nuevo">Actividad</a>
        <a href="MaterialServlet?accion=nuevo">Material</a>
        <a href="UtilizacionServlet?accion=nuevo">Utilizacion</a>
        <a href="EmpleadoServlet?accion=nuevo">Empleado</a>
        <a href="ParticipacionServlet?accion=nuevo">Participacion</a>
    </div><br>

    <div class="separador"></div>
    
    <div class="menuMostrar">
        <label>MOSTRAR:</label>
        <a href="SocioServlet?accion=listar">Socios</a>
        <a href="PersonalServlet?accion=listar">Personales</a>
        <a href="ActividadServlet?accion=listar">Actividad</a>
        <a href="MaterialServlet?accion=listar">Materiales</a>
        <a href="UtilizacionServlet?accion=listar">Utilizacion</a>
        <a href="EmpleadoServlet?accion=listar">Empleado</a>
        <a href="ParticipacionServlet?accion=listar">Participacion</a>
    </div>

    <div class="separador"></div>

</body>
</html>