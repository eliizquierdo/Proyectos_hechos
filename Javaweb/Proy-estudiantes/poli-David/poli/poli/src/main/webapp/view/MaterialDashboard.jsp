<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*, com.davidbellerati.vo.MaterialVO" %>

<!DOCTYPE html>
<html>
<head>
    <title>Polideportivo | Materiales</title>
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
            max-width: 800px;
            margin: 0 auto 30px auto;
            border-collapse: collapse; 
            font-size: 13px; 
            box-shadow: 0 4px 8px rgba(0,0,0,0.1);
            border-radius: 8px;
            overflow: hidden; 
        }
        
        table tr {
            display: grid;
            grid-template-columns: 4fr 2fr 1fr; 
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

        input[type="text"], input[type="number"] { 
            width: 100%; 
            padding: 6px; 
            box-sizing: border-box; 
            border: 1px solid #ced4da;
            border-radius: 4px;
            transition: border-color 0.2s;
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
            grid-column: 1 / span 3;
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
        
        @media (max-width: 600px) {
            table {
                width: 100%;
                overflow-x: auto; 
            }
            table tr {
                 display: table-row; 
            }
            th, td {
                display: table-cell;
                min-width: 100px;
            }
            
             .add-row-header td {
                display: table-cell;
                min-width: auto;
            }
        }
    </style>
</head>

<body>
    <h1>Polideportivo | Materiales</h1>

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

    <form action="material" method="post">
        <table>
            <tr>
                <th>Nombre</th>
                <th>Cantidad</th>
                <th>Acciones</th>
            </tr>

            <%
                List<MaterialVO> materials = (List<MaterialVO>) request.getAttribute("materials");
                if (materials != null) {
                    for (MaterialVO m : materials) {
            %>
                <tr>
                    <td><input type="text" name="name_<%= m.getId() %>" value="<%= m.getName() %>"></td>
                    <td><input type="number" name="amount_<%= m.getId() %>" value="<%= m.getAmount() %>"></td>
                    <td>
                        <button type="submit" 
                                name="action" 
                                value="deleteRow" 
                                formnovalidate>
                            Eliminar
                        </button>
                        <input type="hidden" name="id" value="<%= m.getId() %>">
                    </td>
                </tr>
            <%
                    }
                }
            %>
            
            <tr class="add-row-header">
                <td colspan="3">Añadir Nuevo Material</td>
            </tr>
            
            <tr>
                <td><input type="text" name="name" placeholder="Nombre del material" required></td>
                <td><input type="number" name="amount" placeholder="Cantidad" required></td>
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