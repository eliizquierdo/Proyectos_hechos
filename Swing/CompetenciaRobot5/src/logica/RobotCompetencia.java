package logica;

public class RobotCompetencia extends Robot{
		
	private double velocidad;
	
	public RobotCompetencia(int id, String nombre, int anio, double velocidad) {
		super(id, nombre, anio);
		this.velocidad = velocidad;
		
	}

	public RobotCompetencia() {
		
	}
	
	public double getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(double velocidad) {
		this.velocidad = velocidad;
	}

	@Override
	public String toString() {
		return super.getId() + "\t" +
	        	   super.getNombre() + "\t" +
	        	   super.getAnio() + "\t" +
	        	   velocidad + "\n";
	
	}
}
