package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegistroServlet")
public class RegistroServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nombre = request.getParameter("nombre");
        String bebida = request.getParameter("bebida");

        // Guardamos los datos en atributos de la request
        request.setAttribute("nombre", nombre);
        request.setAttribute("bebida", bebida);

        // Redirigimos a la JSP de salida
        request.getRequestDispatcher("resultado.jsp").forward(request, response);
    }
}