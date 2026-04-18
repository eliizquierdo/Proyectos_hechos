package logica;

import java.util.ArrayList;

public class Tienda {

	private ArrayList<Celular> inventario;

	public Tienda() {
		inventario = new ArrayList<>();
	}

	public void agregarCelular(Celular c) {
		inventario.add(c);
	}

	public void vende(int i) {
		inventario.remove(i);
	}

	public void venderCelular(int codigo) {
		int i = 0;
		boolean encelu = false;
		do {
			if (inventario.get(i).getCodigo() == codigo) {
				inventario.remove(i);
				encelu = true;
			} else
				i++;
		} while (i < inventario.size() || !encelu);
	}
}
