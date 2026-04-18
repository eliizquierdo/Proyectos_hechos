<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.Arrays" %>
<%
    String baseURL = request.getContextPath();
    boolean isPost = "POST".equalsIgnoreCase(request.getMethod());

    String nombre = request.getParameter("nombre");
    String clase  = request.getParameter("clase");
    String[] habilidades = request.getParameterValues("habilidades");

    boolean showResult = isPost
        && nombre != null && !nombre.trim().isEmpty()
        && clase  != null && !clase.trim().isEmpty();
%>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8" />
  <title>Personaje Gamer</title>
  <meta name="viewport" content="width=device-width, initial-scale=1" />

  <!-- Fuentes 8‑bit -->
  <link rel="preconnect" href="https://fonts.googleapis.com">
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
  <link href="https://fonts.googleapis.com/css2?family=Press+Start+2P&family=VT323&display=swap" rel="stylesheet">

  <!-- CSS -->
  <link rel="stylesheet" href="<%= baseURL %>/estilos.css?v=7" />
</head>
<body>
  <h1>⚔️ Elegí tu personaje</h1>

  <div class="form-container">
    <form method="post" action="" autocomplete="on">
      <fieldset class="fieldset">
        <legend>Datos del personaje</legend>

        <!-- Nombre -->
        <label for="nombre">Tu nombre:</label>
        <input id="nombre" name="nombre" type="text"  required value="<%= nombre!=null?nombre:"" %>"/>

        <!-- Clase (radio) -->
        <label>Elegí clase:</label>
        <div class="radio-group">
          <label class="radio8"><input type="radio" name="clase" value="Guerrero" <%= "Guerrero".equals(clase)?"checked":"" %> required><span>Guerrero</span></label>
          <label class="radio8"><input type="radio" name="clase" value="Mago" <%= "Mago".equals(clase)?"checked":"" %>><span>Mago</span></label>
          <label class="radio8"><input type="radio" name="clase" value="Explorador" <%= "Explorador".equals(clase)?"checked":"" %>><span>Explorador</span></label>
          <label class="radio8"><input type="radio" name="clase" value="Ingeniero" <%= "Ingeniero".equals(clase)?"checked":"" %>><span>Ingeniero</span></label>
        </div>

        <!-- Habilidades (checkbox) -->
        <label>Seleccioná habilidades:</label>
        <div class="checkbox-group">
          <label class="chk8"><input type="checkbox" name="habilidades" value="Velocidad"  <%= habilidades!=null && Arrays.asList(habilidades).contains("Velocidad")?"checked":"" %>><span>Velocidad</span></label>
          <label class="chk8"><input type="checkbox" name="habilidades" value="Fuerza"     <%= habilidades!=null && Arrays.asList(habilidades).contains("Fuerza")?"checked":"" %>><span>Fuerza</span></label>
          <label class="chk8"><input type="checkbox" name="habilidades" value="Resistencia" <%= habilidades!=null && Arrays.asList(habilidades).contains("Resistencia")?"checked":"" %>><span>Resistencia</span></label>
          <label class="chk8"><input type="checkbox" name="habilidades" value="Magia"      <%= habilidades!=null && Arrays.asList(habilidades).contains("Magia")?"checked":"" %>><span>Magia</span></label>
          <label class="chk8"><input type="checkbox" name="habilidades" value="Sigilo"     <%= habilidades!=null && Arrays.asList(habilidades).contains("Sigilo")?"checked":"" %>><span>Sigilo</span></label>
          <label class="chk8"><input type="checkbox" name="habilidades" value="Precisión"  <%= habilidades!=null && Arrays.asList(habilidades).contains("Precisión")?"checked":"" %>><span>Precisión</span></label>
        </div>

        <input type="submit" value="Crear personaje" />
      </fieldset>
    </form>
  </div>

  <% if (showResult) { %>
    <div class="form-container result-card" aria-live="polite">
      <h2>🎮 Personaje creado</h2>
      <p><strong><%= nombre %></strong> es un <strong><%= clase %></strong> listo para la aventura.</p>
      <p>
        Habilidades:
        <%= (habilidades!=null && habilidades.length>0)
              ? String.join(", ", habilidades)
              : "sin habilidades seleccionadas" %>
      </p>
    </div>
  <% } %>
</body>
</html>
