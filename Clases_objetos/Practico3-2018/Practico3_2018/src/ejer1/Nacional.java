package ejer1;

import java.util.Scanner;

public class Nacional extends Articulo {

		private String departamento;
		private boolean subsidiado;
		
		public Nacional() {
			
		}
		
		public Nacional(int codigo,String nombre, double precioCosto, String departamento, boolean subsidiado) {
			super(codigo,nombre, precioCosto);
			this.departamento = departamento;
			this.subsidiado = subsidiado;
		}

		public String getDepartamento() {
			return departamento;
		}

		public boolean getSubsidiado() {
			return subsidiado;
		}

		public void setSubsidiado(boolean subsidiado) {
			this.subsidiado = subsidiado;
		}
		
		
		@Override
		public String toString() {
			String sub;
			if (subsidiado)
				sub="Si";
			else 
				sub="No";
			return super.toString()
					+ " \nDepartamento=" + departamento 
					+ "\nSubsidiado=" + sub;
		}

		public void pedirDatos(){
			
			Scanner entrada=new Scanner(System.in);
			System.out.println(" ");
			super.pedirDatos();
			System.out.println("Ingrese departamento: ");
			departamento=entrada.next();
			System.out.println("Ingrese 1 si es subsidiado, 2 en caso contrario: ");
			int sub=entrada.nextInt();
			if (sub==1)
				subsidiado=true;
			else
				subsidiado=false;
			
	    }
		
		@Override
		public double precioVenta(){
			double total=super.precioVenta();
			String dep=getDepartamento();
			
			if (getSubsidiado())
				return total;
			else{
				if (dep.equals("Montevideo"))
					total=total+total*15/100;
				else
					total=total+total*10/100;
				return(total);
			}
			
		}
		
	
}
