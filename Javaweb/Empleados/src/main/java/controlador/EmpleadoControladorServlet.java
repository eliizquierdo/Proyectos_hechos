package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import modelo.dao.EmpleadoDAO;
import modelo.vo.EmpleadoVO;

@WebServlet("/empleado")
public class EmpleadoControladorServlet extends HttpServlet {
    private final EmpleadoDAO dao = new EmpleadoDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        if (action == null)
            action = "";

        switch (action) {
            case "nuevo":
                mostrarFormulario(request, response);
                break;
            case "editar":
                cargarParaEditar(request, response);
                break;
            case "listar":
                listar(request, response);
                break;
            default:
                listar(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            response.sendRedirect(request.getContextPath() + "/empleado");
            return;
        }

        switch (action) {
            case "guardar":
                guardar(request, response);
                break;
            case "actualizar":
                actualizar(request, response);
                break;
            case "eliminar":
                eliminar(request, response);
                break;
            default:
                response.sendRedirect(request.getContextPath() + "/empleado");
        }
    }

    private void mostrarFormulario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Pasar las opciones para los selects
        request.setAttribute("departamentos", dao.getDepartamentos());
        request.setAttribute("cargos", dao.getCargos());
        request.setAttribute("idiomas", dao.getIdiomas());
        request.setAttribute("habilidades", dao.getHabilidades());

        request.getRequestDispatcher("/vista/empleado-form.jsp").forward(request, response);
    }

    private void cargarParaEditar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        EmpleadoVO empleado = dao.obtenerPorId(id);

        if (empleado != null) {
            request.setAttribute("empleado", empleado);
            request.setAttribute("departamentos", dao.getDepartamentos());
            request.setAttribute("cargos", dao.getCargos());
            request.setAttribute("idiomas", dao.getIdiomas());
            request.setAttribute("habilidades", dao.getHabilidades());
            request.getRequestDispatcher("/vista/empleado-form.jsp").forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/empleado");
        }
    }

    private void guardar(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        EmpleadoVO empleado = extraerDatosDelFormulario(request);
        dao.agregar(empleado);

        // En una aplicación real, podrías guardar el mensaje en la sesión para
        // mostrarlo
        response.sendRedirect(request.getContextPath() + "/empleado");
    }

    private void actualizar(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        EmpleadoVO empleado = extraerDatosDelFormulario(request);
        empleado.setId(Integer.parseInt(request.getParameter("id")));
        dao.actualizar(empleado);
        response.sendRedirect(request.getContextPath() + "/empleado");
    }

    private void eliminar(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        dao.eliminar(id);
        response.sendRedirect(request.getContextPath() + "/empleado");
    }

    private void listar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("empleados", dao.getLista());
        request.getRequestDispatcher("/vista/empleado-lista.jsp").forward(request, response);
    }

    private EmpleadoVO extraerDatosDelFormulario(HttpServletRequest request) {
        EmpleadoVO empleado = new EmpleadoVO();

        // Campos básicos
        empleado.setNombre(request.getParameter("nombre"));
        empleado.setEmail(request.getParameter("email"));
        empleado.setFechaNacimiento(request.getParameter("fechaNacimiento"));
        empleado.setComentarios(request.getParameter("comentarios"));

        // Radio button - género
        empleado.setGenero(request.getParameter("genero"));

        // Select simple - departamento
        empleado.setDepartamento(request.getParameter("departamento"));

        // Select simple - cargo
        empleado.setCargo(request.getParameter("cargo"));

        // Radio button - turno
        empleado.setTurno(request.getParameter("turno"));

        // Select simple - nivel educación
        empleado.setNivelEducacion(request.getParameter("nivelEducacion"));

        // Number input - salario
        String salarioStr = request.getParameter("salario");
        if (salarioStr != null && !salarioStr.trim().isEmpty()) {
            try {
                empleado.setSalario(Double.parseDouble(salarioStr));
            } catch (NumberFormatException e) {
                empleado.setSalario(0.0);
            }
        }

        // Checkboxes individuales
        empleado.setActivo(request.getParameter("activo") != null);
        empleado.setTieneVehiculo(request.getParameter("tieneVehiculo") != null);
        empleado.setDisponibleViajes(request.getParameter("disponibleViajes") != null);

        // Select múltiple - idiomas
        String[] idiomasSeleccionados = request.getParameterValues("idiomas");
        empleado.setIdiomas(idiomasSeleccionados != null ? idiomasSeleccionados : new String[] {});

        // Checkboxes múltiples - habilidades
        String[] habilidadesSeleccionadas = request.getParameterValues("habilidades");
        empleado.setHabilidades(habilidadesSeleccionadas != null ? habilidadesSeleccionadas : new String[] {});

        return empleado;
    }
}