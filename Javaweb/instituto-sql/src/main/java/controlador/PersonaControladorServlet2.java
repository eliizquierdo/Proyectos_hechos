package controlador;

import java.io.IOException;
import java.util.List; // ← AGREGADO: Import faltante
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import modelo.dao.PersonaDAO;
import modelo.vo.PersonaVO;

@WebServlet("/persona")
public class PersonaControladorServlet2 extends HttpServlet {
    private final PersonaDAO dao = new PersonaDAO();

    // ======================== GET ========================
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        if (action == null) action = "";

        switch (action) {
            case "agregar": // mostrar formulario de alta (GET)
                request.getRequestDispatcher("/vista/persona-form.jsp")
                        .forward(request, response);
                break;

            case "cargarEditar": // mostrar formulario de edición (GET)
                cargarEditar(request, response);
                break;

            case "listar": // listar explícito
                listar(request, response);
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
            response.sendRedirect(request.getContextPath() + "/persona");
            return;
        }

        switch (action) {
            case "agregar":
                agregar(request, response);
                break;
            case "editar": // ← CORREGIDO: Descomentado
                editar(request, response);
                break;
            case "eliminar":
                eliminar(request, response);
                break;
            default:
                response.sendRedirect(request.getContextPath() + "/persona");
        }
    }

    // ===================== Acciones privadas =====================
    private void agregar(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException { // ← AGREGADO: ServletException
        
        try {
            // ← AGREGADO: Validación de parámetros
            String codigoStr = request.getParameter("codigo");
            String nombre = request.getParameter("nombre");
            String apellido = request.getParameter("apellido");
            
            System.out.println("Agregando - Código: " + codigoStr + ", Nombre: " + nombre + ", Apellido: " + apellido);
            
            if (codigoStr == null || nombre == null || apellido == null ||
                codigoStr.trim().isEmpty() || nombre.trim().isEmpty() || apellido.trim().isEmpty()) {
                
                request.setAttribute("error", "Todos los campos son obligatorios");
                request.getRequestDispatcher("/vista/persona-form.jsp").forward(request, response);
                return;
            }
            
            int codigo = Integer.parseInt(codigoStr);
            PersonaVO persona = new PersonaVO(codigo, nombre.trim(), apellido.trim());
            
            boolean exito = dao.agregarPersona(persona); // ← CORREGIDO: Verificar resultado
            
            if (exito) {
                System.out.println("Persona agregada exitosamente");
                response.sendRedirect(request.getContextPath() + "/persona?action=listar");
            } else {
                request.setAttribute("error", "Error al agregar la persona");
                request.getRequestDispatcher("/vista/persona-form.jsp").forward(request, response);
            }
            
        } catch (NumberFormatException e) { // ← AGREGADO: Manejo de errores
            System.err.println("Error: Código debe ser numérico - " + e.getMessage());
            request.setAttribute("error", "El código debe ser un número válido");
            request.getRequestDispatcher("/vista/persona-form.jsp").forward(request, response);
        } catch (Exception e) {
            System.err.println("Error en agregar: " + e.getMessage());
            e.printStackTrace();
            request.setAttribute("error", "Error interno del servidor");
            request.getRequestDispatcher("/vista/persona-form.jsp").forward(request, response);
        }
    }

    private void cargarEditar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            String codigoStr = request.getParameter("codigo"); // ← CORREGIDO: Validación
            
            if (codigoStr == null || codigoStr.trim().isEmpty()) {
                response.sendRedirect(request.getContextPath() + "/persona");
                return;
            }
            
            int codigo = Integer.parseInt(codigoStr);
            PersonaVO persona = dao.obtenerPersonaPorCodigo(codigo);

            if (persona != null) {
                request.setAttribute("persona", persona);
                request.getRequestDispatcher("/vista/persona-editar.jsp").forward(request, response);
            } else {
                System.out.println("No se encontró persona con código: " + codigo);
                response.sendRedirect(request.getContextPath() + "/persona");
            }
            
        } catch (NumberFormatException e) { // ← AGREGADO: Manejo de errores
            System.err.println("Código inválido para editar: " + e.getMessage());
            response.sendRedirect(request.getContextPath() + "/persona");
        }
    }

    private void editar(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException { // ← AGREGADO: ServletException
        
        try {
            // ← AGREGADO: Validación completa
            String codigoStr = request.getParameter("codigo");
            String nombre = request.getParameter("nombre");
            String apellido = request.getParameter("apellido");
            
            System.out.println("Editando - Código: " + codigoStr + ", Nombre: " + nombre + ", Apellido: " + apellido);
            
            if (codigoStr == null || nombre == null || apellido == null ||
                codigoStr.trim().isEmpty() || nombre.trim().isEmpty() || apellido.trim().isEmpty()) {
                
                request.setAttribute("error", "Todos los campos son obligatorios");
                // Recargar datos para el formulario
                int codigo = Integer.parseInt(codigoStr);
                PersonaVO persona = dao.obtenerPersonaPorCodigo(codigo);
                request.setAttribute("persona", persona);
                request.getRequestDispatcher("/vista/persona-editar.jsp").forward(request, response);
                return;
            }
            
            int codigo = Integer.parseInt(codigoStr);
            PersonaVO persona = new PersonaVO(codigo, nombre.trim(), apellido.trim());
            
            boolean exito = dao.actualizarPersona(persona); // ← CORREGIDO: Verificar resultado
            
            if (exito) {
                System.out.println("Persona editada exitosamente");
                response.sendRedirect(request.getContextPath() + "/persona?action=listar");
            } else {
                request.setAttribute("error", "No se pudo actualizar - persona no encontrada");
                request.setAttribute("persona", persona);
                request.getRequestDispatcher("/vista/persona-editar.jsp").forward(request, response);
            }
            
        } catch (NumberFormatException e) { // ← AGREGADO: Manejo de errores
            System.err.println("Error: Código debe ser numérico - " + e.getMessage());
            request.setAttribute("error", "El código debe ser un número válido");
            response.sendRedirect(request.getContextPath() + "/persona");
        } catch (Exception e) {
            System.err.println("Error en editar: " + e.getMessage());
            e.printStackTrace();
            request.setAttribute("error", "Error interno del servidor");
            response.sendRedirect(request.getContextPath() + "/persona");
        }
    }

    private void eliminar(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        
        try {
            String codigoStr = request.getParameter("codigo"); // ← CORREGIDO: Validación
            
            if (codigoStr == null || codigoStr.trim().isEmpty()) {
                response.sendRedirect(request.getContextPath() + "/persona");
                return;
            }
            
            int codigo = Integer.parseInt(codigoStr);
            
            boolean exito = dao.eliminarPersona(codigo); // ← CORREGIDO: Verificar resultado
            
            if (exito) {
                System.out.println("Persona eliminada exitosamente");
            } else {
                System.out.println("No se pudo eliminar - persona no encontrada");
            }
            
            response.sendRedirect(request.getContextPath() + "/persona?action=listar");
            
        } catch (NumberFormatException e) { // ← AGREGADO: Manejo de errores
            System.err.println("Código inválido para eliminar: " + e.getMessage());
            response.sendRedirect(request.getContextPath() + "/persona");
        }
    }

    private void listar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            List<PersonaVO> personas = dao.listarPersonas(); // ← AGREGADO: Variable local
            System.out.println("Listando personas - Total encontradas: " + personas.size());
            
            request.setAttribute("personas", personas);
            request.getRequestDispatcher("/vista/persona-lista.jsp").forward(request, response);
            
        } catch (Exception e) { // ← AGREGADO: Manejo de errores
            System.err.println("Error al listar personas: " + e.getMessage());
            e.printStackTrace();
            request.setAttribute("error", "Error al cargar la lista de personas");
            request.getRequestDispatcher("/vista/error.jsp").forward(request, response);
        }
    }
}