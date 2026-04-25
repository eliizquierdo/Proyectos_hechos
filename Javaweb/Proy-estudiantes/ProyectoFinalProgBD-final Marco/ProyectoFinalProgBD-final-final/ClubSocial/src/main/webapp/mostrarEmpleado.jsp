<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, modelo.vo.EmpleadoVO"%>
<!DOCTYPE html>
<html>
<head>
    <title>Lista de los Empleados</title>
    <link rel="stylesheet" href="css/style2.css">
</head>
<body>
    <h2>Lista de los Empleados</h2>
    <table>
        <tr>
            <th>Cedula</th><th>Nombre</th><th>Apellido</th><th>Fecha de Nacimiento</th><th>Email</th><th>Calle</th><th>Numero</th><th>Referencia</th><th>Sueldo</th><th>Categoria</th><th>Telefonos</th><th>Acciones</th>
        </tr>
        <%
        List<EmpleadoVO> lista = (List<EmpleadoVO>) request.getAttribute("empleados");
        if(lista != null){
        for(EmpleadoVO e: lista){
        %>
        <tr>
            <td><%= e.getCedula()%></td>
            <td><%= e.getNombre() %></td>
            <td><%= e.getApellido() %></td>
            <td><%= e.getFechaNacimiento() %></td>
            <td><%= e.getEmail() %></td>
            <td><%= e.getCalle() %></td>
            <td><%= e.getNumero() %></td>
            <td><%= e.getEspecificacion() %></td>
            <td><%= e.getSueldo() %></td>
            <td><%= e.getCategoria() %></td>
            <td>
                <% 
                    List<String> lisT = e.getTelefonos();
                    if (lisT != null && !lisT.isEmpty()) { 
                        out.print(String.join(" / ", lisT));
                    } else {
                        out.print("N/A");
                    }
                %>
            </td>
            <td>
            <a href="EmpleadoServlet?accion=eliminar&cedula=<%= e.getCedula() %>"><button>Eliminar</button></a>
            <a href="EmpleadoServlet?accion=actualizar&id=<%= e.getCedula() %>"><button>Modificar</button></a>
            </td>
            <% 
        } 
%>

        </tr>
        <%      }
        %>
    </table>
    <a href="index.jsp">Volver</a>
</body>
</html>