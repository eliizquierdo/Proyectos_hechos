<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/estilos.css">
    <title>Menú Perros</title>
</head>
<body>
    <h1>Menú Principal</h1>
    <form action="PerroServlet" method="get">
        <input type="hidden" name="action" value="irAgregar">
        <button type="submit">Agregar Perro</button>
    </form>
    <form action="PerroServlet" method="get">
        <input type="hidden" name="action" value="listar">
        <button type="submit">Listar Perros</button>
    </form>
</body>
</html>