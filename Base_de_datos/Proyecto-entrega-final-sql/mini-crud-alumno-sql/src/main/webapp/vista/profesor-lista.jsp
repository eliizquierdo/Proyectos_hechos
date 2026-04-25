<%@ page contentType="text/html; charset=UTF-8" %> <%@ page import="java.util.*,
modelo.vo.ProfesorVO" %> <% String baseURL = request.getContextPath();
List<ProfesorVO>
  lista = (List<ProfesorVO
    >) request.getAttribute("profesor"); %>
    <!DOCTYPE html>
    <html lang="es">
      <head>
        <meta charset="UTF-8" />
        <title>Listado de Profesores</title>
        <link rel="stylesheet" href="<%= baseURL %>/css/styles.css" />
      </head>
      <body>
        <div class="page-container">
          <h1>Listado de Profesores</h1>




          <div class="table-wrap">
            <table class="table">
              <thead>
                <tr>
                  <th>Cedula</th>
                  <th>Nombre</th>
                  <th>Apellido</th>
                  <th>Fecha de Nacimiento</th>
                  <th>Direccion</th>
                  <th>Enfermedad</th>
                  <th>Mutualista</th>
                  <th>Carnet Salud</th>
                  <th>Acciones</th>

                 
                </tr>
              </thead>
              <tbody>
                <% if (lista != null && !lista.isEmpty()) { for (ProfesorVO a :
                lista) { %>
                <tr>
                  <td><%= a.getCedula() %></td>
                  <td><%= a.getNombre() %></td>
                  <td><%= a.getApellido() %></td>
                  <td><%= a.getF_Nacimiento() %></td>
                  <td><%= a.getDireccion() %></td>
                  <td><%= a.getEnfermedad() %></td>
                  <td><%= a.getMutualista() %></td>
                  <td><%= a.carnetSalud() %></td>
                  <td class="actions">
                 
                    <a
                      class="btn btn-edit"
                      href="<%= baseURL %>/profesor?action=editar&id=<%= a.getCedula() %>"
                      >Editar</a
                    >
                    <a
                      class="btn btn-danger"
                      href="<%= baseURL %>/profesor?action=eliminar&id=<%= a.getCedula() %>"
                      onclick="return confirm('¿Eliminar profesor?');"
                      >Eliminar</a
                    >
                  </td>
                </tr>
                <% } } else { %>
                <tr>
                  <td colspan="4">No hay profesores cargados.</td>
                </tr>
                <% } %>
              </tbody>
            </table>
          </div>




          <a class="btn" href="<%= baseURL %>/profesor?action=agregar"
            >Agregar profesor</a
          >
        </div>
      </body>
    </html></ProfesorVO
  ></ProfesorVO
>






