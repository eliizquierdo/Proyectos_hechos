package controlador;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import modelo.dao.EmpleadoDAO;
import modelo.vo.EmpleadoVO;
import java.util.List;

@WebServlet(name = "EmpleadoServlet", urlPatterns = { "/EmpleadoServlet" })
public class EmpleadoServlet extends HttpServlet {

    EmpleadoDAO dao = new EmpleadoDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");

        if (accion == null) {
            response.sendRedirect("index.jsp");
        } else if (accion.equals("listar")) {
            List<EmpleadoVO> lista = dao.listarEmpleado();
            request.setAttribute("Empleado", lista);
            RequestDispatcher rd = request.getRequestDispatcher("mostrarEmpleado.jsp");
            rd.forward(request, response);

        } else if (accion.equals("nuevo")) {
            RequestDispatcher rd = request.getRequestDispatcher("agregarEmpleado.jsp");
            rd.forward(request, response);

        } else if (accion.equals("modificar")) {
            int cedula = Integer.parseInt(request.getParameter("cedula"));
            // Buscamos el Empleado y lo seteamos en el request
            EmpleadoVO empleado = dao.obtenerEmpleado(cedula);
            request.setAttribute("Empleado", empleado);

            RequestDispatcher rd = request.getRequestDispatcher("modificarEmpleado.jsp");
            rd.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");

        if ("agregar".equals(accion)) {
            int cedula = Integer.parseInt(request.getParameter("cedula"));
            String nombre = request.getParameter("nombre");
            int telefono = Integer.parseInt(request.getParameter("telefono"));
            String categoria = request.getParameter("categoria");

            // CORRECCIÓN: Usar Double.parseDouble y cast a int para manejar el ".0"
            int sueldo = (int) Double.parseDouble(request.getParameter("sueldo"));

            EmpleadoVO m = new EmpleadoVO(cedula, nombre, telefono, categoria, sueldo);
            dao.agregarEmpleado(m);
            response.sendRedirect("EmpleadoServlet?accion=listar");

        } else if ("eliminar".equals(accion)) {
            int cedula = Integer.parseInt(request.getParameter("cedula"));
            dao.eliminarEmpleado(cedula);
            response.sendRedirect("EmpleadoServlet?accion=listar");

        } else if ("modificar".equals(accion)) {
            int cedula = Integer.parseInt(request.getParameter("cedula"));
            String nombre = request.getParameter("nombre");
            int telefono = Integer.parseInt(request.getParameter("telefono"));
            String categoria = request.getParameter("categoria");

            // CORRECCIÓN: Usar Double.parseDouble y cast a int para manejar el ".0"
            int sueldo = (int) Double.parseDouble(request.getParameter("sueldo")); // <-- ESTA ES LA LÍNEA CORREGIDA
                                                                                   // (Línea 83 aprox.)

            EmpleadoVO e = new EmpleadoVO(cedula, nombre, telefono, categoria, sueldo);
            dao.modificarEmpleado(e);
            response.sendRedirect("EmpleadoServlet?accion=listar");
        }
    }
}