package controlador;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import modelo.dao.ProfesorDAO; // Solo necesitamos ProfesorDAO
// Eliminamos el import de PersonaDAO
import modelo.vo.ProfesorVO;
import java.util.List;

@WebServlet(name = "ProfesorServlet", urlPatterns = { "/ProfesorServlet" })
public class ProfesorServlet extends HttpServlet {
    ProfesorDAO dao = new ProfesorDAO(); // Solo un DAO

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");

        if (accion == null) {
            response.sendRedirect("index.jsp");
        } else if (accion.equals("listar")) {
            List<ProfesorVO> lista = dao.listarProfesor();
            request.setAttribute("profesor", lista);
            RequestDispatcher rd = request.getRequestDispatcher("mostrarProfesor.jsp");
            rd.forward(request, response);

        } else if (accion.equals("nuevo")) {
            RequestDispatcher rd = request.getRequestDispatcher("agregarProfesor.jsp");
            rd.forward(request, response);

        } else if (accion.equals("modificar")) {
            RequestDispatcher rd = request.getRequestDispatcher("modificarProfesor.jsp");
            int cedula = Integer.parseInt(request.getParameter("cedula"));
            request.setAttribute("profesor", dao.obtenerProfesor(cedula));
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
            String especialidad = request.getParameter("especialidad");

            ProfesorVO m = new ProfesorVO(cedula, nombre, telefono, especialidad);
            // CORREGIDO: Llamamos a ProfesorDAO.agregarProfesor(), que ahora inserta en
            // ambas tablas.
            dao.agregarProfesor(m);

            response.sendRedirect("ProfesorServlet?accion=listar");

        } else if ("eliminar".equals(accion)) {
            int cedula = Integer.parseInt(request.getParameter("cedula"));

            // CORREGIDO: Un solo llamado a ProfesorDAO.eliminarProfesor(), que ahora
            // elimina de ambas tablas.
            dao.eliminarProfesor(cedula);

            response.sendRedirect("ProfesorServlet?accion=listar");

        } else if ("modificar".equals(accion)) {
            int cedula = Integer.parseInt(request.getParameter("cedula"));
            String nombre = request.getParameter("nombre");
            int telefono = Integer.parseInt(request.getParameter("telefono"));
            String especialidad = request.getParameter("especialidad");

            ProfesorVO m = new ProfesorVO(cedula, nombre, telefono, especialidad);
            // CORREGIDO: Llamamos a ProfesorDAO.modificarProfesor(), que ahora actualiza
            // ambas tablas.
            dao.modificarProfesor(m);

            response.sendRedirect("ProfesorServlet?accion=listar");
        }
    }
}