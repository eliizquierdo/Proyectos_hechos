package logica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import persistencia.Conexion;

public class ContenidoDAO {

	private static Conexion conexion;
	
	public ContenidoDAO() {
		
		conexion = new Conexion();
	}

	public String insertarPelicula(PeliculaVO pelicula) {
		
		int numFAfectas = 0;
		String rptaRegistro = null;
		
		try {
		
			Connection acceDB = conexion.getConnection();
			
			String sql = "Insert into Pelicula values (?,?,?)";
			
			PreparedStatement estatuto = acceDB.prepareStatement(sql);
			
			estatuto.setString(1, pelicula.getNombre());
			estatuto.setString(2, pelicula.getDescripcion());
			estatuto.setString(3, pelicula.getGenero());
			
			numFAfectas = estatuto.executeUpdate();
			
		}catch(Exception e){
			
			System.out.println(e.getMessage());
			
		}
		
		return rptaRegistro;
		
		
	}
	
	
	public String insertarSerie(SerieVO serie) {
		
		int numFAfectas = 0;
		String rptaRegistro = null;
		
		try {
		
			Connection acceDB = conexion.getConnection();
			
			String sql = "Insert into Serie values (?,?,?,?,?)";
			
			PreparedStatement estatuto = acceDB.prepareStatement(sql);
			
			estatuto.setString(1, serie.getNombre());
			estatuto.setString(2, serie.getDescripcion());
			estatuto.setString(3, serie.getGenero());
			estatuto.setString(4, serie.getCapitulos());
			estatuto.setString(5, serie.getTemporadas());
			
			
			numFAfectas = estatuto.executeUpdate();
			
		}catch(Exception e){
			
			System.out.println(e.getMessage());
			
		}
		
		return rptaRegistro;
		
		
	}
	
	
	public SerieVO buscarSerie(String nombre){
		
        SerieVO serie = new SerieVO();
        
        serie.setNombre(nombre);
        
        try {
        	
            Connection acceDB = conexion.getConnection();
            String sql="select * from Serie where nombre=" + "?" + ";";
            PreparedStatement estatuto = acceDB.prepareStatement(sql);
            estatuto.setString(1, nombre);
            ResultSet rs = estatuto.executeQuery();
            
            while(rs.next()){
            	
                    serie.setNombre(rs.getString(1));
                    serie.setDescripcion(rs.getString(2));
                    serie.setGenero(rs.getString(3));
                    serie.setCapitulos(rs.getString(4));
                    serie.setTemporadas(rs.getString(5));
                    
                
            }
            
        } catch (SQLException e) {
        	System.out.println(e.getMessage());
       }
        return serie;
    }
	
	
	public int eliminarSerie(String nombre){
	     int filAfectadas = 0;
	     try {
	            Connection accesoDB = conexion.getConnection();
	            String sql="DELETE FROM Serie WHERE nombre=?;";
	            PreparedStatement estatuto = accesoDB.prepareStatement(sql);
	            estatuto.setString(1, nombre);
	            filAfectadas = estatuto.executeUpdate();
	     } catch (Exception e) {
	        	System.out.println(e.getMessage());
	 }
	     return filAfectadas;
	}
	
	public int eliminarPelicula(String nombre){
	     int filAfectadas = 0;
	     try {
	            Connection accesoDB = conexion.getConnection();
	            String sql="DELETE FROM Pelicula WHERE nombre=?;";
	            PreparedStatement estatuto = accesoDB.prepareStatement(sql);
	            estatuto.setString(1, nombre);
	            filAfectadas = estatuto.executeUpdate();
	     } catch (Exception e) {
	        	System.out.println(e.getMessage());
	 }
	     return filAfectadas;
	}
	
	public PeliculaVO buscarPelicula(String nombre){
		
        PeliculaVO pelicula = new PeliculaVO();
        
        pelicula.setNombre(nombre);
        
        try {
        	
            Connection acceDB = conexion.getConnection();
            String sql="select * from Pelicula where nombre=" + "?" + ";";
            PreparedStatement estatuto = acceDB.prepareStatement(sql);
            estatuto.setString(1, nombre);
            ResultSet rs = estatuto.executeQuery();
            
            while(rs.next()){
            	
                    pelicula.setNombre(rs.getString(1));
                    pelicula.setDescripcion(rs.getString(2));
                    pelicula.setGenero(rs.getString(3));
                    
                
            }
            
        } catch (SQLException e) {
        	System.out.println(e.getMessage());
       }
        return pelicula;
    }
}
