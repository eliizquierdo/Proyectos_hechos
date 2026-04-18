package logica;


	public class RobotCompetencia extends Robot {
	    // Atributo adicional
	    private double velocidad;

	    // Constructor completo
	    public RobotCompetencia(int id, String nombre, int anio, double velocidad) {
	        super(id, nombre, anio); // Llama al constructor de Vehiculo
	        this.velocidad = velocidad;
	    }

	    
	    public double getVelocidad() {
	        return velocidad;
	    }

	    public void setVelocidad(double velocidad) {
	        this.velocidad = velocidad;
	    }

	    
	    public String toString() {
	        return super.toString() +
	               ", velocidad=" + velocidad;
	    }
	    

	    
	}

