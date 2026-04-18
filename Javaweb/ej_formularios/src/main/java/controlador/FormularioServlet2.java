package controlador;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ProcesarFormularioNombre2")
public class FormularioServlet2 extends HttpServlet {
    

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Recibir parámetros del formulario
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String edadStr = request.getParameter("edad");
        String sabor = request.getParameter("sabor");

        int edad = 0;
        String mensajeVoto;

        try {
            edad = Integer.parseInt(edadStr);
            mensajeVoto = (edad < 18)
                    ? "Y no puedes votar."
                    : "¡Puedes votar!";
        } catch (NumberFormatException e) {
            mensajeVoto = "La edad ingresada no es válida.";
        }

        // Enviar datos al JSP de resultado
        request.setAttribute("nombre", nombre);
        request.setAttribute("apellido", apellido);
        request.setAttribute("edad", edad);
        request.setAttribute("sabor", sabor);
        request.setAttribute("mensajeVoto", mensajeVoto);

        // Redirigir a resultado.jsp
        request.getRequestDispatcher("resultado.jsp").forward(request, response);
    }
}
