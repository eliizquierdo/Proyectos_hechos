package controlador;




import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;




import modelo.dao.ActividadDAO;
import modelo.vo.ActividadVO;




@WebServlet("/actividad")
public class ActividadControladorServlet extends HttpServlet {
    // DAO
    private final ActividadDAO dao = new ActividadDAO();




    // ======================== GET ========================
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {




        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = ""; // evita NPE en switch
        }




        switch (action) {
            case "agregar": // mostrar formulario de alta (GET)
                request.getRequestDispatcher("/vista/actividad-form.jsp").forward(request, response);
                break;




            case "editar": // cargar datos y mostrar formulario de edición (GET)
                mostrarEditar(request, response);
                break;




            case "eliminar": // eliminar por GET (Diseño particular)
                eliminar(request, response);
                break;




            default: // sin action o desconocida → listar
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




            case "actualizar": // Corresponde a la acción de editar por POST
                actualizar(request, response);
                break;




            default:
                // Si la acción POST es desconocida, redirigir al listado principal
                response.sendRedirect(request.getContextPath() + "/actividad");
                break;
        }
    }




    // ===================== Acciones privadas =====================




    private void listar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            request.setAttribute("actividad", dao.listarActividad());
        } catch (Exception e) {
            request.setAttribute("error", "Error al listar actividades: " + e.getMessage());
            e.printStackTrace();
        }
        request.getRequestDispatcher("/vista/actividad-lista.jsp").forward(request, response);
    }




    private void agregar(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String nombre = request.getParameter("nombre");
            String horarios = request.getParameter("horarios");
            String fecha = request.getParameter("fecha");
         




            ActividadVO actividad = new ActividDVO(id,nombre,horarios, fecha );
            dao.agregarActividad(actividad);




            response.sendRedirect(request.getContextPath() + "/actividad"); // PRG
        } catch (Exception e) {
            System.err.println("ERROR al agregar actividad: " + e.getMessage());
            e.printStackTrace();
            request.setAttribute("error", "No se pudo guardar la actividad: " + e.getMessage());
            request.getRequestDispatcher("/vista/actividad-form.jsp").forward(request, response);
        }
    }




    private void mostrarEditar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            ActividadVO actividad = dao.obtenerActividadporId(id);
            request.setAttribute("actividad", actividad);
            request.getRequestDispatcher("/vista/actividad-editar.jsp").forward(request, response);
        } catch (Exception e) {
            System.err.println("ERROR al mostrar editar: " + e.getMessage());
            e.printStackTrace();
            request.setAttribute("error", "No se pudo cargar la actividad: " + e.getMessage());
            listar(request, response);
        }
    }




    private void actualizar(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String nombre = request.getParameter("nombre");
            String horarios = request.getParameter("horarios");
            String fecha = request.getParameter("fecha");
         




       
            boolean exito = dao.actualizarActividad(new ActividadVO(id,nombre,horarios,fecha ));




            response.sendRedirect(request.getContextPath() + "/actividad"); // PRG
        } catch (Exception e) {
            System.err.println("ERROR al actualizar actividad: " + e.getMessage());
            e.printStackTrace();
            request.setAttribute("error", "No se pudo actualizar la actividad: " + e.getMessage());
            // Intenta volver a la vista de edición si falla la actualización
            mostrarEditar(request, response);
        }
    }




    private void eliminar(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            dao.eliminarActividad(id);
        } catch (Exception e) {
            System.err.println("ERROR al eliminar actividad: " + e.getMessage());
            e.printStackTrace();
            // (Opcional: podrías agregar un mensaje de error a la request
            // antes de redirigir si quisieras mostrarlo en la lista)
        }
        response.sendRedirect(request.getContextPath() + "/actividad"); // PRG
    }
}


