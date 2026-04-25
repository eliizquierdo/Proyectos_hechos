package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import modelo.dao.ProfesorDAO;
import modelo.vo.ProfesorVO;

@WebServlet("/profesor")
public class ProfesorControladorServlet extends HttpServlet {
    private final ProfesorDAO dao = new ProfesorDAO();

    // ======================== GET ========================
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        if (action == null)
            action = "";

        switch (action) {
            case "agregar":
                request.getRequestDispatcher("/vista/profesor-form.jsp")
                        .forward(request, response);
                break;

            case "cargarEditar":
                cargarEditar(request, response);
                break;

            case "listar":
                listar(request, response);
                break;

            default:
                listar(request, response);
                break;
        }
    }

    // ======================== POST ========================
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            response.sendRedirect(request.getContextPath() + "/profesor");
            return;
        }

        switch (action) {
            case "agregar":
                agregar(request, response);
                break;
            case "editar":
                editar(request, response);
                break;
            case "eliminar":
                eliminar(request, response);
                break;
            default:
                response.sendRedirect(request.getContextPath() + "/profesor");
        }
    }

    // ===================== Acciones privadas =====================
    private void agregar(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        int cedula = Integer.parseInt(request.getParameter("cedula"));
        String nombre = request.getParameter("nombre");
        String especialidad = request.getParameter("especialidad");

        dao.agregar(new ProfesorVO(cedula, nombre, especialidad));
        response.sendRedirect(request.getContextPath() + "/profesor");
    }

    private void editar(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        int cedula = Integer.parseInt(request.getParameter("cedula"));
        String nombre = request.getParameter("nombre");
        String especialidad = request.getParameter("especialidad");

        dao.actualizar(new ProfesorVO(cedula, nombre, especialidad));
        response.sendRedirect(request.getContextPath() + "/profesor");
    }

    private void eliminar(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        int cedula = Integer.parseInt(request.getParameter("cedula"));
        dao.eliminar(cedula);
        response.sendRedirect(request.getContextPath() + "/profesor");
    }

    private void cargarEditar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int cedula = Integer.parseInt(request.getParameter("cedula"));
        ProfesorVO profesor = dao.obtenerXCodigo(cedula);

        if (profesor != null) {
            request.setAttribute("profesor", profesor);
            request.getRequestDispatcher("/vista/profesor-editar.jsp")
                    .forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/profesor");
        }
    }

    private void listar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("profesores", dao.getLista());
        request.getRequestDispatcher("/vista/profesor-lista.jsp")
                .forward(request, response);
    }
}
