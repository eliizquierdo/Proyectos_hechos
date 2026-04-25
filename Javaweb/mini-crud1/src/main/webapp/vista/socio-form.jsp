<%@ page contentType="text/html; charset=UTF-8" %>
<%
  String baseURL = request.getContextPath();
%>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <title>Agregar Socio</title>
  <link rel="stylesheet" href="<%= baseURL %>/css/styles.css">
</head>
<body>
<div class="form-container">
  <h1>Agregar Socio</h1>
  <form action="<%= baseURL %>/socio" method="post">
    <input type="hidden" name="action" value="agregar">

    <label>Cédula</label>
    <input type="number" name="cedula" required>

    <label>Nombre</label>
    <input type="text" name="nombre" required>

    <label>Medicación</label>
    <input type="text" name="medicacion" required>

    <label>Carnet de Salud</label>
    <input type="text" name="carnetSalud" required>

    <label>Sociedad Médica</label>
    <input type="text" name="sociedadMedica" required>

    <button class="btn" type="submit">Guardar</button>
    <a class="btn btn-secondary" href="<%= baseURL %>/socio/lista.jsp">Volver</a>
  </form>
</div>
</body>
</html>
