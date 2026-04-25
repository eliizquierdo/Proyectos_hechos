<%@ page contentType="text/html; charset=UTF-8" %>
<%
  String baseURL = request.getContextPath();
%>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <title>Agregar Actividad</title>
  <link rel="stylesheet" href="<%= baseURL %>/css/styles.css">
</head>
<body>
<div class="form-container">
  <h1>Agregar Actividad</h1>
  <form action="<%= baseURL %>/actividad" method="post">
    <input type="hidden" name="action" value="agregar">

    <label>ID Actividad</label>
    <input type="number" name="idActividad" required>

    <label>Nombre</label>
    <input type="text" name="nombre" required>

    <label>Día</label>
    <input type="text" name="dia" required>

    <label>Hora</label>
    <input type="text" name="hora" required>

    <button class="btn" type="submit">Guardar</button>
    <a class="btn btn-secondary" href="<%= baseURL %>/actividad/lista.jsp">Volver</a>
  </form>
</div>
</body>
</html>
