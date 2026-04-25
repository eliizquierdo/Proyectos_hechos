package logica;

public class Material implements Gestionable {
    private String nombre;
    private String codigo;
    private String estado;
    private int cantidad;

    public Material(String nombre, String codigo, String estado, int cantidad) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.estado = estado;
        this.cantidad = cantidad;
    }

    @Override
    public String getId() {
        return codigo;
    }

    @Override
    public void mostrar() {
        System.out.println("Material: [Nombre: " + nombre + ", Código: " + codigo + ", Estado: " + estado + ", Cantidad: " + cantidad + "]");
    }
}