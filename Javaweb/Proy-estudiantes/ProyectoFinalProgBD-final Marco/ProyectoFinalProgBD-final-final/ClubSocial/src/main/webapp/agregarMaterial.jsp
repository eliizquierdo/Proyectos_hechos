<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Agregar Material</title>
    <link rel="stylesheet" href="css/style2.css">
</head>
<body>
    <h2>Agregar Material</h2>
    <form action="MaterialServlet" method="post">
        <input type="hidden" name="accion" value="agregar" request>
        <label>ID Material:</label><input type="number" name="idMaterial" required><br>
        <label>Nombre:</label><input type="text" name="nombre" required><br>
        <label>Cantidad</label><input type="number" name="cantidad" request><br>
        <label>Descripcion:</label><input type="text" name="descripcion" required><br>
        <label>Ubicacion:</label><input type="text" name="ubicacion" required><br>
        <button type="submit">Guardar</button>
    </form>
    <a href="index.jsp">Volver</a>
</body>
</html>