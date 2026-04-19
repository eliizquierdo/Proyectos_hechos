package Logica;

import java.sql.*;
import Persistencia.*;

public class AlumnoDAO {

	private Conexion conexion;

	public AlumnoDAO() {
		conexion = new Conexion();
	}

	public String insertarAlumno(Alumno alumno) {
		int numFAfectadas = 0;
		int numFAfectadas1 = 0;
		String rptaRegistro = null;
		
		 try {
		    	//Se fija si el alumno a ingresar ya existe	       
			 Connection acceBDCheck = conexion.getConnection();			 
			 String verificarSql = "SELECT ci FROM Socio WHERE ci=?";
		        try (PreparedStatement verificarSocio = acceBDCheck.prepareStatement(verificarSql)) {
		        
		        	verificarSocio.setInt(1, alumno.getCi());
		          
		        	try (ResultSet rs = verificarSocio.executeQuery()) 
		        	{
		                if (rs.next()) {
		                    throw new Exception("El alumno con ci " + alumno.getCi() + " ya existe.");
		                }
		            }
		        }
		    //Ingresa al alumno
			Connection acceBD = conexion.getConnection();
			String sql = "INSERT INTO Socio VALUES(?,?,?,?)";
			PreparedStatement estatuto = acceBD.prepareStatement(sql);
			estatuto.setInt(1, alumno.getCi());
			estatuto.setString(2, alumno.getNombre());
			estatuto.setString(3, alumno.getDireccion());
			estatuto.setString(4, alumno.getTelefono());

			String sql1 = "INSERT INTO Alumno VALUES(?,?,?,?)";
			PreparedStatement estatuto1 = acceBD.prepareStatement(sql1);
			estatuto1.setInt(1, alumno.getCi());
			estatuto1.setString(2, alumno.getFechaNacimiento());
			estatuto1.setInt(3, alumno.getEdad());
			estatuto1.setString(4, alumno.getGrupo());

			numFAfectadas = estatuto.executeUpdate();
			numFAfectadas1 = estatuto1.executeUpdate();
			
			if (numFAfectadas > 0 && numFAfectadas1 > 0) {
				rptaRegistro = "Registro Exitoso!";

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		rptaRegistro = "Error al intentar registrar: " + e.getMessage();
		}
		return rptaRegistro;
	}

	public int eliminarAlumno(int ci) {
		int numFAfectadas = 0;
		try {
			Connection acceBD = conexion.getConnection();
			String sql1 = "DELETE FROM Alumno WHERE isbn=?;";
			String sql2 = "DELETE FROM Socio WHERE isbn=?;";

			PreparedStatement estatuto1 = acceBD.prepareStatement(sql1);
			estatuto1.setInt(1, ci);
			PreparedStatement estatuto2 = acceBD.prepareStatement(sql2);
			estatuto2.setInt(1, ci);
			numFAfectadas = estatuto1.executeUpdate();
			numFAfectadas = estatuto2.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return numFAfectadas;
	}

	public ListSocio listaSocios() {

		ListSocio list = new ListSocio();
		Alumno S;
		try {
			Connection acceBD = conexion.getConnection();
			String sql = "SELECT s.ci, s.nombre, s.direccion, s.telefono, a.edad, a.fechaNacimiento, a.grupo "
					+ "FROM Socio s " + "LEFT JOIN Alumno a ON s.ci=a.ci";
			PreparedStatement estatuto = acceBD.prepareStatement(sql);
			ResultSet rs = estatuto.executeQuery();
			while (rs.next()) {
				S = new Alumno();
				S.setCi(rs.getInt("ci"));
				S.setNombre(rs.getString("nombre"));
				S.setDireccion(rs.getString("direccion"));
				S.setTelefono(rs.getString("telefono"));
				S.setEdad(rs.getInt("edad"));
				S.setFechaNacimiento(rs.getString("fechaNacimiento"));
				S.setGrupo(rs.getString("grupo"));

				list.agregarSocio(S);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return list;
	}

}