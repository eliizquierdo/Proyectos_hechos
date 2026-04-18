package controlador;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/conversorServlet")
public class ConversorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        String sDinero = request.getParameter("dinero");
        String op = request.getParameter("op");

        double resultado = 0;
        String sOp = "";

        try {
            double pesos = Double.parseDouble(sDinero);

            switch (op) {
                case "dolares":
                    resultado = pesos / 40;
                    sOp = "dólares";
                    break;
                case "reales":
                    resultado = pesos / 8;
                    sOp = "reales";
                    break;
                case "pesosargentinos":
                    resultado = pesos / 0.2;
                    sOp = "pesos argentinos";
                    break;
                default:
                    sOp = "moneda desconocida";
            }

            request.setAttribute("resultado", resultado);
            request.setAttribute("operacion", sOp);
            request.getRequestDispatcher("resultado.jsp").forward(request, response);

        } catch (NumberFormatException e) {
            request.setAttribute("error", "Debe ingresar un número válido.");
            request.getRequestDispatcher("resultado.jsp").forward(request, response);
        }
    }
}
