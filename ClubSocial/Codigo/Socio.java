import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class Socio {

    private ArrayList<Integer> telefono;
    private int cedula;
    private LocalDate fechaNacimiento;
    private double mensualidad;
    private String nombre;
    private String apellido;
    private String email;
    private Direccion direccion;

    public Socio() {
        this.telefono = new ArrayList<>();
    }

    public Socio( int cedula, LocalDate fechaNacimiento, double mensualidad, String nombre, String email, Direccion direccion) {
        this.telefono = new ArrayList<>();
        this.cedula = cedula;
        this.fechaNacimiento = fechaNacimiento;
        this.mensualidad = mensualidad;
        this.nombre = nombre;
        this.email = email;
        this.direccion = direccion;
    }


    public ArrayList<Integer> getTelefono() {
        return telefono;
    }

    public void setTelefono(ArrayList<Integer> telefono) {
        this.telefono = telefono;
    }
    
    public void agregarTelefono(int telefono) {
        this.telefono.add(telefono);
    }
    
    public void eliminarTelefono(int telefonoBuscado) {
        if(telefono.isEmpty()){
            System.out.println("Telefono no encontrado.");
        }else{
            for(int i = 0; i < telefono.size(); i ++){
                Integer buscarTelefono = telefono.get(i);
                if(buscarTelefono == telefonoBuscado){
                    telefono.remove(i);
                    System.out.println("Telefono " + telefonoBuscado + " ha sido eliminado.");
                    i = telefono.size();
                }
            }
        }
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public double getMensualidad() {
        return mensualidad;
    }

    public void setMensualidad(double mensualidad) {
        this.mensualidad = mensualidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }
    
    @Override
    public String toString() {
        return "Socio [telefono=" + telefono + ", cedula=" + cedula + Edad() +", fechaNacimiento=" + fechaNacimiento
                + ", mensualidad=" + mensualidad + ", nombre=" + nombre + ", email=" + email + ", direccion=" + direccion + "]";
    }
    
    public String Edad(){
        LocalDate fechaActual = LocalDate.now();
        Period periodo = Period.between(fechaNacimiento, fechaActual);
        //Period representa un periodo de tiempo vasado en las fechas y between calcula la diferencia entre dos objetos de tiempo.
        int edad = periodo.getYears();
        //getYears obtiene el año de esa resta.
        return ", edad: " + edad;
    }
}