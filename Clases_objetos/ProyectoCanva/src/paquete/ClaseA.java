package paquete;

public class ClaseA {
	private int atributo1;
	private ClaseB atributo2;
	
	public ClaseA(int atributo1, ClaseB atributo2) {
		this.atributo1 = atributo1;
		this.atributo2 = atributo2;
	}

	public int getAtributo1() {
		return atributo1;
	}

	public void setAtributo1(int atributo1) {
		this.atributo1 = atributo1;
	}

	public ClaseB getAtributo2() {
		return atributo2;
	}

	public void setAtributo2(ClaseB atributo2) {
		this.atributo2 = atributo2;
	}

	@Override
	public String toString() {
		return "atributo1=" + atributo1 + "\n"
				+ ", atributo2=" + atributo2.toString();
	}
	
	
	
	

}
