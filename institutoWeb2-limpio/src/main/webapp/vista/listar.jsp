<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Listado de Personas</title>
</head>
<body>

    <h2>Listado de personas registradas</h2>

    <table border="1" cellpadding="5">
        <tr>
            <th>Cédula</th>
            <th>Nombre</th>
            <th>Apellido</th>
            <th>Acciones</th>
        </tr>

        <c:forEach var="p" items="${personas}">
            <tr>
                <td>${p.cedula}</td>
                <td>${p.nombre}</td>
                <td>${p.apellido}</td>
                <td>
                    <!-- Enlace para Editar -->
                    <a href="${pageContext.request.contextPath}/persona?action=cargarEditar&cedula=${p.cedula}">Editar</a>

                    <!-- Enlace para Eliminar -->
                    <a href="${pageContext.request.contextPath}/persona?action=eliminar&cedula=${p.cedula}" 
                       onclick="return confirm('¿Estás seguro que deseas eliminar esta persona?');">Eliminar</a>
                </td>
            </tr>
        </c:forEach>

    </table>

    <br>
    <a href="${pageContext.request.contextPath}/vista/formularioAgregar.jsp">Agregar nueva persona</a>

</body>
</html>
