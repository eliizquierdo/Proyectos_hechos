package consola;
import logica.*;

public class Principal {

    public static void main(String[] args) {
        Veterinaria v = new Veterinaria();

        v.agregarMascota(new Perro());
        v.agregarMascota(new Gato());
        v.agregarMascota(new Perro());
        v.agregarMascota(new Gato());
        v.agregarMascota(new Perro());

        v.saludar();
    }
}