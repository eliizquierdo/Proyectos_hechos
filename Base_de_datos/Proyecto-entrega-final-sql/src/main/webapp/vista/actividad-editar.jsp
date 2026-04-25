<%@ page contentType="text/html; charset=UTF-8" %> <%@ page
import="modelo.vo.  ActividadVO" %> <% String baseURL = request.getContextPath();
ActividadVO actividad = (ActividadVO) request.getAttribute("actividad"); %>
<!DOCTYPE html>
<html lang="es">
  <head>
    <meta charset="UTF-8" />
    <title>Editar actividad</title>
    <link rel="stylesheet" href="<%= baseURL %>/css/styles.css" />
  </head>
  <body>
    <div class="form-container">
      <h1>Editar actividad</h1>


      <form action="<%= baseURL %>/actividad" method="post">
        <input type="hidden" name="action" value="editar" />


        <label>id</label>
        <input
          type="number"
          name="id"
          value="<%= actividad.getId() %>"
          readonly
          required
        />


        <label>Nombre</label>
        <input
          type="text"
          name="nombre"
          value="<%= actividad.getNombre() %>"
          required
        />


        <label>horarios</label>
        <input
          type="text"
          name="horarios"
          value="<%= actividad.getHorarios() %>"
          required
        />


        <label>Fecha</label>
        <input
          type="text"
          name="fecha"
          value="<%= actividad.getFecha() %>"
          required
        />


    


        <button class="btn" type="submit">Actualizar</button>
        <a class="btn btn-secondary" href="<%= baseURL %>/actividad">Volver</a>
      </form>
    </div>
  </body>
</html>


