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
        if (action == null) action = "";

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
        request.setAttribute("idiomas", dao.getIdiomas());
        
        request.getRequestDispatcher("/vista/empleado-form.jsp").forward(request, response);
    }

    private void cargarParaEditar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        EmpleadoVO empleado = dao.obtenerPorId(id);
        
        if (empleado != null) {
            request.setAttribute("empleado", empleado);
            request.setAttribute("departamentos", dao.getDepartamentos());
            request.setAttribute("idiomas", dao.getIdiomas());
            request.getRequestDispatcher("/vista/empleado-form.jsp").forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/empleado");
        }
    }

    private void guardar(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        EmpleadoVO empleado = extraerDatosDelFormulario(request);
        dao.agregar(empleado);
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

    /**
     * EJEMPLO: Extrae datos del formulario para cada tipo de control HTML
     * Los estudiantes pueden expandir este método agregando más campos
     */
    private EmpleadoVO extraerDatosDelFormulario(HttpServletRequest request) {
        EmpleadoVO empleado = new EmpleadoVO();
        
        // ===== INPUT TYPE="TEXT" =====
        empleado.setNombre(request.getParameter("nombre"));
        
        // ===== INPUT TYPE="EMAIL" =====  
        empleado.setEmail(request.getParameter("email"));
        
        // ===== INPUT TYPE="NUMBER" =====
        String salarioStr = request.getParameter("salario");
        if (salarioStr != null && !salarioStr.trim().isEmpty()) {
            try {
                empleado.setSalario(Double.parseDouble(salarioStr));
            } catch (NumberFormatException e) {
                empleado.setSalario(0.0);
            }
        }
        
        // ===== RADIO BUTTONS (un solo valor) =====
        empleado.setGenero(request.getParameter("genero"));
        
        // ===== SELECT SIMPLE (un solo valor) =====
        empleado.setDepartamento(request.getParameter("departamento"));
        
        // ===== SELECT MÚLTIPLE (array de valores) =====
        String[] idiomasSeleccionados = request.getParameterValues("idiomas");
        empleado.setIdiomas(idiomasSeleccionados != null ? idiomasSeleccionados : new String[]{});
        
        // ===== CHECKBOX INDIVIDUAL (true/false) =====
        empleado.setActivo(request.getParameter("activo") != null);
        
        // ===== TEXTAREA =====
        empleado.setComentarios(request.getParameter("comentarios"));
        
        /*
         * TODO: Los estudiantes pueden agregar más campos aquí:
         * 
         * // Más radio buttons:
         * empleado.setTurno(request.getParameter("turno"));
         * 
         * // Más selects:
         * empleado.setCargo(request.getParameter("cargo"));
         * 
         * // Más checkboxes múltiples:
         * String[] habilidades = request.getParameterValues("habilidades");
         * empleado.setHabilidades(habilidades != null ? habilidades : new String[]{});
         * 
         * // Input date:
         * empleado.setFechaNacimiento(request.getParameter("fechaNacimiento"));
         * 
         * // Más checkboxes individuales:
         * empleado.setTieneVehiculo(request.getParameter("tieneVehiculo") != null);
         */
        
        return empleado;
    }
}