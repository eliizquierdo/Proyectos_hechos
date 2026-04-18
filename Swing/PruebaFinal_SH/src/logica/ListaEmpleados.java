package logica;

import java.util.ArrayList;

public class ListaEmpleados {

	private ArrayList<Empleado> lista;

	public ListaEmpleados() {
		lista = new ArrayList<>();
	}

	public String listarEmpleados() {
		String listaFinal = "nroEmpleado \tNombre \tApellido \tValor Jornal \tCantidad de dias\tExtra\n";
		if (lista.isEmpty()) {
			return "No hay productos en la lista.";
		} else {
			for (int i = 0; i < lista.size(); i++) {
				listaFinal += lista.get(i).toString() + "\n";
			}
			return listaFinal;
		}
	}

}
