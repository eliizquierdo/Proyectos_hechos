<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*, com.davidbellerati.vo.ActivityVO, com.davidbellerati.vo.MemberVO, com.davidbellerati.vo.TeacherVO" %>

<!DOCTYPE html>
<html>
<head>
    <title>Polideportivo | Actividades</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            padding: 20px;
            background-color: #f8f9fa;
        }
        h1 {
            color: #212529;
            margin-bottom: 25px;
            text-align: center;
        }
        h2 {
            color: #495057;
            margin-top: 30px;
            margin-bottom: 15px;
            text-align: center;
        }

        table.activity-table {
            width: 95%;
            max-width: 1400px;
            margin: 0 auto 30px auto;
            border-collapse: collapse;
            font-size: 13px;
            box-shadow: 0 4px 8px rgba(0,0,0,0.1);
            border-radius: 8px;
            overflow: hidden;
            table-layout: auto;
        }

        table.activity-table th, table.activity-table td {
            border: 1px solid #dee2e6;
            padding: 10px 8px;
            text-align: left;
            vertical-align: middle;
            border-left: none;
            border-right: none;
        }
        table.activity-table th {
            background-color: #e9ecef;
            color: #495057;
            font-weight: 600;
        }
        
        .activity-row-container {
            border: 1px solid #dee2e6;
            margin-bottom: 20px;
            border-radius: 8px;
            overflow: hidden;
            box-shadow: 0 2px 4px rgba(0,0,0,0.05);
        }
        .activity-row-container table {
            margin: 0;
            width: 100%;
            box-shadow: none;
            border-radius: 0;
        }
        .activity-row-container table tr:last-child td {
            border-bottom: none;
        }

        input[type="text"], input[type="number"] {
            width: 100%;
            padding: 6px;
            box-sizing: border-box;
            border: 1px solid #ced4da;
            border-radius: 4px;
            transition: border-color 0.2s;
            font-size: 13px;
        }
        input[type="text"]:focus, input[type="number"]:focus {
            border-color: #007bff;
            outline: none;
            box-shadow: 0 0 0 0.1rem rgba(0, 123, 255, 0.25);
        }

        button {
            font-size: 13px;
            cursor: pointer;
            padding: 8px 10px;
            border-radius: 6px;
            border: none;
            margin-right: 5px;
            transition: background-color 0.2s, transform 0.1s;
            white-space: nowrap;
        }
        button:active {
            transform: scale(0.98);
        }

        button[name="action"][value^="addMember_"] {
             background-color: #007bff;
             color: white;
             padding: 6px 10px; 
        }
        button[name="action"][value^="addMember_"]:hover {
             background-color: #0056b3;
        }
        
        button[name="action"][value="addRow"],
        button[name="action"][value="saveRow"] {
            background-color: #007bff;
            color: white;
            padding: 10px 20px;
            font-weight: bold;
        }
        button[name="action"][value="addRow"]:hover,
        button[name="action"][value="saveRow"]:hover {
            background-color: #0056b3;
        }

        button[name="action"][value="deleteRow"],
        button[name="action"][value^="deleteMember_"] {
            background-color: #dc3545;
            color: white;
            padding: 8px 15px;
            margin-right: 0;
        }
        button[name="action"][value="deleteRow"]:hover,
        button[name="action"][value^="deleteMember_"]:hover {
            background-color: #c82333;
        }

        .button-group-bottom button {
            background-color: #6c757d;
            color: white;
            padding: 10px 20px;
            font-weight: bold;
        }
        .button-group-bottom button:hover {
            background-color: #5a6268;
        }
        
        /* --- Estilo de Mensajes de Error --- */
        .error-message {
            margin: 15px auto;
            width: fit-content;
            padding: 10px 20px;
            border: 1px solid #f5c6cb;
            background-color: #f8d7da;
            color: #721c24;
            border-radius: 5px;
            font-weight: bold;
        }

        .button-group-top {
            text-align: center;
            margin-top: 20px;
            display: flex;
            justify-content: center;
            gap: 15px;
        }

        .button-group-bottom button {
            background-color: #6c757d;
            color: white;
            padding: 8px 20px;
        }
        .button-group-bottom button:hover {
            background-color: #5a6268;
        }

        .member-table-container {
            max-height: 150px;
            overflow-y: auto;
            border: 1px solid #ced4da;
            border-radius: 4px;
            padding: 5px;
            margin-top: 10px;
        }
        .member-table {
            width: 100%;
            font-size: 11px;
            margin: 0;
            border-collapse: collapse;
            box-shadow: none;
        }
        .member-table th, .member-table td {
            border: 1px solid #dee2e6;
            padding: 4px 6px;
            text-align: left;
            border-left: none;
            border-right: none;
        }
        .member-table th {
            background-color: #f8f9fa; /* Fondo más claro para la cabecera interna */
            font-weight: 600;
            color: #495057;
        }
        .member-table button {
            font-size: 11px;
            padding: 3px 6px;
            margin: 0;
        }
        .member-table tr:hover {
            background-color: #f1f1f1;
        }
    </style>
</head>

<body>
<h1>Polideportivo | Actividades </h1>

<%
    String errorMessage = (String) request.getAttribute("errorMessage");
    if (errorMessage != null) {
%>
    <div class="error-message">
        <%= errorMessage %>
    </div>
<%
    }
%>

<form action="activity" method="post">
<%
    List<ActivityVO> activities = (List<ActivityVO>) request.getAttribute("activities");
    List<MemberVO> members = (List<MemberVO>) request.getAttribute("members");
    if (activities != null) {
        for (ActivityVO a : activities) {
%>
    <div class="activity-row-container">
        <table class="activity-table">
            <tr>
                <th style="width: 20%;">Nombre</th>
                <th style="width: 15%;">Hora de Entrada</th>
                <th style="width: 15%;">Hora de Salida</th>
                <th style="width: 30%;">Profesor (Cédula)</th>
                <th style="width: 20%;">Acciones</th>
            </tr>
            <tr>
                <td><input type="text" name="name_<%= a.getId() %>" value="<%= a.getName() %>"></td>
                <td><input type="text" name="entryHour_<%= a.getId() %>" value="<%= a.getEntryHour() %>"></td>
                <td><input type="text" name="departHour_<%= a.getId() %>" value="<%= a.getDepartHour() %>"></td>
                <td><input type="number" name="asignedTeacher_<%= a.getId() %>" value="<%= a.getAsignedTeacher() != null ? a.getAsignedTeacher().getCI() : "" %>"></td>
                <td>
                    <button type="submit" name="action" value="deleteRow" formnovalidate>Eliminar</button>
                    <input type="hidden" name="id" value="<%= a.getId() %>">
                </td>
            </tr>
            <tr>
                <td colspan="5">
                    <div style="font-weight: bold; margin-top: 5px; color: #495057;">Miembros Asignados:</div>
                    <div class="member-table-container">
                        <table class="member-table">
                            <tr>
                                <th style="width: 70%;">Nombre del Miembro</th>
                                <th style="width: 30%;">Acciones</th>
                            </tr>
                            <%
                            List<MemberVO> assignedMembers = a.getAsignedMembers();
                            if (assignedMembers != null) {
                                for (MemberVO m : assignedMembers) {
                            %>
                            <tr>
                                <td><%= m.getName() %></td>
                                <td>
                                    <button type="submit" name="action" value="deleteMember_<%= a.getId() %>_<%= m.getId() %>" formnovalidate>Eliminar</button>
                                </td>
                            </tr>
                            <%
                                }
                            }
                            %>
                            <tr>
                                <td><input type="number" name="newMember_<%= a.getId() %>" placeholder="Cédula del Miembro a agregar (opcional)"></td>
                                <td><button type="submit" name="action" value="addMember_<%= a.getId() %>" formnovalidate>Agregar</button></td>
                            </tr>
                        </table>
                    </div>
                </td>
            </tr>
        </table>
    </div>
<%
        }
    }
%>

<h2>Agregar Actividad</h2>
<table class="activity-table">
    <tr>
        <th style="width: 25%;">Nombre</th>
        <th style="width: 25%;">Hora de Entrada</th>
        <th style="width: 25%;">Hora de Salida</th>
        <th style="width: 25%;">Profesor (Cédula)</th>
    </tr>
    <tr>
        <td><input type="text" name="name" required placeholder="Ej: Natación Avanzada"></td>
        <td><input type="text" name="entryHour" required placeholder="Ej: 08:00"></td>
        <td><input type="text" name="departHour" required placeholder="Ej: 09:00"></td>
        <td><input type="number" name="asignedTeacher" required placeholder="Cédula del Profesor"></td>
    </tr>
</table>

<div class="button-group-top">
    <button type="submit" name="action" value="addRow">Agregar</button>
    <button type="submit" name="action" value="saveRow" formnovalidate>Guardar</button>
</div>
</form>

<div class="button-group-bottom">
    <button type="button" onclick="window.location.href='index.jsp'">
        Volver
    </button>
</div>
</body>
</html>