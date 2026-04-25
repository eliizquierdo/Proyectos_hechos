package logica;  

import persistencia.ControladorPersistencia;


public class LibrosDAO {
	
	 //constructor 
    public LibrosDAO(){	
    	
    }

	public boolean insertarLibroBD(Libro lib){
    	boolean ok1=false;
    	   			
    	  //preparo los datos necesarios para crear la sentencia a insertar en la tabla persona
  		  String tabla1="libro";
	      String campos1="codigo, titulo";
	      String valores1=lib.getCodigo()+",'"+lib.getTitulo()+"'";
	        
	      try{
		        //inserto en la tabla libro
		        ok1=ControladorPersistencia.getInstancia().insert(tabla1, campos1,valores1);
		       
	      }catch(Exception e){
	    	   System.out.println("error no se pudo insertar");
	      }
	      return ok1; 
    }
    
    public boolean eliminarLibroBD(int codigo ) {
    	
    	boolean esta1=false;
    	String tabla1="libro";
    	String condicion="codigo="+codigo;
    	try{
	    	esta1=ControladorPersistencia.getInstancia().delete(tabla1, condicion);
	    	    	
    	}catch(Exception e){
    		System.out.println("error no se pudo eliminar");
    	}
    	return esta1;
    				
    }
    
   
    //recupera todos los registros de la bd en una lista
    public ListaLibros recuperaLibrosBD(){
    	ListaLibros lis=new ListaLibros();
    	String[][] datosLibro= null;
    	    	
    	try{
    		datosLibro= ControladorPersistencia.getInstancia().getColLibBD().select();
    		
    	}catch(Exception ex){
    		System.out.println("error ...");
    	}	
    	int i=0;
    	while( i<datosLibro.length){
    		Libro lib=new Libro();   		  	
	    	lib.setCodigo(Integer.parseInt(datosLibro[i][0]));
	    	lib.setTitulo(datosLibro[i][1]);
	    	
	    	lis.agregar(lib);
	    	i++;
	    }
    	return lis;
    }
    
    
}

