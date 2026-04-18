package controlador;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import modelo.*;

@WebServlet("/ProductoServlet")
public class ProductoServlet extends HttpServlet {
    private ProductoDAO dao = new ProductoDAO();

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) action = "listar";
        switch (action) {
            case "nuevo":
                req.getRequestDispatcher("jsp/formulario.jsp").forward(req, res);
                break;
            case "editar":
                int id = Integer.parseInt(req.getParameter("id"));
                req.setAttribute("producto", dao.obtenerPorId(id));
                req.getRequestDispatcher("jsp/formulario.jsp").forward(req, res);
                break;
            case "eliminar":
                dao.eliminar(Integer.parseInt(req.getParameter("id")));
                res.sendRedirect("ProductoServlet");
                break;
            default:
                req.setAttribute("listaProductos", dao.obtenerTodos());
                req.getRequestDispatcher("jsp/productos.jsp").forward(req, res);
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String action = req.getParameter("action");
        String nombre = req.getParameter("nombre");
        double precio = Double.parseDouble(req.getParameter("precio"));
        if ("insertar".equals(action)) {
            dao.insertar(new Producto(0, nombre, precio));
        } else if ("actualizar".equals(action)) {
            int id = Integer.parseInt(req.getParameter("id"));
            dao.actualizar(new Producto(id, nombre, precio));
        }
        res.sendRedirect("ProductoServlet");
    }
}