<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Agregar Arquero</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <h2>Agregar Arquero</h2>
    <form action="ArqueroServlet" method="post">
        <label>Nombre:</label><input type="text" name="nombre" required><br>
        <label>Cantidad Flechas:</label><input type="number" name="cat_Flechas" required><br>
        <label>Nivel:</label><input type="number" name="nivel" required><br>
        <button type="submit">Guardar</button>
    </form>
    <a href="index.jsp">Volver</a>
</body>
</html>