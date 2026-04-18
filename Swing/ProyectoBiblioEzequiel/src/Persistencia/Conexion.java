package Persistencia;
import java.sql.*;
public class Conexion {

	String bd="biblioteca";
	String login="root";
	String password="admin123";
	String url = "jdbc:mysql://localhost:3306/biblioteca?user=root&serverTimezone=America/Montevideo";
	
	private Connection con;
	
	public Conexion () {
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, login, password);
			if (con!=null)
			        System.out.println("Conexión a base de datos " + bd +" OK\n");
			
			}catch(SQLException e){
				
			System.out.println(e);
			
			}catch(ClassNotFoundException e){
				
			System.out.println(e);
			
			}catch(Exception e){
				
			System.out.println(e);
			}
		}
	
	public void desconectar(){
		try{
		    System.out.println("Desconectado de base de datos " + bd +" OK\n");
		    
		    con.close();
		    
		}catch(SQLException e){
			
		System.out.println("Error al desconectar");
			}
		
		}	
	

		public Connection getConnection(){
			return con;
			}


}
