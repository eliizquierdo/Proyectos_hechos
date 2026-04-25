<%@ page contentType="text/html; charset=UTF-8" %> <%@ page import="java.util.*,
modelo.vo.ActividadVO" %> <% String baseURL = request.getContextPath();
List<ActividadVO>
  lista = (List<ActividadVO
    >) request.getAttribute("actividad"); %>
    <!DOCTYPE html>
    <html lang="es">
      <head>
        <meta charset="UTF-8" />
        <title>Listado de Actividades</title>
        <link rel="stylesheet" href="<%= baseURL %>/css/styles.css" />
      </head>
      <body>
        <div class="page-container">
          <h1>Listado de Actividades</h1>


          <div class="table-wrap">
            <table class="table">
              <thead>
                <tr>
                  <th>id</th>
                  <th>Nombre</th>
                  <th>horarios</th>
                  <th>Fecha</th>
                  
                </tr>
              </thead>
              <tbody>
                <% if (lista != null && !lista.isEmpty()) { for (ActividadVO a :
                lista) { %>
                <tr>
                  <td><%= a.getId() %></td>
                  <td><%= a.getNombre() %></td>
                  <td><%= a.getHorarios() %></td>
                  <td><%= a.getFecha() %></td>
                  <td class="actions">
                    <a
                      class="btn btn-edit"
                      href="<%= baseURL %>/actividad?action=editar&id=<%= a.getId() %>"
                      >Editar</a
                    >
                    <a
                      class="btn btn-danger"
                      href="<%= baseURL %>/usuario?action=eliminar&id=<%= a.getId() %>"
                      onclick="return confirm('¿Eliminar actividad?');"
                      >Eliminar</a
                    >
                  </td>
                </tr>
                <% } } else { %>
                <tr>
                  <td colspan="4">No hay actividades cargados.</td>
                </tr>
                <% } %>
              </tbody>
            </table>
          </div>


          <a class="btn" href="<%= baseURL %>/actividad?action=agregar"
            >Agregar actividad</a
          >
        </div>
      </body>
    </html></ActividadVO
  ></ActividadVO
>


