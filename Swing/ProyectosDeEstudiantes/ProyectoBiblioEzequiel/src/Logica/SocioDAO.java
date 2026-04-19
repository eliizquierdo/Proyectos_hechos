package Logica;

import java.sql.*;

import Persistencia.Conexion;

public class SocioDAO {

	private Conexion conexion;
	
	public SocioDAO() {
		conexion=new Conexion();
	}
	
	public String getSocios() {
		try {
			Connection acceBD = conexion.getConnection();

			String sql = "SELECT s.ci, s.nombre, s.direccion, s.telefono, a.edad, a.grupo, a.fechaNacimiento, p.asignatura, p.fechaIngreso "
					+ "FROM Socio s "
					+ "LEFT JOIN Alumno a ON s.ci = a.ci "
					+ "LEFT JOIN Profesor p ON s.ci = p.ci;";

			PreparedStatement estatuto = acceBD.prepareStatement(sql);

			ResultSet resultSet = estatuto.executeQuery();

			StringBuilder Resultado = new StringBuilder();

			while (resultSet.next()) {
				String ci = resultSet.getString("ci");
				String nombre = resultSet.getString("nombre");
				String direccion = resultSet.getString("direccion");
				String telefono = resultSet.getString("telefono");

				if (resultSet.getString("edad") != null) {
					String edad = resultSet.getString("edad");
					String grupo = resultSet.getString("grupo");
					String fechaNacimiento = resultSet.getString("fechaNacimiento");

					Resultado.append("CI: ").append(ci).append(", Nombre: ").append(nombre).append(", Dirección: ")
							.append(direccion).append(", Teléfono: ").append(telefono).append(", Edad: ").append(edad)
							.append(", Grupo: ").append(grupo).append(", Fecha de Nacimiento: ").append(fechaNacimiento)
							.append("\n");
				}

				else if (resultSet.getString("asignatura") != null) {
					String asignatura = resultSet.getString("asignatura");
					String fechaIngreso = resultSet.getString("fechaIngreso");

					Resultado.append("CI: ").append(ci).append(", Nombre: ").append(nombre).append(", Dirección: ")
							.append(direccion).append(", Teléfono: ").append(telefono).append(", Asignatura: ")
							.append(asignatura).append(", Fecha de Ingreso: ").append(fechaIngreso).append("\n");
				}

			}

			return Resultado.toString();

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return "Error al obtener datos de socios";
		}
	}


	public ListSocio listaSocios() {
		
		ListSocio list=new ListSocio();
		Profesor P;
		Alumno A;
		try {
			Connection acceBD=conexion.getConnection();
			String sql="SELECT s.*, p.fechaIngreso, p.asignatura, a.edad, a.grupo, a.fechaNacimiento "+"FROM Socio s "+"LEFT JOIN Profesor p ON s.ci=p.ci "+ "LEFT JOIN Alumno a ON s.ci = a.ci;";
			PreparedStatement estatuto=acceBD.prepareStatement(sql);
			ResultSet rs=estatuto.executeQuery();
			while (rs.next()) {
				P=new Profesor();
				A=new Alumno();
				if(rs.getString("asignatura")!=null) {
					P.setCi(rs.getInt("ci"));
					P.setNombre(rs.getString("nombre"));
					P.setDireccion(rs.getString("direccion"));
					P.setTelefono(rs.getString("telefono"));
					P.setAsignatura(rs.getString("asignatura"));
					P.setFechaIngreso(rs.getString("fechaIngreso"));	
					list.agregarSocio(P);
					}
				
				if(rs.getString("grupo")!=null) {
					A.setCi(rs.getInt("ci"));
					A.setNombre(rs.getString("nombre"));
					A.setDireccion(rs.getString("direccion"));
					A.setTelefono(rs.getString("telefono"));
					A.setEdad(rs.getInt("edad"));
					A.setGrupo(rs.getString("grupo"));
					A.setFechaNacimiento(rs.getString("fechaNacimiento"));
					list.agregarSocio(A);
				}
				
				
			}
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
			}
		return list;
		}
	
	public int eliminarSocio(int ci) {
		int numFAfectadas=0;
	try {
		Connection acceBD=conexion.getConnection();
		String sql="SELECT s.*, p.asignatura, a.grupo "+"FROM Socio s "+"LEFT JOIN Profesor p ON s.ci=p.ci "+ "LEFT JOIN Alumno a ON s.ci = a.ci;";
		PreparedStatement estatuto=acceBD.prepareStatement(sql);
		ResultSet rs=estatuto.executeQuery();
		while(rs.next()) {
			
			if(rs.getString("grupo")!=null) {
				String sql1="DELETE FROM Alumno WHERE ci=?";
				PreparedStatement estatuto1=acceBD.prepareStatement(sql1);
				estatuto1.setInt(1, ci);
				numFAfectadas = estatuto1.executeUpdate();
			}
			if(rs.getString("asignatura")!=null) {
				String sql1="DELETE FROM Profesor WHERE ci=?";
				PreparedStatement estatuto1=acceBD.prepareStatement(sql1);
				estatuto1.setInt(1, ci);
				numFAfectadas = estatuto1.executeUpdate();
			}
		}
		String sql3="DELETE FROM Socio WHERE ci=?;";
		PreparedStatement estatuto3=acceBD.prepareStatement(sql3);
		estatuto3.setInt(1, ci);
		numFAfectadas = estatuto3.executeUpdate();
	}catch (Exception e) {
		System.out.println(e.getMessage());
	}
	return numFAfectadas;
	}


}

