<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<html>
  <head>
    <title>Java JSP - Info</title>
  </head>
  <body>
    <h1>Información del Servidor y JSP</h1>

    <p>Servidor: <%= application.getServerInfo() %></p>
    <p>
      Versión Servlet: <%= application.getMajorVersion() %> <%=
      application.getMinorVersion() %>
    </p>
    <p>Ruta real de la aplicación: <%= application.getRealPath("/") %></p>
    <h1>El famoso script Hello World</h1>
    <p><%= "Hola Mundo!" %></p>
  </body>
</html>
