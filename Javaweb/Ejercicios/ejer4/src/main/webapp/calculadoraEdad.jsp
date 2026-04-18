<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Calculadora de Edad</title>
     <% String baseURL = request.getContextPath(); %>
     <link rel="stylesheet" href="<%= baseURL %>/estilos.css" />
  </head>
  <body>
     <h1>Calculadora de Edad</h1>
     <div class="form-container">
    
    <form method="post">
      <label for="anio">Año de nacimiento:</label>
      <input type="number" name="anio" id="anio" required />
      <input type="submit" value="Calcular edad" />
    </form>
    </div>
   <% 
    String anioStr = request.getParameter("anio");
    if (anioStr != null &&!anioStr.isEmpty()) { 
        int anioNacimiento = Integer.parseInt(anioStr); 
        int anioActual = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
        int edad = anioActual - anioNacimiento; 
        if (edad >= 0 && edad <= 120) {
    %>
    <h1>Resultado</h1>
    <div class="form-container result-card">
    
    <p>Tenés <%= edad %> años.</p>
    <% 
      } else { 
    %>
    <p>El año ingresado no es válido.</p>
    <% 
      }
        if (edad >= 18) {
    %>
    <p>Tenés edad para votar.</p>
    <% 
      } else { 
    %>
    <p>No podes votar.</p>
    <% 
      }
      } %>
      </div>
  </body></html>

