<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head><title>Productos</title></head>
<body>
<h1>📦 Lista de Productos</h1>
<a href="ProductoServlet?action=nuevo">➕ Nuevo producto</a>
<table border="1"><tr><th>ID</th><th>Nombre</th><th>Precio</th><th>Acciones</th></tr>
<c:forEach var="p" items="${listaProductos}">
<tr>
<td>${p.id}</td><td>${p.nombre}</td><td>${p.precio}</td>
<td>
<a href="ProductoServlet?action=editar&id=${p.id}">Editar</a>
<a href="ProductoServlet?action=eliminar&id=${p.id}" onclick="return confirm('¿Eliminar?')">Eliminar</a>
</td>
</tr>
</c:forEach>
</table>
</body></html>
