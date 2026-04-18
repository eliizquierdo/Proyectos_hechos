package logica;

import java.util.Scanner;

public class Alumno {
	//atributos
	private String apellido;
	private int grupo;
	private double cuotaBase;
	private Fecha nacimiento ;
	
	//constructor por defecto
	public Alumno() {
		nacimiento=new Fecha();
	}
	
	//constructor específico
	public Alumno(String ape, int gru, double cu, Fecha nacim) {
		apellido=ape;
		grupo=gru;
		cuotaBase=cu;
		nacimiento= nacim;
	}
	
	//getter y setter	get:obtener y set:poner
	public String getApellido() {
		return apellido;
	}
	
	public void setApellido(String apellido) {
		this.apellido=apellido;
	}
	
	public int getGrupo() {
		return grupo;
	}
	
	public void setGrupo(int gru) {
		grupo=gru;
	}
	
	public double getCuotaBase() {
		return cuotaBase;
	}
	
	public void setCuotaBase(double cuota) {
		cuotaBase=cuota;
	}
	
	public Fecha getNacimiento() {
		return nacimiento;
	}
	
	public void setNacimiento(Fecha nac) {
		nacimiento=nac;
	}
	
	//metodo especifico
	public boolean boletoGratis() {
		boolean siCorresponde = false;
		int edad=2020-nacimiento.getAnio();
		
		if (edad<18)
			siCorresponde = true;
		return siCorresponde;
	}
	
	public double cuotaNeta() {
		double monto = cuotaBase;
		if (grupo == 1 || grupo == 2)
			monto = cuotaBase * 0.60;
		if (grupo == 3 || grupo == 4)
			monto = cuotaBase * 0.80;
		return monto;
	}
	
	//toString
	@Override
	public String toString() {
		return "\n"+apellido+
				"\t"+grupo+
				"\t"+cuotaBase+
				"\t"+cuotaNeta()+
				"\t"+nacimiento.toString();
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
		this.nacimiento.pedirDatos();
	}

}
