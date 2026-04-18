package modelo.dao;

import modelo.vo.PersonaVO;
import java.util.ArrayList;

public class PersonaDAO {

    private final ArrayList<PersonaVO> lista;

    public PersonaDAO() {
        lista = new ArrayList<>();
    }

    public String insertarPersona(PersonaVO per) {
        for (PersonaVO p : lista) {
            if (p.getCedula() == per.getCedula()) {
                return "❌ La persona ya existe.";
            }
        }
        lista.add(per);
        return "✅ Persona agregada correctamente.";
    }

    public String eliminarPersona(int cedula) {
        for (PersonaVO p : lista) {
            if (p.getCedula() == cedula) {
                lista.remove(p);
                return "🗑 Persona eliminada.";
            }
        }
        return "⚠ Persona no encontrada.";
    }

    public String actualizarPersona(PersonaVO p) {
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getCedula() == p.getCedula()) {
                lista.set(i, p);
                return "🔄 Persona actualizada.";
            }
        }
        return "⚠ Persona no encontrada.";
    }

    public ArrayList<PersonaVO> listar() {
        return lista;
    }

    public PersonaVO buscarPersona(int cedula) {
        for (PersonaVO p : lista) {
            if (p.getCedula() == cedula) {
                return p;
            }
        }
        return null;
    }
}
