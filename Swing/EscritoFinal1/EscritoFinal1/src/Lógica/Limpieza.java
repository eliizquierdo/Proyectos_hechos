package Lógica;

public class Limpieza extends Producto {
    private int anioVencimiento;

    public Limpieza(int codigo, String nombre, double costo, int anioVencimiento) {
        super(codigo, nombre, costo);
        this.anioVencimiento = anioVencimiento;
    }

    public int getAnioVencimiento() {
        return anioVencimiento;
    }

    public void setAnioVencimiento(int anioVencimiento) {
        this.anioVencimiento = anioVencimiento;
    }
    
    @Override
    public double precio() {
        if (getAnioVencimiento() < 2022) {
            return costo + (costo * 0.10);
        } else {
            return costo;
        }
    }
    
  

    @Override
    public String toString() {
        return super.toString() + "Anio Vencimiento:" +anioVencimiento + " Precio: " + precio();
 }
}