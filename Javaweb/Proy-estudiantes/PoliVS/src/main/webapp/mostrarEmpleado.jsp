<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, modelo.vo.EmpleadoVO"%>
<!DOCTYPE html>
<html>
<head>
    <title>Lista de Empleado</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <h2>Lista de Empleado</h2>
    <table border="1">
        <tr>
            <th>Cedula</th><th>Nombre</th><th>Telefono</th><th>Categoria</th><th>Sueldo</th><th>Acciones</th>
        </tr>
        <%
            List<EmpleadoVO> lista = (List<EmpleadoVO>) request.getAttribute("Empleado");
            if(lista != null){
                for(EmpleadoVO e: lista){
        %>
        <tr>
            <td><%= e.getCedula() %></td>
            <td><%= e.getNombre() %></td>
            <td><%= e.getTelefono() %></td>
            <td><%= e.getCategoria() %></td>
            <td><%= e.getSueldo() %></td>
            <td>
                <form action="EmpleadoServlet" method="post" style="display:inline;">
                    <input type="hidden" name="accion" value="eliminar">
                    <input type="hidden" name="cedula" value="<%= e.getCedula() %>">
                    <input type="submit" value="Eliminar" onclick="return confirm('¿Estás seguro de eliminar este Empleado?');">
                </form>
                <form action="EmpleadoServlet" method="get" style="display:inline;">
                    <input type="hidden" name="accion" value="modificar">
                    <input type="hidden" name="cedula" value="<%= e.getCedula() %>">
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