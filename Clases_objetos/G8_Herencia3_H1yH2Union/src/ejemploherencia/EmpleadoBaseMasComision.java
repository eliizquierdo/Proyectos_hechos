package ejemploherencia;
import ejemploherencia1.EmpleadoPorComision;

/**
 * @date 02/07/2018
 * @author Fredy Kcrez
 */
public class EmpleadoBaseMasComision extends EmpleadoPorComision {
    private double salarioBase;
    
    public EmpleadoBaseMasComision( String nombre, String apellido, String nss,
        double ventas, double tarifa, double salario ) {
        // llamada explícita al constructor de la superclase EmpleadoPorComision
        super( nombre, apellido, nss, ventas, tarifa);
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
    
    @Override
    public double ingresos() {
        return salarioBase + (tarifaComision * ventasTotales);
    }
    
    @Override
    public String toString() {
        // no está permitido: intentos por acceder a los miembros private de la superclase
        return String.format( "%s: %s %s\n%s: %s\n%s: %.2f\n%s: %.2f\n%s: %.2f",
            "empleado por comision con sueldo base", primerNombre,
            apellidoPaterno, "numero de seguro social", numeroSeguroSocial,
            "ventas brutas", ventasTotales, "tarifa de comision", tarifaComision,
            "salario base", salarioBase
        );
    }
}