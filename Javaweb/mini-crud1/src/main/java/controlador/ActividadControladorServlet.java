package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import modelo.dao.ActividadDAO;
import modelo.vo.ActividadVO;

@WebServlet("/actividad")
public class ActividadControladorServlet extends HttpServlet {
    private final ActividadDAO dao = new ActividadDAO();

    // ======================== GET ========================
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        if (action == null)
            action = "";

        switch (action) {
            case "agregar":
                request.getRequestDispatcher("/vista/actividad-form.jsp")
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
            response.sendRedirect(request.getContextPath() + "/actividad");
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
                response.sendRedirect(request.getContextPath() + "/actividad");
        }
    }

    // ===================== Acciones privadas =====================
    private void agregar(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        int idActividad = Integer.parseInt(request.getParameter("idActividad"));
        String nombre = request.getParameter("nombre");
        String dia = request.getParameter("dia");
        String hora = request.getParameter("hora");

        dao.agregarA(new ActividadVO(idActividad, nombre, dia, hora));
        response.sendRedirect(request.getContextPath() + "/actividad");
    }

    private void editar(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        int idActividad = Integer.parseInt(request.getParameter("idActividad"));
        String nombre = request.getParameter("nombre");
        String dia = request.getParameter("dia");
        String hora = request.getParameter("hora");

        dao.actualizarA(new ActividadVO(idActividad, nombre, dia, hora));
        response.sendRedirect(request.getContextPath() + "/actividad");
    }

    private void eliminar(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        int idActividad = Integer.parseInt(request.getParameter("idActividad"));
        dao.eliminarA(idActividad);
        response.sendRedirect(request.getContextPath() + "/actividad");
    }

    private void cargarEditar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idActividad = Integer.parseInt(request.getParameter("idActividad"));
        ActividadVO actividad = dao.obtenerXCodigoA(idActividad);

        if (actividad != null) {
            request.setAttribute("actividad", actividad);
            request.getRequestDispatcher("/vista/actividad-editar.jsp")
                    .forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/actividad");
        }
    }

    private void listar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("actividades", dao.getListaA());
        request.getRequestDispatcher("/vista/actividad-lista.jsp")
                .forward(request, response);
    }
}
