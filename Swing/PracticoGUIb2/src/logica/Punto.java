package logica;

public class Punto {
	private int valorX;
	private int valorY;
	
	public Punto() {
		
	}
	
	public Punto(int valorX, int valorY) {
		
		this.valorX = valorX;
		this.valorY = valorY;
	}

	public int getValorX() {
		return valorX;
	}

	public void setValorX(int valorX) {
		this.valorX = valorX;
	}

	public int getValorY() {
		return valorY;
	}

	public void setValorY(int valorY) {
		this.valorY = valorY;
	}

	@Override
	public String toString() {
		return "Punto [valorX=" + valorX + ", valorY=" + valorY + "]";
	}
	
	
	
	
	
}
