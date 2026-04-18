<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Conversor</title>
</head>
<body>
    <div>
        <h2>Conversor de moneda</h2>
    </div>

    <form action="${pageContext.request.contextPath}/conversorServlet" method="get">
        Ingrese cantidad de dinero en $:
        <input type="number" name="dinero" required /><br><br>

        Desea calcular:
        <input type="radio" name="op" value="dolares" checked /> Dólares<br>
        <input type="radio" name="op" value="reales" /> Reales<br>
        <input type="radio" name="op" value="pesosargentinos" /> Pesos argentinos<br><br>

        <input type="submit" value="Calcular" />
    </form>
</body>
</html>
