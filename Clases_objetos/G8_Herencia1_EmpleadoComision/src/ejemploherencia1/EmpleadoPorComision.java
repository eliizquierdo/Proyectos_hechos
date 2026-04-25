package ejemploherencia1;

/**
 * @date 02/07/2018
 * @author Fredy Kcrez
 */
public class EmpleadoPorComision extends Object {
    protected String primerNombre;
    protected String apellidoPaterno;
    protected String numeroSeguroSocial;
    protected double ventasTotales;
    protected double tarifaComision;
    
    public EmpleadoPorComision( String nombre, String apellido, String nss, double ventas, double tarifa ) {
        // la llamada implícita al constructor de Object ocurre aquí
        // Los constructores no se heradan
        this.setPrimerNombre( nombre );
        this.setApellidoPaterno( apellido );
        this.setNumeroSeguroSocial( nss );
        this.setVentasTotales( ventas ); // valida y almacena las ventas  Brutas
        this.setTarifaComision( tarifa ); // valida y almacena la tarifa  de comisió
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
     * @return the ventasTotales
     */
    public double getVentasTotales() {
        return ventasTotales;
    }

    /**
     * @param ventasTotales the ventasTotales to set
     */
    public void setVentasTotales(double ventasTotales) {
        if(ventasTotales > 0.0)
            this.ventasTotales = ventasTotales;
        else
             throw new IllegalArgumentException("Las ventas Brutas deben ser >= 0.0" ); 
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
        if( (tarifaComision > 0.0) && (tarifaComision > 0.0) )
            this.tarifaComision = tarifaComision;
        else
            throw new IllegalArgumentException("La tarifa de comisión debe ser > 0.0 y < 1.0" );
    }
    
    public double ingresos() {
        return this.tarifaComision * this.ventasTotales;
    }
    
    @Override // Se sobreescribe el metodo toString de la clase padre (Object)
    public String toString() {
        return String.format( "%s: %s %s\n%s: %s\n%s: %.2f\n%s: %.2f",
                "empleado por comision", primerNombre, apellidoPaterno,
                "numero de seguro social", numeroSeguroSocial,
                "ventas Brutas", ventasTotales,
                "tarifa de comision", tarifaComision
        );
    }
}