<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, modelo.vo.ArqueroVO"%>
<!DOCTYPE html>
<html>
<head>
    <title>Lista de Arqueros</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <h2>Lista de Arqueros</h2>
    <table>
        <tr>
            <th>ID</th><th>Nombre</th><th>Cantidad Flechas</th><th>Nivel</th>
        </tr>
        <%
            List<ArqueroVO> lista = (List<ArqueroVO>) request.getAttribute("arqueros");
            if(lista != null){
                for(ArqueroVO a: lista){
        %>
        <tr>
            <td><%= a.getId() %></td>
            <td><%= a.getNombre() %></td>
            <td><%= a.getCat_Flechas()  %></td>
            <td><%= a.getNivel() %></td>
        </tr>
        <%      }
            }
        %>
    </table>
    <a href="index.jsp">Volver</a>
</body>
</html>