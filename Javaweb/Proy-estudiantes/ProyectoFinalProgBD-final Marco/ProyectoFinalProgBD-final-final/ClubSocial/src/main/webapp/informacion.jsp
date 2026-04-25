<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Gestión RPG</title>
    <link rel="stylesheet" href="css/style1.css">
</head>
<body>
    <h1>INFORMACIÓN</h1>

    <div class="separador"></div>

    <h6 class="subTituloInfo">Función del programa: </h6>
    <p class="textoInfo">
    Este programa está diseñado para la gestión de los datos de un club social.
    Este programa puede gestionar:<br>
     • Datos de socios <br>
     • Datos del personal <br>
     • Datos de las actividades <br>
     • Datos de los materiales <br>
     • Datos de las participaciones <br>
        <span style="padding-left: 10px;">-Socios que participan en actividades</span> <br>
     • Datos de uso <br>
        <span style="padding-left: 10px;">-Uso de materiales en las actividades</span> <br>

    Este programa es muy facil de usar incluso si no tiene experiencia en programas de gestión
    </p>

    <div class="separador"></div>
    <h3>MANUAL</h3>

    <h6 class="subTituloInfo">Eliminación de datos: </h6>
    <p class="textoInfo">
    Para eliminar devemos precionar el boton "Eliminar" que esta en la casilla
    "Accion" o "Acciones" de la lista.<br>
    Para borrar correctamente los datos deves 
    tener en cuenta si los datos a borrar tienen o no datos hijos en otro lugar,
    en caso de tenerlos deve borrarlos antes.
    Si no lo sabes si los datos a borrar tienen datos hijos
    se le recomienda primero obserbar los lugares donde pueden haver datos hijos.
    </p>

    <h6 class="subTituloInfo">Modificacion de datos: </h6>
    <p class="textoInfo">
    Para modificar devemos precionar el boton "Modificar" que
    esta en la casilla "Accion" o "Acciones" de la lista.<br>
    Al precionar el boton modificar se le llevara a un formulario
    con los datos necesarios cargados. En ese formulario podras cambira
    los valores de cada socio, personal, actividad o material.<br> Las
    participaciones y utilizaciones no cuentan con un boton de modificar
    por sus pocos datos y porque sus datos son claves o identificadores
    de otras tablas.
    </p>

    <h6 class="subTituloInfo">Eliminacion de telefonos: </h6>
    <p class="textoInfo">
    Para eliminar telefonos o franjas horarias deve darle al boton eliminar que 
    esta devajo de cada telefono o franja horaria.<br>
    Por simplicidad de implementación, la eliminación directa se maneja antes de la edición general del socio.<br>
    Primero elimine los teléfonos que desee quitar antes de agregar nuevos o modificar los datos del socio.
    </p>

    <div class="separador"></div>
    <h3>MENSAJES DE ERRORES</h3>

    <h6 class="subTituloInfo">Error de registro:</h6>
    <p class="textoInfo">
    Este error ocurre cuando un dato que no deberia poder repetirse (Por ejemplo la cédula), efectivamente se repite
    </p>

    <h6 class="subTituloInfo">Error de Datos:</h6>
    <p class="textoInfo">
    Este error se debe a una inconsistencia de datos
    </p>

    <h6 class="subTituloInfo">Datos incompletos:</h6>
    <p class="textoInfo">
    Este error ocurre cuando hay un dato que requiere informacion está vacio.<br> Contáctese con los desarrolladores en caso de presentarse este error
    </p>

    <h6 class="subTituloInfo">Aviso al ejecutar:</h6>
    <p class="textoInfo">
    Si te aparece un error que diga "Ha ocurrido un fallo interno del programa."
    por lo general indica que ocurrio un fallo de conexion con la 
    Base de Datos o un fallo de sintaxis.<br>
    Lo recomendado en este caso es consultar con los desarrolladores para buscar una solucion al error. 
    </p>

    <div class="separador"></div>
    
    <h6 class="subTituloInfo">CONTACTO:</h6>
    <p class="textoInfo">
    Email: proyecto135792468@gmail.com <br>
    Teléfono: 097 111 222
    </p>

    <a href="index.jsp" class="boton-salir">Salir</a>

</body>
</html>