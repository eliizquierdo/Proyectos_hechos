<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8" />
  <title>Resultado</title>
</head>
<body>
  <h2>Hola, <%= request.getAttribute("nombre") %> 
      <%= request.getAttribute("apellido") %>!</h2>

  <p>Tu edad es: <strong><%= request.getAttribute("edad") %></strong> años.</p>
  <p>Tu sabor de helado favorito es: <strong><%= request.getAttribute("sabor") %></strong></p>
  <p><strong><%= request.getAttribute("mensajeVoto") %></strong></p>

  <p><a href="formularioNombre2.jsp">Volver al formulario</a></p>
</body>
</html>
