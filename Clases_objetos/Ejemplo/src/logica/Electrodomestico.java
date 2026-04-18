package logica;

public class Electrodomestico {
 
	private String marca;
	private String nombre;
	private double consumo;
	
	
	public Electrodomestico(String marca, String nombre, double consumo) {
		super();
		this.marca = marca;
		this.nombre = nombre;
		this.consumo = consumo;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getConsumo() {
		return consumo;
	}
	public void setConsumo(double consumo) {
		this.consumo = consumo;
	}
	
	public double calculoConsumo(int horas) {
		return consumo=(consumo*horas);
		
	}
	@Override
	public String toString() {
		return "Electrodomestico [marca=" + marca + ", nombre=" + nombre + ", consumo=" + consumo + ", getMarca()="
				+ getMarca() + ", getNombre()=" + getNombre() + ", getConsumo()=" + getConsumo() + "]";
	}

	



}