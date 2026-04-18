<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
  <title>Resultado</title>
  <% String baseURL = request.getContextPath(); %>
  <link rel="stylesheet" href="<%= baseURL %>/estilos.css?v=4" />
</head>
<body>
  <h2>Resultado del registro</h2>

  <div class="form-container result-card">
    <h3>¡Hola, <%= (request.getAttribute("nombre")!=null? request.getAttribute("nombre") : "") %>!</h3>

    <p>Tu bebida favorita es: 
      <strong><%= (request.getAttribute("bebida")!=null? request.getAttribute("bebida") : "") %></strong>
    </p>

    <p>¡Nos vemos en la fiesta! 🎉</p>

    <a class="btn" href="<%= baseURL %>/registroFiesta.jsp">Volver al formulario</a>
  </div>
</body>
</html>
