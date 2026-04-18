package modelo.dao;

import modelo.vo.PersonaVO;
import modelo.conexion.Conexion;
import java.sql.*;

import java.util.ArrayList;

public class PersonaDAO {

    private final Conexion conexion;

    public PersonaDAO() {
        conexion = new Conexion();
    }

    public String insertarPersona(PersonaVO per) {
        String rptaRegistro;
        int numFAfectas;
        String sql = "INSERT INTO persona VALUES(?,?,?) ";

        try {
            Connection acceDB = conexion.getConnection();
            PreparedStatement ps = acceDB.prepareStatement(sql);

            ps.setInt(1, per.getCedula());
            ps.setString(2, per.getNombre());
            ps.setString(3, per.getApellido());

            numFAfectas = ps.executeUpdate();

            if (numFAfectas > 0) {
                rptaRegistro = "Registro exitoso.";
            } else {
                rptaRegistro = "Fallo al registrar";
            }

        } catch (SQLException e) {
            return e.getMessage();
        }
        return rptaRegistro;
    }

    public String eliminarPersona(int cedula) {
        String rptaRegistro;
        int numFAfectas;
        String sql = "DELETE FROM persona WHERE cedula=?";
        try {
            Connection acceDB = conexion.getConnection();
            PreparedStatement ps = acceDB.prepareStatement(sql);
            ps.setInt(1, cedula);
            numFAfectas = ps.executeUpdate();
            if (numFAfectas > 0) {
                rptaRegistro = "Eliminación exitosa";
            } else {
                rptaRegistro = "No se encontró la persona";
            }
        } catch (SQLException e) {
            return e.getMessage();
        }
        return rptaRegistro;
    }
    
    public String actualizarPersona(PersonaVO p) {
        String rptaRegistro;
        int numFAfectas;
        String sql = "UPDATE persona SET nombre=?, apellido=? WHERE cedula=?";
        try {
            Connection acceDB = conexion.getConnection();
            PreparedStatement ps = acceDB.prepareStatement(sql);
            ps.setString(1, p.getNombre());
            ps.setString(2, p.getApellido());
            ps.setInt(3, p.getCedula());
            numFAfectas = ps.executeUpdate();
            if (numFAfectas > 0) {
                rptaRegistro = "Actualización exitosa";
            } else {
                rptaRegistro = "No se actualizó la persona";
            }
        } catch (SQLException e) {
            return e.getMessage();
        }
        return rptaRegistro;
    }

    public ArrayList<PersonaVO> listar() {
        PersonaVO p;
        String sql = "SELECT * FROM persona";
        ArrayList<PersonaVO> lista = new ArrayList<>();
        try {
            Connection acceDB = conexion.getConnection();
            PreparedStatement ps = acceDB.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                p=new PersonaVO();
                p.setCedula(rs.getInt(1));
                p.setNombre(rs.getString(2));
                p.setApellido(rs.getString(3));
                lista.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return lista;
    }
    
    public PersonaVO buscarPersona(int cedula) {
        PersonaVO p=new PersonaVO();
        String sql = "SELECT * FROM persona WHERE cedula=?";
         try {
            Connection acceDB = conexion.getConnection();
            PreparedStatement ps = acceDB.prepareStatement(sql);
            ps.setInt(1, cedula);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                p.setCedula(rs.getInt(1));
                p.setNombre(rs.getString(2));
                p.setApellido(rs.getString(3));
                return p;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
