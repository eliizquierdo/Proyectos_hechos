package Logica;
import java.sql.*;
import Persistencia.*;

public class PrestamoDAO {
	
private Conexion conexion;
	
	public PrestamoDAO() {
		conexion=new Conexion();
	}
	
	public String insertarPrestamo(Prestamo prestamo) {
		int numFAfectadas=0;
		String rptaRegistro=null;
	try {
        Connection acceBDCheck = conexion.getConnection();

        String verificarSql = "SELECT p.ciSocio, p.isbnLibro " +"FROM Prestamo p " +"WHERE ciSocio=? AND isbnLibro=?";
        try (PreparedStatement verificarPrestamo = acceBDCheck.prepareStatement(verificarSql)) {
            verificarPrestamo.setInt(1, prestamo.getCi());
            verificarPrestamo.setInt(2, prestamo.getIsbn());
            try (ResultSet rs = verificarPrestamo.executeQuery()) {
                if (rs.next()) {
                    throw new Exception("El prestamo con ci " + prestamo.getCi() + " y isbn "+prestamo.getIsbn()+" ya existe.");
                }
            }
        }
		Connection acceBD=conexion.getConnection();
		String sql="INSERT INTO Prestamo VALUES(?,?,?,?)";
		PreparedStatement estatuto=acceBD.prepareStatement(sql);
		estatuto.setInt(1, prestamo.getCi());
		estatuto.setInt(2, prestamo.getIsbn());
		estatuto.setString(3, prestamo.getFechaPrestamo());
		estatuto.setString(4, prestamo.getFechaDevolucion());
	
		numFAfectadas=estatuto.executeUpdate();
		
		if(numFAfectadas>0)
			rptaRegistro="Registro Exitoso!";
		return rptaRegistro;
		
		}catch(Exception e) {
			System.out.println(e.getMessage());
			rptaRegistro = "Error al intentar registrar: " + e.getMessage();
		}
	return rptaRegistro;
	}
	public int eliminarPrestamo(int ci,int isbn) {
		int numFAfectadas=0;
	try {
		Connection acceBD=conexion.getConnection();
		String sql1="DELETE FROM Prestamo WHERE ciSocio=? AND isbnLibro=?;";
		
		PreparedStatement estatuto1=acceBD.prepareStatement(sql1);
		estatuto1.setInt(1, ci);
		estatuto1.setInt(2, isbn);
		numFAfectadas = estatuto1.executeUpdate();
	}catch (Exception e) {
		System.out.println(e.getMessage());
	}
	return numFAfectadas;
	}
	
	public Prestamos listaPrestamo() {
		
		Prestamos list=new Prestamos();
		Prestamo P;
		try {
			Connection acceBD=conexion.getConnection();
			String sql=("SELECT p.inicioPrestamo, p.fechaDevolucion, s.ci AS ciSocio, l.isbn AS isbnLibro " + "FROM Prestamo p " + "LEFT JOIN Socio s ON s.ci = p.ciSocio " + "LEFT JOIN Libro l ON l.isbn = p.isbnLibro");
			PreparedStatement estatuto=acceBD.prepareStatement(sql);
			ResultSet rs=estatuto.executeQuery();
			while (rs.next()) {
				P=new Prestamo();
				P.setCi(rs.getInt("ciSocio"));
				P.setIsbn(rs.getInt("isbnLibro"));
				P.setFechaPrestamo(rs.getString("inicioPrestamo"));
				P.setFechaDevolucion(rs.getString("fechaDevolucion"));
								
				list.agregarPrestamo(P);
			}
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Es aca");
			}
		return list;
		}
	
		
}