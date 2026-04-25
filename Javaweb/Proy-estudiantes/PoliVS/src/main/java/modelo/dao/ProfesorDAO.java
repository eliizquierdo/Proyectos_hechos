package modelo.dao;

import modelo.conexion.Conexion;
import modelo.vo.ProfesorVO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProfesorDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    // --- C R U D ---

    public List<ProfesorVO> listarProfesor() {
        List<ProfesorVO> lista = new ArrayList<>();
        // Uso de JOIN para listar toda la información
        String sql = "SELECT p.ci, p.nombre, p.telefono, pr.especialidad " +
                "FROM personas p INNER JOIN profesor pr ON p.ci = pr.ciP";
        try {
            if (cn.conectar()) {
                con = cn.getConnection();
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    ProfesorVO profesor = new ProfesorVO(
                            rs.getInt("ci"),
                            rs.getString("nombre"),
                            rs.getInt("telefono"),
                            rs.getString("especialidad"));
                    lista.add(profesor);
                }
                cn.desconectar();
            }
        } catch (SQLException e) {
            System.out.println("Error al listar Profesor: " + e.getMessage());
        }
        return lista;
    }

    public ProfesorVO obtenerProfesor(int cedula) {
        ProfesorVO profesor = null;
        // Uso de JOIN para obtener toda la información de una vez
        String sql = "SELECT p.ci, p.nombre, p.telefono, pr.especialidad " +
                "FROM personas p INNER JOIN profesor pr ON p.ci = pr.ciP WHERE p.ci = ?";
        try {
            if (cn.conectar()) {
                con = cn.getConnection();
                ps = con.prepareStatement(sql);
                ps.setInt(1, cedula);
                rs = ps.executeQuery();

                if (rs.next()) {
                    profesor = new ProfesorVO(
                            rs.getInt("ci"),
                            rs.getString("nombre"),
                            rs.getInt("telefono"),
                            rs.getString("especialidad"));
                }
                cn.desconectar();
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener Profesor: " + e.getMessage());
        }
        return profesor;
    }

    // Método que maneja la inserción en DOS TABLAS con TRANSACCIÓN
    public void agregarProfesor(ProfesorVO m) {
        String sql1 = "INSERT INTO personas(ci, nombre, telefono) VALUES (?, ?, ?)";
        String sql2 = "INSERT INTO profesor(ciP, especialidad) VALUES(?,?)";

        try {
            if (cn.conectar()) {
                con = cn.getConnection();
                con.setAutoCommit(false); // 1. Iniciar transacción

                // 2. Insertar en tabla personas
                ps = con.prepareStatement(sql1);
                ps.setInt(1, m.getCedula());
                ps.setString(2, m.getNombre());
                ps.setInt(3, m.getTelefono());
                ps.executeUpdate();

                // 3. Insertar en tabla profesor
                ps = con.prepareStatement(sql2);
                ps.setInt(1, m.getCedula());
                ps.setString(2, m.getEspecialidad());
                ps.executeUpdate();

                con.commit(); // 4. Confirmar transacción
                cn.desconectar();
            }
        } catch (SQLException e) {
            System.out.println("Error al agregar Profesor: " + e.getMessage());
            try {
                con.rollback(); // Deshacer si hay error
            } catch (SQLException ex) {
                System.out.println("Error en rollback: " + ex.getMessage());
            }
        }
    }

    // Método que maneja la eliminación en DOS TABLAS con TRANSACCIÓN
    public void eliminarProfesor(int cedula) {
        // Se asume que no tiene ON DELETE CASCADE, por lo que borramos de la sub-tabla
        // primero.
        String sql1 = "DELETE FROM profesor WHERE ciP = ?";
        String sql2 = "DELETE FROM personas WHERE ci = ?";

        try {
            if (cn.conectar()) {
                con = cn.getConnection();
                con.setAutoCommit(false); // 1. Iniciar transacción

                // 2. Eliminar de tabla profesor
                ps = con.prepareStatement(sql1);
                ps.setInt(1, cedula);
                ps.executeUpdate();

                // 3. Eliminar de tabla personas
                ps = con.prepareStatement(sql2);
                ps.setInt(1, cedula);
                ps.executeUpdate();

                con.commit(); // 4. Confirmar transacción
                cn.desconectar();
            }
        } catch (SQLException e) {
            System.out.println("Error al eliminar Profesor: " + e.getMessage());
            try {
                con.rollback(); // Deshacer si hay error
            } catch (SQLException ex) {
                System.out.println("Error en rollback al eliminar: " + ex.getMessage());
            }
        }
    }

    // Método que maneja la modificación en DOS TABLAS con TRANSACCIÓN
    public void modificarProfesor(ProfesorVO e) {
        String sql1 = "UPDATE personas SET nombre = ?, telefono = ? WHERE ci = ?";
        String sql2 = "UPDATE profesor SET especialidad = ? WHERE ciP = ?";

        try {
            if (cn.conectar()) {
                con = cn.getConnection();
                con.setAutoCommit(false); // 1. Iniciar transacción

                // 2. Actualizar tabla personas (nombre y telefono)
                ps = con.prepareStatement(sql1);
                ps.setString(1, e.getNombre());
                ps.setInt(2, e.getTelefono());
                ps.setInt(3, e.getCedula());
                ps.executeUpdate();

                // 3. Actualizar tabla profesor (especialidad)
                ps = con.prepareStatement(sql2);
                ps.setString(1, e.getEspecialidad());
                ps.setInt(2, e.getCedula());
                ps.executeUpdate();

                con.commit(); // 4. Confirmar transacción
                cn.desconectar();
            }
        } catch (SQLException ex) {
            System.out.println("Error al modificar Profesor: " + ex.getMessage());
            try {
                con.rollback(); // Deshacer si hay error
            } catch (SQLException ex2) {
                System.out.println("Error en rollback al modificar: " + ex2.getMessage());
            }
        }
    }
}