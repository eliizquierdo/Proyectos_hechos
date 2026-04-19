package Logica;

public enum State {
	GUARDADO("Guardado"),
	PRESTADO("Prestado");
	
	private final String nombre;
	
	State(String nombre){
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}
	
}
