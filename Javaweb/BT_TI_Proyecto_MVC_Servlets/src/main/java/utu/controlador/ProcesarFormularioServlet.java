package utu.controlador;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/procesar")
public class ProcesarFormularioServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String nombre = req.getParameter("nombre");
        req.setAttribute("nombre", nombre);

        req.getRequestDispatcher("resultado.jsp").forward(req, resp);
    }
}
