package modelo;

import java.util.ArrayList;

public class Empleados {
	
	private ArrayList<Empleado> lista;

	public Empleados() {
		lista = new ArrayList<>();
	}
	
	public void agregar(Empleado e) {
		lista.add(e);
	}
	
	public void eliminar(int i){
		if (i >= 0 && i < lista.size()) {
			lista.remove(i);
		}
	}
	
	public int cantidad() {
		return lista.size();
	}
	
	public Empleado devolver(int i) {
		if (i >= 0 && i < lista.size()) {
			return lista.get(i);
		}
		return null; // Retorna null si el índice no es válido
	}
	
	public boolean contiene(Empleado e) {
		return lista.contains(e);
	}
	
	// Calcular el total de sueldos
	public double totalSueldos() {
		double suma = 0;
		for (Empleado actual : lista) {
			suma += actual.sueldo();
		}
		return suma;
	}
	
	public int totalVendedores() {
		int cantidad = 0;
		for (Empleado actual : lista) {
			if (actual instanceof Vendedor) {
				cantidad++;
			}
		}
		return cantidad;
	}
	
	@Override
	public String toString() {
		StringBuilder temp = new StringBuilder("Nombre \tApellido \tSueldo\n");
		for (Empleado actual : lista) {
			temp.append(actual.toString()).append("\n");
		}
	
		temp.append("Suma de sueldos = ").append(totalSueldos())
		    .append("\nTotal de vendedores = ").append(totalVendedores());
		return temp.toString();
	}
}
