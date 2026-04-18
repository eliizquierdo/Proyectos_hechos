<%@ page contentType="text/html; charset=UTF-8" %>
<html>
  <head>
    <title>
        Personaje Gamer
    </title>
    <% String baseURL = request.getContextPath(); %>
    <link rel="stylesheet" href="<%= baseURL %>/estilos.css?v=4" />
  </head>
  <body>
    <h1>⚔️ Elegí tu personaje</h1>
    
    <div class="form-container">
    <form method="post">
      Tu nombre: <input type="text" name="nombre"><br>
      Elegí clase:
      <select name="clase">
        <option>Guerrero</option>
        <option>Mago</option>
        <option>Explorador</option>
        <option>Ingeniero</option>
      </select><br>
      <input type="submit" value="Crear personaje">
    </form>
</div>
    <% 
      String nombre = request.getParameter("nombre");
      String clase = request.getParameter("clase");

      if(nombre != null && clase != null) {
    %>
    <div class="form-container result-card">
      <h2>🎮 Personaje creado</h2>
      <p><strong><%= nombre %></strong> es un <strong><%= clase %></strong> listo para la aventura.</p>
    <% } %>
    </div>
  </body>
</html>

