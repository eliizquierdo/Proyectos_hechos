<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, modelo.vo.AlumnoVO"%>
<!DOCTYPE html>
<html>
<head>
    <title>Lista de Alumno</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <h2>Lista de Alumno</h2>
    <table border="1">
        <tr>
            <th>Cedula</th><th>Nombre</th><th>Telefono</th><th>Edad</th><th>Calle</th><th>Nro</th><th>Acciones</th>
        </tr>
        <%
            List<AlumnoVO> lista = (List<AlumnoVO>) request.getAttribute("Alumnos");
            if(lista != null){
                for(AlumnoVO m: lista){
        %>
        <tr>
            <td><%= m.getCedula() %></td>
            <td><%= m.getNombre() %></td>
            <td><%= m.getTelefono() %></td>
            <td><%= m.getedad() %></td>
            <td><%= m.getcalle() %></td>
            <td><%= m.getnro() %></td>
            <td>
                <form action="AlumnoServlet" method="post" style="display:inline;">
                    <input type="hidden" name="accion" value="eliminar">
                    <input type="hidden" name="cedula" value="<%= m.getCedula() %>">
                    <input type="submit" value="Eliminar" onclick="return confirm('¿Estás seguro de eliminar este alumno?');">
                </form>
                <form action="AlumnoServlet" method="get" style="display:inline;">
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