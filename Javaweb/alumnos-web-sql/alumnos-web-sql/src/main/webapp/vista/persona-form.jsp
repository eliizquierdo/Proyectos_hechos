<%@ page contentType="text/html; charset=UTF-8" %>
<%
    String baseURL = request.getContextPath();
    // Recupera el mensaje que el doGet puso como ATRIBUTO DE REQUEST (si existe un error de validación)
    String mensaje = (String) request.getAttribute("mensaje"); 
%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Agregar Persona</title>
    <link rel="stylesheet" href="<%= baseURL %>/css/styles.css">
</head>
<body>
<div class="form-container">
    <h1>Agregar Persona</h1>
    
    <%
        // Lógica para mostrar solo errores de validación/DAO
        if (mensaje != null) {
            if ("formato_invalido".equals(mensaje)) {
    %>
                <p class="msg-error">❌ Error de validación: El código debe ser un número válido.</p>
    <%
            } else if ("error_dao".equals(mensaje)) {
    %>
                <p class="msg-error">❌ Error al guardar: Ya existe una persona con ese código o falló la inserción.</p>
    <%
            }
        }
    %>
    
    <hr>
    
    <form action="<%= baseURL %>/persona" method="post">
        <input type="hidden" name="action" value="agregar">

        <label for="codigo">Código</label>
        <input type="number" id="codigo" name="codigo" required>

        <label for="nombre">Nombre</label>
        <input type="text" id="nombre" name="nombre" required>

        <button class="btn" type="submit">Guardar</button>
        <a class="btn btn-secondary" href="<%= baseURL %>/persona">Volver al Listado</a>
    </form>
</div>
</body>
</html>