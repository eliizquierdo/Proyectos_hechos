package pruebaControlador;

import java.util.ArrayList;

public class Datos {
	private ArrayList<String> nombres;
	private int pos;
	private String nomb;

	public Datos(ArrayList<String> nombres, int pos, String name) {
		this.nombres = new ArrayList<String>();
		this.pos = 0;
		this.nomb = name;
	}

	public Datos() {

	}

	public ArrayList<String> getNombres() {
		return nombres;
	}

	public void setNombres(ArrayList<String> nombresi) {
		this.nombres = nombresi;
	}

	public int getPos() {
		return pos;
	}
	
	

	public void setPos(int pos) {
		this.pos = pos;
	}

	public String getNomb() {
		return nomb;
	}

	public void setNomb(String name) {
		this.nomb = name;
	}

	public void agregarNombre(String n) {
		this.nombres.add(n);
	}

	public void borrarNombre(String nbr) {
		this.nombres.remove(nbr);
	}

	public void modificarNombre(String nombre) {
		for (int i = 0; i < this.nombres.size(); i++) {
			if (this.getNomb().equals(nombre)) {

			}
		}
	}

	public void posAdelante(int pos) {
		if (pos < nombres.size()) {
			pos++;
		}
	}

	public void posAtras(int pos) {
		if (pos > nombres.size()) {
			pos--;
		}
	}

	public int getPosAdelante() {
		return pos;
	}

	public void setPosAdelante() {
		this.posAdelante(pos);
	}
	
	public int getPosAtras() {
		return pos;
	}
	
	public void setPosAtras() {
		this.posAtras(pos);
	}
	
	

}
