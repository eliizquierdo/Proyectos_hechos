package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import modelo.dao.SocioDAO;
import modelo.vo.SocioVO;

@WebServlet("/socio")
public class SocioControladorServlet extends HttpServlet {
    private final SocioDAO dao = new SocioDAO();

    // ======================== GET ========================
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        if (action == null)
            action = "";

        switch (action) {
            case "agregar":
                request.getRequestDispatcher("/vista/socio-form.jsp")
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
            response.sendRedirect(request.getContextPath() + "/socio");
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
                response.sendRedirect(request.getContextPath() + "/socio");
        }
    }

    // ===================== Acciones privadas =====================
    private void agregar(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        int cedula = Integer.parseInt(request.getParameter("cedula"));
        String nombre = request.getParameter("nombre");
        String medicacion = request.getParameter("medicacion");
        String carnetSalud = request.getParameter("carnetSalud");
        String sociedadMedica = request.getParameter("sociedadMedica");

        dao.agregar(new SocioVO(cedula, nombre, medicacion, carnetSalud, sociedadMedica));
        response.sendRedirect(request.getContextPath() + "/socio");
    }

    private void editar(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        int cedula = Integer.parseInt(request.getParameter("cedula"));
        String nombre = request.getParameter("nombre");
        String medicacion = request.getParameter("medicacion");
        String carnetSalud = request.getParameter("carnetSalud");
        String sociedadMedica = request.getParameter("sociedadMedica");

        dao.actualizar(new SocioVO(cedula, nombre, medicacion, carnetSalud, sociedadMedica));
        response.sendRedirect(request.getContextPath() + "/socio");
    }

    private void eliminar(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        int cedula = Integer.parseInt(request.getParameter("cedula"));
        dao.eliminar(cedula);
        response.sendRedirect(request.getContextPath() + "/socio");
    }

    private void cargarEditar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int cedula = Integer.parseInt(request.getParameter("cedula"));
        SocioVO socio = dao.obtenerXCodigo(cedula);

        if (socio != null) {
            request.setAttribute("socio", socio);
            request.getRequestDispatcher("/vista/socio-editar.jsp")
                    .forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/socio");
        }
    }

    private void listar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("socios", dao.getLista());
        request.getRequestDispatcher("/vista/socio-lista.jsp")
                .forward(request, response);
    }
}
