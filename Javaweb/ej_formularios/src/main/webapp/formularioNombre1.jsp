<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Formulario en JSP</title>
</head>
<body>
    <h1>Ingrese sus datos</h1>

    <form method="get">
        <label for="nombre">Nombre:</label>
        <input type="text" name="nombre" id="nombre" required />
        <br /><br />

        <label for="apellido">Apellido:</label>
        <input type="text" name="apellido" id="apellido" required />
        <br /><br />

        <label for="edad">Edad:</label>
        <input type="number" name="edad" id="edad" required />
        <br /><br />

        <label for="sabor">Elija su sabor de helado favorito:</label>
        <select name="sabor" id="sabor">
            <option value="Chocolate">Chocolate</option>
            <option value="Vainilla">Vainilla</option>
            <option value="Frutilla">Frutilla</option>
            <option value="Menta Granizada">Menta Granizada</option>
        </select>
        <br /><br />

        <input type="submit" value="Enviar" />
    </form>

    <%
        String nom = request.getParameter("nombre");
        String ape = request.getParameter("apellido");
        String edad = request.getParameter("edad");
        String sabor = request.getParameter("sabor");

        if (nom != null && ape != null && edad != null && sabor != null) {
            int edadI = Integer.parseInt(edad);
    %>
            <h2>Hola, <%= nom %> <%= ape %>!</h2>
            <p>Edad: <%= edad %></p>
            <p>Tu sabor favorito de helado es: <%= sabor %></p>
            <% if (edadI < 18) { %>
                <p>Y no puedes votar</p>
            <% } else { %>
                <p>Y puedes votar</p>
            <% } %>
    <%
        }
    %>
</body>
</html>
