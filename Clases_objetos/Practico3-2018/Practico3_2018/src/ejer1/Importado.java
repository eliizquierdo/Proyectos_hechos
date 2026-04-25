package ejer1;

import java.util.Scanner;

	public class Importado extends Articulo {
		
		private int anioImportacion;
		private double impuesto;
		
		public Importado() {
			
		}
	
		public Importado(int codigo,String nombre, double precioCosto, int anioImportacion, double impuesto) {
			super(codigo,nombre, precioCosto);
			this.anioImportacion = anioImportacion;
			this.impuesto = impuesto;
		}
		public int getAnioImportacion() {
			return anioImportacion;
		}
		public void setAnioImportacion(int anioImportacion) {
			this.anioImportacion = anioImportacion;
		}
		public double getImpuesto() {
			return impuesto;
		}
		public void setImpuesto(double impuesto) {
			this.impuesto = impuesto;
		}
	
	
	
		@Override
		public String toString() {
			return super.toString()+" \nAnioImportacion=" + anioImportacion
					+ "\nImpuesto=" + impuesto;
		}
		
		public void pedirDatos(){
			
			Scanner entrada=new Scanner(System.in);
			System.out.println(" ");
			super.pedirDatos();
			System.out.println("Ingrese anio de importaci�n: ");
			anioImportacion=entrada.nextInt();
			System.out.println("Ingrese impuesto: ");
			impuesto=entrada.nextDouble();
			
	    }
		
		@Override
		public double precioVenta(){
			double precio=super.precioVenta();
			
			if (anioImportacion<=2008)
				precio=precio+impuesto*80/100;
			else
				precio=precio+impuesto;
			return precio;
				
			
		}

		
		
}
