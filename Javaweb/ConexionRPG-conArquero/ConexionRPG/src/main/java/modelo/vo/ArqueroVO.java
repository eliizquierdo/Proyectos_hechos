package modelo.vo;

public class ArqueroVO {

    private int id;
    private String nombre;
    private int cat_Flechas;
    private int nivel;

    public ArqueroVO(int id, String nombre, int cat_Flechas, int nivel) {
        this.id = id;
        this.nombre = nombre;
        this.cat_Flechas = cat_Flechas;
        this.nivel = nivel;
    }

    public ArqueroVO(String nombre, int cat_Flechas, int nivel) {
        this.nombre = nombre;
        this.cat_Flechas = cat_Flechas;
        this.nivel = nivel;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getCat_Flechas() {
        return cat_Flechas;
    }
    public void setCat_Flechas(int cat_Flechas) {
        this.cat_Flechas = cat_Flechas;
    }
    public int getNivel() {
        return nivel;
    }
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

}
