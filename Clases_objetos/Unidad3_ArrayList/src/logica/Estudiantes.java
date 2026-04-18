package logica;
import java.util.ArrayList;

public class Estudiantes {
	
	private ArrayList<Alumno> lista;

	public Estudiantes() {
		lista=new ArrayList<>();
	}
	
	public void agregar(Alumno a) {
		lista.add(a);
	}
	
	//i es el indice
	public void eliminar(int i){
		lista.remove(i);
	}
	
	public int cantidad() {
		return lista.size();
	}
	
	public Alumno devolver(int i) {
		return lista.get(i);
	}
	
	
	public boolean contiene(Alumno a) {
		boolean esta=false;
		
		if (lista.contains(a))
			esta=true;
		return esta;
	}
	
	
	public double totalCuotas() {
		double suma=0;
		for(Alumno actual:lista) {
			suma=suma+actual.cuotaNeta();
		}
		
		return suma;
	}
	public void eliminarXCodigo(int cod) {
		int x=0;
		boolean encontre=false;
		do{
			if(lista.get(x).getCodigo()==cod) {
				lista.remove(x);
				encontre=true;
			 }else
				x++;
		 }while( x<lista.size()&& !encontre);
					
		
	}
	
	public double totalCuotas1() {
		double suma=0;
		for(int x=0; x<=lista.size(); x++) {
			suma=suma+lista.get(x).cuotaNeta();
		}		
		return suma;
	}
	
	
	@Override
	public String toString() {
	return "Estudiantes: " + lista.toString()
	 + "\nSuma de cuotas bases = " + totalCuotas();
	
	}
		
}
