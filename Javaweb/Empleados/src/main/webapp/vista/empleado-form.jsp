<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="modelo.vo.EmpleadoVO" %>
<%@ page import="java.util.Arrays" %>
<%
  String baseURL = request.getContextPath();
  EmpleadoVO empleado = (EmpleadoVO) request.getAttribute("empleado");
  String[] departamentos = (String[]) request.getAttribute("departamentos");
  String[] cargos = (String[]) request.getAttribute("cargos");
  String[] idiomas = (String[]) request.getAttribute("idiomas");
  String[] habilidades = (String[]) request.getAttribute("habilidades");
  
  boolean esEdicion = empleado != null;
  String titulo = esEdicion ? "Editar Empleado" : "Nuevo Empleado";
  String action = esEdicion ? "actualizar" : "guardar";
%>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <title><%= titulo %></title>
  <link rel="stylesheet" href="<%= baseURL %>/css/styles.css">
</head>
<body>
<div class="form-container">
  <h1><%= titulo %></h1>
  
  <form action="<%= baseURL %>/empleado" method="post">
    <input type="hidden" name="action" value="<%= action %>">
    <% if (esEdicion) { %>
      <input type="hidden" name="id" value="<%= empleado.getId() %>">
    <% } %>
    
    <!-- ===================== INFORMACIÓN BÁSICA ===================== -->
    <div class="form-section form-wide">
      <h3>📋 Información Básica</h3>
      
      <label for="nombre">Nombre Completo</label>
      <input type="text" id="nombre" name="nombre" 
             value="<%= esEdicion ? empleado.getNombre() : "" %>" required>
      
      <label for="email">Email</label>
      <input type="email" id="email" name="email" 
             value="<%= esEdicion ? empleado.getEmail() : "" %>" required>
      
      <label for="fechaNacimiento">Fecha de Nacimiento</label>
      <input type="date" id="fechaNacimiento" name="fechaNacimiento" 
             value="<%= esEdicion ? empleado.getFechaNacimiento() : "" %>">
      
      <label>Género</label>
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
    
    <!-- ===================== INFORMACIÓN LABORAL ===================== -->
    <div class="form-section form-wide">
      <h3>💼 Información Laboral</h3>
      
      <label for="departamento">Departamento</label>
      <select id="departamento" name="departamento" required>
        <option value="">Seleccionar departamento...</option>
        <% for (String dept : departamentos) { %>
          <option value="<%= dept %>" 
                  <%= (esEdicion && dept.equals(empleado.getDepartamento())) ? "selected" : "" %>>
            <%= dept.substring(0,1).toUpperCase() + dept.substring(1) %>
          </option>
        <% } %>
      </select>
      
      <label for="cargo">Cargo</label>
      <select id="cargo" name="cargo" required>
        <option value="">Seleccionar cargo...</option>
        <% for (String car : cargos) { %>
          <option value="<%= car %>" 
                  <%= (esEdicion && car.equals(empleado.getCargo())) ? "selected" : "" %>>
            <%= car.substring(0,1).toUpperCase() + car.substring(1) %>
          </option>
        <% } %>
      </select>
      
      <label for="salario">Salario Anual ($)</label>
      <input type="number" id="salario" name="salario" min="0" step="1000"
             value="<%= esEdicion ? (int)empleado.getSalario() : "" %>">
      
      <label>Turno de Trabajo</label>
      <div class="radio-group">
        <div class="radio-item">
          <input type="radio" id="turno_mañana" name="turno" value="mañana"
                 <%= (esEdicion && "mañana".equals(empleado.getTurno())) ? "checked" : "" %>>
          <label for="turno_mañana">Mañana (6:00 - 14:00)</label>
        </div>
        <div class="radio-item">
          <input type="radio" id="turno_tarde" name="turno" value="tarde"
                 <%= (esEdicion && "tarde".equals(empleado.getTurno())) ? "checked" : "" %>>
          <label for="turno_tarde">Tarde (14:00 - 22:00)</label>
        </div>
        <div class="radio-item">
          <input type="radio" id="turno_noche" name="turno" value="noche"
                 <%= (esEdicion && "noche".equals(empleado.getTurno())) ? "checked" : "" %>>
          <label for="turno_noche">Noche (22:00 - 6:00)</label>
        </div>
        <div class="radio-item">
          <input type="radio" id="turno_completo" name="turno" value="completo"
                 <%= (esEdicion && "completo".equals(empleado.getTurno())) ? "checked" : "" %>>
          <label for="turno_completo">Tiempo Completo (8:00 - 17:00)</label>
        </div>
      </div>
      
      <label for="nivelEducacion">Nivel de Educación</label>
      <select id="nivelEducacion" name="nivelEducacion">
        <option value="">Seleccionar nivel...</option>
        <option value="secundario" <%= (esEdicion && "secundario".equals(empleado.getNivelEducacion())) ? "selected" : "" %>>
          Secundario
        </option>
        <option value="tecnico" <%= (esEdicion && "tecnico".equals(empleado.getNivelEducacion())) ? "selected" : "" %>>
          Técnico
        </option>
        <option value="universitario" <%= (esEdicion && "universitario".equals(empleado.getNivelEducacion())) ? "selected" : "" %>>
          Universitario
        </option>
        <option value="posgrado" <%= (esEdicion && "posgrado".equals(empleado.getNivelEducacion())) ? "selected" : "" %>>
          Posgrado
        </option>
        <option value="doctorado" <%= (esEdicion && "doctorado".equals(empleado.getNivelEducacion())) ? "selected" : "" %>>
          Doctorado
        </option>
      </select>
    </div>
    
    <!-- ===================== IDIOMAS Y HABILIDADES ===================== -->
    <div class="form-section form-wide">
      <h3>🌍 Idiomas y Habilidades</h3>
      
      <label>Idiomas (Selección múltiple)</label>
      <select name="idiomas" multiple size="4" class="select-multiple">
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
      <small class="select-hint">Mantén presionado Ctrl (o Cmd) para seleccionar múltiples opciones</small>
      
      <label>Habilidades Técnicas</label>
      <div class="multi-select">
        <% 
        String[] habilidadesEmpleado = esEdicion ? empleado.getHabilidades() : new String[]{};
        for (String habilidad : habilidades) { 
          boolean checked = esEdicion && Arrays.asList(habilidadesEmpleado).contains(habilidad);
        %>
          <div class="checkbox-item">
            <input type="checkbox" id="hab_<%= habilidad %>" name="habilidades" value="<%= habilidad %>"
                   <%= checked ? "checked" : "" %>>
            <label for="hab_<%= habilidad %>">
              <%= habilidad.substring(0,1).toUpperCase() + habilidad.substring(1) %>
            </label>
          </div>
        <% } %>
      </div>
    </div>
    
    <!-- ===================== PREFERENCIAS ===================== -->
    <div class="form-section form-wide">
      <h3>⚙️ Preferencias y Estado</h3>
      
      <div></div>
      <div class="checkbox-group">
        <div class="checkbox-item">
          <input type="checkbox" id="activo" name="activo" value="true"
                 <%= (esEdicion && empleado.isActivo()) ? "checked" : (!esEdicion ? "checked" : "") %>>
          <label for="activo">Empleado activo</label>
        </div>
        
        <div class="checkbox-item">
          <input type="checkbox" id="tieneVehiculo" name="tieneVehiculo" value="true"
                 <%= (esEdicion && empleado.isTieneVehiculo()) ? "checked" : "" %>>
          <label for="tieneVehiculo">Tiene vehículo propio</label>
        </div>
        
        <div class="checkbox-item">
          <input type="checkbox" id="disponibleViajes" name="disponibleViajes" value="true"
                 <%= (esEdicion && empleado.isDisponibleViajes()) ? "checked" : "" %>>
          <label for="disponibleViajes">Disponible para viajes de trabajo</label>
        </div>
      </div>
    </div>
    
    <!-- ===================== COMENTARIOS ADICIONALES ===================== -->
    <div class="form-section form-wide">
      <h3>📝 Comentarios Adicionales</h3>
      
      <label for="comentarios">Observaciones</label>
      <textarea id="comentarios" name="comentarios" 
                placeholder="Información adicional sobre el empleado, experiencia previa, certificaciones, etc."><%= esEdicion ? empleado.getComentarios() : "" %></textarea>
    </div>
    
    <!-- ===================== BOTONES DE ACCIÓN ===================== -->
    <div></div>
    <div class="form-actions">
      <button type="submit" class="btn">
        <%= esEdicion ? "Actualizar Empleado" : "Guardar Empleado" %>
      </button>
      <a class="btn btn-secondary" href="<%= baseURL %>/empleado">Cancelar</a>
    </div>
  </form>
</div>

<script>
// Validación básica del formulario
document.querySelector('form').addEventListener('submit', function(e) {
  const nombre = document.getElementById('nombre').value.trim();
  const email = document.getElementById('email').value.trim();
  const departamento = document.getElementById('departamento').value;
  const cargo = document.getElementById('cargo').value;
  
  if (!nombre || !email || !departamento || !cargo) {
    e.preventDefault();
    alert('Por favor, completa todos los campos obligatorios.');
    return;
  }
  
  // Validar que al menos un idioma esté seleccionado
  const idiomas = document.querySelectorAll('select[name="idiomas"] option:checked');
  if (idiomas.length === 0) {
    e.preventDefault();
    alert('Selecciona al menos un idioma.');
    return;
  }
  
  // Validar que al menos una habilidad esté seleccionada
  const habilidades = document.querySelectorAll('input[name="habilidades"]:checked');
  if (habilidades.length === 0) {
    e.preventDefault();
    alert('Selecciona al menos una habilidad.');
    return;
  }
});

// Mejorar UX del select múltiple
document.querySelector('select[multiple]').addEventListener('change', function() {
  const selected = this.querySelectorAll('option:checked');
  const count = selected.length;
  const hint = this.nextElementSibling;
  
  if (count > 0) {
    hint.textContent = `${count} idioma${count > 1 ? 's' : ''} seleccionado${count > 1 ? 's' : ''}`;
    hint.style.color = '#16a34a';
  } else {
    hint.textContent = 'Mantén presionado Ctrl (o Cmd) para seleccionar múltiples opciones';
    hint.style.color = '#6b7280';
  }
});
</script>
</body>
</html>
  
    
   