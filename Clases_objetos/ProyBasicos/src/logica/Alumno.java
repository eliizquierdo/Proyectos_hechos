package logica;

import java.util.Scanner;

public class Alumno {
	// atributos
	private int codigo;
	private String apellido;
	private int grupo;
	private double cuotaBase;

	// constructor por defecto
	public Alumno() {

	}

	// constructor especÃ­fico
	public Alumno(int cod, String ape, int gru, double cu) {
		codigo = cod;
		apellido = ape;
		grupo = gru;
		cuotaBase = cu;

	}

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

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

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
		return "\ncodigo: " + codigo +
				"\napellido: " + apellido +
				"\ngrupo: " + grupo +
				"\ncuotaBase: " + cuotaBase;

	}

	public void pedirDatos() {
		Scanner teclado = new Scanner(System.in);

		System.out.println("Ingrese apellido: ");
		setApellido(teclado.next());
		System.out.println("Ingrese grupo: ");
		setGrupo(teclado.nextInt());
		System.out.println("Ingrese cuotaBase: ");
		setCuotaBase(teclado.nextDouble());
		System.out.println("Ingrese fecha de nacimiento: ");

	}

}
