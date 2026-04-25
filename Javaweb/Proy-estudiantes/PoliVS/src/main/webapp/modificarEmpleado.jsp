<%@ page contentType="text/html" pageEncoding="UTF-8"%> <%@ page
import="java.util.*, modelo.vo.EmpleadoVO"%>
<!DOCTYPE html>
<html>
  <head>
    <title>Modificar Empleado</title>
    <link rel="stylesheet" href="css/style.css" />
  </head>
  <body>
    <h2>Modificar Empleado</h2>

    <% EmpleadoVO a = (EmpleadoVO) request.getAttribute("Empleado"); %>

    <form action="EmpleadoServlet" method="post">
      <label>Nombre:</label>
      <input
        type="text"
        name="nombre"
        value="<%= a.getNombre() %>"
        required
      /><br />

      <label>Telefono:</label>
      <input
        type="number"
        min="100000000"
        max="999999999"
        name="telefono"
        value="<%= a.getTelefono() %>"
        required
      /><br />

      <label>Categoria:</label>
      <input
        type="text"
        name="categoria"
        value="<%= a.getCategoria() %>"
        required
      /><br />

      <label>Numero:</label>
      <input
        type="number"
        name="sueldo"
        value="<%= a.getSueldo() %>"
        required
      /><br />

      <input type="hidden" name="cedula" value="<%= a.getCedula() %>" />
      <input type="hidden" name="accion" value="modificar" />
      <button type="submit">Modificar</button>
    </form>

    <a href="index.jsp">Volver</a>
  </body>
</html>
