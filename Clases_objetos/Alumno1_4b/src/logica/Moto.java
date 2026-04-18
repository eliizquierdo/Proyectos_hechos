package logica;

public class Moto extends Vehiculo {
    private int cilindrada;

    public Moto(String marca, String modelo, double precioBase, Fecha fechaFabricacion, int cilindrada) {
        super(marca, modelo, precioBase, fechaFabricacion);
        this.cilindrada = cilindrada;
    }

   
    @Override
	public String toString() {
		return "Moto [cilindrada=" + cilindrada + "]";
	}


	public int getCilindrada() {
		return cilindrada;
	}


	public void setCilindrada(int cilindrada) {
		this.cilindrada = cilindrada;
	}


	public double descuentoNeto() {
        double descuento = super.descuentoNeto();
        if (cilindrada < 100) {
            descuento += descuento * 0.10; 
        }
        return descuento;
    }

   
}