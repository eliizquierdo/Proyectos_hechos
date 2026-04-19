package logica;

import java.sql.*;
import persistencia.*;


public class ClientesDAO {
	
	private static Conexion conexion;
	
	
	public ClientesDAO() {
		
		conexion = new Conexion();
		
	}
	
	
	public String insertarCliente(ClientesVO cliente) {
		
		int numFAfectas = 0;
		String rptaRegistro = null;
		
		try {
		
			Connection acceDB = conexion.getConnection();
			
			String sql = "Insert into Clientes values (?,?,?,?,?,?,?,?,?)";
			
			PreparedStatement estatuto = acceDB.prepareStatement(sql);
			
			estatuto.setString(1, cliente.getEmail());
			estatuto.setString(2, cliente.getPassword());
			estatuto.setString(3, cliente.getNombre());
			estatuto.setString(4, cliente.getApellido());
			estatuto.setString(5, cliente.getCiudad());
			estatuto.setString(6, cliente.getPais());
			estatuto.setString(7, cliente.getNombrePropietario());
			estatuto.setString(8, cliente.getNumeroTarjeta());
			estatuto.setString(9, cliente.getCodigoTarjeta());
			
			numFAfectas = estatuto.executeUpdate();
			
		}catch(Exception e){
			
			System.out.println(e.getMessage());
			
		}
		
		return rptaRegistro;
		
		
	}
	
	public int eliminarCliente(String email){
	     int filAfectadas = 0;
	     try {
	            Connection accesoDB = conexion.getConnection();
	            String sql="DELETE FROM Clientes WHERE email=?;";
	            PreparedStatement estatuto = accesoDB.prepareStatement(sql);
	            estatuto.setString(1, email);
	            filAfectadas = estatuto.executeUpdate();
	     } catch (Exception e) {
	        	System.out.println(e.getMessage());
	 }
	     return filAfectadas;
	}
	
	public ClientesVO buscarXEmail(String email){
		
        ClientesVO cliente = new ClientesVO();
         
        cliente.setEmail(email);
        
        try {
        	
            Connection acceDB = conexion.getConnection();
            String sql="select * from Clientes where email=" + "?" + ";";
            PreparedStatement estatuto = acceDB.prepareStatement(sql);
            estatuto.setString(1, email);
            ResultSet rs = estatuto.executeQuery();
            
            while(rs.next()){
            	
                    cliente.setNombre(rs.getString(3));
                    cliente.setApellido(rs.getString(4));
                    cliente.setEmail(rs.getString(1));
                    cliente.setPassword(rs.getString(2));
                    cliente.setCiudad(rs.getString(5));
                    cliente.setPais(rs.getString(6));
                    cliente.setNombrePropietario(rs.getString(7));
                    cliente.setNumeroTarjeta(rs.getString(8));
                    cliente.setCodigoTarjeta(rs.getString(9));
                    
                
            }
            
        } catch (SQLException e) {
        	System.out.println(e.getMessage());
       }
        return cliente;
    }




	
	
	
	
	
}

	