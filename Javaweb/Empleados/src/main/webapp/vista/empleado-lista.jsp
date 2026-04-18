<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="modelo.vo.EmpleadoVO" %>
<%@ page import="java.util.Arrays" %>
<%
  String baseURL = request.getContextPath();
  List<EmpleadoVO> empleados = (List<EmpleadoVO>) request.getAttribute("empleados");
%>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <title>Gestión de Empleados</title>
  <link rel="stylesheet" href="<%= baseURL %>/css/styles.css">
</head>
<body>
<div class="page-container">
  <h1>Gestión de Empleados</h1>
  
  <!-- Estadísticas rápidas -->
  <div class="stats-cards">
    <div class="stat-card">
      <div class="stat-number"><%= empleados.size() %></div>
      <div class="stat-label">Total Empleados</div>
    </div>
    <div class="stat-card">
      <div class="stat-number">
        <%
          int empleadosActivos = 0;
          for (EmpleadoVO emp : empleados) {
            if (emp.isActivo()) {
              empleadosActivos++;
            }
          }
        %>
        <%= empleadosActivos %>
      </div>
      <div class="stat-label">Empleados Activos</div>
    </div>
    <div class="stat-card">
      <div class="stat-number">
        <%
          java.util.Set<String> departamentosUnicos = new java.util.HashSet<String>();
          for (EmpleadoVO emp : empleados) {
            if (emp.getDepartamento() != null && !emp.getDepartamento().isEmpty()) {
              departamentosUnicos.add(emp.getDepartamento());
            }
          }
        %>
        <%= departamentosUnicos.size() %>
      </div>
      <div class="stat-label">Departamentos</div>
    </div>
  </div>
  
  <!-- Acciones de la tabla -->
  <div class="table-actions">
    <h2>Lista de Empleados</h2>
    <a class="btn" href="<%= baseURL %>/empleado?action=nuevo">Agregar Empleado</a>
  </div>

  <div class="table-wrap">
    <table class="table">
      <thead>
        <tr>
          <th>ID</th>
          <th>Información Personal</th>
          <th>Puesto</th>
          <th>Salario</th>
          <th>Idiomas</th>
          <th>Habilidades</th>
          <th>Estado</th>
          <th>Acciones</th>
        </tr>
      </thead>
      <tbody>
      <%
        if (empleados != null && !empleados.isEmpty()) {
          for (EmpleadoVO emp : empleados) {
      %>
        <tr>
          <td><strong>#<%= emp.getId() %></strong></td>
          
          <td>
            <div><strong><%= emp.getNombre() %></strong></div>
            <div class="employee-details">
              <%= emp.getEmail() %><br>
              <span class="badge badge-info">
                <%= emp.getGenero().substring(0,1).toUpperCase() + emp.getGenero().substring(1) %>
              </span>
              <%= emp.getTurno() != null ? " • " + emp.getTurno().substring(0,1).toUpperCase() + emp.getTurno().substring(1) : "" %>
            </div>
          </td>
          
          <td>
            <div><strong><%= emp.getCargo() != null ? emp.getCargo().substring(0,1).toUpperCase() + emp.getCargo().substring(1) : "N/A" %></strong></div>
            <div class="employee-details">
              Dpto: <%= emp.getDepartamento() != null ? emp.getDepartamento().substring(0,1).toUpperCase() + emp.getDepartamento().substring(1) : "N/A" %>
              <% if (emp.getNivelEducacion() != null) { %>
                <br><%= emp.getNivelEducacion().substring(0,1).toUpperCase() + emp.getNivelEducacion().substring(1) %>
              <% } %>
            </div>
          </td>
          
          <td>
            <% if (emp.getSalario() > 0) { %>
              <strong>$<%= String.format("%,.0f", emp.getSalario()) %></strong>
            <% } else { %>
              <span class="employee-details">No especificado</span>
            <% } %>
          </td>
          
          <td>
            <% if (emp.getIdiomas() != null && emp.getIdiomas().length > 0) { %>
              <% for (String idioma : emp.getIdiomas()) { %>
                <span class="badge badge-info"><%= idioma.substring(0,1).toUpperCase() + idioma.substring(1) %></span><br>
              <% } %>
            <% } else { %>
              <span class="employee-details">Ninguno</span>
            <% } %>
          </td>
          
          <td>
            <% if (emp.getHabilidades() != null && emp.getHabilidades().length > 0) { %>
              <div class="skills-list">
                <% for (String skill : emp.getHabilidades()) { %>
                  <span class="skill-tag"><%= skill %></span>
                <% } %>
              </div>
            <% } else { %>
              <span class="employee-details">Ninguna</span>
            <% } %>
          </td>
          
          <td>
            <span class="badge <%= emp.isActivo() ? "badge-success" : "badge-danger" %>">
              <%= emp.isActivo() ? "Activo" : "Inactivo" %>
            </span>
            <div class="employee-details employee-icons">
              <% if (emp.isTieneVehiculo()) { %>
                🚗 Vehículo<br>
              <% } %>
              <% if (emp.isDisponibleViajes()) { %>
                ✈️ Viajes
              <% } %>
            </div>
          </td>
          
          <td class="actions">
            <a class="btn btn-edit" 
               href="<%= baseURL %>/empleado?action=editar&id=<%= emp.getId() %>">
              Editar
            </a>
            
            <form action="<%= baseURL %>/empleado" method="post" class="inline-form">
              <input type="hidden" name="action" value="eliminar">
              <input type="hidden" name="id" value="<%= emp.getId() %>">
              <button type="submit" class="btn btn-danger"
                      onclick="return confirm('¿Eliminar el empleado <%= emp.getNombre() %>?');">
                Eliminar
              </button>
            </form>
          </td>
        </tr>
      <%
          }
        } else {
      %>
        <tr>
          <td colspan="8" class="lista-empty-state">
            <div class="lista-empty-icon">📋</div>
            No hay empleados registrados.<br>
            <a href="<%= baseURL %>/empleado?action=nuevo" class="btn btn-main">
              Agregar el primer empleado
            </a>
          </td>
        </tr>
      <%
        }
      %>
      </tbody>
    </table>
  </div>
  
  <% if (empleados != null && !empleados.isEmpty()) { %>
  <div class="lista-summary">
    Mostrando <%= empleados.size() %> empleado<%= empleados.size() != 1 ? "s" : "" %> en total
  </div>
  <% } %>
</div>
</body>
</html>