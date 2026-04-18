package controlador;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.dao.PersonaDAO;
import modelo.vo.PersonaVO;

@WebServlet("/personas")
public class PersonaControlador extends HttpServlet {

    private PersonaDAO dao;

    @Override
    public void init() throws ServletException {
        dao = new PersonaDAO(); // DAO compartido para persistencia en memoria
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");
        String codParam = request.getParameter("codigo");
        String nombre = request.getParameter("nombre");
        int cod = codParam != null && !codParam.isEmpty() ? Integer.parseInt(codParam) : -1;

        String mensaje = "";

        if (accion != null) {
            switch (accion) {
                case "agregar":
                    if (!dao.estaPersona(cod)) {
                        dao.agregar(new PersonaVO(cod, nombre));
                        mensaje = "Persona agregada correctamente.";
                    } else {
                        mensaje = "Ya existe una persona con ese código.";
                    }
                    break;
                case "actualizar":
                    mensaje = dao.actualizar(new PersonaVO(cod, nombre));
                    break;
                case "eliminar":
                    mensaje = dao.eliminar(cod);
                    break;
                default:
                    mensaje = "Acción desconocida.";
            }
        }

        request.setAttribute("mensaje", mensaje);
        request.setAttribute("personas", dao.getLista());
        request.getRequestDispatcher("vista/persona.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("personas", dao.getLista());
        request.getRequestDispatcher("vista/persona.jsp").forward(request, response);
    }
}
