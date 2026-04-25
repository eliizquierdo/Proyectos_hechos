<%@ page contentType="text/html; charset=UTF-8" %> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">
  <head>
    <meta charset="UTF-8" />
    <title>Agregar Profesor</title>

    <%-- Se utiliza el path absoluto de la aplicación para que el CSS cargue
    correctamente --%>
    <link
      rel="stylesheet"
      href="${pageContext.request.contextPath}/css/styles.css"
    />
  </head>
  <body>
    <div class="form-container">
      <h1>Agregar Profesor</h1>

      <%-- Muestra el mensaje de error si el atributo 'error' existe en el
      request --%>
      <c:if test="${requestScope.error != null}">
        <div
          style="
            color: red;
            border: 1px solid red;
            padding: 10px;
            margin-bottom: 15px;
            background-color: #ffe8e8;
          "
        >
          <strong>Error:</strong> ${requestScope.error}
        </div>
      </c:if>

      <form action="${pageContext.request.contextPath}/usuario" method="post">
        <input type="hidden" name="action" value="agregar" />

        <label>cedula</label>
        <input type="number" name="Cedula" required <%-- Precarga el valor del
        objeto 'profesor' si existe --%> value="${requestScope.profesor.cedula}" />

        <label>Nombre</label>
        <input type="text" name="nombre" required <%-- Precarga el valor del
        objeto 'profesor' si existe --%> value="${requestScope.profesor.nombre}" />

        <label>Apellido</label>
        <input type="text" name="Apellido" required <%-- Precarga el valor del
        objeto 'profesor' si existe --%> value="${requestScope.profesor.apellido}" />

        <label>Fecha de nacimiento</label>
        <input type="text" name="Fecha de nacimiento" required <%-- Precarga el valor del
        objeto 'profesor' si existe --%> value="${requestScope.profesor.f_Nacimineto}" />

        <label>Direccion</label>
        <input type="text" name="Direccion" required <%-- Precarga el valor del
        objeto 'profesor' si existe --%> value="${requestScope.profesor.direccion}" />

        <label>Enfermedad</label>
        <input type="text" name="Enfermedad" required <%-- Precarga el valor del
        objeto 'profesor' si existe --%> value="${requestScope.profesor.enfermedad}" />

        <label>Mutualista</label>
        <input type="text" name="Mutialista" required <%-- Precarga el valor del
        objeto 'profesor' si existe --%> value="${requestScope.profesor.mutualista}" />

        <label>Carnet de Salud</label>
        <input type="text" name="Carnet de Salud" placeholder="si,no" required <%-- Precarga el valor del
        objeto 'Profesor' si existe --%> value="${requestScope.profesor.carnetSalud}" />

        <button class="btn" type="submit">Guardar</button>
        <a
          class="btn btn-secondary"
          href="${pageContext.request.contextPath}/profesor"
          >Volver</a
        >
      </form>
    </div>
  </body>
</html>
