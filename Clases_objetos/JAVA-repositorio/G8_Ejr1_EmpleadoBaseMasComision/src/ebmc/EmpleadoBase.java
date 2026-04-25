package ebmc;

/**
 * @date 02/07/2018
 * @author Fredy Kcrez
 */
public class EmpleadoBase {
    protected String primerNombre;
    protected String apellidoPaterno;
    protected String numeroSeguroSocial;
    protected double salarioBase;

    public EmpleadoBase(String nombre, String apellido, String nss, double salario) {
        this.setPrimerNombre( nombre );
        this.setApellidoPaterno( apellido );
        this.setNumeroSeguroSocial( nss );
        this.setSalarioBase( salario );
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
     * @return the salarioBase
     */
    public double getSalarioBase() {
        return salarioBase;
    }

    /**
     * @param salarioBase the salarioBase to set
     */
    public void setSalarioBase(double salarioBase) {
        if(salarioBase >= 0)
            this.salarioBase = salarioBase;
        else
            throw new IllegalArgumentException("El salario base debe ser >= 0");
    }
    
    
}