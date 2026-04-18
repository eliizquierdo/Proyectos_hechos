package logica;


public class Personaje {
	private String nombre;
	private int salud;
	private int defensa;
	
	//el constructor por defecto
	public Personaje() {
		
	}
	
	//constructor específico
	public Personaje(String nombre, int salud, int defensa ) {
		this.nombre= nombre;
		this.salud=salud;
		this.defensa=defensa;
	}	
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getSalud() {
		return salud;
	}
	public void setSalud(int salud) {
		this.salud = salud;
	}
	public int getDefensa() {
		return defensa;
	}
	public void setDefensa(int defensa) {
		this.defensa = defensa;
	}
	
	public void defender() {
		System.out.println("El personaje se defiende del ataque.");
	}
	
	@Override
	public String toString() {
		return "Nombre: "+ nombre+ "\nSalud: "+salud+"\nDefensa: "+defensa;
	}
	
}
