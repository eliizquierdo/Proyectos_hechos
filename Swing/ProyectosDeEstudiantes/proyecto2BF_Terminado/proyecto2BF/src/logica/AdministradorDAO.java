package logica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import persistencia.Conexion;

public class AdministradorDAO {
	
	private static Conexion conexion;
	
	
	public AdministradorDAO() {
		
		conexion = new Conexion();
		
	}
	
}
