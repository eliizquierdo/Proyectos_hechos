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

    public int getid() {
        return id;
    }
    public void setid(int id) {
        this.id = id;
    }
    public String getnombre() {
        return nombre;
    }
    public void setnombre(String nombre) {
        this.nombre = nombre;
    }
    public int getcupo() {
        return cupo;
    }
    public void setcupo(int cupo) {
        this.cupo = cupo;
    }
    
}
