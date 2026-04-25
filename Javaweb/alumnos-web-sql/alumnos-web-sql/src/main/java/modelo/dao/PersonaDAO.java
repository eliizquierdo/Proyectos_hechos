package modelo.dao;

import modelo.conexion.Conexion;
import modelo.vo.PersonaVO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/*****************************************************************************/
public class PersonaDAO {
    
    public List<PersonaVO> listarPersonas() {
        List<PersonaVO> lista = new ArrayList<>();
                
        Conexion cn = new Conexion();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            if (cn.conectar()) {
                 //1
                con = cn.getConnection();
                //2
                String sql = "SELECT * FROM persona";
                //3
                ps = con.prepareStatement(sql);
                //4
                rs = ps.executeQuery();
                //5
                while (rs.next()) {
                    PersonaVO persona = new PersonaVO(
                        rs.getInt("codigo"),
                        rs.getString("nombre")
                    );
                    lista.add(persona);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al listar personas: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Cerrar recursos en orden inverso
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                cn.desconectar();
            } catch (SQLException e) {
                System.err.println("Error al cerrar recursos: " + e.getMessage());
            }
        }
        return lista;
    }
/*****************************************************************************/
    public boolean agregarPersona(PersonaVO persona) {
        String sql = "INSERT INTO persona(codigo, nombre) VALUES (?, ?)";
        
        Conexion cn = new Conexion();
        Connection con = null;
        PreparedStatement ps = null;
        boolean exito = false;
        
        try {
            if (cn.conectar()) {
                con = cn.getConnection();
                ps = con.prepareStatement(sql);
                ps.setInt(1, persona.getCodigo());
                ps.setString(2, persona.getNombre());
                
                int filasAfectadas = ps.executeUpdate();
                exito = filasAfectadas > 0;
                
                System.out.println("Persona agregada: " + persona.toString());
            }
        } catch (SQLException e) {
            System.err.println("Error al agregar persona: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) 
                  ps.close();
                cn.desconectar();
            } catch (SQLException e) {
                System.err.println("Error al cerrar recursos: " + e.getMessage());
            }
        }
        return exito;
    }

   
}