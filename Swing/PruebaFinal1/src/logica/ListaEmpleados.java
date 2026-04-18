package logica;

import java.util.ArrayList;

public class ListaEmpleados {
	
	private ArrayList<Empleado> lista;

	public ListaEmpleados() {
		lista = new ArrayList<>();
	}
	
	public void agregarEmpleado(Empleado p) {
		lista.add(p);
	}
	
	//elimina el producto dado el codigo
	public void eliminarEmpleado(int nroEmpleado) {
		
		int x=0;
		boolean encontre=false;
		do{
			if(lista.get(x).getNroEmpleado()==nroEmpleado) {
				lista.remove(x);
				encontre=true;
			 }else
				x++;
		 }while( x<lista.size()&&!encontre);
					
	}
	
	public boolean estaEmpleado(int nroEmpleado) {
		
		int x=0;
		boolean encontre=false;
		do{
			if(lista.get(x).getNroEmpleado()==nroEmpleado) {
				encontre=true;
			 }else
				x++;
		 }while( x<lista.size()&&!encontre);
		return encontre;			
	
	}
	
	
	
	
	
}
