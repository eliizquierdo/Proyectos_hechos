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

    /* public String insertar(PersonaVO p) {
        String sql = "INSERT INTO persona VALUES(?,?,?)";
        try (PreparedStatement ps = conexion.getConnection().prepareStatement(sql)) {
            ps.setInt(1, p.getCedula());
            ps.setString(2, p.getNombre());
            ps.setString(3, p.getApellido());
            int filas = ps.executeUpdate();
            return (filas > 0) ? "Registro exitoso" : "Fallo al registrar";
        } catch (SQLException e) {
            return e.getMessage();
        }
    }*/
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

            if (numFAfectas > 0)
                rptaRegistro = "Registro exitoso.";
            else
                rptaRegistro = "Fallo al registrar";
            
        } catch (SQLException e) {
            return e.getMessage();
        }
        return rptaRegistro;
    }

    public String actualizar(PersonaVO p) {
        String sql = "UPDATE persona SET nombre=?, apellido=? WHERE cedula=?";
        try (PreparedStatement ps = conexion.getConnection().prepareStatement(sql)) {
            ps.setString(1, p.getNombre());
            ps.setString(2, p.getApellido());
            ps.setInt(3, p.getCedula());
            int filas = ps.executeUpdate();
            return (filas > 0) ? "Actualización exitosa" : "No se encontró la persona";
        } catch (SQLException e) {
            return e.getMessage();
        }
    }

    public String eliminar(int cedula) {
        String sql = "DELETE FROM persona WHERE cedula=?";
        try (PreparedStatement ps = conexion.getConnection().prepareStatement(sql)) {
            ps.setInt(1, cedula);
            int filas = ps.executeUpdate();
            return (filas > 0) ? "Eliminación exitosa" : "No se encontró la persona";
        } catch (SQLException e) {
            return e.getMessage();
        }
    }

    public PersonaVO buscar(int cedula) {
        String sql = "SELECT * FROM persona WHERE cedula=?";
        try (PreparedStatement ps = conexion.getConnection().prepareStatement(sql)) {
            ps.setInt(1, cedula);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new PersonaVO(rs.getInt("cedula"), rs.getString("nombre"), rs.getString("apellido"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public ArrayList<PersonaVO> listar() {
        String sql = "SELECT * FROM persona";
        ArrayList<PersonaVO> lista = new ArrayList<>();
        try (PreparedStatement ps = conexion.getConnection().prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                lista.add(new PersonaVO(rs.getInt("cedula"), rs.getString("nombre"), rs.getString("apellido")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return lista;
    }
}
