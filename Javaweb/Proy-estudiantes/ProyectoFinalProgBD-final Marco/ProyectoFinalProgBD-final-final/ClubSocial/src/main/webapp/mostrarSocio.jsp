<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, modelo.vo.SocioVO"%>
<!DOCTYPE html>
<html>
<head>
    <title>Lista de Socios</title>
    <link rel="stylesheet" href="css/style2.css">
</head>
<body>
    <h2>Lista de Socios</h2>
    <table>
        <tr>
            <th>Cedula</th><th>Nombre</th><th>Apellido</th><th>Fecha de Nacimiento</th><th>Email</th><th>Calle</th><th>Numero</th><th>Referencia</th><th>Mensualidad</th><th>Telefonos</th><th>Acciones</th>
        </tr>
        <%
        List<SocioVO> lista = (List<SocioVO>) request.getAttribute("socios");
        if(lista != null){
        for(SocioVO s: lista){
        %>
        <tr>
            <td><%= s.getCedula()%></td>
            <td><%= s.getNombre() %></td>
            <td><%= s.getApellido() %></td>
            <td><%= s.getFechaNacimiento() %></td>
            <td><%= s.getEmail() %></td>
            <td><%= s.getCalle() %></td>
            <td><%= s.getNumero() %></td>
            <td><%= s.getEspecificacion() %></td>
            <td><%= s.getMensualidad() %></td>
            <td>
                <% 
                    List<String> lisT = s.getTelefonos();
                    if (lisT != null && !lisT.isEmpty()) { 
                        out.print(String.join(" / ", lisT));
                    } else {
                        out.print("N/A");
                    }
                %>
            </td>
            <td>
            <a href="SocioServlet?accion=eliminar&cedula=<%= s.getCedula() %>"><button>Eliminar</button></a>
            <a href="SocioServlet?accion=actualizar&id=<%= s.getCedula() %>"><button>Modificar</button></a>
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