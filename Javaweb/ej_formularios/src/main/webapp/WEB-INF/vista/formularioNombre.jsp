<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Calendar" %>
<html>
  <head>
    <title>Formulario en JSP</title>
  </head>
  <body>
    <h1>Complete el formulario</h1>

    <form method="get">
      <label for="nombre">Nombre:</label>
      <input type="text" name="nombre" id="nombre" required /><br />

      <label for="apellido">Apellido:</label>
      <input type="text" name="apellido" id="apellido" required /><br />

      <label for="anio">Año de nacimiento</label>
      <input type="number" name="anio" id="anio" min="1900" required />

      <br /><br />
      <input type="submit" value="Enviar" />
    </form>
        
    <%
      String nom = request.getParameter("nombre");
      String ape = request.getParameter("apellido");
      String anioStr = request.getParameter("anio");

      if (nom != null && ape != null && anioStr != null && !anioStr.trim().isEmpty()) {
          int anioNacimiento = Integer.parseInt(anioStr.trim());
          int anioActual = Calendar.getInstance().get(Calendar.YEAR);
          int edad = anioActual - anioNacimiento;

          String mensaje;
          if (edad >= 18) {
              mensaje = "Podés votar.";
          } else {
              mensaje = "Todavía no podés votar.";
          }
    %>
          <h2>Hola, <%= nom %> <%= ape %></h2>
          <p>Tu edad es: <%= edad %> años</p>
          <p><%= mensaje %></p>
    <%
      }
    %>
  </body>
</html>
