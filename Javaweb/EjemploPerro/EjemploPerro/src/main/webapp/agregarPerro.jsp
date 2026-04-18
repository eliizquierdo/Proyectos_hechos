<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/estilos.css">
    <title>Agregar Perro</title>
</head>
<body>
    <h1>Agregar Perro</h1>
    <form action="PerroServlet" method="post">
        <input type="hidden" name="action" value="agregar">
        <label>Nombre: <input type="text" name="nombre" required></label><br><br>
        <label>Raza: <input type="text" name="raza" required></label><br><br>
        <button type="submit">Guardar</button>
    </form>
    <br>
    <a href="index.jsp">Volver al Menú</a>
</body>
</html>