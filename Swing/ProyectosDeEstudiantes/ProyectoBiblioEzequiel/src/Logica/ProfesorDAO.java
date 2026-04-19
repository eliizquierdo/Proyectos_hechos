package Logica;
import java.sql.*;
import Persistencia.*;

public class ProfesorDAO {
	
private Conexion conexion;
	
	public ProfesorDAO() {
		conexion=new Conexion();
	}
	
	public String insertarProfesor(Profesor profesor) {
	    String rptaRegistro = null;

	    try {
	    	//Se fija si el profesor a ingresar ya existe
	        Connection acceBDCheck = conexion.getConnection();

	        String verificarSql = "SELECT ci FROM Socio WHERE ci=?";
	        try (PreparedStatement verificarSocio = acceBDCheck.prepareStatement(verificarSql)) {
	            verificarSocio.setInt(1, profesor.getCi());
	            try (ResultSet rs = verificarSocio.executeQuery()) {
	                if (rs.next()) {
	                    throw new Exception("El profesor con ci " + profesor.getCi() + " ya existe.");
	                }
	            }
	        }
	        //Ingresa el profesor
	        Connection acceBD = conexion.getConnection();
	        String sql = "INSERT INTO Socio VALUES(?,?,?,?)";
	        try (PreparedStatement estatuto = acceBD.prepareStatement(sql)) {
	            estatuto.setInt(1, profesor.getCi());
	            estatuto.setString(2, profesor.getNombre());
	            estatuto.setString(3, profesor.getDireccion());
	            estatuto.setString(4, profesor.getTelefono());

	            String sql1 = "INSERT INTO Profesor VALUES(?,?,?)";
	            try (PreparedStatement estatuto1 = acceBD.prepareStatement(sql1)) {
	                estatuto1.setInt(1, profesor.getCi());
	                estatuto1.setString(2, profesor.getFechaIngreso());
	                estatuto1.setString(3, profesor.getAsignatura());

	                int numFAfectadas = estatuto.executeUpdate();
	                int numFAfectadas1 = estatuto1.executeUpdate();

	                if (numFAfectadas > 0 && numFAfectadas1 > 0) {
	                    rptaRegistro = "Registro Exitoso!";
	                }
	            }
	        }
	    } catch (Exception e) {
	        System.out.println(e.getMessage());
	        rptaRegistro = "Error al intentar registrar: " + e.getMessage();
	    }

	    return rptaRegistro;
	}
		
	public int eliminarProfesor(int ci) {
		int numFAfectadas=0;
	try {
		Connection acceBD=conexion.getConnection();
		String sql1="DELETE FROM Profesor WHERE isbn=?;";
		String sql2="DELETE FROM Socio WHERE isbn=?;";
		
		PreparedStatement estatuto1=acceBD.prepareStatement(sql1);
		estatuto1.setInt(1,ci);
		PreparedStatement estatuto2=acceBD.prepareStatement(sql2);
		estatuto2.setInt(1,ci);
		numFAfectadas = estatuto1.executeUpdate();
		numFAfectadas = estatuto2.executeUpdate();
	}catch (Exception e) {
		System.out.println(e.getMessage());
	}
	return numFAfectadas;
	}
	
	public ListSocio listaSocios() {
		
		ListSocio list=new ListSocio();
		Profesor S;
		try {
			Connection acceBD=conexion.getConnection();
			String sql="SELECT s.ci, s.nombre, s.direccion, s.telefono, p.fechaIngreso, p.asignatura "+"FROM Socio s "+"LEFT JOIN Profesor p ON s.ci=p.ci";
			PreparedStatement estatuto=acceBD.prepareStatement(sql);
			ResultSet rs=estatuto.executeQuery();
			while (rs.next()) {
				S=new Profesor();
				S.setCi(rs.getInt("ci"));
				S.setNombre(rs.getString("nombre"));
				S.setDireccion(rs.getString("direccion"));
				S.setTelefono(rs.getString("telefono"));
				S.setFechaIngreso(rs.getString("fechaIngreso"));
				S.setAsignatura(rs.getString("asignatura"));
				
				list.agregarSocio(S);
			}
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
			}
		return list;
		}
	
		
}
