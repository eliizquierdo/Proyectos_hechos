<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, modelo.vo.PersonalVO"%>
<!DOCTYPE html>
<html>
<head>
    <title>Lista del Personal</title>
    <link rel="stylesheet" href="css/style2.css">
</head>
<body>
    <h2>Lista del Personal</h2>
    <table>
        <tr>
            <th>Cedula</th><th>Nombre</th><th>Apellido</th><th>Fecha de Nacimiento</th><th>Email</th><th>Calle</th><th>Numero</th><th>Referencia</th><th>Salario</th><th>Area de trabajo</th><th>Telefonos</th><th>Acciones</th>
        </tr>
        <%
        List<PersonalVO> lista = (List<PersonalVO>) request.getAttribute("personales");
        if(lista != null){
        for(PersonalVO p: lista){
        %>
        <tr>
            <td><%= p.getCedula()%></td>
            <td><%= p.getNombre() %></td>
            <td><%= p.getApellido() %></td>
            <td><%= p.getFechaNacimiento() %></td>
            <td><%= p.getEmail() %></td>
            <td><%= p.getCalle() %></td>
            <td><%= p.getNumero() %></td>
            <td><%= p.getEspecificacion() %></td>
            <td><%= p.getSalario() %></td>
            <td><%= p.getAreaTrabajo() %></td>
            <td>
                <% 
                    List<String> lisT = p.getTelefonos();
                    if (lisT != null && !lisT.isEmpty()) { 
                        out.print(String.join(" / ", lisT));
                    } else {
                        out.print("N/A");
                    }
                %>
            </td>
            <td>
            <a href="PersonalServlet?accion=eliminar&cedula=<%= p.getCedula() %>"><button>Eliminar</button></a>
            <a href="PersonalServlet?accion=actualizar&id=<%= p.getCedula() %>"><button>Modificar</button></a>
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