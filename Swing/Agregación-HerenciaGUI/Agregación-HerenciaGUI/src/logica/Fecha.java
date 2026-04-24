package logica;

public class Fecha {
    private int dia;
    private int mes;
    private int anio;

    public Fecha() {
    }

    public Fecha(int d, int m, int a) {
        dia = d;
        mes = m;
        anio = a;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int d) {
        dia = d;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int m) {
        mes = m;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int a) {
        anio = a;
    }

    @Override
    public String toString() {
        return dia + "/" + mes + "/" + anio;
    }
} // Fin de Fecha
