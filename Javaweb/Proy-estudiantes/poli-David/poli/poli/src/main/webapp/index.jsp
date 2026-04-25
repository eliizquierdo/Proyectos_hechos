<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
    <title> Polideportivo | Bienvenido </title>
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;600&display=swap" rel="stylesheet">
    <style>
        body {
            font-family: 'Inter', sans-serif;
            padding: 20px;
            
            background-image: url('https://www.imcanelones.gub.uy/sites/default/files/noticias/galeria/18mayo_3667.jpg'); 
            background-size: cover;
            background-repeat: no-repeat;
            background-position: center center;
            background-attachment: fixed;
            background-color: #1a1a1a;
            
            display: flex;
            flex-direction: column;
            align-items: center;
            min-height: 100vh;
            margin: 0;
            color: #212529;
        }

        h1 {
            color: #ffffff;
            margin-bottom: 50px;
            text-align: center;
            font-weight: 600;
            font-size: 2.5rem;
            text-shadow: 0 2px 4px rgba(0, 0, 0, 0.5); 
        }

        .dashboard-menu {
            display: flex;
            flex-direction: column;
            gap: 15px;
            align-items: center;
            width: 90%;
            max-width: 400px;
            padding: 30px;
            background: rgba(255, 255, 255, 0.95);
            border-radius: 12px;
            box-shadow: 0 10px 25px rgba(0, 0, 0, 0.2);
        }

        form {
            width: 100%;
        }
        
        button {
            width: 100%;
            font-size: 16px;
            cursor: pointer;
            padding: 12px 25px;
            border-radius: 8px;
            border: none;
            transition: background-color 0.2s, transform 0.1s, box-shadow 0.2s;
            white-space: nowrap;
            
            background-color: #007bff; 
            color: white;
            font-weight: 600;
            box-shadow: 0 2px 4px rgba(0, 123, 255, 0.3);
        }
        
        button:hover {
            background-color: #0056b3;
            box-shadow: 0 4px 8px rgba(0, 123, 255, 0.4);
        }
        
        button:active {
            transform: scale(0.98);
        }
    </style>
</head>

<body>
    <h1> Polideportivo | Bienvenido </h1>
    
    <div class="dashboard-menu">
        <form action="teacher" method="get">
            <input type="hidden" name="action" value="teacherDashboard">
            <button type="submit"> Profesores </button>
        </form>
        
        <form action="member" method="get">
            <input type="hidden" name="action" value="memberDashboard">
            <button type="submit"> Miembros </button>
        </form>
        
        <form action="activity" method="get">
            <input type="hidden" name="action" value="activityDashboard">
            <button type="submit"> Actividades </button>
        </form>
        
        <form action="material" method="get">
            <input type="hidden" name="action" value="materialDashboard">
            <button type="submit"> Materiales </button>
        </form>

        <form action="employee" method="get">
            <input type="hidden" name="action" value="employeeDashboard">
            <button type="submit"> Empleados </button>
        </form>
    </div>
    
</body>

</html>