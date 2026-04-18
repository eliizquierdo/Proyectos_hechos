package Logica;

public enum Subject {
	MATEMATICAS("Matematicas"),
	INGLES("Ingles"),
	FISICA("Física"),
	QUIMICA("Química"),
	HISTORIA("Historia"),
	GEOGRAFIA("Geografía");
	
	private final String nombre;
	
	Subject(String nombre){
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}
	
}
