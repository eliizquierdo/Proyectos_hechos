package logica;
import java.util.Scanner;

public class Articulo {
		
	private int codigo;
	private String nombre;
	private double precioCosto;
	private Fecha vencimiento;
	
	//constructor por defecto
	public Articulo() {
			
	}
	
	//constructor especifico
	public Articulo(int codigo, String nombre, double precioCosto, Fecha vencimiento) {
			this.codigo = codigo;
			this.nombre = nombre;
			this.precioCosto = precioCosto;
			this.vencimiento = vencimiento;
	}
		
		

	public int getCodigo() {
			return codigo;
	}

	public void setCodigo(int codigo) {
			this.codigo = codigo;
	}

	public String getNombre() {
			return nombre;
	}

	public void setNombre(String nombre) {
			this.nombre = nombre;
	}

	public double getPrecioCosto() {
			return precioCosto;
	}

	public void setPrecioCosto(double precioCosto) {
			this.precioCosto = precioCosto;
	}
	
	public Fecha getVencimiento() {
		return vencimiento;
	}
	
	public void setVencimiento(Fecha vencimiento) {
		this.vencimiento=vencimiento;
	}
		
	/////////////////////////////////////////////
		public boolean estaVencido(Fecha f) {
			
				//if (this.vencimiento.cantDias(f)<0)
			int dif=(vencimiento.getAnio()-f.getAnio())*360+
					(vencimiento.getMes()-f.getMes())*30+
					(vencimiento.getDia()-f.getDia());
			if (dif<0)
				return true;
				else
					return false;
		}
		
		public boolean estaVencidoDeLaProfe(Fecha actual) {
			boolean viejo=true; 
			
			int difAnios=actual.getAnio()- this.vencimiento.getAnio();
			
			if (difAnios<0)  //se vence años proximos, no está vencido
				viejo= false;
			else{
				
				if (difAnios==0) {
					int difMeses=this.vencimiento.getMes()-actual.getMes();//chequeo los meses
					if (0<=difMeses)
						viejo=false;
				}
				else {
					viejo=true;
					System.out.println("Entre por años >0");
				}
			}
			return viejo;
			
		}
			
		
		
		
		public double precioVenta() {
			double precioVenta;
			precioVenta = precioCosto + (precioCosto*20/100);
			return precioVenta;
		}
		
		
		public String toString() {
			return "Codigo: " + codigo + "\nNombre: " + nombre + "\nPrecio de venta: " + precioVenta()
			+"\nFecha de vencimiento: "+vencimiento.toString();
		}
		
		public void pedirDatos() {
			Scanner tecla = new Scanner(System.in);
			
			System.out.println("Ingrese codigo: ");
			setCodigo(tecla.nextInt());
			System.out.println("Ingrese nombre: ");
			setNombre(tecla.next());
			System.out.println("Ingrese precio de compra: ");
			setPrecioCosto(tecla.nextDouble());
		}
}
