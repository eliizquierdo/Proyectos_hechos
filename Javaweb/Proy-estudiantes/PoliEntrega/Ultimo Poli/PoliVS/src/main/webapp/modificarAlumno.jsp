<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, modelo.vo.AlumnoVO"%>
<!DOCTYPE html>
<html>
<head>
    <title>Modificar Alumno</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <h2>Modificar Alumno</h2>

    <%
        AlumnoVO a = (AlumnoVO) request.getAttribute("Alumnos");
    %>

    <form action="AlumnoServlet" method="post">
        <label>Nombre:</label>
        <input type="text" min=10000000 max=99999999 name="nombre" value="<%= a.getNombre() %>" required><br>

        <label>Telefono:</label>
        <input type="number" min=100000000 max=999999999 name="telefono" value="<%= a.getTelefono() %>" required><br>

        <label>Edad:</label>
        <input type="number" min=5 max=60 name="edad" value="<%= a.getedad() %>" required><br>

        <label>Calle:</label>
        <input type="text" name="calle" value="<%= a.getcalle() %>" required><br>

        <label>Numero:</label>
        <input type="number" name="nro" value="<%= a.getnro() %>" required><br>

        <input type="hidden" name="cedula" value="<%= a.getCedula() %>">
        <input type="hidden" name="accion" value="modificar">
        <button type="submit">Modificar</button>
    </form>

    <a href="index.jsp">Volver</a>
</body>
</html>