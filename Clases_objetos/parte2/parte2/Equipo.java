package parte2;

//parte 3
public class Equipo {

	private int numero;
	private String actividad;
	private Alumno alu1;
	private Alumno alu2;
	public Equipo(int numero, String actividad, Alumno alu1, Alumno alu2) {
		this.numero = numero;
		this.actividad = actividad;
		this.alu1 = alu1;
		this.alu2 = alu2;
	}
	public int getNumero() {
		return numero;
	}
	public String getActividad() {
		return actividad;
	}
	public Alumno getAlu1() {
		return alu1;
	}
	public Alumno getAlu2() {
		return alu2;
	}
	
	
	
}
