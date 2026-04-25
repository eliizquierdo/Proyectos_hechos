<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <title>Agregar Empleado</title>
    <link rel="stylesheet" href="css/style.css" />
  </head>
  <body>
    <h2>Agregar Empleado</h2>
    <form action="EmpleadoServlet" method="post">
      <label>Cedula:</label>
      <input type="number" name="cedula" required /><br />

      <label>Nombre:</label>
      <input type="text" name="nombre" required /><br />

      <label>Telefono:</label>
      <input type="number" name="telefono" required /><br />

      <label>Categoria:</label>
      <input type="text" name="categoria" required /><br />

      <label>Sueldo:</label>
      <input type="number" name="sueldo" required /><br />

      <input type="hidden" name="accion" value="agregar" />
      <button type="submit">Guardar</button>
    </form>
    <a href="index.jsp">Volver</a>
  </body>
</html>
