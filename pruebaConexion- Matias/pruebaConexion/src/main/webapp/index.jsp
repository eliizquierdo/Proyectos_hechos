<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Conexión BD</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 40px; }
        .estado {
            font-weight: bold;
            padding: 10px;
            border-radius: 5px;
            width: fit-content;
        }
        .conectado { background: #d4edda; color: #155724; }
        .desconectado { background: #f8d7da; color: #721c24; }
        .boton { padding: 10px 20px; margin: 5px; cursor: pointer; }
    </style>
</head>
<body>
    <h2>Gestión de conexión</h2>
    <form action="conexion" method="post">
        <button class="boton" name="accion" value="conectar">Conectar</button>
        <button class="boton" name="accion" value="desconectar">Desconectar</button>
    </form>

    <h3>Estado:</h3>
    <div class="estado <%= (request.getAttribute("estado") != null && (Boolean)request.getAttribute("estado")) ? "conectado" : "desconectado" %>">
        <%= (request.getAttribute("mensaje") != null) ? request.getAttribute("mensaje") : "Desconectado" %>
    </div>
</body>
</html>