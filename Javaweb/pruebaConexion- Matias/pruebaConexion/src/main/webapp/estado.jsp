<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Estado</title>
    <style>
        .estado {
            font-weight: bold;
            padding: 10px;
            width: 200px;
            text-align: center;
            color: white;
        }
        .conectado { background-color: green; }
        .desconectado { background-color: red; }
    </style>
</head>
<body>
    <h2>${mensaje}</h2>
    <div class="estado ${estado}">
        ${estado.toUpperCase()}
    </div>
    <br>
    <a href="index.jsp">Volver</a>
</body>
</html>