<%@ page contentType="text/html; charset=UTF-8" %> <%@ page import="java.util.*,
modelo.vo.UsuarioVO" %> <% String baseURL = request.getContextPath();
List<UsuarioVO>
  lista = (List<UsuarioVO
    >) request.getAttribute("usuario"); %>
    <!DOCTYPE html>
    <html lang="es">
      <head>
        <meta charset="UTF-8" />
        <title>Listado de Usuarios</title>
        <link rel="stylesheet" href="<%= baseURL %>/css/styles.css" />
      </head>
      <body>
        <div class="page-container">
          <h1>Listado de Usuarios</h1>


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
                  <th>Adulto Responsable</th>
                  <th>Numero del Adulto<th>
                  <th>Acciones</th>
                </tr>
              </thead>
              <tbody>
                <% if (lista != null && !lista.isEmpty()) { for (UsuarioVO a :
                lista) { %>
                <tr>
                  <td><%= a.getCedula() %></td>
                  <td><%= a.getNombre() %></td>
                  <td><%= a.getApellido() %></td>
                  <td><%= a.getF_Nacimiento() %></td>
                  <td><%= a.getDireccion() %></td>
                  <td><%= a.getEnfermedad() %></td>
                  <td><%= a.getMutualista() %></td>
                  <td><%= a.getAdultPresponsable() %></td>
                  <td><%= a.getNumAdult() %></td>
                  <td class="actions">
                    <a
                      class="btn btn-edit"
                      href="<%= baseURL %>/usuario?action=editar&id=<%= a.getCedula() %>"
                      >Editar</a
                    >
                    <a
                      class="btn btn-danger"
                      href="<%= baseURL %>/usuario?action=eliminar&id=<%= a.getCedula() %>"
                      onclick="return confirm('¿Eliminar usuario?');"
                      >Eliminar</a
                    >
                  </td>
                </tr>
                <% } } else { %>
                <tr>
                  <td colspan="4">No hay usuarios cargados.</td>
                </tr>
                <% } %>
              </tbody>
            </table>
          </div>


          <a class="btn" href="<%= baseURL %>/usuario?action=agregar"
            >Agregar usuario</a
          >
        </div>
      </body>
    </html></UsuarioVO
  ></UsuarioVO
>


