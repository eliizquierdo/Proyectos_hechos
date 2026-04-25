<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.*, modelo.vo.SocioVO" %>
<%
  String baseURL = request.getContextPath();
  ArrayList<SocioVO> lista = (ArrayList<SocioVO>) request.getAttribute("listaSocios");
%>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <title>Lista de Socios</title>
  <link rel="stylesheet" href="<%= baseURL %>/css/styles.css">
</head>
<body>
<div class="table-container">
  <h1>Socios Registrados</h1>
  <a class="btn" href="<%= baseURL %>/socio/form.jsp">Agregar Nuevo</a>
  <table>
    <tr>
      <th>Cédula</th>
      <th>Nombre</th>
      <th>Medicación</th>
      <th>Carnet de Salud</th>
      <th>Sociedad Médica</th>
      <th>Acciones</th>
    </tr>
    <%
      if (lista != null && !lista.isEmpty()) {
        for (SocioVO s : lista) {
    %>
      <tr>
        <td><%= s.getCedula() %></td>
        <td><%= s.getNombre() %></td>
        <td><%= s.getMedicacion() %></td>
        <td><%= s.getCarnetSalud() %></td>
        <td><%= s.getSociedadMedica() %></td>
        <td>
          <a href="<%= baseURL %>/socio?action=editar&cedula=<%= s.getCedula() %>">Editar</a> |
          <a href="<%= baseURL %>/socio?action=eliminar&cedula=<%= s.getCedula() %>">Eliminar</a>
        </td>
      </tr>
    <%
        }
      } else {
    %>
      <tr><td colspan="6">No hay socios registrados.</td></tr>
    <%
      }
    %>
  </table>
</div>
</body>
</html>
