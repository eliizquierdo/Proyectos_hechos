<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, modelo.vo.EmpleadoVO"%>
<!DOCTYPE html>
<html>
<head>
    <title>Lista de Empleados</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <h2>Lista de Empleados</h2>
    <table border="1">
        <tr>
            <th>Cedula</th><th>Nombre</th><th>Telefono</th><th>Categoria</th><th>Sueldo</th>
        </tr>
        <%
            List<EmpleadoVO> lista = (List<EmpleadoVO>) request.getAttribute("empleado");
            if(lista != null){
                for(EmpleadoVO m: lista){
        %>
        <tr>
            <td><%= m.getCedula() %></td>
            <td><%= m.getNombre() %></td>
            <td><%= m.getTelefono() %></td>
            <td><%= m.getCategoria() %></td>
            <td><%= m.getSueldo() %></td>
            <td>
                <form action="EmpleadoServlet" method="post" style="display:inline;">
                    <input type="hidden" name="accion" value="eliminar">
                    <input type="hidden" name="cedula" value="<%= m.getCedula() %>">
                    <input type="submit" value="Eliminar" onclick="return confirm('¿Estás seguro de eliminar este empleado?');">
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