<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
  <title>Registro a la Fiesta</title>
  <% String baseURL = request.getContextPath(); %>
  <link rel="stylesheet" href="<%= baseURL %>/estilos.css?v=4" />
</head>
<body>
  <h2>¡Registrate a la fiesta!</h2>

  <div class="form-container">
    <form action="RegistroServlet" method="post">
      <label for="nombre">Nombre:</label>
      <input type="text" id="nombre" name="nombre" />

      <label for="bebida">Bebida favorita:</label>
      <select id="bebida" name="bebida">
        <option value="Jugo">Jugo</option>
        <option value="Refresco">Refresco</option>
        <option value="Agua">Agua</option>
      </select>

      <!-- Espaciador para botón alineado -->
      <span></span>
      <input type="submit" value="Enviar" />
    </form>
  </div>
</body>
</html>
