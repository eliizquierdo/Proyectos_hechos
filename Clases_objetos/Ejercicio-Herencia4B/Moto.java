public class Moto extends Vehiculo{
	private int cilindrada;

	public Moto(int cilindrada, String mr, double p, String mt, Fecha fC) {
		super(mr, p, mt, fC);
		this.cilindrada = cilindrada;
	}

	public int getCilindrada() {
		return cilindrada;
	}

	public void setCilindrada(int cilindrada) {
		this.cilindrada = cilindrada;
	}
	

	public double descuentoNeto() {
		double descNet = 0;
		
		if(cilindrada < 100) 
			descNet = super.getPrecio() * 0.10;
		return super.getPrecio() - descNet;
	}
	
	public String toString() {
		return String.format("Marca: %s\nPrecio: %s\nMatricula: %s\nFecha de compra: %s\nCilindrada: %s", 
				super.getMarca(), super.getPrecio(), super.getMatricula(), super.getFechaCompra(), cilindrada);
	}
}
