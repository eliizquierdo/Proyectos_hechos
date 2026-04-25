<%@ page contentType="text/html; charset=UTF-8" %> <%@ page
import="modelo.vo.ProfesorVO" %> <% String baseURL = request.getContextPath();
ProfesorVO profesor = (ProfesorVO) request.getAttribute("profesor"); %>
<!DOCTYPE html>
<html lang="es">
  <head>
    <meta charset="UTF-8" />
    <title>Editar Profesor</title>
    <link rel="stylesheet" href="<%= baseURL %>/css/styles.css" />
  </head>
  <body>
    <div class="form-container">
      <h1>Editar Profesor</h1>


      <form action="<%= baseURL %>/persona" method="post">
        <input type="hidden" name="action" value="editar" />


        <label>Cedula</label>
        <input
          type="number"
          name="cedula"
          value="<%= profesor.getCedula() %>"
          readonly
          required
        />


        <label>Nombre</label>
        <input
          type="text"
          name="nombre"
          value="<%= profesor.getNombre() %>"
          required
        />


        <label>Apellido</label>
        <input
          type="text"
          name="apellido"
          value="<%= profesor.getApellido() %>"
          required
        />


        <label>Fecha de Nacimiento</label>
        <input
          type="text"
          name="fecha de nacimiento"
          value="<%= profesor.getF_Nacimiento() %>"
          required
        />


        <label>Direccion</label>
        <input
          type="text"
          name="direccion"
          value="<%= profesor.getDireccion() %>"
          required
        />


        <label>Enfermedad</label>
        <input
          type="text"
          name="Enfermedad"
          value="<%= profesor.get() %>"
          required
        />


	<label>Mutualista</label>
        <input
          type="text"
          name="Mutualista"
          value="<%= profesor.get() %>"
          required
        />


	<label>Carnet Salud</label>
        <input
          type="text"
          name="CarnetSalud"
          value="<%= profesor.get() %>"
          required
        />




        <button class="btn" type="submit">Actualizar</button>
        <a class="btn btn-secondary" href="<%= baseURL %>/profesor">Volver</a>
      </form>
    </div>
  </body>
</html>


