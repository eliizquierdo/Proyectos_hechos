package logica;

public class Empleado {
    private String nombre;
    private double salario;
    private Direccion direccion;
    


	public Empleado(String nombre, double salario, Direccion direccion) {
        this.nombre = nombre;
        this.salario = salario;
        this.direccion = direccion;
    }
    
    public double calcularImpuesto() {
        return salario * 0.15; // Ejemplo simple
    }
    
    public double getSalario() {
        return salario;
    }
    
    public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}
}



