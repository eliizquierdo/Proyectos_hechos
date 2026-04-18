package logica;

public class Recta {
	
	private Punto punto1;
	private Punto punto2;
	
public Recta() {
		
		
	}
	
	public Recta(Punto punto1, Punto punto2) {
		
		this.punto1 = punto1;
		this.punto2 = punto2;
	}

	public Punto getPunto1() {
		return punto1;
	}

	public void setPunto1(Punto punto1) {
		this.punto1 = punto1;
	}

	public Punto getPunto2() {
		return punto2;
	}

	public void setPunto2(Punto punto2) {
		this.punto2 = punto2;
	}

	@Override
	public String toString() {
		return "Recta [punto1=" + punto1 + ", punto2=" + punto2 + "]";
	}
	
	public double largoRecta() {
		double restaX=Math.pow(punto2.getValorX()-punto1.getValorX(),2);
		double restaY=Math.pow(punto2.getValorY()-punto1.getValorY(),2);
		double largo=Math.round(Math.sqrt(restaX+restaY));
		return largo;
	}
	
	
	
	
}
