<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="modelo.vo.PerroVO" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/estilos.css">
    <title>Lista de Perros</title>
</head>
<body>
    <h1>Lista de Perros</h1>
    <%
        List<PerroVO> lista = (List<PerroVO>) request.getAttribute("listaPerros");
        if (lista != null && !lista.isEmpty()) {
    %>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Nombre</th>
            <th>Raza</th>
        </tr>
        <%
            for (PerroVO p : lista) {
        %>
        <tr>
            <td><%= p.getId() %></td>
            <td><%= p.getNombre() %></td>
            <td><%= p.getRaza() %></td>
        </tr>
        <%
            }
        %>
    </table>
    <%
        } else {
    %>
        <p>No hay perros registrados.</p>
    <%
        }
    %>
    <br>
    <a href="index.jsp">Volver al Menú</a>
</body>
</html>