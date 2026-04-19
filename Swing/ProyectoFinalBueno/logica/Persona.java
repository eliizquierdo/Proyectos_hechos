package logica;

import java.util.ArrayList;
import java.util.Scanner;

public class Persona{
	private String Cedula;
	private String Apellido;
	private ArrayList<Persona> listaP;
	public Persona(String Cedula, String Apellido) {
		this.Cedula=Cedula;
		this.Apellido=Apellido;
	}
	public Persona() {
		listaP = new ArrayList<>();
		
	}	public void agregar(Persona a) {
		listaP.add(a);
	}
	
	public void eliminar(Persona a) {
		listaP.remove(a);
	}
	
	public boolean contiene(Persona a) {
		boolean esta=false;
		
		if (listaP.contains(a))
			esta=true;
		return esta;
	}
	
	public Persona devolver(int i) {
		return listaP.get(i);
	}public Persona buscar(String Cedula) {
	    
	    int i = 0;
	    
	    while(i < (cantidad())){
	      
	      if(devolver(i).getCedula() == Cedula) {
	        
	        return devolver(i);
	        
	      }
	      
	      i++;
	      
	    }
	    
	    return null;
	    
	  }
public Persona buscar2(String Cedula) {
	    
	    int i = 0;
	    
	    while(i < (cantidad())){
	      
	      if(devolver(i).getCedula() == Cedula) {
	        
	        return listaP.get(i);
	        
	      }
	      
	      i++;
	      
	    }
	    
	    return null;
	    
	  } 
	
	public int cantidad() {
		return listaP.size();
	}
	
	public String getCedula() {
		return Cedula;
	}

	public void setCedula(String cedula) {
		Cedula = cedula;
	}

	public String getApellido() {
		return Apellido;
	}

	public void setApellido(String apellido) {
		Apellido = apellido;
	}
	@Override
	public String toString() {
		return "Persona [Cedula=" + Cedula + ", Apellido=" + Apellido + "]";
	}

	
	
	
	
	
	
}

