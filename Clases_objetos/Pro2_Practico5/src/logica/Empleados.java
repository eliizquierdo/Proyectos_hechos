package logica;

import java.util.ArrayList;

public class Empleados {
    private ArrayList<Empleado> listaEmpleados;
    
    public Empleados() {
        listaEmpleados = new ArrayList<>();
    }
    
    public void agregar(Empleado e) {
        listaEmpleados.add(e);
    }
    
    public void eliminar(int i) {
    	listaEmpleados.remove(i);
    	
    }
    
    public int size() {
    	return listaEmpleados.size();
    }
    
    public Empleado devolver(int i) {
    	return listaEmpleados.get(i);
    }
    
    public double obtenerTotalSalarios() {
        double totalSalarios = 0;
        for (Empleado empleado : listaEmpleados) {
            totalSalarios += empleado.getSalario();
        }
        return totalSalarios;
    }
    
    public int cantidadVendedores() {
        int total = 0;
        for (Empleado empleado : listaEmpleados) {
        	if (empleado instanceof Vendedor)
            total ++;
        }
        return total;
    }
    
    public String toString() {
    	
    	return " ";
    }
}

	
