<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, modelo.vo.DisciplinaVO"%>
<!DOCTYPE html>
<html>
<head>
    <title>Lista de Disciplina</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <h2>Lista de Disciplina</h2>
    <table border="1">
        <tr>
            <th>Id</th><th>Nombre</th><th>Cupo</th><th>Acciones</th>
        </tr>
        <%
            List<DisciplinaVO> lista = (List<DisciplinaVO>) request.getAttribute("Disciplina");
            if(lista != null){
                for(DisciplinaVO m: lista){
        %>
        <tr>
            <td><%= m.getid() %></td>
            <td><%= m.getnombre() %></td>
            <td><%= m.getcupo() %></td>
            <td>
                <form action="DisciplinaServlet" method="post" style="display:inline;">
                    <input type="hidden" name="accion" value="eliminar">
                    <input type="hidden" name="id" value="<%= m.getid() %>">
                    <input type="submit" value="Eliminar" onclick="return confirm('¿Estás seguro de eliminar esta disciplina?');">
                </form>
                <form action="DisciplinaServlet" method="get" style="display:inline;">
                    <input type="hidden" name="accion" value="modificar">
                    <input type="hidden" name="id" value="<%= m.getid() %>">
                    <input type="submit" value="Modificar">
                </form>
            </td>
        </tr>
        <%      }
            }
        %>
    </table>
    <a href="index.jsp">Volver</a>
</body>
</html>