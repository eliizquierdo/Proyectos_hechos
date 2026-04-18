<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head><title>Editar Persona</title></head>
<body>
    <h2>Editar Persona</h2>
    
        <form action="${pageContext.request.contextPath}/persona?action=editar" method="post">
        <label>Cédula:</label>
        <input type="number" name="cedula" value="${persona.cedula}" readonly><br>
        <label>Nombre:</label>
        <input type="text" name="nombre" value="${persona.nombre}" required><br>
        <label>Apellido:</label>
        <input type="text" name="apellido" value="${persona.apellido}" required><br>
        <input type="submit" value="Actualizar">
    </form>
    <a href="${pageContext.request.contextPath}/persona?action=listar">Volver al listado</a>
</body>
</html>
