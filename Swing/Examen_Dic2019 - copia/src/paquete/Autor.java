package paquete;

public class Autor {
	private String apellido;
	private String pais;
	
	public Autor() {
		
	}
	
	public Autor(String apellido, String pais) {
		super();
		this.apellido = apellido;
		this.pais = pais;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	
	@Override
	public String toString() {
		return "Autor [apellido=" + apellido + ", pais=" + pais + "]";
	}

}
