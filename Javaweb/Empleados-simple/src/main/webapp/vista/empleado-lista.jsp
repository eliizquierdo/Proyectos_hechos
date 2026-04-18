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
  <link rel="stylesheet" href="<%= baseURL %>/css/empleado-lista.css">
</head>
<body>
<div class="page-container">
  <h1 class="page-title">Gestión de Empleados</h1>
  
 
  <!-- Header de tabla -->
  <div class="table-header">
    <h2 class="table-title">Lista de Empleados</h2>
    <a href="<%= baseURL %>/empleado?action=nuevo" class="btn-add">
      + Agregar Empleado
    </a>
  </div>

  <!-- Tabla -->
  <div class="table-container">
    <table class="table">
      <thead>
        <tr>
          <th>ID</th>
          <th>Información Personal</th>
          <th>Departamento</th>
          <th>Salario</th>
          <th>Idiomas</th>
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
          <td>
            <div class="employee-id">#<%= emp.getId() %></div>
          </td>
          
          <td>
            <div class="employee-name"><%= emp.getNombre() %></div>
            <div class="employee-email"><%= emp.getEmail() %></div>
            <span class="badge badge-gender">
              <%= emp.getGenero().substring(0,1).toUpperCase() + emp.getGenero().substring(1) %>
            </span>
          </td>
          
          <td>
            <div class="department-name">
              <%= emp.getDepartamento() != null ? emp.getDepartamento().substring(0,1).toUpperCase() + emp.getDepartamento().substring(1) : "N/A" %>
            </div>
          </td>
          
          <td>
            <% if (emp.getSalario() > 0) { %>
              <div class="salary-amount">$<%= String.format("%,.0f", emp.getSalario()) %></div>
            <% } else { %>
              <div class="salary-na">No especificado</div>
            <% } %>
          </td>
          
          <td>
            <div class="languages-container">
              <% if (emp.getIdiomas() != null && emp.getIdiomas().length > 0) { %>
                <% for (String idioma : emp.getIdiomas()) { %>
                  <span class="badge badge-info"><%= idioma.substring(0,1).toUpperCase() + idioma.substring(1) %></span>
                <% } %>
              <% } else { %>
                <span class="employee-details">Ninguno</span>
              <% } %>
            </div>
          </td>
          
          <td>
            <span class="badge <%= emp.isActivo() ? "badge-success" : "badge-danger" %>">
              <%= emp.isActivo() ? "Activo" : "Inactivo" %>
            </span>
            <% if (emp.getComentarios() != null && !emp.getComentarios().trim().isEmpty()) { %>
              <div class="employee-details" style="margin-top: 8px;">
                <%= emp.getComentarios().length() > 40 ? emp.getComentarios().substring(0, 40) + "..." : emp.getComentarios() %>
              </div>
            <% } %>
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
          <td colspan="7" class="empty-state">
            <div class="empty-icon">📋</div>
            <div class="empty-title">No hay empleados registrados</div>
            <div class="empty-description">Comienza agregando el primer empleado al sistema</div>
            <a href="<%= baseURL %>/empleado?action=nuevo" class="btn-add">
              + Agregar el primer empleado
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
  <div class="table-summary">
    Mostrando <%= empleados.size() %> empleado<%= empleados.size() != 1 ? "s" : "" %> en total
  </div>
  <% } %>
  
  <!-- Consignas para estudiantes -->
  <div class="consignas-estudiantes">
    <h3>📚 Ejercicios para expandir la funcionalidad:</h3>
    <ol>
      <li><strong>Agregar columna "Cargo":</strong> Mostrar el cargo del empleado cuando se implemente el campo correspondiente en el VO</li>
      <li><strong>Agregar columna "Habilidades":</strong> Mostrar las habilidades técnicas como badges de colores cuando se implementen</li>
      <li><strong>Calcular edad automáticamente:</strong> Usar la fecha de nacimiento para calcular y mostrar la edad actual</li>
      <li><strong>Iconos de beneficios:</strong> Mostrar íconos para vehículo propio, disponibilidad de viajes, etc.</li>
      <li><strong>Filtros dinámicos:</strong> Agregar controles para filtrar por departamento, estado activo, rango salarial</li>
      <li><strong>Ordenamiento por columnas:</strong> Hacer clickeables los headers para ordenar por nombre, salario, departamento</li>
      <li><strong>Paginación:</strong> Implementar navegación por páginas cuando haya muchos empleados</li>
      <li><strong>Buscador en tiempo real:</strong> Agregar campo de búsqueda que filtre la tabla dinámicamente</li>
    </ol>
  </div>
</div>
</body>
</html>