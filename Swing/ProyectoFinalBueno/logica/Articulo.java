package logica;
import java.util.Scanner;
public class Articulo {
	private int Codigo;
	private String Nombre;
	private double precioCosto;
	private Fecha fechavencimiento;
	public Articulo(String Nombre,int Codigo,double precioCosto,Fecha fechavencimiento) {
		this.Codigo=Codigo;
		this.Nombre=Nombre;
		this.precioCosto=precioCosto;
		this.fechavencimiento=fechavencimiento;
		
	}

	public Articulo() {
		// TODO Auto-generated constructor stub
	}

	public int getCodigo() {
		return Codigo;
	}
	public void setCodigo(int codigo) {
		Codigo = codigo;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public double getprecioCosto() {
		return precioCosto;
	}
	public void setprecioCosto(double precioVenta) {
		this.precioCosto = precioVenta;
	}
	
	public double getPrecioVenta() {
		return precioCosto;
	}
	public void setPrecioVenta(double precioVenta) {
		this.precioCosto = precioVenta;
	}
	public Fecha getFechavencimiento() {
		return fechavencimiento;
	}
	public void setFechavencimiento(Fecha fechavencimiento) {
		this.fechavencimiento = fechavencimiento;
		
	}
	public double getPrecioCosto() {
		return precioCosto;
	}

	public void setPrecioCosto(double precioCosto) {
		this.precioCosto = precioCosto;
	}
	@Override
	public String toString() {
		return  "\n" + "Codigo:" + Codigo + " Nombre:" + Nombre + " Precio Costo: "+ precioCosto + " Fecha Vencimiento: " + fechavencimiento.toString() + "\n";
		
	}
	public double precioVenta() {
		return precioCosto;
		
	}
	public void pedirDatos() {
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Ingrese Codigo: ");
		setCodigo(teclado.nextInt());
		System.out.println("Ingrese Nombre: ");
		setNombre(teclado.toString());
		System.out.println("Ingrese PrecioCosto: ");
		setprecioCosto(teclado.nextDouble());
		System.out.println("Ingrese fecha de nacimiento: ");
		this.fechavencimiento.pedirDatos();
	




	}

}
