<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Agregar Disciplina</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <h2>Agregar Disciplina</h2>
    <form action="DisciplinaServlet" method="post">
        <label>Id:</label>
        <input type="number" name="id" required><br>

        <label>Nombre:</label>
        <input type="text" name="nombre" required><br>

        <label>Cupo:</label>
        <input type="number" name="cupo" max=25 required><br>
        
        <input type="hidden" name="accion" value="agregar">
        <button type="submit">Guardar</button>
    </form>
    <a href="index.jsp">Volver</a>
</body>
</html>