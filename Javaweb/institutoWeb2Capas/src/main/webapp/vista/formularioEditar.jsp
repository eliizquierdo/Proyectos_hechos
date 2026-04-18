<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
        <!DOCTYPE html>
        <html lang="es">

        <head>
            <meta charset="UTF-8">
            <title>Editar Persona</title>
            <c:set var="baseURL" value="${pageContext.request.contextPath}" />
            <link rel="stylesheet" href="${baseURL}/css/estilos.css">
        </head>

        <body>

            <div class="contenedor">
                <header>
                    <h1>Registro de Personas</h1>
                </header>

                <section>
                    <h2>Editar Persona</h2>

                    <form action="${baseURL}/persona?action=editar" method="post">
                        <div>
                            <label for="cedula">Cédula:</label>
                            <input type="number" name="cedula" id="cedula" value="${persona.cedula}" readonly>
                        </div>

                        <div>
                            <label for="nombre">Nombre:</label>
                            <input type="text" name="nombre" id="nombre" value="${persona.nombre}" required>
                        </div>

                        <div>
                            <label for="apellido">Apellido:</label>
                            <input type="text" name="apellido" id="apellido" value="${persona.apellido}" required>
                        </div>

                        <button type="submit">Actualizar</button>
                    </form>
                </section>

                <div class="volver">
                    <a href="${baseURL}/persona?action=listar">Volver al listado</a>
                </div>

                <footer>
                    <p>&copy; 2025 - Proyecto Personas con JSP y Servlets</p>
                </footer>
            </div>

        </body>

        </html>