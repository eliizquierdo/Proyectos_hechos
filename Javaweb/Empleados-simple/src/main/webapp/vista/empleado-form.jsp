<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="modelo.vo.EmpleadoVO" %>
<%@ page import="java.util.Arrays" %>
<%
  String baseURL = request.getContextPath();
  EmpleadoVO empleado = (EmpleadoVO) request.getAttribute("empleado");
  String[] departamentos = (String[]) request.getAttribute("departamentos");
  String[] idiomas = (String[]) request.getAttribute("idiomas");
  
  boolean esEdicion = empleado != null;
  String titulo = esEdicion ? "Editar Empleado" : "Nuevo Empleado";
  String action = esEdicion ? "actualizar" : "guardar";
%>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <title><%= titulo %></title>
  <link rel="stylesheet" href="<%= baseURL %>/css/empleado-form.css">
</head>
<body>
<div class="form-container">
  <h1 class="form-title"><%= titulo %></h1>
  
  <form action="<%= baseURL %>/empleado" method="post">
    <input type="hidden" name="action" value="<%= action %>">
    <% if (esEdicion) { %>
      <input type="hidden" name="id" value="<%= empleado.getId() %>">
    <% } %>
    
    <!-- Información Básica -->
    <div class="form-section">
      <h3 class="section-title">👤 Información Básica</h3>
      
      <div class="form-grid">
        <label class="form-label" for="nombre">Nombre Completo</label>
        <input type="text" id="nombre" name="nombre" class="form-input"
               value="<%= esEdicion ? empleado.getNombre() : "" %>" required>
        
        <label class="form-label" for="email">Email</label>
        <input type="email" id="email" name="email" class="form-input"
               value="<%= esEdicion ? empleado.getEmail() : "" %>" required>
        
        <label class="form-label" for="salario">Salario Anual ($)</label>
        <input type="number" id="salario" name="salario" class="form-input" min="0" step="1000"
               value="<%= esEdicion ? (int)empleado.getSalario() : "" %>">
        
        <label class="form-label">Género</label>
        <div class="radio-group">
          <div class="radio-item">
            <input type="radio" id="genero_masculino" name="genero" value="masculino"
                   <%= (esEdicion && "masculino".equals(empleado.getGenero())) ? "checked" : "" %>>
            <label for="genero_masculino">Masculino</label>
          </div>
          <div class="radio-item">
            <input type="radio" id="genero_femenino" name="genero" value="femenino"
                   <%= (esEdicion && "femenino".equals(empleado.getGenero())) ? "checked" : "" %>>
            <label for="genero_femenino">Femenino</label>
          </div>
          <div class="radio-item">
            <input type="radio" id="genero_otro" name="genero" value="otro"
                   <%= (esEdicion && "otro".equals(empleado.getGenero())) ? "checked" : "" %>>
            <label for="genero_otro">Otro</label>
          </div>
        </div>
      </div>
    </div>
    
    <!-- Información Laboral -->
    <div class="form-section">
      <h3 class="section-title">💼 Información Laboral</h3>
      
      <div class="form-grid">
        <label class="form-label" for="departamento">Departamento</label>
        <select id="departamento" name="departamento" class="form-select" required>
          <option value="">Seleccionar departamento...</option>
          <% for (String dept : departamentos) { %>
            <option value="<%= dept %>" 
                    <%= (esEdicion && dept.equals(empleado.getDepartamento())) ? "selected" : "" %>>
              <%= dept.substring(0,1).toUpperCase() + dept.substring(1) %>
            </option>
          <% } %>
        </select>
        
        <label class="form-label">Idiomas</label>
        <div>
          <select name="idiomas" multiple class="select-multiple">
            <% 
            String[] idiomasEmpleado = esEdicion ? empleado.getIdiomas() : new String[]{};
            for (String idioma : idiomas) { 
              boolean selected = esEdicion && Arrays.asList(idiomasEmpleado).contains(idioma);
            %>
              <option value="<%= idioma %>" <%= selected ? "selected" : "" %>>
                <%= idioma.substring(0,1).toUpperCase() + idioma.substring(1) %>
              </option>
            <% } %>
          </select>
          <div class="select-hint">Mantén presionado Ctrl (o Cmd) para seleccionar múltiples opciones</div>
        </div>
        
        <label class="form-label">Estado</label>
        <div class="checkbox-group">
          <div class="checkbox-item">
            <input type="checkbox" id="activo" name="activo" value="true"
                   <%= (esEdicion && empleado.isActivo()) ? "checked" : (!esEdicion ? "checked" : "") %>>
            <label for="activo">Empleado activo</label>
          </div>
        </div>
      </div>
    </div>
    
    <!-- Comentarios -->
    <div class="form-section">
      <h3 class="section-title">📝 Información Adicional</h3>
      
      <div class="form-grid">
        <label class="form-label" for="comentarios">Comentarios</label>
        <textarea id="comentarios" name="comentarios" class="form-textarea"
                  placeholder="Información adicional sobre el empleado..."><%= esEdicion ? empleado.getComentarios() : "" %></textarea>
      </div>
    </div>
    
    <!-- Botones -->
    <div class="form-actions">
      <button type="submit" class="btn btn-primary">
        <%= esEdicion ? "✅ Actualizar Empleado" : "✅ Guardar Empleado" %>
      </button>
      <a class="btn btn-secondary" href="<%= baseURL %>/empleado">
        ❌ Cancelar
      </a>
    </div>
  </form>
</div>

<script>
document.querySelector('form').addEventListener('submit', function(e) {
  const nombre = document.getElementById('nombre').value.trim();
  const email = document.getElementById('email').value.trim();
  const departamento = document.getElementById('departamento').value;
  
  if (!nombre || !email || !departamento) {
    e.preventDefault();
    alert('Por favor, completa todos los campos obligatorios.');
    return;
  }
});
</script>
</body>
</html>