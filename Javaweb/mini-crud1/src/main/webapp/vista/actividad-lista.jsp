<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.*, modelo.vo.ActividadVO" %>
<%
  String baseURL = request.getContextPath();
  ArrayList<ActividadVO> lista = (ArrayList<ActividadVO>) request.getAttribute("listaActividades");
%>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <title>Lista de Actividades</title>
  <link rel="stylesheet" href="<%= baseURL %>/css/styles.css">
</head>
<body>
<div class="table-container">
  <h1>Actividades Registradas</h1>
  <a class="btn" href="<%= baseURL %>/actividad/form.jsp">Agregar Nueva</a>
  <table>
    <tr>
      <th>ID</th>
      <th>Nombre</th>
      <th>Día</th>
      <th>Hora</th>
      <th>Acciones</th>
    </tr>
    <%
      if (lista != null && !lista.isEmpty()) {
        for (ActividadVO a : lista) {
    %>
      <tr>
        <td><%= a.getIdActividad() %></td>
        <td><%= a.getNombre() %></td>
        <td><%= a.getDia() %></td>
        <td><%= a.getHora() %></td>
        <td>
          <a href="<%= baseURL %>/actividad?action=editar&idActividad=<%= a.getIdActividad() %>">Editar</a> |
          <a href="<%= baseURL %>/actividad?action=eliminar&idActividad=<%= a.getIdActividad() %>">Eliminar</a>
        </td>
      </tr>
    <%
        }
      } else {
    %>
      <tr><td colspan="5">No hay actividades registradas.</td></tr>
    <%
      }
    %>
  </table>
</div>
</body>
</html>
