<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Agregar Alumno</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <h2>Agregar Alumno</h2>
    <form action="AlumnoServlet" method="post">
        <label>Cedula:</label>
        <input type="number" min=10000000 max=99999999 name="cedula" required><br>

        <label>Nombre:</label>
        <input type="text" name="nombre" required><br>

        <label>Telefono:</label>
        <input type="number" min=100000000 max=999999999 name="telefono"required><br>

        <label>Edad:</label>
        <input type="number" min=5 max=60 name="edad" required><br>

        <label>Calle:</label>
        <input type="text" name="calle" required><br>

        <label>Numero:</label>
        <input type="number" name="nro" required><br>

        <input type="hidden" name="accion" value="agregar">
        <button type="submit">Guardar</button>
    </form>
    <a href="index.jsp">Volver</a>
</body>
</html>