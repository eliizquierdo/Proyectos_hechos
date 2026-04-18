package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "conversor", urlPatterns = { "/conversor" })
public class ConversorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        double dolares, euros;
        String dolaresQueEnvia, eurosQueEnvia, dolaresQueDevuelve, eurosQueDevuelve;

        try {
            out.println("<html>");
            out.println("<head>");
            out.println("</head>");
            out.println("<body>");

            dolaresQueEnvia = request.getParameter("txtDolares");
            eurosQueEnvia = request.getParameter("txtEuros");
            if (!dolaresQueEnvia.equals("")) {
                dolares = Double.valueOf(dolaresQueEnvia).doubleValue();
                euros = dolares * 0.71;
                eurosQueDevuelve = Double.toString(euros);
                out.println(dolaresQueEnvia + " dolares son " + eurosQueDevuelve + " euros.<br>");
            }
            if (!eurosQueEnvia.equals("")) {
                euros = Double.valueOf(eurosQueEnvia).doubleValue();
                dolares = euros * 1.73;
                dolaresQueDevuelve = Double.toString(dolares);
                out.println(eurosQueEnvia + " euros son " + dolaresQueDevuelve + " dolares.<br>");
            }
            out.println("</body>");
            out.println("</html>");

        } finally {
            out.close();
        }
    }

}
