<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="java.util.Calendar" %>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8" />
  <title>Calculadora de Edad</title>
  <!-- Enlace a hoja de estilos externa 
  este es un comentario de varia lineas-->  
  <link rel="stylesheet" href="estilo.css">
</head>
<body>
<div class="page">
  <h1>¿Cuántos años tenés?</h1>

  <form method="get">
    <label for="anio">Año de nacimiento:</label>
    <input type="number" name="anio" id="anio" required placeholder="ej. 2007" />
    <input type="submit" value="Calcular edad" />
  </form>

  <%
    String anioStr = request.getParameter("anio");
    if (anioStr != null && anioStr.trim().length() > 0) {
        String mensaje = "";
        try {
            int anioNacimiento = Integer.parseInt(anioStr.trim());
            int anioActual = Calendar.getInstance().get(Calendar.YEAR);
            int edad = anioActual - anioNacimiento;

            boolean rangoAnioValido = (anioNacimiento >= 1900 && anioNacimiento <= anioActual);
            boolean rangoEdadValido = (edad >= 0 && edad <= 120);

            if (rangoAnioValido && rangoEdadValido) {
  %>
              <p class="ok">Tenés <strong><%= edad %></strong> años.</p>
  <%
                if (edad >= 18) {
                    mensaje = "Podés votar.";
                } else {
                    mensaje = "Todavía no podés votar.";
                }
  %>
              <p class="ok"><%= mensaje %></p>
  <%
            } else {
  %>
              <p class="err">El año ingresado no es válido.</p>
  <%
            }
        } catch (NumberFormatException e) {
  %>
            <p class="err">Ingresá un número de año válido.</p>
  <%
        }
    }
  %>
</div>
</body>
</html>
