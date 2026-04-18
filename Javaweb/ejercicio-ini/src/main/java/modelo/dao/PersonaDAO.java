package modelo.dao;

import modelo.vo.PersonaVO;
import java.util.ArrayList;

public class PersonaDAO {
    private ArrayList<PersonaVO> lista;

    public PersonaDAO() {
        lista = new ArrayList<>();
        // Datos iniciales solo si está vacío
        lista.add(new PersonaVO(1, "Ana"));
        lista.add(new PersonaVO(2, "María"));
    }

    public void agregar(PersonaVO p) {
        lista.add(p);
    }

    public String eliminar(int cod) {
        for (PersonaVO p : lista) {
            if (p.getCod() == cod) {
                lista.remove(p);
                return "Persona eliminada.";
            }
        }
        return "Persona no encontrada.";
    }

    public String actualizar(PersonaVO p) {
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getCod() == p.getCod()) {
                lista.set(i, p);
                return "Persona actualizada.";
            }
        }
        return "Persona no encontrada.";
    }

    public boolean estaPersona(int cod) {
        for (PersonaVO p : lista) {
            if (p.getCod() == cod)
                return true;
        }
        return false;
    }

    public ArrayList<PersonaVO> getLista() {
        return lista;
    }
}
