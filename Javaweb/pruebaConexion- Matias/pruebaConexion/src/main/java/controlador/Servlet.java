package controlador;

import modelo.conexion.Conexion;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;


@WebServlet("/conexion")
public class Servlet extends HttpServlet {

    private Conexion conexion = new Conexion();
    private boolean estado = false;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");

        if ("conectar".equals(accion)) {
            estado = conexion.conectar();
            request.setAttribute("mensaje", estado ? "Conectado con éxito" : "Error al conectar");

        } else if ("desconectar".equals(accion)) {
            if (conexion.estaConectado()) {
                boolean ok = conexion.desconectar();
                estado = conexion.estaConectado(); // debería quedar en false
                request.setAttribute("mensaje", ok ? "Desconectado con éxito" : "Error al desconectar");
            } else {
                estado = false;
                request.setAttribute("mensaje", "Ya estaba desconectado");
            }
        }

        request.setAttribute("estado", estado);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}


