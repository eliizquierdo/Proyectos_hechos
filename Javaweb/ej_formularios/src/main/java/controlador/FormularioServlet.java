package controlador;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/formulario")
public class FormularioServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("/WEB-INF/vista/formularioNombre.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding(StandardCharsets.UTF_8.name());

        String nombre = trimOrNull(request.getParameter("nombre"));
        String apellido = trimOrNull(request.getParameter("apellido"));
        String anioStr = trimOrNull(request.getParameter("anio"));

        // Repoblar campos si hay error
        request.setAttribute("nombre", nombre);
        request.setAttribute("apellido", apellido);
        request.setAttribute("anio", anioStr);

        String error = validar(nombre, apellido, anioStr);
        if (error != null) {
            request.setAttribute("error", error);
            request.getRequestDispatcher("/WEB-INF/vista/formularioNombre.jsp")
                    .forward(request, response);
            return;
        }

        int anioNacimiento = Integer.parseInt(anioStr);
        int anioActual = Calendar.getInstance().get(Calendar.YEAR);
        int edad = anioActual - anioNacimiento;

        String mensaje = (edad >= 18) ? "Podés votar." : "Todavía no podés votar.";

        request.setAttribute("edad", edad);
        request.setAttribute("mensaje", mensaje);

        request.getRequestDispatcher("/WEB-INF/vista/resultado.jsp")
                .forward(request, response);
    }

    // ===== Helpers =====
    private static String trimOrNull(String s) {
        return (s == null) ? null : s.trim();
    }

    private static String validar(String nombre, String apellido, String anioStr) {
        if (nombre == null || nombre.isEmpty())
            return "El nombre es obligatorio.";
        if (apellido == null || apellido.isEmpty())
            return "El apellido es obligatorio.";
        if (anioStr == null || anioStr.isEmpty())
            return "El año de nacimiento es obligatorio.";

        int anio;
        try {
            anio = Integer.parseInt(anioStr);
        } catch (NumberFormatException e) {
            return "El año de nacimiento debe ser un número.";
        }

        int anioActual = Calendar.getInstance().get(Calendar.YEAR);
        if (anio < 1900 || anio > anioActual) {
            return "El año ingresado no es válido. Debe estar entre 1900 y " + anioActual + ".";
        }
        return null;
    }
}
