package controlador;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import modelo.dao.PersonaDAO;
import modelo.vo.EmpleadoVO;
import modelo.dao.EmpleadoDAO;
import java.util.List;

@WebServlet(name = "EmpleadoServlet", urlPatterns = {"/EmpleadoServlet"})
public class EmpleadoServlet extends HttpServlet {
    EmpleadoDAO daoE = new EmpleadoDAO();
    PersonaDAO dao = new PersonaDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");

        if (accion == null) {
            response.sendRedirect("index.jsp");
        } else if (accion.equals("listar")) {
            List<EmpleadoVO> lista = daoE.listarEmpleado();
            request.setAttribute("empleado", lista);
            RequestDispatcher rd = request.getRequestDispatcher("mostrarEmpleado.jsp");
            rd.forward(request, response);


        } else if (accion.equals("nuevo")) {
            RequestDispatcher rd = request.getRequestDispatcher("agregarEmpleado.jsp");
            rd.forward(request, response);


        } else if (accion.equals("modificar")) {
            RequestDispatcher rd = request.getRequestDispatcher("modificarEmpleado.jsp");
            int cedula = Integer.parseInt(request.getParameter("cedula"));
            request.setAttribute("empleado", dao.obtenerPersona(cedula, "empleado"));
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
            double sueldo = Integer.parseInt(request.getParameter("sueldo"));

            EmpleadoVO m = new EmpleadoVO(cedula, nombre, telefono, categoria, sueldo);
            dao.agregarPersona(m, "empleado");

            response.sendRedirect("EmpleadoServlet?accion=listar");

            
        } else if ("eliminar".equals(accion)) {
            int cedula = Integer.parseInt(request.getParameter("cedula"));
            dao.eliminarPersona(cedula, "empleado");
            String prs = "empleado";
            dao.eliminarPersona(cedula, prs);
            response.sendRedirect("EmpleadoServlet?accion=listar");


        } else if ("modificar".equals(accion)){
            int cedula = Integer.parseInt(request.getParameter("cedula"));
            String nombre = request.getParameter("nombre");
            int telefono = Integer.parseInt(request.getParameter("telefono"));
            String categoria = request.getParameter("categoria");
            double sueldo = Integer.parseInt(request.getParameter("sueldo"));
        
            EmpleadoVO m = new EmpleadoVO(cedula, nombre, telefono, categoria, sueldo);
            dao.modificarPersona(m, "empleado");

            response.sendRedirect("ProfesorServlet?accion=listar");
        }
    }
}