package modelo.dao;

import modelo.conexion.Conexion;
import modelo.vo.PersonaVO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonaDAO {
    
    public List<PersonaVO> listarPersonas() {
        List<PersonaVO> lista = new ArrayList<>();
        String sql = "SELECT * FROM persona";
        
        Conexion cn = new Conexion();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            if (cn.conectar()) {
                con = cn.getConnection();
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                
                while (rs.next()) {
                    PersonaVO persona = new PersonaVO(
                        rs.getInt("codigo"),
                        rs.getString("nombre"),
                        rs.getString("apellido")
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

    public boolean agregarPersona(PersonaVO persona) {
       
        
        Conexion cn = new Conexion();
        Connection con = null;
        PreparedStatement ps = null;
        boolean exito = false;
        
        try {
            if (cn.conectar()) {
                //1-Se establece la conexión
                con = cn.getConnection();
                //2- Se define un String donde se escribe la sentencia SQL
                String sql = "INSERT INTO persona(codigo, nombre, apellido) VALUES (?, ?, ?)";
                //3- El objeto ps recibe como parametro la sentencia SQL y los parametros
                ps = con.prepareStatement(sql);
                ps.setInt(1, persona.getCodigo());
                ps.setString(2, persona.getNombre());
                ps.setString(3, persona.getApellido());
                //4- Ejecutar la sentencia
                int filasAfectadas = ps.executeUpdate();
                exito = filasAfectadas > 0;
                
                System.out.println("Persona agregada: " + persona.toString());
            }
        } catch (SQLException e) {
            System.err.println("Error al agregar persona: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) ps.close();
                cn.desconectar();
            } catch (SQLException e) {
                System.err.println("Error al cerrar recursos: " + e.getMessage());
            }
        }
        return exito;
    }

    public boolean actualizarPersona(PersonaVO persona) {
        String sql = "UPDATE persona SET nombre = ?, apellido = ? WHERE codigo = ?";
        
        Conexion cn = new Conexion();
        Connection con = null;
        PreparedStatement ps = null;
        boolean exito = false;
        
        try {
            if (cn.conectar()) {
                con = cn.getConnection();
                ps = con.prepareStatement(sql);
                ps.setString(1, persona.getNombre());
                ps.setString(2, persona.getApellido());
                ps.setInt(3, persona.getCodigo());
                
                int filasAfectadas = ps.executeUpdate();
                exito = filasAfectadas > 0;
                
                if (exito) {
                    System.out.println("Persona actualizada: " + persona.toString());
                } else {
                    System.out.println("No se encontró persona con código " + persona.getCodigo());
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al actualizar persona: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) ps.close();
                cn.desconectar();
            } catch (SQLException e) {
                System.err.println("Error al cerrar recursos: " + e.getMessage());
            }
        }
        return exito;
    }


    public boolean eliminarPersona(int codigo) {
        String sql = "DELETE FROM persona WHERE codigo = ?";
        
        Conexion cn = new Conexion();
        Connection con = null;
        PreparedStatement ps = null;
        boolean exito = false;
        
        try {
            if (cn.conectar()) {
                con = cn.getConnection();
                ps = con.prepareStatement(sql);
                ps.setInt(1, codigo);
                
                int filasAfectadas = ps.executeUpdate();
                exito = filasAfectadas > 0;
                
                if (exito) {
                    System.out.println("Persona con código " + codigo + " eliminada exitosamente");
                } else {
                    System.out.println("No se encontró persona con código " + codigo);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al eliminar persona: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) ps.close();
                cn.desconectar();
            } catch (SQLException e) {
                System.err.println("Error al cerrar recursos: " + e.getMessage());
            }
        }
        return exito;
    }

    public PersonaVO obtenerPersonaPorCodigo(int codigo) {
        String sql = "SELECT * FROM persona WHERE codigo = ?";
        
        Conexion cn = new Conexion();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        PersonaVO persona = null;
        
        try {
            if (cn.conectar()) {
                con = cn.getConnection();
                ps = con.prepareStatement(sql);
                ps.setInt(1, codigo);
                rs = ps.executeQuery();
                
                if (rs.next()) {
                    persona = new PersonaVO(
                        rs.getInt("codigo"),
                        rs.getString("nombre"),
                        rs.getString("apellido")
                    );
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener persona: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                cn.desconectar();
            } catch (SQLException e) {
                System.err.println("Error al cerrar recursos: " + e.getMessage());
            }
        }
        return persona;
    }
}