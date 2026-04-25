2package controlador;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;


import modelo.dao.UsuarioDAO;
import modelo.vo.UsuarioVO;


@WebServlet("/usuario")
public class UsuarioControladorServlet extends HttpServlet {
    // DAO
    private final UsuarioDAO dao = new UsuarioDAO();


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
                request.getRequestDispatcher("/vista/usuario-form.jsp").forward(request, response);
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
            response.sendRedirect(request.getContextPath() + "/alumno");
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
                response.sendRedirect(request.getContextPath() + "/alumno");
                break;
        }
    }


    // ===================== Acciones privadas =====================


    private void listar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            request.setAttribute("usuarios", dao.listarUsuario());
        } catch (Exception e) {
            request.setAttribute("error", "Error al listar alumnos: " + e.getMessage());
            e.printStackTrace();
        }
        request.getRequestDispatcher("/vista/alumno-lista.jsp").forward(request, response);
    }


    private void agregar(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        try {
            int cedula = Integer.parseInt(request.getParameter("cedula"));
            String nombre = request.getParameter("nombre");
            String apellido = request.getParameter("apellido");
            String f_Nacimiento = request.getParameter("f_Nacimiento");
            String direccion = request.getParameter("direccion");
            String enfermedad = request.getParameter("enfermedad");
            String mutualista = request.getParameter("mutualista");
            String adultResponsable = request.getParameter("adultResponsable");
            String numAdult = request.getParameter("numAdult");


            UsuarioVO usuario = new UsuarioVO(cedula,nombre, apellido,f_Nacimiento,direccion,enfermedad,mutualista,adultResponsable,numAdult );
            dao.agregarUsuario(usuario);


            response.sendRedirect(request.getContextPath() + "/usuario"); // PRG
        } catch (Exception e) {
            System.err.println("ERROR al agregar usuario: " + e.getMessage());
            e.printStackTrace();
            request.setAttribute("error", "No se pudo guardar el usuario: " + e.getMessage());
            request.getRequestDispatcher("/vista/usuario-form.jsp").forward(request, response);
        }
    }


    private void mostrarEditar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int cedula = Integer.parseInt(request.getParameter("cedula"));
            UsuarioVO usuario = dao.obtenerUsuarioporCedula(cedula);
            request.setAttribute("usuario", usuario;
            request.getRequestDispatcher("/vista/usuario-editar.jsp").forward(request, response);
        } catch (Exception e) {
            System.err.println("ERROR al mostrar editar: " + e.getMessage());
            e.printStackTrace();
            request.setAttribute("error", "No se pudo cargar el usuario: " + e.getMessage());
            listar(request, response);
        }
    }


    private void actualizar(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        try {
            int cedula = Integer.parseInt(request.getParameter("cedula"));
            String nombre = request.getParameter("nombre");
            String apellido = request.getParameter("apellido");
            String f_Nacimiento = request.getParameter("f_Nacimiento");
            String direccion = request.getParameter("direccion");
            String enfermedad = request.getParameter("enfermedad");
            String mutualista = request.getParameter("mutualista");
            String adultResponsable = request.getParameter("adultResponsable");
            String numAdult = request.getParameter("numAdult");


            boolean exito = dao.actualizarUsuario(new UsuarioVO(cedula, nombre, apellido,f_Nacimiento, direccion, enfermedad,mutualista,adultResponsable,numAdult ));


            response.sendRedirect(request.getContextPath() + "/usuario"); // PRG
        } catch (Exception e) {
            System.err.println("ERROR al actualizar usuario: " + e.getMessage());
            e.printStackTrace();
            request.setAttribute("error", "No se pudo actualizar el usuario: " + e.getMessage());
            // Intenta volver a la vista de edición si falla la actualización
            mostrarEditar(request, response);
        }
    }


    private void eliminar(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        try {
            int cedula = Integer.parseInt(request.getParameter("cedula"));
            dao.eliminarUsuario(cedula);
        } catch (Exception e) {
            System.err.println("ERROR al eliminar usuario: " + e.getMessage());
            e.printStackTrace();
            // (Opcional: podrías agregar un mensaje de error a la request
            // antes de redirigir si quisieras mostrarlo en la lista)
        }
        response.sendRedirect(request.getContextPath() + "/usuario"); // PRG
    }
}
