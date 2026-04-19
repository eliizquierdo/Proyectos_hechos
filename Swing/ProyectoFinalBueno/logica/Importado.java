package logica;
public class Importado extends Articulo{
	private double precioVenta;
	private double impuesto;
	private int anioimportacion;
	
	public Importado(int c,String n,double p,int a,double i,Fecha f,double v) {
		super(n,c,p,f);
		precioVenta = v;
		impuesto=i;
		anioimportacion=a;
	}
	public double getPrecioVenta() {
		return precioVenta;
	}
	public void setPrecioVenta(double precioVenta) {
		this.precioVenta = precioVenta;
	}
	
	public double getImpuesto() {
		return impuesto;
	}
	public void setImpuesto(double impuesto) {
		this.impuesto = impuesto;
	}
	public int getAnioimportacion() {
		return anioimportacion;
	}
	public void setAnioimportacion(int anioimportacion) {
		this.anioimportacion = anioimportacion;
	}
	public double precioVenta(){
		if (getAnioimportacion()>2008) {
			return (super.precioVenta()+impuesto);
			
		}else {
			return (super.precioVenta()+impuesto*80/100);
		}

	
}
	@Override
	public String toString() {
		return super.toString() + "[ Precio Venta: "+ precioVenta() + " Impuesto: " +impuesto +"\n"+ "AñoImportacion:"+ getAnioimportacion();
	}
}