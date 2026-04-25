<%@ page contentType="text/html; charset=UTF-8" %> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">
  <head>
    <meta charset="UTF-8" />
    <title>Agregar Actividad</title>

    <%-- Se utiliza el path absoluto de la aplicación para que el CSS cargue
    correctamente --%>
    <link
      rel="stylesheet"
      href="${pageContext.request.contextPath}/css/styles.css"
    />
  </head>
  <body>
    <div class="form-container">
      <h1>Agregar Actividad</h1>

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

        <label>id</label>
        <input type="number" name="id" required <%-- Precarga el valor del
        objeto 'actividad' si existe --%> value="${requestScope.actividad.id}" />

        <label>Nombre</label>
        <input type="text" name="Nombre" required <%-- Precarga el valor del
        objeto 'actividad' si existe --%> value="${requestScope.actividad.nombre}" />

        <label>Dia</label>
        <input type="text" name="Dia" required <%-- Precarga el valor del
        objeto 'actividad' si existe --%> value="${requestScope.actividad.fecha}" />

        <label>Horarios</label>
        <input type="text" name="horarios" placeholder="Ej: 11:00 y 17:30 " required <%-- Precarga el valor del
        objeto 'actividad' si existe --%> value="${requestScope.usaurio.horarios}" />

        <button class="btn" type="submit">Guardar</button>
        <a
          class="btn btn-secondary"
          href="${pageContext.request.contextPath}/usuario"
          >Volver</a
        >
      </form>
    </div>
  </body>
</html>
