package controlador;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.dao.PersonaDAO;
import modelo.vo.PersonaVO;

@WebServlet("/persona")
public class PersonaControladorServlet extends HttpServlet {

    private PersonaDAO dao = new PersonaDAO();
    //private PersonaControlador controlador = new PersonaControlador();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        if (action == null) action = "listar";

        switch (action) {
            case "cargarEditar":
                cargarEditar(request, response);
                break;
            case "eliminar":
                eliminar(request, response);
                break;
            default: // listar
                listar(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        switch (action) {
            case "agregar":
                agregar(request, response);
                break;
            case "editar":
                editar(request, response);
                break;
        }
    }

    private void agregar(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        PersonaVO p = new PersonaVO();
        try {
            p.setCedula(Integer.parseInt(request.getParameter("cedula")));
        } catch (NumberFormatException e) {
            response.sendRedirect("formularioAgregar.jsp?error=cedula");
            return;
        }

        p.setNombre(request.getParameter("nombre"));
        p.setApellido(request.getParameter("apellido"));
        dao.insertarPersona(p);
        response.sendRedirect("persona?action=listar");
    }

    private void editar(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        PersonaVO p = new PersonaVO();
        p.setCedula(Integer.parseInt(request.getParameter("cedula")));
        p.setNombre(request.getParameter("nombre"));
        p.setApellido(request.getParameter("apellido"));
        dao.actualizarPersona(p);
        response.sendRedirect("persona?action=listar");
    }

    private void eliminar(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        int cedula = Integer.parseInt(request.getParameter("cedula"));
        dao.eliminarPersona(cedula);
        response.sendRedirect("persona?action=listar");
    }

    private void cargarEditar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int cedula = Integer.parseInt(request.getParameter("cedula"));
        PersonaVO persona = dao.buscarPersona(cedula);

        if (persona != null) {
            request.setAttribute("persona", persona);
            request.getRequestDispatcher("vista/formularioEditar.jsp").forward(request, response);
        } else {
            response.sendRedirect("persona?action=listar");
        }
    }

    private void listar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<PersonaVO> listaPersonas = dao.listar();
        request.setAttribute("personas", listaPersonas);
        request.getRequestDispatcher("vista/listar.jsp").forward(request, response);
    }
}