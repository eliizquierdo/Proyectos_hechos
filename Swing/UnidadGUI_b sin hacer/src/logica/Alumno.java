package logica;

public class Alumno {
	//atributos
	private String apellido;
	private int grupo;
	private double cuotaBase;

	//constructor por defecto
	public Alumno() {
		apellido = null;
		grupo = 0;
		cuotaBase = 0.0;

	}

	// constructor especifico
	public Alumno(String ape, int gru, double cuota) {
		apellido = ape;
		grupo = gru;
		cuotaBase = cuota;
	}

	// getter y setter get:obtener y set:poner
	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getGrupo() {
		return grupo;
	}

	public void setGrupo(int gru) {
		grupo = gru;
	}

	public double getCuotaBase() {
		return cuotaBase;
	}

	public void setCuotaBase(double cuota) {
		cuotaBase = cuota;
	}
	
	// metodos específicos
	public double cuotaNeta() {
		double monto = cuotaBase;
		if (grupo == 1 || grupo == 2)
			monto = cuotaBase * 0.60;
		if (grupo == 3 || grupo == 4)
			monto = cuotaBase * 0.80;
		return monto;
	}

	

	// toString
	@Override
	public String toString() {
		return "apellido: " + apellido + "\n" +
				" grupo: " + grupo + "\n" + 
				" cuotaBase: " + cuotaBase + "\n";

	}

}
