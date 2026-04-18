package Lógica;


public class Producto {
    int codigo;
    String nombre;
    double costo;
    

    //Constructor
    public Producto(int codigo, String nombre, double costo) {
    	super();
        this.codigo = codigo;
        this.nombre = nombre;
        this.costo = costo;
    }
    
    public Producto() {
    	
    }

    //Getters
    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public double getCosto() {
        return costo;
    }

    //Setters
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    //Metodo precio
    public double precio() {
        if (getCosto() > 200) {
            costo = costo + (costo * 0.2);
            return costo;
        } else {
            costo= costo + (costo * 0.1);
            return costo;
        }
        
    }

   
    @Override
    public String toString() {
        return "Producto{" + "codigo=" + codigo + ", nombre='" + nombre + '\'' +  ", costo=" + costo +'}';
    }
}