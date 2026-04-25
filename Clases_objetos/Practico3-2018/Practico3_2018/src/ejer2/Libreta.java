package ejer2;

import java.util.ArrayList;

public class Libreta {
	
	private ArrayList<Estudiante> lista; 
	private Docente unDocente;
	
	public Libreta(){	// Constructor de Libreta
		lista=new ArrayList<>();
		Docente unDocente=new Docente();
	}
	
	public void setDocente(Docente d){
		unDocente=d;
		
	}
	
	public Docente getDocente(){
		
		return(unDocente);
	}

	/** M�todos primitivos **/
	public void insertar(Estudiante a) { 
		lista.add(a);
	}
	
		
	public void eliminar(String ced){
		lista.remove(this.obtenerXCedula(ced));
	}
	
	public boolean encontrar(String ced){
		return (lista.contains(this.obtenerXCedula(ced)));
	}	
	
	//devuelve  el Estudiante que esta en la posicion i
	public Estudiante devolver(int i) {
			return (lista.get(i));
	}
		
	public boolean esVacia(){
		return( lista.isEmpty());
	}
	
	public int cantidad(){
		return (lista.size());
			
	}
	
		
	public int aprobados(){
		int cant=0;
		
		for (int i=0;i<cantidad();i++)
			if (this.devolver(i).devolverNota(i)>=8)
				cant++;
		
		return(cant);
	}
	
	public double edadPromedio(){
		double prom=0;
		for (int i=0;i<cantidad();i++)
			prom=prom+this.devolver(i).getEdad();
		return (prom/cantidad());
	}
	
	public void imprimeLista() {
		System.out.println("Docente: "+unDocente.toString()+"\n");
		for(int i=0; i<cantidad();i++)
			System.out.println("Estudiantes: "+this.devolver(i).toString()+"\n");
	}
	
	public void imprimeCarnet(String ced){
		
		System.out.println("Apellido: "+this.obtenerXCedula(ced).getApellido());
		System.out.println("Promedio de notas: "+this.obtenerXCedula(ced).promedio());
	}
	
	public Estudiante obtenerXCedula(String cedula){ 
		boolean encontre=false;
		Estudiante temp=new Estudiante();
		int i=0;
		
		  do{
			   if (lista.get(i).getCedula().equals(cedula)){
				  temp= lista.get(i); 
				  encontre=true;
			   }
			   else i++;
		   }while(i<lista.size() && !encontre);
		   return temp; 
	} 
	
} // Fin de la clase Libreta
	

