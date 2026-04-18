<%@ page contentType="text/html; charset=UTF-8" language="java" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <!DOCTYPE html>
        <html lang="es">

        <head>
            <meta charset="UTF-8">
            <title>Listado de Personas</title>
            <c:set var="baseURL" value="${pageContext.request.contextPath}" />
            <link rel="stylesheet" href="${baseURL}/css/estilos.css">
        </head>

        <body>
            <div class="contenedor">
                <header>
                    <h1>Listado de personas registradas</h1>
                </header>

                <table>
                    <thead>
                        <tr>
                            <th>Cédula</th>
                            <th>Nombre</th>
                            <th>Apellido</th>
                            <th>Acciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="p" items="${personas}">
                            <tr>
                                <td>${p.cedula}</td>
                                <td>${p.nombre}</td>
                                <td>${p.apellido}</td>
                                <td>
                                    <a href="${baseURL}/persona?action=cargarEditar&cedula=${p.cedula}">Editar</a>
                                    <a href="${baseURL}/persona?action=eliminar&cedula=${p.cedula}"
                                        onclick="return confirm('¿Estás seguro que deseas eliminar esta persona?');">Eliminar</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>

                <div class="volver">
                    <a href="${baseURL}/vista/formularioAgregar.jsp">Agregar nueva persona</a>
                </div>

                <footer>
                    <p>&copy; 2025 - Proyecto Personas con JSP y Servlets</p>
                </footer>
            </div>
        </body>

        </html>