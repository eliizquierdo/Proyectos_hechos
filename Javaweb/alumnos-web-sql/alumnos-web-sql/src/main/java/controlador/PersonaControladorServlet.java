package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import modelo.dao.PersonaDAO;
import modelo.vo.PersonaVO;

@WebServlet("/persona")
public class PersonaControladorServlet extends HttpServlet {
    private final PersonaDAO dao = new PersonaDAO();

    // ======================== GET ========================
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        if (action == null)
            action = "";

        switch (action) {
            case "agregar": // mostrar formulario de alta (GET)
                // Recuperamos un posible mensaje (error al POSTear, por ejemplo)
                String mensajeForm = request.getParameter("mensaje");
                if (mensajeForm != null) {
                    request.setAttribute("mensaje", mensajeForm);
                }
                request.getRequestDispatcher("/vista/persona-form.jsp")
                        .forward(request, response);
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

            default:
                response.sendRedirect(request.getContextPath() + "/persona");
        }
    }

    // ===================== Acciones privadas =====================
    private void agregar(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        try {
            // Intentamos parsear el código. Un error aquí lanza NumberFormatException
            int codigo = Integer.parseInt(request.getParameter("codigo")); 
            String nombre = request.getParameter("nombre");
            
            boolean exito = dao.agregarPersona(new PersonaVO(codigo, nombre));
            
            // Implementación con Post-Redirect-Get (PRG)
            if (exito) {
                // Éxito: Redirige a la lista para ver el nuevo elemento
                response.sendRedirect(request.getContextPath() + "/persona?mensaje=ok");
            } else {
                // Error de la DAO (ej: llave duplicada, etc.): Redirige al formulario con mensaje
                response.sendRedirect(request.getContextPath() + "/persona?action=agregar&mensaje=error_dao");
            }
        } catch (NumberFormatException e) {
            // Error de formato de datos: Redirige al formulario con mensaje
            // Es buena práctica validar también que el nombre no sea null/vacío
            response.sendRedirect(request.getContextPath() + "/persona?action=agregar&mensaje=formato_invalido");
        }
    }

    private void listar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Recuperamos un posible mensaje (ej: después de un éxito en agregar)
        String mensaje = request.getParameter("mensaje");
        if (mensaje != null) {
            request.setAttribute("mensaje", mensaje);
        }
        
        request.setAttribute("personas", dao.listarPersonas());
        request.getRequestDispatcher("/vista/persona-lista.jsp")
                .forward(request, response);
    }
}