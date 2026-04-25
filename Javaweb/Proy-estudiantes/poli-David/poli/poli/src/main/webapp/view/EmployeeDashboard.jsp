<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*, com.davidbellerati.vo.EmployeeVO" %>

<!DOCTYPE html>
<html>
<head>
    <title>Polideportivo | Empleados</title>
    <style>
        body { 
            font-family: 'Inter', sans-serif; 
            padding: 20px; 
            background-color: #f8f9fa;
        }
        h1 { 
            color: #212529; 
            margin-bottom: 25px; 
            text-align: center;
        }

        table { 
            width: 95%;
            max-width: 1400px;
            margin: 0 auto 30px auto;
            border-collapse: collapse; 
            font-size: 13px; 
            box-shadow: 0 4px 8px rgba(0,0,0,0.1);
            border-radius: 8px;
            overflow: hidden; 
        }
        
        table tr {
            display: grid;
            grid-template-columns: 3fr 1.5fr 2fr 1.5fr 2fr 3fr 1fr 1fr 1fr; 
        }

        th, td { 
            border: 1px solid #dee2e6; 
            padding: 10px 8px; 
            text-align: left; 
            vertical-align: middle; 
            border-left: none;
            border-right: none;
        }
        th { 
            background-color: #e9ecef; 
            color: #495057;
            font-weight: 600;
        }

        input[type="text"], input[type="number"], input[type="date"] { 
            width: 100%; 
            padding: 6px; 
            box-sizing: border-box; 
            border: 1px solid #ced4da;
            border-radius: 4px;
            transition: border-color 0.2s;
        }
        input[type="text"]:focus, input[type="number"]:focus, input[type="date"]:focus {
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
        
        button[name="action"][value="addRow"], 
        button[name="action"][value="saveRow"] { 
            background-color: #007bff; 
            color: white; 
        }
        button[name="action"][value="addRow"]:hover, 
        button[name="action"][value="saveRow"]:hover { 
            background-color: #0056b3; 
        }

        button[name="action"][value="deleteRow"] { 
            background-color: #dc3545; 
            color: white; 
            padding: 8px 15px;
        }
        button[name="action"][value="deleteRow"]:hover { 
            background-color: #c82333; 
        }

        .button-group-bottom button {
            background-color: #6c757d;
            color: white;
            padding: 8px 20px;
        }
        .button-group-bottom button:hover {
            background-color: #5a6268;
        }

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
        
        .add-row-header td {
            background-color: #e9ecef; 
            text-align: center; 
            font-weight: bold;
            color: #495057;
            grid-column: 1 / span 9;
        }
        
        .button-group-top {
            text-align: center;
            margin-top: 20px;
            display: flex;
            justify-content: center;
            gap: 15px;
        }

        .button-group-bottom {
            margin-top: 30px;
            text-align: left;
        }
        
        @media (max-width: 900px) {
            table {
                width: 100%;
                overflow-x: auto; 
            }
            table tr {
                 display: table-row; 
            }
            th, td {
                display: table-cell;
                min-width: 120px;
            }
            
             .add-row-header td {
                display: table-cell;
                min-width: auto;
            }
        }
    </style>
</head>

<body>
    <h1>Polideportivo | Empleados</h1>

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

    <form action="employee" method="post">
        <table>
            <tr>
                <th>Nombre</th>
                <th>Cédula</th>
                <th>Fecha de nacimiento</th>
                <th>Teléfono</th>
                <th>Servicio Emergencias</th>
                <th>Dirección</th>
                <th>Salario</th>
                <th>Categoría</th>
                <th>Acciones</th>
            </tr>

            <%
                List<EmployeeVO> employees = (List<EmployeeVO>) request.getAttribute("showList");
                if (employees != null) {
                    for (EmployeeVO e : employees) {
            %>
                <tr>
                    <td><input type="text" name="name_<%= e.getId() %>" value="<%= e.getName() %>"></td>
                    <td><input type="number" name="ci_<%= e.getId() %>" value="<%= e.getCI() %>"></td>
                    <td><input type="date" name="dateOfBirth_<%= e.getId() %>" value="<%= e.getDateOfBirth() %>"></td>
                    <td><input type="number" name="phoneNumber_<%= e.getId() %>" value="<%= e.getPhoneNumber() %>"></td>
                    <td><input type="text" name="emergencyService_<%= e.getId() %>" value="<%= e.getEmergencyService() %>"></td>
                    <td><input type="text" name="homeAddress_<%= e.getId() %>" value="<%= e.getHomeAddress() %>"></td>
                    <td><input type="number" name="salary_<%= e.getId() %>" value="<%= e.getSalary() %>"></td>
                    <td><input type="text" name="category_<%= e.getId() %>" value="<%= e.getCategory() %>"></td>
                    <td>
                        <button type="submit"
                                name="action"
                                value="deleteRow"
                                formnovalidate>
                                Eliminar
                        </button>
                        <input type="hidden" name="id" value="<%= e.getId() %>">
                    </td>
                </tr>
            <%
                    }
                }
            %>
            
            <tr class="add-row-header">
                <td colspan="9">Agregar Empleado</td>
            </tr>
            
            <tr>
                <td><input type="text" name="name" placeholder="Nombre completo" required></td>
                <td><input type="number" name="ci" placeholder="Cédula" required></td>
                <td><input type="date" name="dateOfBirth" required></td>
                <td><input type="number" name="phoneNumber" placeholder="Teléfono" required></td>
                <td><input type="text" name="emergencyService" placeholder="Servicio médico" required></td>
                <td><input type="text" name="homeAddress" placeholder="Dirección" required></td>
                <td><input type="number" name="salary" placeholder="Salario" required></td>
                <td><input type="text" name="category" placeholder="Categoría" required></td>
                <td>
                    <button type="submit" name="action" value="addRow">Agregar</button>
                </td>
            </tr>
        </table>

        <div class="button-group-top">
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
