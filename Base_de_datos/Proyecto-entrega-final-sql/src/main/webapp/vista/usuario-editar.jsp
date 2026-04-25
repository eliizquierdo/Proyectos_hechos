<%@ page contentType="text/html; charset=UTF-8" %> <%@ page
import="modelo.vo.PersonaVO" %> <% String baseURL = request.getContextPath();
UsuarioVO usuario = (UsuarioVO) request.getAttribute("Usuario"); %>
<!DOCTYPE html>
<html lang="es">
  <head>
    <meta charset="UTF-8" />
    <title>Editar Usuario</title>
    <link rel="stylesheet" href="<%= baseURL %>/css/styles.css" />
  </head>
  <body>
    <div class="form-container">
      <h1>Editar Usuario</h1>


      <form action="<%= baseURL %>/usuario" method="post">
        <input type="hidden" name="action" value="editar" />


        <label>Cedula</label>
        <input
          type="number"
          name="cedula"
          value="<%= usuario.getCedula() %>"
          readonly
          required
        />


        <label>Nombre</label>
        <input
          type="text"
          name="nombre"
          value="<%= usuario.getNombre() %>"
          required
        />


        <label>Apellido</label>
        <input
          type="text"
          name="apellido"
          value="<%= usuario.getApellido() %>"
          required
        />


        <label>Fecha de Nacimiento</label>
        <input
          type="text"
          name="fecha de nacimiento"
          value="<%= usuario.getF_Nacimiento() %>"
          required
        />


        <label>Direccion</label>
        <input
          type="text"
          name="direccion"
          value="<%= usuario.getDireccion() %>"
          required
        />


        <label>Enfermedad</label>
        <input
          type="text"
          name="Enfermedad"
          value="<%= usuario.get() %>"
          required
        />


	<label>Mutualista</label>
        <input
          type="text"
          name="Mutualista"
          value="<%= usaurio.get() %>"
          required
        />


	<label>Adulto responsable</label>
        <input
          type="text"
          name="AdultPespondable"
          value="<%= usaurio.get() %>"
          required
        />

<label>Numero del Adulto</label>
        <input
          type="text"
          name="numAdult"
          value="<%= usaurio.get() %>"
          required
        />


        <button class="btn" type="submit">Actualizar</button>
        <a class="btn btn-secondary" href="<%= baseURL %>/usaurio">Volver</a>
      </form>
    </div>
  </body>
</html>


