<%@ page contentType="text/html;charset=UTF-8" language="java" %> <%@ taglib
prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>Formulario</title>
  </head>
  <body>
    <h1><c:out value="${producto != null ? 'Editar' : 'Nuevo'}" /> Producto</h1>
    <form action="ProductoServlet" method="post">
      <input
        type="hidden"
        name="action"
        value="${producto != null ? 'actualizar' : 'insertar'}"
      />
      <c:if test="${producto != null}"
        ><input type="hidden" name="id" value="${producto.id}"
      /></c:if>
      <p>
        Nombre:
        <input type="text" name="nombre" value="${producto.nombre}" required />
      </p>
      <p>
        Precio:
        <input
          type="number"
          step="0.01"
          name="precio"
          value="${producto.precio}"
          required
        />
      </p>
      <p>
        <input type="submit" value="Guardar" />
        <a href="ProductoServlet">Cancelar</a>
      </p>
    </form>
  </body>
</html>
