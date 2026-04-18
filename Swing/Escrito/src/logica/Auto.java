package logica;

public class Auto extends Vehiculo {
    private int cilindrada;

    public Auto(String matricula, String marca, double precio, int cilindrada) {
        super(matricula, marca, precio); 
        this.cilindrada = cilindrada;
    }

    
    public int getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }

    
    public String toString() {
        return super.toString() + cilindrada + "\n";
    }
    
    public double promocion() {
        if (cilindrada < 10) {
            double descuento = getPrecio() * 0.20;
            return getPrecio() - descuento;
        } else {
            return getPrecio(); // Sin
        }
    }
}
