package logica;
import java.util.*;
import java.util.ArrayList;
import grafica.frminicio;
public class datos {
	
	    
	
	private ArrayList<frminicio>nom;
	       public datos() {
	       nom=new ArrayList<>();
	       }
	       public void agregar(frminicio nomU ){
	    	   nom.add(nomU);
	    	  
	    		   }
	       public frminicio devolver(int i) {
	    	   return (nom.get(i)); 
	       }
	    	   
    		  
    		 
	    	   public String toString() {
	    		   return "datos del usuario" + nom ;
	    	   }
	    	   
	       
	

}
