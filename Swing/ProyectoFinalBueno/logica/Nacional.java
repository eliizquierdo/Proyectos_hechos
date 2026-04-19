package logica;
import java.util.Scanner;
public class Nacional extends Articulo {
	Scanner sc = new Scanner(System.in);
	private double precioVenta;
	private String departamento;
	private boolean subsidiado;
	public Nacional(int c,String n,double p,String d,boolean s,Fecha f,double v) {
		super(n,c,p,f);
		precioVenta = v;
		departamento = d;
		subsidiado = s;
	}
	public double getPrecioVenta() {
		
		return precioVenta;
	}
	public void setPrecioVenta(double precioVenta) {
		this.precioVenta = precioVenta;
	}
	@Override 
	public double precioVenta() {
		 if(departamento=="Montevideo" && subsidiado==false) {
			return ((super.precioVenta() + super.precioVenta()*15/100));
			}else if(departamento=="Interior" && subsidiado==false){
			return  (super.precioVenta() + super.precioVenta()*10/100); 
		}else
			return super.precioVenta();
	}
@Override 
public String toString() {
	return super.toString() + "Precio Venta "
			+ ": "+precioVenta()+" Departamento: "
					+departamento+ " Subsidiado: "
							+ ""+subsidiado;
	
}
}
