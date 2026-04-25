<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.*, modelo.vo.ProfesorVO" %>
<%
  String baseURL = request.getContextPath();
  ArrayList<ProfesorVO> lista = (ArrayList<ProfesorVO>) request.getAttribute("listaProfesores");
%>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <title>Lista de Profesores</title>
  <link rel="stylesheet" href="<%= baseURL %>/css/styles.css">
</head>
<body>
<div class="table-container">
  <h1>Profesores Registrados</h1>
  <a class="btn" href="<%= baseURL %>/profesor/form.jsp">Agregar Nuevo</a>
  <table>
    <tr>
      <th>Cédula</th>
      <th>Nombre</th>
      <th>Especialidad</th>
      <th>Acciones</th>
    </tr>
    <%
      if (lista != null && !lista.isEmpty()) {
        for (ProfesorVO p : lista) {
    %>
      <tr>
        <td><%= p.getCedula() %></td>
        <td><%= p.getNombre() %></td>
        <td><%= p.getEspecialidad() %></td>
        <td>
          <a href="<%= baseURL %>/profesor?action=editar&cedula=<%= p.getCedula() %>">Editar</a> |
          <a href="<%= baseURL %>/profesor?action=eliminar&cedula=<%= p.getCedula() %>">Eliminar</a>
        </td>
      </tr>
    <%
        }
      } else {
    %>
      <tr><td colspan="4">No hay profesores registrados.</td></tr>
    <%
      }
    %>
  </table>
</div>
</body>
</html>
