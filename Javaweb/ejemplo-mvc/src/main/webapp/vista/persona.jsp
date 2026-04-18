<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@ page import="java.util.List" %>
        <%@ page import="modelo.vo.PersonaVO" %>

            <% List<PersonaVO> personas = (List<PersonaVO>) request.getAttribute("personas");
                    %>

                    <html>

                    <head>
                        <title>Listado de Personas</title>
                    </head>

                    <body>
                        <h1>Personas Registradas</h1>
                        <table border="1">
                            <tr>
                                <th>Código</th>
                                <th>Nombre</th>
                            </tr>

                            <% if (personas !=null) { 
                                for (PersonaVO persona : personas) { %>
                                <tr>
                                    <td>
                                        <%= persona.getCodigo() %>
                                    </td>
                                    <td>
                                        <%= persona.getNombre() %>
                                    </td>
                                </tr>
                                <% } } else { %>
                                    <tr>
                                        <td colspan="2">No hay personas registradas.</td>
                                    </tr>
                                    <% } %>
                        </table>
                    </body>

                    </html>