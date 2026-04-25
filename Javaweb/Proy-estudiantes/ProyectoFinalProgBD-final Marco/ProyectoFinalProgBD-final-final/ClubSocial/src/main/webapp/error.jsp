<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Error</title>
    <link rel="stylesheet" href="css/style1.css">
</head>
<body>
    <%
    String tipo = (String) request.getAttribute("tipo");
    
    if (tipo.equals("PK")){
        
        %>
        <h1 class="tituloError" >Error de registro:</h1>

        <div class="separador"></div>

        <p class="textoError">
        Se ingresaron datos que deverian ser unicos.
        </p>
    <%    
    } else if (tipo.equals("FK")){
        %>
        <h1 class="tituloError">Error de Datos:</h1>
        
        <div class="separador"></div>
        
        <p class="textoError">
        Se encontraron valores inexistentes que deberian existir.<br>
        Por favor, ingrese datos existentes en los lugares necesarios.
        </p>
        <%
    }
    else if (tipo.equals("notNull")){
        %>
        <h1 class="tituloError">Datos Incompletos:</h1>

        <div class="separador"></div>
        
        <p class="textoError">
        No se pudo completar el registro.<br>
        Por favor, asegúrese de completar todos los campos.
        </p>
        <%
    } else if (tipo.equals("otrosInternos")){
        %>
        <h1  class="tituloError">Aviso:</h1>
        
        <div class="separador"></div>
        
        <p class="textoError">
        Ha ocurrido un fallo interno del programa.
        Por favor, verifique los datos o la accion y/o consulte el error con el fabricante.
        </p>
        <%
    }
    %>
    <a href="index.jsp" class="boton-salir">Salir</a>
</body>
</html>