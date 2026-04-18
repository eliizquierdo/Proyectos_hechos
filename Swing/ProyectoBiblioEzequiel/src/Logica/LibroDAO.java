package Logica;
import java.sql.*;
import Persistencia.*;

public class LibroDAO {
	
private Conexion conexion;
	
	public LibroDAO() {
		conexion=new Conexion();
	}
	
	public String insertarcopia(CopiaLibro copia) {
		int numFAfectadas=0;
		int numFAfectadas1=0;
		String rptaRegistro=null;
	try {
		Connection acceBD=conexion.getConnection();
		String sql="INSERT INTO Libro VALUES(?,?,?,?,?,?,?)";
		PreparedStatement estatuto=acceBD.prepareStatement(sql);
		estatuto.setInt(1, copia.getIsbn());
		estatuto.setString(2, copia.getTitulo());
		estatuto.setInt(3, copia.getNroPaginas());
		estatuto.setString(4, copia.getEdicion());
		estatuto.setString(5, copia.getEditorial());
		estatuto.setString(6, copia.getAutor());
		estatuto.setString(7, copia.getPais());
		
		String sql1="INSERT INTO Copia VALUES(?,?,?)";
		PreparedStatement estatuto1=acceBD.prepareStatement(sql1);
		estatuto1.setInt(1, copia.getIsbn());
		estatuto1.setString(2, copia.getEstado());
		estatuto1.setInt(3, copia.getCantCopias());
		
		
		numFAfectadas=estatuto.executeUpdate();
		numFAfectadas1=estatuto1.executeUpdate();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	if(numFAfectadas>0 && numFAfectadas1>0)
		rptaRegistro="Registro Exitoso!";
	return rptaRegistro;
	}
	
	public int eliminarLibro(int isbn) {
		int numFAfectadas=0;
	try {
		Connection acceBD=conexion.getConnection();
		String sql1="DELETE FROM Copia WHERE isbn=?;";
		String sql2="DELETE FROM Libro WHERE isbn=?;";
		
		PreparedStatement estatuto1=acceBD.prepareStatement(sql1);
		estatuto1.setInt(1,isbn);
		PreparedStatement estatuto2=acceBD.prepareStatement(sql2);
		estatuto2.setInt(1,isbn);
		numFAfectadas = estatuto1.executeUpdate();
		numFAfectadas = estatuto2.executeUpdate();
	}catch (Exception e) {
		System.out.println(e.getMessage());
	}
	return numFAfectadas;
	}
	
	public ListLibros listaLibros() {
		
		ListLibros list=new ListLibros();
		CopiaLibro L;
		try {
			Connection acceBD=conexion.getConnection();
			String sql="SELECT l.isbn, l.titulo, l.nroPaginas, l.edicion, l.editorial, l.autor, l.pais, c.estado, c.cantCopias "+"FROM Libro l "+"LEFT JOIN Copia c ON l.isbn=c.isbn";
			PreparedStatement estatuto=acceBD.prepareStatement(sql);
			ResultSet rs=estatuto.executeQuery();
			while (rs.next()) {
				L=new CopiaLibro();
				L.setIsbn(rs.getInt("isbn"));
				L.setTitulo(rs.getString("titulo"));
				L.setNroPaginas(rs.getInt("nroPaginas"));
				L.setEdicion(rs.getString("edicion"));
				L.setEditorial(rs.getString("editorial"));
				L.setAutor(rs.getString("autor"));
				L.setPais(rs.getString("pais"));
				L.setEstado(rs.getString("estado"));
				L.setCantCopias(rs.getInt("cantCopias"));
				
				list.agregarLibro(L);
			}
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
			}
		return list;
		}
	
		
}