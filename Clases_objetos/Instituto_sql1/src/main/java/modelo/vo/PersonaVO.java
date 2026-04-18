package modelo.vo;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PersonaVO {

    private int cedula;
    private String nombre;
    private String apellido;

    public PersonaVO() {

    }

    public PersonaVO(int cedula, String nombre, String apellido) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public int getCedula() {
        return cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public String toString() {
        return "cedula:" + cedula + ", nombre:" + nombre + ", apellido:" + apellido;
    }

    public void pedirDatos() {
        Scanner teclado = new Scanner(System.in);
        boolean cedulaValida = false;

        // Validación de cédula numérica
        while (!cedulaValida) {
            try {
                System.out.print("Ingrese cédula: ");
                this.setCedula(teclado.nextInt());
                cedulaValida = true;
            } catch (InputMismatchException e) {
                System.out.println("La cédula debe ser un número entero. Intente de nuevo.");
                teclado.next(); // Limpia la entrada incorrecta del buffer
            }
        }

        System.out.print("Ingrese nombre: ");
        this.setNombre(teclado.next());

        System.out.print("Ingrese apellido: ");
        this.setApellido(teclado.next());

        System.out.println(); // Espacio al final
    }
}
