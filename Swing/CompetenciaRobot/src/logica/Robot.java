package logica;


public abstract class Robot {
    private String id;
    private String nombre;
    private String fabricante;
    private int anioConstruccion;

    public Robot(String id, String nombre, String fabricante, int anioConstruccion) {
        this.id = id;
        this.nombre = nombre;
        this.fabricante = fabricante;
        this.anioConstruccion = anioConstruccion;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getFabricante() {
        return fabricante;
    }

    public int getAnioConstruccion() {
        return anioConstruccion;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Nombre: " + nombre + ", Fabricante: " + fabricante + ", Año: " + anioConstruccion;
    }
    
    
}
