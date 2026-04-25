package composicionEmpleadoPorComision;
import ejemploherencia1.EmpleadoPorComision;

/**
 * @date 04/07/2018
 * @author Fredy Kcrez
 */
public class EmpleadoBaseMasComision {
    private double salarioBase;
    private EmpleadoPorComision epc;
    
    public EmpleadoBaseMasComision( String nombre, String apellido, String nss,
        double ventas, double tarifa, double salario ) {
        // llamada explícita al constructor de la superclase EmpleadoPorComision
        epc = new EmpleadoPorComision( nombre, apellido, nss, ventas, tarifa);
        setSalarioBase( salario ); // valida y almacena el salario base    }
    }

    /**
     * @return the salarioBase
     */
    public double getSalarioBase() {
        return salarioBase;
    }

    /**
     * @param salarioBase the salarioBase to set
     */
    public void setSalarioBase(double salarioBase) {
        if( salarioBase >= 0.0 )
            this.salarioBase = salarioBase;
        else
            throw new IllegalArgumentException("El salario base debe ser >= 0.0" ); 
    }

    public double ingresos() {
        return salarioBase + (epc.getTarifaComision() * epc.getVentasTotales());
    }
    
    @Override
    public String toString() {
        // no está permitido: intentos por acceder a los miembros private de la superclase
        return String.format( "%s: %s %s\n%s: %s\n%s: %.2f\n%s: %.2f\n%s: %.2f",
            "empleado por comision con sueldo base", epc.getPrimerNombre(),
            epc.getApellidoPaterno(), "numero de seguro social", epc.getNumeroSeguroSocial(),
            "ventas brutas", epc.getVentasTotales(), "tarifa de comision", epc.getTarifaComision(),
            "salario base", salarioBase
        );
    }
}