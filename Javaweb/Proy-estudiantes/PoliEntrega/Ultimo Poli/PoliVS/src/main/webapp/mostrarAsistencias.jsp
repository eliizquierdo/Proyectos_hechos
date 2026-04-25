<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, modelo.vo.DisciplinaVO"%>
<%@ page import="java.util.*, modelo.vo.AlumnoVO"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Lista de Asistencias</title>
        <link rel="stylesheet" href="css/style.css">
    </head>
    <body>
        <h2>Lista de Asistencias</h2>
        <table border="1">
            <tr>
                <th>Id de Alumno</th><th>Nombres</th><th>Id de disciplina</th><th>Disciplinas</th>
            </tr>
            <%
                List<DisciplinaVO> lista = (List<DisciplinaVO>) request.getAttribute("Disciplina");//En DisciplinaServlet.java
                List<AlumnoVO> listaA = (List<AlumnoVO>) request.getAttribute("Alumnos");
                if(listaA != null){
                    for(AlumnoVO a: listaA){
            %>
            <tr>
                <td><%= a.getCedula() %></td>
                <td><%= a.getNombre() %></td>
            <%      }
                }
                if(lista != null){
                    for(DisciplinaVO d: lista){
            %>
                <td><%= d.getid() %></td>
                <td><%= d.getnombre() %></td>
            </tr>
            <%      }
                }
            %>
        </table>
        <a href="index.jsp">Volver</a>
    </body>
</html>