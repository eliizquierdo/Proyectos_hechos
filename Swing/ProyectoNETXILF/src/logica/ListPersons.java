package logica;

import java.util.ArrayList;

/**
 * La clase `ListPersons` representa una lista de personas.
 */
public class ListPersons {

    /**
     * Lista de personas almacenadas.
     */
    private ArrayList<PersonsVO> list;

    /**
     * Crea una nueva instancia de la lista de personas.
     */
    public ListPersons() {
        list = new ArrayList<>();
    }

    /**
     * Agrega una persona a la lista.
     *
     * @param person La persona que se va a agregar a la lista.
     */
    public void add(PersonsVO person) {
        list.add(person);
    }

    /**
     * Obtiene la lista de personas.
     *
     * @return La lista de personas.
     */
    public ArrayList<PersonsVO> getList() {
        return list;
    }

    /**
     * Obtiene el nombre de una persona por su ID.
     *
     * @param idPersons El ID de la persona cuyo nombre se desea obtener.
     * @return El nombre de la persona si se encuentra, o null si no se encuentra.
     */
    public String getNamePersonById(String id_Persons) {
        for (PersonsVO person : list) {
        	 if (person.getId_Persons().equals(id_Persons)) {
                return person.getNamePerson();
            }
        }
        return null; // Retorna null si no se encuentra el idPersons en la lista
    }
}
