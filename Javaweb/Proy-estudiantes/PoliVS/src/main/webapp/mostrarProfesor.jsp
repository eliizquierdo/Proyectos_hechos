<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, modelo.vo.ProfesorVO"%>
<!DOCTYPE html>
<html>
<head>
    <title>Lista de Profesores</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <h2>Lista de Profesores</h2>
    <table border="1">
        <tr>
            <th>Cedula</th><th>Nombre</th><th>Telefono</th><th>Especialidad</th><th>Acciones</th>
        </tr>
        <%
            List<ProfesorVO> lista = (List<ProfesorVO>) request.getAttribute("profesor");
            if(lista != null){
                for(ProfesorVO m: lista){
        %>
        <tr>
            <td><%= m.getCedula() %></td>
            <td><%= m.getNombre() %></td>
            <td><%= m.getTelefono() %></td>
            <td><%= m.getespecialidad() %></td>
            <td>
                <form action="ProfesorServlet" method="post" style="display:inline;">
                    <input type="hidden" name="accion" value="eliminar">
                    <input type="hidden" name="cedula" value="<%= m.getCedula() %>">
                    <input type="submit" value="Eliminar" onclick="return confirm('¿Estás seguro de eliminar este Profesor?');">
                </form>
                <form action="ProfesorServlet" method="get" style="display:inline;">
                    <input type="hidden" name="accion" value="modificar">
                    <input type="hidden" name="cedula" value="<%= m.getCedula() %>">
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