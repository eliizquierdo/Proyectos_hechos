<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*, com.davidbellerati.vo.TeacherVO" %>

<!DOCTYPE html>
<html>
<head>
    <title>Polideportivo | Profesores</title>
    <style>
        body { font-family: 'Inter', sans-serif; padding: 20px; background-color: #f8f9fa; }
        h1 { color: #212529; margin-bottom: 25px; text-align: center; }
        table { width: 95%; max-width: 1400px; margin: 0 auto 30px auto; border-collapse: collapse; font-size: 13px; box-shadow: 0 4px 8px rgba(0,0,0,0.1); border-radius: 8px; overflow: hidden; }
        table tr { display: grid; grid-template-columns: 3fr 1.5fr 2fr 1.5fr 1.5fr 2fr 3fr 1fr; }
        th, td { border: 1px solid #dee2e6; padding: 10px 8px; text-align: left; vertical-align: middle; border-left: none; border-right: none; }
        th { background-color: #e9ecef; color: #495057; font-weight: 600; }
        input[type="text"], input[type="number"], input[type="date"] { width: 100%; padding: 6px; box-sizing: border-box; border: 1px solid #ced4da; border-radius: 4px; transition: border-color 0.2s; }
        input[type="text"]:focus, input[type="number"]:focus, input[type="date"]:focus { border-color: #007bff; outline: none; box-shadow: 0 0 0 0.1rem rgba(0, 123, 255, 0.25); }
        button { font-size: 13px; cursor: pointer; padding: 8px 10px; border-radius: 6px; border: none; margin-right: 5px; transition: background-color 0.2s, transform 0.1s; white-space: nowrap; }
        button:active { transform: scale(0.98); }
        .btn-blue { background-color: #007bff; color: white; }
        .btn-blue:hover { background-color: #0056b3; }
        .btn-red { background-color: #dc3545; color: white; }
        .btn-red:hover { background-color: #c82333; }
        .button-group-top { text-align: center; margin-top: 20px; display: flex; justify-content: center; gap: 15px; }
        .button-group-bottom { margin-top: 30px; text-align: left; }
        .error-message { margin: 15px auto; width: fit-content; padding: 10px 20px; border: 1px solid #f5c6cb; background-color: #f8d7da; color: #721c24; border-radius: 5px; font-weight: bold; }
        .add-row-header td { background-color: #e9ecef; text-align: center; font-weight: bold; color: #495057; grid-column: 1 / span 8; }
        @media (max-width: 900px) { table { width: 100%; overflow-x: auto; } table tr { display: table-row; } th, td { display: table-cell; min-width: 120px; } .add-row-header td { display: table-cell; min-width: auto; } }
    </style>
</head>

<body>
<h1>Polideportivo | Profesores</h1>

<%
    String errorMessage = (String) request.getAttribute("errorMessage");
    if (errorMessage != null) {
%>
    <div class="error-message"><%= errorMessage %></div>
<%
    }
%>

<form action="teacher" method="post" id="teacherForm">
    <input type="hidden" name="action" value="saveAllRows">
    <input type="hidden" id="deleteId" name="id" value="">
    <table>
        <tr>
            <th>Nombre</th>
            <th>Cédula</th>
            <th>Fecha de nacimiento</th>
            <th>Teléfono</th>
            <th>Salario</th>
            <th>Servicio de Emergencias</th>
            <th>Dirección</th>
            <th>Acciones</th>
        </tr>

<%
    List<TeacherVO> teachers = (List<TeacherVO>) request.getAttribute("showList");
    if (teachers != null && !teachers.isEmpty()) {
        for (TeacherVO t : teachers) {
%>
        <tr>
            <td><input type="text" name="name_<%= t.getId() %>" value="<%= t.getName() %>" required></td>
            <td><input type="number" name="ci_<%= t.getId() %>" value="<%= t.getCI() %>" required></td>
            <td><input type="date" name="dateOfBirth_<%= t.getId() %>" value="<%= t.getDateOfBirth() %>" required></td>
            <td><input type="number" name="phoneNumber_<%= t.getId() %>" value="<%= t.getPhoneNumber() %>" required></td>
            <td><input type="number" name="salary_<%= t.getId() %>" value="<%= t.getSalary() %>" required></td>
            <td><input type="text" name="emergencyService_<%= t.getId() %>" value="<%= t.getEmergencyService() %>"></td>
            <td><input type="text" name="homeAddress_<%= t.getId() %>" value="<%= t.getHomeAddress() %>"></td>
            <td>
                <button type="submit" class="btn-red" 
                        onclick="document.getElementById('deleteId').value=<%= t.getId() %>; this.form.action='teacher'; this.form.action='teacher'; this.form.querySelector('[name=action]').value='deleteRow';">
                    Eliminar
                </button>
            </td>
        </tr>
<%
        }
    }
%>
    </table>

    <div class="button-group-top">
        <button type="submit" class="btn-blue">Guardar Cambios</button>
    </div>
</form>

<hr/>

<!-- Formulario separado para agregar profesor -->
<form action="teacher" method="post">
    <input type="hidden" name="action" value="addRow">
    <table>
        <tr class="add-row-header">
            <td colspan="8">Agregar Profesor</td>
        </tr>
        <tr>
            <td><input type="text" name="name" placeholder="Nombre completo" required></td>
            <td><input type="number" name="ci" placeholder="Cédula" required></td>
            <td><input type="date" name="dateOfBirth" required></td>
            <td><input type="number" name="phoneNumber" placeholder="Teléfono" required></td>
            <td><input type="number" name="salary" placeholder="Salario" required></td>
            <td><input type="text" name="emergencyService" placeholder="Servicio médico"></td>
            <td><input type="text" name="homeAddress" placeholder="Dirección"></td>
            <td>
                <button type="submit" class="btn-blue">Agregar</button>
            </td>
        </tr>
    </table>
</form>

<div class="button-group-bottom">
    <button type="button" onclick="window.location.href='index.jsp'">Volver</button>
</div>

</body>
</html>
