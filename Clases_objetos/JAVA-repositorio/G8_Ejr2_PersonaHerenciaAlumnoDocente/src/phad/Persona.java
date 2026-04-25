package phad;

import java.util.Date;

/**
 * @date 02/07/2018
 * @author Fredy Kcrez
 */
public class Persona {
    protected String nombre;
    protected String direccion;
    protected String telefono;
    protected char sexo;
    protected Date fechaNacimiento;
    
    public Persona (String nombre, String direccion, String telefono, char sexo, Date fechaNac) {
        this.setNombre( nombre );
        this.setDirección( direccion);
        this.setTelefono( telefono );
        this.setSexo( sexo );
        this.setFechaNacimiento( fechaNac );
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the dirección
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the dirección to set
     */
    public void setDirección(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * @return the sexo
     */
    public String getSexo() {
        if(sexo == 'M' || sexo == 'm')
            return "Mujer";
        else
            return "Hombre";
    }

    /**
     * @param sexo the sexo to set
     */
    public void setSexo(char sexo) {
        if(sexo == 'm' || sexo == 'm' || sexo == 'H' || sexo == 'h')
            this.sexo = sexo;
        else
            throw new IllegalArgumentException("El sexo debe ser un caracter de"
                    + "la lista: H/h/M/m");
    }

    /**
     * @return the fechaNacimiento
     */
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * @param fechaNacimiento the fechaNacimiento to set
     */
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
}