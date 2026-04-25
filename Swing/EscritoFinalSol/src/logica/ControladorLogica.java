package logica;

import persistencia.ControladorPersistencia;


public class ControladorLogica {
	//atributos
    private static ControladorLogica instancia;	//atributo Singleton
    private  AlumnosDAO alumnos;
    private  LibrosDAO libros;
    
    
    //constructor privado
    private ControladorLogica(){	
    	alumnos= new AlumnosDAO();
    	libros=new LibrosDAO();
    }
    
    //Singleton metodo getInstancia
    public static ControladorLogica getInstancia(){
    	if (instancia==null)
    		instancia=new ControladorLogica();
    	return instancia;
	}


    public boolean insertarAlumno(Alumno a) {  
     	boolean ok=false;
 			ok=alumnos.insertarAlumnoBD(a);
     	return ok;
 	}
     
     public boolean eliminarAlumno(int cedula) {  
     	boolean ok=false;
 			ok=alumnos.eliminarAlumnoBD(cedula);
     	return ok;
 	}
     
     public Alumno recuperarAlumno(int cedula) {  
     	Alumno a=null;
 			a=alumnos.recuperarAlumnoBD(cedula);
     	return a;
 	}
     
     public boolean modificarAlumno(Alumno a) {  
     	boolean ok=false;
 			ok=alumnos.modificarAlumnoBD(a);
     	return ok;
 	}
     
     public ListaAlumnos recuperarAlumnos(){
     	return alumnos.recuperarAlumnosBD();
     }
     
     public boolean insertarLibro(Libro l) {  
      	boolean ok=false;
  			ok=libros.insertarLibroBD(l);
      	return ok;
  	}
      
    public boolean eliminarLibro(int codigo) {  
      	boolean ok=false;
  			ok=libros.eliminarLibroBD(codigo);
      	return ok;
  	}
      
   
	public LibrosDAO getLibros() {
		return libros;
	}

	public void setLibros(LibrosDAO libros) {
		this.libros = libros;
	}

	public void desconectarBD(){
    	
    	try{
    		ControladorPersistencia.getInstancia().getConexion().desconectar();
    	}catch(Exception e){
    		System.out.println("Error al intentar desconectar"+e.getMessage());
    	}
    }
}

