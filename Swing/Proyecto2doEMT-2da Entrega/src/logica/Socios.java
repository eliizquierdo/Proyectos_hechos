package logica;

import java.util.Scanner;

public abstract class Socios {
	
	Scanner tec= new Scanner(System.in);
	
	private int cedula;
	private String nombre;
	private String apellido;
	private String direccion;
	private int telefono;
	
	public Socios(){
		this.cedula= 0;
		this.nombre= " ";
		this.direccion= " ";
		this.telefono= 0;
		this.apellido= " ";
	}
	
	public Socios(int cedula, String nombre, String apellido, String direccion, int telefono) {
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellido= apellido;
		this.direccion = direccion;
		this.telefono = telefono;
	}

	public int getCedula() {
		return cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public String getDireccion() {
		return direccion;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setCedula(int cedula) {
		this.cedula = cedula;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	
	public void pedirDatos(){
			
			System.out.println("------------------------------- Ingrese los datos del socio -------------------------------  " );
			
			int cedu=0;
					
			do {
				
				System.out.println("\nIngrese una cédula, sin puntos, ni guiones: "); 

					cedu= tec.nextInt();
				
										
					if(Integer.toString(cedu).length()!=8){
						System.out.println("\nIngrese exactamente 8 digitos, por favor intente nuevamente."); 
					}
					
			}while(Integer.toString(cedu).length() !=8);		
			
			setCedula(cedu);
			
			System.out.println("Ingrese el primer nombre: ");
			setNombre(tec.next());
			
			System.out.println("Ingrese apellido: ");
			setApellido(tec.next());
			
			System.out.println("Ingrese la dirección: ");
			setDireccion(tec.next());
			
			System.out.println("Ingrese el teléfono");
			setTelefono(tec.nextInt());
	}
	
	public void modificarDatos() {

		System.out.println("------------------------------- Modifique los datos del socio -------------------------------  " );
		
		System.out.println("Ingrese el primer nombre: ");
		setNombre(tec.next());
		
		System.out.println("Ingrese apellido: ");
		setApellido(tec.next());
		
		System.out.println("Ingrese la dirección: ");
		setDireccion(tec.next());
		
		System.out.println("Ingrese el teléfono");
		setTelefono(tec.nextInt());
		
	}

	@Override
	public String toString() {
		return "Socio [Cédula=" + this.cedula + ", Nombre=" + this.nombre + ", Apellido=" + this.apellido + ", Direccion=" + this.direccion + ", Telefono=" + this.telefono ;
	}
	
	public abstract String tipoSocio();
	
}