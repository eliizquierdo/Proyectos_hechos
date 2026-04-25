<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="modelo.vo.SocioVO" %>
<%
  String baseURL = request.getContextPath();
  SocioVO socio = (SocioVO) request.getAttribute("socio");
%>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <title>Editar Socio</title>
  <link rel="stylesheet" href="<%= baseURL %>/css/styles.css">
</head>
<body>
<div class="form-container">
  <h1>Editar Socio</h1>
  <form action="<%= baseURL %>/socio" method="post">
    <input type="hidden" name="action" value="editar">

    <label>Cédula</label>
    <input type="number" name="cedula" value="<%= socio.getCedula() %>" readonly>

    <label>Nombre</label>
    <input type="text" name="nombre" value="<%= socio.getNombre() %>" required>

    <label>Medicación</label>
    <input type="text" name="medicacion" value="<%= socio.getMedicacion() %>" required>

    <label>Carnet de Salud</label>
    <input type="text" name="carnetSalud" value="<%= socio.getCarnetSalud() %>" required>

    <label>Sociedad Médica</label>
    <input type="text" name="sociedadMedica" value="<%= socio.getSociedadMedica() %>" required>

    <button class="btn" type="submit">Actualizar</button>
    <a class="btn btn-secondary" href="<%= baseURL %>/socio/lista.jsp">Volver</a>
  </form>
</div>
</body>
</html>
