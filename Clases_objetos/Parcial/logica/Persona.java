package logica;

public abstract class Persona implements Gestionable {
    protected String nombre;
    protected String ci;

    public Persona(String nombre, String ci) {
        this.nombre = nombre;
        this.ci = ci;
    }

    @Override
    public String getId() {
        return ci;
    }
}