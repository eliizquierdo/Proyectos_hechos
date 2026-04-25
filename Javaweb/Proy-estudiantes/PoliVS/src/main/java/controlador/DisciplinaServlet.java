package controlador;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import modelo.dao.DisciplinaDAO;
import modelo.dao.AlumnoDAO;
//import modelo.vo.AlumnoVO;
import modelo.vo.DisciplinaVO;
import java.util.List;

@WebServlet(name = "DisciplinaServlet", urlPatterns = {"/DisciplinaServlet"})
public class DisciplinaServlet extends HttpServlet {
    DisciplinaDAO dao = new DisciplinaDAO();
    AlumnoDAO daoA = new AlumnoDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");

        if (accion == null) {
            response.sendRedirect("index.jsp");


        } else if (accion.equals("listar")) {
            List<DisciplinaVO> lista = dao.listarDisciplina();
            request.setAttribute("Disciplina", lista);
            RequestDispatcher rd = request.getRequestDispatcher("mostrarDisciplina.jsp");
            rd.forward(request, response);


        } else if (accion.equals("nuevo")) {
            RequestDispatcher rd = request.getRequestDispatcher("agregarDisciplina.jsp");
            rd.forward(request, response);


        } else if (accion.equals("modificar")) {
            RequestDispatcher rd = request.getRequestDispatcher("modificarDisciplina.jsp");
            int id = Integer.parseInt(request.getParameter("id"));
            request.setAttribute("Disciplina", dao.obtenerDisciplina(id));
            rd.forward(request, response);


        /*} else if (accion.equals("tomarAsistencias")) {
            List<AlumnoVO> listaA = daoA.listarAlumno();
            List<DisciplinaVO> lista = dao.listarDisciplina();
            request.setAttribute("Disciplina", lista);
            request.setAttribute("Alumno", listaA);
            RequestDispatcher rd = request.getRequestDispatcher("mostrarAsistencias.jsp");
            rd.forward(request, response);*/
        }
    }
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         String accion = request.getParameter("accion");

        if ("agregar".equals(accion)) {
            int id = Integer.parseInt(request.getParameter("id"));
            String nombre = request.getParameter("nombre");
            int cupo = Integer.parseInt(request.getParameter("cupo"));
            

            DisciplinaVO m = new DisciplinaVO(id, nombre, cupo );
            dao.agregarDisciplina(m);

            response.sendRedirect("DisciplinaServlet?accion=listar");

            
        } else if ("eliminar".equals(accion)) {
            int id = Integer.parseInt(request.getParameter("id"));
            dao.eliminarDisciplina(id);
            response.sendRedirect("DisciplinaServlet?accion=listar");


        } else if ("modificar".equals(accion)){
            int id = Integer.parseInt(request.getParameter("id"));
            String nombre = request.getParameter("nombre");
            int cupo = Integer.parseInt(request.getParameter("cupo"));
        
            DisciplinaVO m = new DisciplinaVO(id, nombre, cupo );
            dao.modificarDisciplina(m);

            response.sendRedirect("DisciplinaServlet?accion=listar");
        }
    }
}
