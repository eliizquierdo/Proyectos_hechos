package logica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalDateTime;

import persistencia.Conexion;

public class AlumnoDAO {
	
	private Conexion conexion;
	
	 public AlumnoDAO(){
	        conexion = new Conexion();
	    }
	    
	    public String insertarAlumno(AlumnoVO alu) {
	        String rptaRegistro=null;
	        int numFAfectas1=0 , numFAfectas2=1;
	     
	        try{
				Connection acceDB = conexion.getConnection();
				String sql="INSERT INTO socio VALUES(?,?,?,?); ";
				
				PreparedStatement estatuto = acceDB.prepareStatement(sql);
				
	            estatuto.setInt(1, alu.getCIa());
	            estatuto.setString(2, alu.getNombre() );
	            estatuto.setString(3, alu.getDireccion());
	            estatuto.setInt(4, alu.getTelefono());
	           
	            numFAfectas1=estatuto.executeUpdate();
	            
	            String sql2="INSERT INTO alumno VALUES(?,?,?,?) ";
				
				PreparedStatement estatuto2 = acceDB.prepareStatement(sql2);/////////////////////////
				
	            estatuto2.setInt(1, alu.getCIa());
	            estatuto2.setObject(2, alu.getfNac().atStartOfDay());/////////////////////////
	            estatuto2.setInt(3, alu.getEdad());
	            estatuto2.setString(4, alu.getGrupo() );
	            numFAfectas2=estatuto2.executeUpdate();
				            
				if(numFAfectas1>0 && numFAfectas2>0){
					rptaRegistro="Registro exitoso.";
				}
								
	    	} catch (Exception e) {
	    		System.out.println(e.getMessage());
	    	}
			return rptaRegistro;
	    }
	    
	    //corregir
	    public int eliminarAlumno(int cedula){
	        int filAfectadas= 0;
	        try {
	            Connection accesoDB = conexion.getConnection();
	            String sql="DELETE FROM persona WHERE cedula=?";
				PreparedStatement estatuto = accesoDB.prepareStatement(sql);
				estatuto.setInt(1, cedula);
	            filAfectadas = estatuto.executeUpdate();
	        } catch (Exception e) {
	        	System.out.println(e.getMessage());
				
	        }
	        
	        return filAfectadas;
	    }
	    
	    
	  
	    
	    //corregir
	    public ArrayAlumno listaAlumno() {
	        ArrayAlumno datosAl = new ArrayAlumno();
	        AlumnoVO alumno;
	        try {
	            Connection acceDB = conexion.getConnection();
	            String sql = "select * from socio";
	            PreparedStatement estatuto = acceDB.prepareStatement(sql);
	            ResultSet rs = estatuto.executeQuery();
	            String sql2 = "select * from alumno";
	            PreparedStatement estatuto2 = acceDB.prepareStatement(sql2);
	            
	            while (rs.next()) {
	                alumno = new AlumnoVO();
	                alumno.setCIa(rs.getInt(1));
	                alumno.setNombre(rs.getString(2));
	                alumno.setDireccion(rs.getString(3));
	                alumno.setTelefono(rs.getInt(4));
	                ResultSet rs2 = estatuto2.executeQuery();
		            while (rs2.next()) {
	                	LocalDate fechaNac = LocalDate.parse(rs2.getObject(2).toString());
	                    alumno.setfNac(fechaNac);
	                    alumno.setEdad(rs2.getInt(3));
	                    alumno.setGrupo(rs2.getString(4));
	                }

	                datosAl.agregar(alumno);
	            }
	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	        }
	        return datosAl;
	    }
	    //arreglar
	    public AlumnoVO buscarXCedula(int cedula){
	        AlumnoVO a = new AlumnoVO();
	        a.setCIa(cedula);
	        try {
	            Connection acceDB = conexion.getConnection();
	            String sql="select * from persona where cedula="+cedula+";";
	            PreparedStatement estatuto = acceDB.prepareStatement(sql);
	            ResultSet rs = estatuto.executeQuery();
	            while(rs.next()){
	                a.setNombre(rs.getString(2));
	                a.setTelefono(rs.getInt(3));
	                a.setDireccion(rs.getString(4));
	              //a.setFecha(rs.getInt(5));
	                a.setEdad(rs.getInt(6));
	                a.setGrupo(rs.getString(7));
	                
	            }
	        } catch (Exception e) {
	        	System.out.println(e.getMessage());
			}
	        return a;
}
}	    
