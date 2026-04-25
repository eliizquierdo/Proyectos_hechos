<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="modelo.vo.AlumnoVO" %>
<%
  String baseURL = request.getContextPath();
  List<AlumnoVO> listaAlumnos = (List<AlumnoVO>) request.getAttribute("alumnos");
%>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <title>Listado de Alumnos</title>
  <link rel="stylesheet" href="<%= baseURL %>/css/styles.css">
</head>
<body>
<div class="page-container">
  <h1>Listado de Alumnos</h1>

  <div class="table-wrap">
    <table class="table">
      <thead>
        <tr>
          <th>Código</th>
          <th>Nombre</th>
          <th>Apellido</th>
          <th>Grupo</th>
          <th>Acciones</th>
        </tr>
      </thead>
      <tbody>
      <%
        if (listaAlumnos != null && !listaAlumnos.isEmpty()) {
          for (AlumnoVO a : listaAlumnos) {
      %>
        <tr>
          <td><%= a.getCodigo() %></td>
          <td><%= a.getNombre() %></td>
          <td><%= a.getApellido() %></td>
          <td><%= a.getGrupo() %></td>
          <td class="actions">
            <a class="btn btn-edit" href="<%= baseURL %>/Persona?action=cargarEditar&codigo=<%= a.getCodigo() %>">Editar</a>
            <form action="<%= baseURL %>/Persona?action=eliminar" method="post" style="display:inline;">
              <input type="hidden" name="codigo" value="<%= a.getCodigo() %>">
              <button type="submit" class="btn btn-danger"
                onclick="return confirm('¿Eliminar el Persona <%= a.getNombre() %>?');">
                Eliminar
              </button>
            </form>
          </td>
        </tr>
      <%
          }
        } else {
      %>
        <tr>
          <td colspan="5" style="text-align:center; color:#6b7280;">No hay alumnos registrados</td>
        </tr>
      <%
        }
      %>
      </tbody>
    </table>
  </div>

  <div class="section-gap">
    <a class="btn" href="<%= baseURL %>/alumno?action=agregar">Agregar Alumno</a>
  </div>
</div>
</body>
</html>