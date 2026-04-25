package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LibrosBD {

	 //devuelve una matriz con todos los registros de la tabla persona y alumno
	 public  String[][] select(){
		 	int i=0, j=0, cant=0;
		 	String [][]datos=null;
		 	Conectar con=ControladorPersistencia.getInstancia().getConexion();
		 	String sql1="SELECT * FROM libro";
		    
		    try {
		    	cant=ControladorPersistencia.getInstancia().contarRegistros("libro");
		    	datos = new String [cant][2];
	            PreparedStatement pstm = con.getConnection().prepareStatement(sql1);
	        	ResultSet rs = pstm.executeQuery();
	            while(rs.next()){
	            	    datos[i][0]=rs.getString("codigo");
		                datos[i][1]=rs.getString("titulo");
		                i++;  //recorre filas
		               
	           }
	            
	        } catch (SQLException ex) {
	           System.out.println("error en BD1");
	        }catch (ClassNotFoundException ex2){
	        	System.out.println("error en BD1");
	        }
	       
	        return datos;
	    
	    }
	 
	 //recupera un registro dada un codigo, lo uso para modificar libros 
	 public   String[] selectCond(int codigo){ 
		 	Conectar con=ControladorPersistencia.getInstancia().getConexion();
		    PreparedStatement pstm=null;
	        String sql1="SELECT * FROM libro WHERE codigo="+codigo;
	        String []datos = new String [2];
	        
	        try {
	            pstm = con.getConnection().prepareStatement(sql1);
	            ResultSet rs = pstm.executeQuery();
	            while(rs.next()){
	            	    datos[0]=rs.getString("codigo");
		                datos[1]=rs.getString("titulo");
		                		                
	           }
	           
	        } catch (SQLException ex) {
	        		System.out.println("error en BD1");
	        }
	        
	          
	        return datos;
	    
	    }
	
}
