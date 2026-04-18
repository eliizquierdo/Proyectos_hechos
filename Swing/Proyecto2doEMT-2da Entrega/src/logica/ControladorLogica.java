package logica;

public class ControladorLogica {
	//atributos
    private  ListaSocios colSocios;
    private ListaMateriales colMateriales;
	private ListaPrestamos colPrestamos;
    private static ControladorLogica instancia;	//atributo Singleton
    
    //constructor privado
    private ControladorLogica(){	
    	colSocios=new ListaSocios();
    	colPrestamos= new ListaPrestamos();
    	colMateriales= new ListaMateriales();
    }
    
    //Singleton metodo getInstancia
    public static ControladorLogica getInstancia(){
    	if (instancia==null)
    		instancia=new ControladorLogica();
    	return instancia;
	}

	
    // Agrega al Socio a la coleccion.
	public  void agregarSocio(Socios s) {
		colSocios.agregar(s);
    }
	
    // Agrega al Material a la coleccion.
	public  void agregarMaterial(Materiales m) {
		colMateriales.agregar(m);
    }
	
    // Agrega al Prestamo a la coleccion.
	public  void agregarPrestamo(Prestamos p){
		colPrestamos.agregar(p);
    }
	
    // Elimina al Socio de la coleccion.
	public  void eliminarSocios(int ced) {
		colSocios.eliminar(colSocios.obtenerXCedula(ced));
    }
	
	// Elimina al Material de la coleccion.
	public  void eliminarMaterial(int cod) {
		colMateriales.eliminar(colMateriales.obtenerXCodigo(cod));
	 }
		
	//retorna la lista de Socios  
    public  ListaSocios devolverSocios() {
        return (colSocios);
    }
    
    //retorna la lista de Materiales
    public  ListaMateriales devolverMateriales() {
        return (colMateriales);
    }
    
    //retorna la lista de Prestamos
    public  ListaPrestamos devolverPrestamos() {
        return (colPrestamos);
    }   
}