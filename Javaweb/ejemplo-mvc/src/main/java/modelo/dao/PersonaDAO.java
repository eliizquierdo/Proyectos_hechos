package modelo.dao;

import modelo.vo.PersonaVO;
import java.util.ArrayList;

public class PersonaDAO {
    private ArrayList<PersonaVO> lista;

    // constructor
    public PersonaDAO() {
        lista = new ArrayList<>();
    }

    // agrega una persona a la lista
    public void agregar(PersonaVO p) {
        lista.add(p);
    }

    // retorna la lista de personas
    public ArrayList<PersonaVO> getLista() {
        // Provisorio: cargar datos "fijos"
        lista.clear();
        PersonaVO p1 = new PersonaVO(1, "Ana");
        PersonaVO p2 = new PersonaVO(2, "María");
        this.agregar(p1);
        this.agregar(p2);
        return lista;
    }
}
