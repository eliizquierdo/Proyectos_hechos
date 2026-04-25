package herencia.vehiculos;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ListadoVehiculos
{
    List lista;
    
    public ListadoVehiculos()
    {
        this.lista = new LinkedList();
    }
    
    public String agregar(Vehiculo v)
    {
        this.lista.add(v);
        return "Ingreso Exitoso.";
    }
    
    public String imprimir()
    {
        String s = "";
        Iterator items = this.lista.iterator();
        while(items.hasNext())
        {
            
        }
        return s;
    }
}
