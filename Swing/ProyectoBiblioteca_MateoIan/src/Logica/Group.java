package Logica;

public enum Group {
	A1("A1"),
	A2("A2"),
	B1("B1"),
	B2("B2");
	
	private final String nombre;
	
	Group(String nombre){
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}
	
}
