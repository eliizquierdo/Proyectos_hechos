<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="modelo.vo.PersonaVO" %>
<%
    // Definiciones y recuperación de datos
    String baseURL = request.getContextPath();
    List<PersonaVO> listaPersonas = (List<PersonaVO>) request.getAttribute("personas");
    
    // Recuperar el mensaje (Flash Message movido de Sesión a Request)
    String mensaje = (String) request.getAttribute("mensaje"); 
%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Listado de Personas</title>
    <link rel="stylesheet" href="<%= baseURL %>/css/styles.css">
</head>
<body>
<div class="page-container">
    <h1>Listado de Personas</h1>

    <%
        // Lógica para mostrar el mensaje Flash (éxito o error de DAO)
        if (mensaje != null) {
            // Mensaje de éxito después de agregar (configurado en el Servlet)
            if (mensaje.startsWith("Persona '") && mensaje.endsWith("' guardada exitosamente.")) {
    %>
                <div class="msg-success" style="padding: 10px; margin-bottom: 15px; border: 1px solid #c3e6cb; background-color: #d4edda; color: #155724; border-radius: 4px;">
                    <strong>✅ Éxito:</strong> <%= mensaje %>
                </div>
    <%
            // Mensaje de error (Error de DAO, formato, etc., que se redirigió aquí)
            } else if (mensaje.startsWith("Error:")) { 
    %>
                <div class="msg-error" style="padding: 10px; margin-bottom: 15px; border: 1px solid #f5c6cb; background-color: #f8d7da; color: #721c24; border-radius: 4px;">
                    <strong>❌ Error:</strong> <%= mensaje %>
                </div>
    <%
            }
        }
    %>

    <div class="table-wrap">
        <table class="table">
            <thead>
                <tr>
                    <th>Código</th>
                    <th>Nombre</th>
                    <th>Acciones</th>
                </tr>
            </thead>
            <tbody>
            <%
                if (listaPersonas != null && !listaPersonas.isEmpty()) {
                  for (PersonaVO p : listaPersonas) {
            %>
                <tr>
                    <td><%= p.getCodigo() %></td>
                    <td><%= p.getNombre() %></td>
                    <td class="actions">
                        <a class="btn btn-edit" 
                           href="<%= baseURL %>/persona?action=cargarEditar&codigo=<%= p.getCodigo() %>"
                           >Editar
                        </a>
                        
                        <form action="<%= baseURL %>/persona?action=eliminar" method="post" style="display: inline;">
                            <input type="hidden" name="codigo" value="<%= p.getCodigo() %>">
                            <button type="submit" class="btn btn-danger"
                                    onclick="return confirm('¿Eliminar el registro <%= p.getNombre() %>?');">
                                Eliminar
                            </button>
                        </form>
                    </td>
                </tr>
            <%
                  }
                } else {
            %>
                <tr>
                    <td colspan="3" style="text-align: center; color: #6b7280; padding: 15px;">
                        No hay personas registradas
                    </td>
                </tr>
            <%
                }
            %>
            </tbody>
        </table>
    </div>

    <div class="section-gap" style="margin-top: 20px;">
        <a class="btn" href="<%= baseURL %>/persona?action=agregar">Agregar Persona</a>
    </div>
</div>
</body>
</html>