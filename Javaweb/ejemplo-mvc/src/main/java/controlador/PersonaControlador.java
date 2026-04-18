package controlador;

import modelo.dao.PersonaDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;

@WebServlet("/personas")
public class PersonaControlador extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PersonaDAO dao = new PersonaDAO();

        // Verificación en consola
        System.out.println("Servlet ejecutado");
        System.out.println("Lista contiene: " + dao.getLista().size() + " personas");

        // 👉 Reenvía al JSP una sola vez
        request.setAttribute("personas", dao.getLista());
        RequestDispatcher dispatcher = request.getRequestDispatcher("vista/persona.jsp");
        dispatcher.forward(request, response);
    }
}
