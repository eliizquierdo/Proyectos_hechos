<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Variables en JSP</title>
</head>
<body>
    <h1>Primer ejemplo de Variables</h1>
    <p>
        <%
            String name = "Miguel";
        %>
        Hola <b><%= name %></b>,encantado de conocerte<br>
        Gracias por venir!
    </p>
</body>
</html>

