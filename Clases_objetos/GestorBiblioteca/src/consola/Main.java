package consola;
import logica.*;

public class Main {
    public static void main(String[] args) {
        GestorBiblioteca gestor = new GestorBiblioteca();

        Libro l1 = new Libro("Frankenstein", "Mary Shelley", 1818, "Terror");
        Libro l2 = new Libro("Cien Años de Soledad", "Gabriel Garcia Marquez", 1967, "Magico");
        Libro l3 = new Libro("Misery", "Stephen King", 1987, "Terror");
        Libro l4 = new Libro("Dune", "Frank Hebert", 1965, "Ciencia Ficcion");
        Libro l5 = new Libro("El visitante", "Stephen King", 2025, "Terror");

        gestor.insertarLibro(l1);
        gestor.insertarLibro(l2);
        gestor.insertarLibro(l3);
        gestor.insertarLibro(l4);
        gestor.insertarLibro(l5);

        System.out.println("Listado completo de libros:");
        gestor.listarPublicaciones();

        int cantidadTerror = gestor.contarLibrosDeTerror();
        System.out.println("Cantidad de libros de Terror: " + cantidadTerror);

        int cantidad2025 = gestor.contarLibrosDelAnio(2025);
        System.out.println("Cantidad de libros del año 2025: " + cantidad2025);
    }
}
