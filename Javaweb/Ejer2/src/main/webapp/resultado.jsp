<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Resultado</title>
</head>
<body>
    <h2>Resultado del cálculo</h2>

    <%
        String error = (String) request.getAttribute("error");
        if (error != null) {
    %>
        <p style="color:red;"><%= error %></p>
    <%
        } else {
            String operacion = (String) request.getAttribute("operacion");
            double resultado = (Double) request.getAttribute("resultado");
    %>
        <p>El resultado en <strong><%= operacion %></strong> es: <strong><%= resultado %></strong></p>
    <%
        }
    %>
</body>
</html>
