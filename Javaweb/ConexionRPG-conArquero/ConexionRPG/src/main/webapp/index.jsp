<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Gestión RPG</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <h1>Menú Principal</h1>
    <div class="menu">
        <a href="GuerreroServlet?accion=nuevo">Agregar Guerrero</a>
        <a href="GuerreroServlet?accion=listar">Mostrar Guerreros</a>
        <a href="MagoServlet?accion=nuevo">Agregar Mago</a>
        <a href="MagoServlet?accion=listar">Mostrar Mago</a>
        <a href="ArqueroServlet?accion=nuevo">Agregar Arquero</a>
        <a href="ArqueroServlet?accion=listar">Mostrar Arquero</a>
    </div>
</body>
</html>