<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="modelo.vo.AlumnoVO" %>
<%
  String baseURL = request.getContextPath();
  AlumnoVO alumno = (AlumnoVO) request.getAttribute("alumno");
%>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <title>Editar Alumno</title>
  <link rel="stylesheet" href="<%= baseURL %>/css/styles.css">
</head>
<body>
<div class="form-container">
  <h1>Editar Alumno</h1>
  <form action="<%= baseURL %>/alumno" method="post">
    <input type="hidden" name="action" value="editar">

    <label>Codigo</label>
    <input type="number" name="codigo" value="<%= alumno.getCodigo() %>" readonly required>

    <label>Nombre</label>
    <input type="text" name="nombre" value="<%= alumno.getNombre() %>" required>

    <label>Apellido</label>
    <input type="text" name="apellido" value="<%= alumno.getApellido() %>" required>

    <label>Grupo</label>
    <input type="number" name="grupo" value="<%= alumno.getGrupo() %>" required>

    <button class="btn" type="submit">Actualizar</button>
    <a class="btn btn-secondary" href="<%= baseURL %>/alumno">Volver</a>
  </form>
</div>
</body>
</html>