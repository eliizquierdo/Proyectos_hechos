<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="modelo.vo.ActividadVO" %>
<%
  String baseURL = request.getContextPath();
  ActividadVO actividad = (ActividadVO) request.getAttribute("actividad");
%>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <title>Editar Actividad</title>
  <link rel="stylesheet" href="<%= baseURL %>/css/styles.css">
</head>
<body>
<div class="form-container">
  <h1>Editar Actividad</h1>
  <form action="<%= baseURL %>/actividad" method="post">
    <input type="hidden" name="action" value="editar">

    <label>ID Actividad</label>
    <input type="number" name="idActividad" value="<%= actividad.getIdActividad() %>" readonly>

    <label>Nombre</label>
    <input type="text" name="nombre" value="<%= actividad.getNombre() %>" required>

    <label>Día</label>
    <input type="text" name="dia" value="<%= actividad.getDia() %>" required>

    <label>Hora</label>
    <input type="text" name="hora" value="<%= actividad.getHora() %>" required>

    <button class="btn" type="submit">Actualizar</button>
    <a class="btn btn-secondary" href="<%= baseURL %>/actividad/lista.jsp">Volver</a>
  </form>
</div>
</body>
</html>
