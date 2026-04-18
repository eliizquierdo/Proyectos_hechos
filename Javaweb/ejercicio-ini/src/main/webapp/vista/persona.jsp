<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ page import="java.util.List" %>
        <%@ page import="modelo.vo.PersonaVO" %>

            <% List<PersonaVO> personas = (List<PersonaVO>) request.getAttribute("personas");
                    String mensaje = (String) request.getAttribute("mensaje");
                    %>

                    <!DOCTYPE html>
                    <html>

                    <head>
                        <title>Gestión de Personas</title>
                        <link rel="stylesheet" href="<%= request.getContextPath() %>/css/estilos.css">
                    </head>

                    <body>
                        <h1>Gestión de Personas</h1>

                        <% if (mensaje !=null) { %>
                            <p class="mensaje">
                                <%= mensaje %>
                            </p>
                            <% } %>

                                <!-- 🧾 Formulario para agregar o actualizar -->
                                <form action="personas" method="post">
                                    <label>Código:</label>
                                    <input type="number" name="codigo" id="codigo" required />

                                    <label>Nombre:</label>
                                    <input type="text" name="nombre" id="nombre" required />

                                    <button type="submit" name="accion" value="agregar">Agregar</button>
                                    <button type="submit" name="accion" value="actualizar">Actualizar</button>
                                </form>

                                <!-- 📋 Tabla de personas -->
                                <table>
                                    <tr>
                                        <th class="acciones">Código</th>
                                        <th class="acciones">Nombre</th>
                                        <th class="acciones">Acciones</th>
                                    </tr>

                                    <% if (personas !=null) { for (PersonaVO p : personas) { %>
                                        <tr>
                                            <td class="acciones">
                                                <%= p.getCod() %>
                                            </td>
                                            <td class="acciones">
                                                <%= p.getNombre() %>
                                            </td>
                                            <td class="acciones">
                                                <!-- Botón editar -->
                                                <button type="button"
                                                    onclick="cargarPersona('<%= p.getCod() %>', '<%= p.getNombre() %>')">Editar</button>

                                                <!-- Botón eliminar -->
                                                <form action="personas" method="post" style="display:inline;">
                                                    <input type="hidden" name="codigo" value="<%= p.getCod() %>" />
                                                    <button type="submit" name="accion" value="eliminar"
                                                        onclick="return confirm('¿Eliminar esta persona?');">Eliminar</button>
                                                </form>
                                            </td>
                                        </tr>
                                        <% } } else { %>
                                            <tr>
                                                <td colspan="3">No hay personas registradas.</td>
                                            </tr>
                                            <% } %>
                                </table>

                                <!-- 🔧 Script para cargar datos al formulario -->
                                <script>
                                    function cargarPersona(codigo, nombre) {
                                        document.getElementById("codigo").value = codigo;
                                        document.getElementById("nombre").value = nombre;
                                    }
                                </script>
                    </body>

                    </html>