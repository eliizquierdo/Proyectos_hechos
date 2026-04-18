import java.util.Scanner;

public class Direccion {
    private String calle;
    private int numero;
    private String especificaciones;

    Scanner entrada = new Scanner(System.in);

    public Direccion() {
    }

    public Direccion(String calle, int numero, String especificaciones) {
        this.calle = calle;
        this.numero = numero;
        this.especificaciones = especificaciones;
    }

    public void ingresarDireccion() {
        System.out.print("Ingrese la calle: ");
        this.calle = entrada.nextLine();

        System.out.print("Ingrese el número de la casa o edificio: ");
        this.numero = entrada.nextInt();
        entrada.nextLine();
        
        System.out.print("Ingrese alguna especificacion/referencias: ");
        this.especificaciones = entrada.nextLine();
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
    
    public String getEspecificaciones() {
        return especificaciones;
    }

    public void setEspecificaciones(String especificaciones) {
        this.especificaciones = especificaciones;
    }

    @Override
    public String toString() {
        return "Calle: " + calle + ", Número: " + numero + ", Especificaciones: " + especificaciones;
    }
}