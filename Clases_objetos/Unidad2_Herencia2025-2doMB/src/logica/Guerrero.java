package logica;
public class Guerrero extends Personaje {
	
	public int fuerza;
	
	public Guerrero() {
		super();
	}
	
	public Guerrero(String nombre, int salud, int defensa, int fuerza) {
		super(nombre, salud, defensa);
		this.fuerza=fuerza;
	}
	
	public int getFuerza() {
		return fuerza;
	}
	
	public void setFuerza(int fuerza) {
		this.fuerza=fuerza;
	}
	
	public void atacar(Personaje p) {
		int vidaActualizada =p.getSalud()-this.fuerza; 
		p.setSalud(vidaActualizada);
		System.out.println(p.getNombre()+" perdió "+ this.fuerza + " puntos de vida por el ataque de "+ this.getNombre()+".");
	}
	
	@Override
	public String toString() {
		return super.toString()+ "\nFuerza: "+ fuerza;
	}
}

