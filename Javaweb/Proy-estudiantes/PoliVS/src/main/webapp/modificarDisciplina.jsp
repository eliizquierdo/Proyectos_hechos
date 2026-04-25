<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, modelo.vo.DisciplinaVO"%>
<!DOCTYPE html>
<html>
<head>
    <title>Modificar Disciplina</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <h2>Modificar Disciplina</h2>

    <%
        DisciplinaVO a = (DisciplinaVO) request.getAttribute("Disciplina");
    %>

    <form action="DisciplinaServlet" method="post">
        <label>Nombre:</label>
        <input type="text" name="nombre" value="<%= a.getnombre() %>" required><br>

        <label>Cupo:</label>
        <input type="number" name="cupo" max=25 value="<%= a.getcupo() %>" required><br>

        <input type="hidden" name="id" value="<%= a.getid() %>">
        <input type="hidden" name="accion" value="modificar">

        

        <button type="submit">Modificar</button>
    </form>

    <a href="index.jsp">Volver</a>
</body>
</html>