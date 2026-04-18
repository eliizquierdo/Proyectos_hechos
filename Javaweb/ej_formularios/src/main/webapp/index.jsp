<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <title>Mi primer proyecto MVC con dos capas</title>
</head>
<body>
  <h1>Mi primer proyecto MVC con dos capas</h1>
  <p>Vista y Controlador</p>

  <!-- Link robusto usando el context path -->
  <a href="<%= request.getContextPath() %>/formulario">Ir al formulario</a>
</body>
</html>
