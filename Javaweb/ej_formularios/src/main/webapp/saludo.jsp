<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Mi primer JSP</title>
  </head>
  <body>
    <h1>Bienvenidos</h1>
    <h3>Datos personales</h3>
    <form method="get">
      Ingrese su nombre: <input type="text" name="nombre" />
      <input type="submit" value="Saludar" />
    </form>
    <% String nombre = request.getParameter("nombre"); if (nombre != null &&
    !nombre.trim().isEmpty()) { %>
    <h2>Hola, <%= nombre %>!</h2>
    <% } %>
  </body>
</html>
