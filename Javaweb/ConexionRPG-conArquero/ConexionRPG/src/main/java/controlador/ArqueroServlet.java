package controlador;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import modelo.dao.ArqueroDAO;
import modelo.vo.ArqueroVO;
import java.util.List;

@WebServlet(name = "ArqueroServlet", urlPatterns = {"/ArqueroServlet"})
public class ArqueroServlet extends HttpServlet {

    ArqueroDAO dao = new ArqueroDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");

        if (accion == null) {
            response.sendRedirect("index.jsp");
        } else if (accion.equals("listar")) {
            List<ArqueroVO> lista = dao.listarArquero();
            request.setAttribute("arqueros", lista);
            RequestDispatcher rd = request.getRequestDispatcher("mostrarArquero.jsp");
            rd.forward(request, response);
        } else if (accion.equals("nuevo")) {
            RequestDispatcher rd = request.getRequestDispatcher("agregarArquero.jsp");
            rd.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nombre = request.getParameter("nombre");
        int cat_Flechas = Integer.parseInt(request.getParameter("cat_Flechas"));
        int nivel = Integer.parseInt(request.getParameter("nivel"));

        ArqueroVO a = new ArqueroVO(nombre, cat_Flechas, nivel);
        dao.agregarArquero(a);

        response.sendRedirect("ArqueroServlet?accion=listar");
    }
}
