
package logica;

import java.util.ArrayList;


public class ListaClientes {
    private ArrayList<Cliente> lista;

    public ListaClientes() {
        lista = new ArrayList<>();
    }
    
    public void insertar(Cliente c){
        lista.add(c);
    } 

    @Override
    public String toString() {
        return lista.toString();
    }
    
    
}
