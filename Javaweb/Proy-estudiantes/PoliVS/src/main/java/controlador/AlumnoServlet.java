package controlador;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import modelo.dao.AlumnoDAO;
// Eliminada la línea: import modelo.dao.PersonaDAO;
import modelo.vo.AlumnoVO;
import java.util.List;

@WebServlet(name = "AlumnoServlet", urlPatterns = { "/AlumnoServlet" })
public class AlumnoServlet extends HttpServlet {
    AlumnoDAO dao = new AlumnoDAO();
    // Eliminada la declaración de PersonaDAO: PersonaDAO daoP = new PersonaDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");

        if (accion == null) {
            response.sendRedirect("index.jsp");
        } else if (accion.equals("listar")) {
            List<AlumnoVO> lista = dao.listarAlumno();
            request.setAttribute("Alumnos", lista);
            RequestDispatcher rd = request.getRequestDispatcher("mostrarAlumno.jsp");
            rd.forward(request, response);

        } else if (accion.equals("nuevo")) {
            RequestDispatcher rd = request.getRequestDispatcher("agregarAlumno.jsp");
            rd.forward(request, response);

        } else if (accion.equals("modificar")) {
            RequestDispatcher rd = request.getRequestDispatcher("modificarAlumno.jsp");
            int cedula = Integer.parseInt(request.getParameter("cedula"));
            request.setAttribute("Alumnos", dao.obtenerAlumno(cedula));
            rd.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");

        if ("agregar".equals(accion)) {
            int cedula = Integer.parseInt(request.getParameter("cedula"));
            String nombre = request.getParameter("nombre");
            int telefono = Integer.parseInt(request.getParameter("telefono"));
            int edad = Integer.parseInt(request.getParameter("edad"));
            String calle = request.getParameter("calle");
            int nro = Integer.parseInt(request.getParameter("nro"));

            AlumnoVO m = new AlumnoVO(cedula, nombre, telefono, edad, calle, nro);
            // CORREGIDO: Llamada al método en AlumnoDAO
            dao.agregarAlumno(m);

            response.sendRedirect("AlumnoServlet?accion=listar");

        } else if ("eliminar".equals(accion)) {
            int cedula = Integer.parseInt(request.getParameter("cedula"));

            // CORREGIDO: Un solo llamado a AlumnoDAO.eliminarAlumno() que maneja ambas
            // tablas
            dao.eliminarAlumno(cedula);

            response.sendRedirect("AlumnoServlet?accion=listar");

        } else if ("modificar".equals(accion)) {
            int cedula = Integer.parseInt(request.getParameter("cedula"));
            String nombre = request.getParameter("nombre");
            int telefono = Integer.parseInt(request.getParameter("telefono"));
            int edad = Integer.parseInt(request.getParameter("edad"));
            String calle = request.getParameter("calle");
            int nro = Integer.parseInt(request.getParameter("nro"));

            AlumnoVO m = new AlumnoVO(cedula, nombre, telefono, edad, calle, nro);
            // CORREGIDO: Llamada al método en AlumnoDAO
            dao.modificarAlumno(m);

            response.sendRedirect("AlumnoServlet?accion=listar");
        }
    }
}
