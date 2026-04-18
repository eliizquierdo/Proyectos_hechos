<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  String baseURL = request.getContextPath();
%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Sistema de Gestión de Empleados</title>
    <link rel="stylesheet" href="<%= baseURL %>/css/index.css">
</head>
<body>
    <div class="welcome-container">
        <div class="welcome-icon">💼</div>
        <h1 class="welcome-title">Sistema de Gestión de Empleados</h1>
        <p class="welcome-subtitle">
            Ejercicio práctico de MVC con todos los tipos de controles HTML
        </p>
        
        <ul class="features-list">
            <li>Formularios con radio buttons, checkboxes y selects</li>
            <li>Manejo de selección múltiple y arrays</li>
            <li>Validaciones del lado cliente</li>
            <li>Arquitectura MVC completa</li>
            <li>Interfaz moderna y responsive</li>
        </ul>
        
        <div>
            <a href="<%= baseURL %>/empleado" class="btn-main">
                Acceder al Sistema
            </a>
        </div>
    </div>
</body>
</html>