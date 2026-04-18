<%@ page contentType="text/html; charset=UTF-8" language="java" %> 
<%@ page import="foo.Counter" %>

<html>
  <head>
    <title>Variables en JSP</title>
  </head>
  <body>
    <h1>Primer ejemplo de Variables</h1>
    <p>
      <% String name = "Miguel"; %> Hola <b><%= name %></b>, encantado de
      conocerte.
    </p>
    La página fue visitada: <% out.println(Counter.getCount()); %>
  </body>
</html>
