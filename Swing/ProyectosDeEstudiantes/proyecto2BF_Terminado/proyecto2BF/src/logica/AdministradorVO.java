package logica;

public class AdministradorVO {

	private static String nombreAdmin;
	private static String apellidoAdmin;
	private static String passwordAdmin;
	
	
//------------------------------------------------------------------------------------------------------------------
	
	public AdministradorVO() {
		
		nombreAdmin="Eric";
		apellidoAdmin="Barone";
		passwordAdmin="2012";
		
	}//DEFECTO

//------------------------------------------------------------------------------------------------------------------
	
	
	//EMPIEZAN GETTERS AND SETTERS
	public static String getNombreAdmin() {
		return nombreAdmin;
	}

	public static void setNombreAdmin(String nombreAdmin) {
		AdministradorVO.nombreAdmin = nombreAdmin;
	}

	public static String getApellidoAdmin() {
		return apellidoAdmin;
	}

	public static void setApellidoAdmin(String apellidoAdmin) {
		AdministradorVO.apellidoAdmin = apellidoAdmin;
	}

	public static String getPasswordAdmin() {
		return passwordAdmin;
	}

	public static void setPasswordAdmin(String passwordAdmin) {
		AdministradorVO.passwordAdmin = passwordAdmin;
	}
	//TERMINAN GETTERS AND SETTERS

	
	
	
}//CLASS
