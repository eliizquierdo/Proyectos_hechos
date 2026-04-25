package ejemploherencia2;

/**
 * @date 02/07/2018
 * @author Fredy Kcrez
 */
public class EmpleadoBaseMasComision {
    private String primerNombre;
    private String apellidoPaterno;
    private String numeroSeguroSocial;
    private double ventasBrutas;
    private double tarifaComision;
    private double salarioBase;
    
     public EmpleadoBaseMasComision( String nombre, String apellido, String nss,
             double ventas, double tarifa, double salario )    {
        // la llamada implícita al constructor de Object ocurre aquí
        primerNombre = nombre;
        apellidoPaterno = apellido;
        numeroSeguroSocial = nss;
        setVentasBrutas( ventas );                                              // valida y almacena las ventas brutas
        setTarifaComision( tarifa );                                            // valida y almacena la tarifa de comisión       
        setSalarioBase( salario );                                              // valida y almacena el salario base
     }

    /**
     * @return the primerNombre
     */
    public String getPrimerNombre() {
        return primerNombre;
    }

    /**
     * @param primerNombre the primerNombre to set
     */
    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    /**
     * @return the apellidoPaterno
     */
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    /**
     * @param apellidoPaterno the apellidoPaterno to set
     */
    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    /**
     * @return the numeroSeguroSocial
     */
    public String getNumeroSeguroSocial() {
        return numeroSeguroSocial;
    }

    /**
     * @param numeroSeguroSocial the numeroSeguroSocial to set
     */
    public void setNumeroSeguroSocial(String numeroSeguroSocial) {
        this.numeroSeguroSocial = numeroSeguroSocial;
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
        if(ventasBrutas >= 0.0)
            this.ventasBrutas = ventasBrutas;
        else
            throw new IllegalArgumentException("Las ventas brutas deben ser >= 0.0" ); 
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
        if(tarifaComision >= 0.0 && tarifaComision <= 1.0)
            this.tarifaComision = tarifaComision;
        else
             throw new IllegalArgumentException("Las tarifa de comision debe ser >= 0.0" ); 
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
        if(salarioBase >= 0.0)
            this.salarioBase = salarioBase;
        else
            throw new IllegalArgumentException("El salario base debe ser >= 0.0" ); 
    }

    public double ingresos() {
        return salarioBase + (tarifaComision * ventasBrutas);
    }

     @Override                                                                  // indica que este método sobrescribe el método de la superclase
     public String toString() {
         return String.format( "%s: %s %s\n%s: %s\n%s: %.2f\n%s: %.2f\n%s: "
                + "%.2f", "empleado por comision con sueldo base",
                primerNombre, apellidoPaterno, "numero de seguro social",
                numeroSeguroSocial, "ventas brutas", ventasBrutas, "tarifa"
                + " de comision", tarifaComision, "salario base",
                salarioBase
         );
     }
}