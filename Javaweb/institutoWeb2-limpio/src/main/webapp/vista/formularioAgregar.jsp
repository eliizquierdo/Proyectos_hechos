<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head><title>Agregar Persona</title></head>
    <body>
        <h2>Agregar Persona</h2>

        <form action="${pageContext.request.contextPath}/persona?action=agregar" method="post">
            <label>Cédula:</label>
            <input type="number" name="cedula" required><br>
            <label>Nombre:</label>
            <input type="text" name="nombre" required><br>
            <label>Apellido:</label>
            <input type="text" name="apellido" required><br>
            <input type="submit" value="Guardar">
        </form>
        <a href="${pageContext.request.contextPath}/persona?action=listar">Volver al listado</a>

    </body>
</html>
