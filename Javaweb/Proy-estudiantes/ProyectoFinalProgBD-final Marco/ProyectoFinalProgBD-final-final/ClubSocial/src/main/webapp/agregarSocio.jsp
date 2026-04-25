<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, modelo.vo.SocioVO"%>
<%@ page import="java.time.format.DateTimeFormatter"%>
<%@ page import="java.time.LocalDate"%>
<!DOCTYPE html>
<html>
<head>
    <title>Agregar Socio</title>
    <link rel="stylesheet" href="css/style2.css">
</head>
<body>
    <%
    int canTel = (Integer) request.getAttribute("addTel");
    SocioVO s = (SocioVO) request.getAttribute("socio");
    int valorCed = 0;
    String valorNom="";
    String valorApe="";
    LocalDate fecha = null;
    String valorFecha = (fecha != null) ? fecha.format(DateTimeFormatter.ISO_LOCAL_DATE) : "";
    String valorEmail="";
    String valorCalle="";
    int valorNum = 0;
    String valorEspe="";
    double valorMen = 0.1;
    
    if(canTel>1){
        valorCed = s.getCedula();
        valorNom = s.getNombre();
        valorApe = s.getApellido();
        fecha = s.getFechaNacimiento();
        valorFecha = (fecha != null) ? fecha.format(DateTimeFormatter.ISO_LOCAL_DATE) : "";
        valorEmail = s.getEmail();
        valorCalle = s.getCalle();
        valorNum = s.getNumero();
        valorEspe = s.getEspecificacion();
        valorMen = s.getMensualidad();
    }
    %>
    <h2>Agregar Socio</h2>
    <form action="SocioServlet" method="post">
        <input type="hidden" name="clase" value="agregar">
        <label>___________________________________</label>
        <label>Cedula:</label><input type="number" name="cedula" value="<%= valorCed%>" required><br>
        <label>Nombre:</label><input type="text" name="nombre" value="<%= valorNom%>" required><br>
        <label>Apellido:</label><input type="text" name="apellido" value="<%= valorApe%>" required><br>
        <label>Fecha de Nacimiento:</label><input type="date" name="fechaNacimiento" value="<%= valorFecha%>" required><br>
        <label>Email:</label><input type="email" name="email" value="<%= valorEmail%>" required><br>
        <br>
        <label>_____________DIRECION_____________</label><br>
        <label>Calle:</label><input type="text" name="calle" value="<%= valorCalle%>" required><br>
        <label>Numero:</label><input type="number" name="numero" value="<%= valorNum%>" required><br>
        <label>Referencia:</label><input type="text" name="especificacion" value="<%= valorEspe%>" required><br>
        <label>___________________________________</label><br>
        <label>Mensualidad:</label><input type="number" step="0.1" name="mensualidad" value="<%= valorMen%>" required><br>
        <label>_____________TELEFONOS___________</label><br>
        <p style="font-size: 12px; color: red;"><img src="recursos\precaucion.png" width="15"  height="15">ATENCION: Tenga cuidado con el número - letra que ingresas.</p>
        <% 
        
        if (canTel==0){
            canTel=1;
        }
        List<String> lisT = s.getTelefonos();
        String valorStr = ""; 
        for (int i = 0; i < canTel; i++){
          if(canTel>1){
            valorStr = lisT.get(i);
          }%>
            <label>Telefono:</label><input type="tel" name="telefono<%= i %>" value="<%= valorStr %>" required><br>
        <% }
        %>
        <p style="font-size: 12px">(Si el socio es menor de edad ingrese el telefono del tutor)</p>
        <input type="hidden" name="canTel" value="<%= canTel%>" >
        <button type="submit" name="accion" value="otroHtmlSocio">Añadir telefono</button>
        <p style="font-size: 12px">Para agregar un nuevo telefono precione el boton "Añadir telefono" despues de aver completado los campos anteriores</p>
        <label>___________________________________</label>
        <button type="submit" name="accion" value="nuevo">Guardar</button>
    </form>
    <a href="index.jsp">Volver</a>
</body>
</html>