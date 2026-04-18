package logica;

import java.util.ArrayList;

public class Vendedor extends Empleado {
    private double comision;
    private int ventasRealizadas;
    
    public Vendedor(String nombre, double salario, Direccion direccion, double comision, int ventasRealizadas) {
        super(nombre, salario, direccion);
        this.comision = comision;
        this.ventasRealizadas = ventasRealizadas;
    }
    
    @Override
    public double calcularImpuesto() {
        return super.calcularImpuesto() + calcularComision()*0.5;
    }
    
    public double calcularComision() {
        return comision * ventasRealizadas;
    }
}

