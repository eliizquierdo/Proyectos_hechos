package controlador;

import modelo.dao.PersonaDAO;
import modelo.vo.PersonaVO;
import java.util.List;

public class PersonaControlador {

    private final PersonaDAO dao = new PersonaDAO();

    public String agregar(PersonaVO p) {
        return dao.insertarPersona(p);
    }

    public String modificar(PersonaVO p) {
        return dao.actualizarPersona(p);
    }

    public String borrar(int cedula) {
        return dao.eliminarPersona(cedula);
    }

    public PersonaVO buscarPorCedula(int cedula) {
        return dao.buscarPersona(cedula);
    }

    public List<PersonaVO> obtenerTodas() {
        return dao.listar();
    }
       

}

