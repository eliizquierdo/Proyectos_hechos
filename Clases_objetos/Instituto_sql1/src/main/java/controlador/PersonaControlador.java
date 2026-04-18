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
        return dao.actualizar(p);
    }

    public String borrar(int cedula) {
        return dao.eliminar(cedula);
    }

    public PersonaVO buscar(int cedula) {
        return dao.buscar(cedula);
    }

    public List<PersonaVO> obtenerTodas() {
        return dao.listar();
    }
}
