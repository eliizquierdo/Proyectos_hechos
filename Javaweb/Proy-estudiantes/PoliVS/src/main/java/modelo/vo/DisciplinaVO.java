package modelo.vo;

public class DisciplinaVO {
    private int id;
    private String nombre;
    private int cupo;

    public DisciplinaVO(int id, String nombre, int cupo) {
        this.id = id;
        this.nombre = nombre;
        this.cupo = cupo;
    }

    public int getId() {
        return id;
    }

    public void setid(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCupo() {
        return cupo;
    }

    public void setCupo(int cupo) {
        this.cupo = cupo;
    }

}
