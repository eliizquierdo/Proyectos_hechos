package ebmc;

/**
 * @date 02/07/2018
 * @author Fredy Kcrez
 */
public class EmpleadoBaseMasComision extends EmpleadoBase {
    private double tarifaComision;
    private double ventasBrutas;
    
    public EmpleadoBaseMasComision(String nombre, String apellido, String nss,
            double salario, double tc, double vb) {
        super(nombre, apellido, nss, salario);
        this.setTarifaComision( tc );
        this.setVentasBrutas( vb );
    }
    
    public double ingresos() {
        return salarioBase + (tarifaComision * ventasBrutas);
    }
    
    @Override
    public String toString() {
        return String.format( "%s: %s %s\n%s: %s\n%s: %.2f\n%s: %.2f", "empleado"
            + " por comision", primerNombre, apellidoPaterno, "numero de "
            + "seguro social", numeroSeguroSocial, "ventas brutas",
            ventasBrutas, "tarifa de comision", tarifaComision
        );
    }

    /**
     * @return the tarifaComision
     */
    public double getTarifaComision() {
        return tarifaComision;
    }

    /**
     * @param tarifaComision the tarifaComision to set
     */
    public void setTarifaComision(double tarifaComision) {
        this.tarifaComision = tarifaComision;
    }

    /**
     * @return the ventasBrutas
     */
    public double getVentasBrutas() {
        return ventasBrutas;
    }

    /**
     * @param ventasBrutas the ventasBrutas to set
     */
    public void setVentasBrutas(double ventasBrutas) {
        this.ventasBrutas = ventasBrutas;
    }
}