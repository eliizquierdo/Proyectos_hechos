 package logica;

public class ClientesVO {
	
	private String email;
	private String password;
	private String nombre;
	private String apellido;
	private String ciudad;
	private String pais;
	private String nombrePropietario;
	private String numeroTarjeta;
	private String codigoTarjeta;
	
	public ClientesVO() {
		
	}//DEFECTO
	
	


	public ClientesVO(String email, String password, String nombre, String apellido, String ciudad, String pais,
			String nombrePropietario, String numeroTarjeta, String codigoTarjeta) {
		
		this.email = email;
		this.password = password;
		this.nombre = nombre;
		this.apellido = apellido;
		this.ciudad = ciudad;
		this.pais = pais;
		this.nombrePropietario = nombrePropietario;
		this.numeroTarjeta = numeroTarjeta;
		this.codigoTarjeta = codigoTarjeta;
	}
	

	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public String getPassword() {
		return password;
	}




	public  void setPassword(String password) {
		this.password = password;
	}




	public  String getNombre() {
		return nombre;
	}




	public  void setNombre(String nombre) {
		this.nombre = nombre;
	}




	public  String getApellido() {
		return apellido;
	}




	public  void setApellido(String apellido) {
		this.apellido = apellido;
	}




	public  String getCiudad() {
		return ciudad;
	}




	public  void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}




	public  String getPais() {
		return pais;
	}




	public void setPais(String pais) {
		this.pais = pais;
	}




	public String getNombrePropietario() {
		return nombrePropietario;
	}




	public  void setNombrePropietario(String nombrePropietario) {
		this.nombrePropietario = nombrePropietario;
	}




	public  String getNumeroTarjeta() {
		return numeroTarjeta;
	}




	public  void setNumeroTarjeta(String numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}




	public  String getCodigoTarjeta() {
		return codigoTarjeta;
	}




	public  void setCodigoTarjeta(String codigoTarjeta) {
		this.codigoTarjeta = codigoTarjeta;
	}



	
	
	

}
