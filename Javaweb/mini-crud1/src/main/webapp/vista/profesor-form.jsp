<%@ page contentType="text/html; charset=UTF-8" %>
<%
  String baseURL = request.getContextPath();
%>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <title>Agregar Profesor</title>
  <link rel="stylesheet" href="<%= baseURL %>/css/styles.css">
</head>
<body>
<div class="form-container">
  <h1>Agregar Profesor</h1>
  <form action="<%= baseURL %>/profesor" method="post">
    <input type="hidden" name="action" value="agregar">

    <label>Cédula</label>
    <input type="number" name="cedula" required>

    <label>Nombre</label>
    <input type="text" name="nombre" required>

    <label>Especialidad</label>
    <input type="text" name="especialidad" required>

    <button class="btn" type="submit">Guardar</button>
    <a class="btn btn-secondary" href="<%= baseURL %>/profesor/lista.jsp">Volver</a>
  </form>
</div>
</body>
</html>
