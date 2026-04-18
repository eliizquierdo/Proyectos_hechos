package controlador;

import modelo.dao.PerroDAO;
import modelo.vo.PerroVO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "PerroServlet", urlPatterns = {"/PerroServlet"})
public class PerroServlet extends HttpServlet {

    private PerroDAO perroDAO = new PerroDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        if ("listar".equalsIgnoreCase(action)) {
            List<PerroVO> perros = perroDAO.listarPerros();
            request.setAttribute("listaPerros", perros);
            RequestDispatcher dispatcher = request.getRequestDispatcher("listarPerro.jsp");
            dispatcher.forward(request, response);
        } else if ("irAgregar".equalsIgnoreCase(action)) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("agregarPerro.jsp");
            dispatcher.forward(request, response);
        } else {
            response.sendRedirect("index.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        if ("agregar".equalsIgnoreCase(action)) {
            String nombre = request.getParameter("nombre");
            String raza = request.getParameter("raza");
            perroDAO.agregarPerro(nombre, raza);
            response.sendRedirect("PerroServlet?action=listar");
        } else {
            response.sendRedirect("index.jsp");
        }
    }
}