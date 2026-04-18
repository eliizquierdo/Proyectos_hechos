//ESCRITO 23-7
package logica;
import java.util.ArrayList;

public class Empresa {
	private String nombre;
	private ArrayList<Empleado> listaEmpleados;
	
	public Empresa() {
		listaEmpleados=new ArrayList<>();
	}
	
	public void contratarEmpleado(Empleado e) {
		listaEmpleados.add(e);
		
	}
	
	public double calcularSueldos() {
		double suma=0;
		
		for(Empleado actual:listaEmpleados) {
			suma=suma+actual.getSueldo();
		}
		
		return suma;
	}
	
	@Override
	public String toString() {
	return "Empleados: " + listaEmpleados.toString();
	
	
	}
}
