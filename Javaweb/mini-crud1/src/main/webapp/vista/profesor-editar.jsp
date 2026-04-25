<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="modelo.vo.ProfesorVO" %>
<%
  String baseURL = request.getContextPath();
  ProfesorVO profesor = (ProfesorVO) request.getAttribute("profesor");
%>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <title>Editar Profesor</title>
  <link rel="stylesheet" href="<%= baseURL %>/css/styles.css">
</head>
<body>
<div class="form-container">
  <h1>Editar Profesor</h1>
  <form action="<%= baseURL %>/profesor" method="post">
    <input type="hidden" name="action" value="editar">

    <label>Cédula</label>
    <input type="number" name="cedula" value="<%= profesor.getCedula() %>" readonly>

    <label>Nombre</label>
    <input type="text" name="nombre" value="<%= profesor.getNombre() %>" required>

    <label>Especialidad</label>
    <input type="text" name="especialidad" value="<%= profesor.getEspecialidad() %>" required>

    <button class="btn" type="submit">Actualizar</button>
    <a class="btn btn-secondary" href="<%= baseURL %>/profesor/lista.jsp">Volver</a>
  </form>
</div>
</body>
</html>
