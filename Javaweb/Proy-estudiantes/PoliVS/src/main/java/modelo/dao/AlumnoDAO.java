package modelo.dao;

import modelo.conexion.Conexion;
import modelo.vo.AlumnoVO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlumnoDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    // --- C R U D ---

    public List<AlumnoVO> listarAlumno() {
        List<AlumnoVO> lista = new ArrayList<>();
        // Uso de JOIN para listar toda la información de personas y alumnos
        String sql = "SELECT p.ci, p.nombre, p.telefono, a.edad, a.calle, a.nro " +
                "FROM personas p INNER JOIN alumno a ON p.ci = a.ciA";
        try {
            if (cn.conectar()) {
                con = cn.getConnection();
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    AlumnoVO alumno = new AlumnoVO(
                            rs.getInt("ci"),
                            rs.getString("nombre"),
                            rs.getInt("telefono"),
                            rs.getInt("edad"),
                            rs.getString("calle"),
                            rs.getInt("nro"));
                    lista.add(alumno);
                }
                cn.desconectar();
            }
        } catch (SQLException e) {
            System.out.println("Error al listar Alumno: " + e.getMessage());
        }
        return lista;
    }

    public AlumnoVO obtenerAlumno(int cedula) {
        AlumnoVO alumno = null;
        // MEJORA: Usamos JOIN para traer todos los datos en una sola consulta
        String sql = "SELECT p.ci, p.nombre, p.telefono, a.edad, a.calle, a.nro " +
                "FROM personas p INNER JOIN alumno a ON p.ci = a.ciA WHERE p.ci = ?";
        try {
            if (cn.conectar()) {
                con = cn.getConnection();
                ps = con.prepareStatement(sql);
                ps.setInt(1, cedula);
                rs = ps.executeQuery();

                if (rs.next()) {
                    alumno = new AlumnoVO(
                            rs.getInt("ci"),
                            rs.getString("nombre"),
                            rs.getInt("telefono"),
                            rs.getInt("edad"),
                            rs.getString("calle"),
                            rs.getInt("nro"));
                }
                cn.desconectar();
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener Alumno: " + e.getMessage());
        }
        return alumno;
    }

    // Método que maneja la inserción en DOS TABLAS con TRANSACCIÓN
    public void agregarAlumno(AlumnoVO m) {
        String sql1 = "INSERT INTO personas(ci, nombre, telefono) VALUES (?, ?, ?)";
        String sql2 = "INSERT INTO alumno(ciA, edad, calle, nro) VALUES (?, ?, ?, ?)";

        try {
            if (cn.conectar()) {
                con = cn.getConnection();
                con.setAutoCommit(false); // 1. Iniciar transacción

                // 2. Insertar en tabla personas (datos de la superclase)
                ps = con.prepareStatement(sql1);
                ps.setInt(1, m.getCedula());
                ps.setString(2, m.getNombre());
                ps.setInt(3, m.getTelefono());
                ps.executeUpdate();

                // 3. Insertar en tabla alumno (datos específicos)
                ps = con.prepareStatement(sql2);
                ps.setInt(1, m.getCedula());
                ps.setInt(2, m.getEdad());
                ps.setString(3, m.getCalle());
                ps.setInt(4, m.getNro());
                ps.executeUpdate();

                con.commit(); // 4. Confirmar transacción
                cn.desconectar();
            }
        } catch (SQLException e) {
            System.out.println("Error al agregar Alumno: " + e.getMessage());
            try {
                con.rollback(); // Deshacer si hay error
            } catch (SQLException ex) {
                System.out.println("Error en rollback: " + ex.getMessage());
            }
        }
    }

    // Método que maneja la eliminación en DOS TABLAS con TRANSACCIÓN
    public void eliminarAlumno(int cedula) {
        // Debemos eliminar el registro de la sub-tabla primero
        String sql1 = "DELETE FROM alumno WHERE ciA = ?";
        String sql2 = "DELETE FROM personas WHERE ci = ?";

        try {
            if (cn.conectar()) {
                con = cn.getConnection();
                con.setAutoCommit(false); // 1. Iniciar transacción

                // 2. Eliminar de tabla alumno
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
            System.out.println("Error al eliminar Alumno: " + e.getMessage());
            try {
                con.rollback(); // Deshacer si hay error
            } catch (SQLException ex) {
                System.out.println("Error en rollback al eliminar: " + ex.getMessage());
            }
        }
    }

    // Método que maneja la modificación en DOS TABLAS con TRANSACCIÓN
    public void modificarAlumno(AlumnoVO e) {
        String sql1 = "UPDATE personas SET nombre = ?, telefono = ? WHERE ci = ?";
        String sql2 = "UPDATE alumno SET edad = ?, calle = ?, nro = ? WHERE ciA = ?";

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

                // 3. Actualizar tabla alumno (edad, calle y nro)
                ps = con.prepareStatement(sql2);
                ps.setInt(1, e.getEdad());
                ps.setString(2, e.getCalle());
                ps.setInt(3, e.getNro());
                ps.setInt(4, e.getCedula());
                ps.executeUpdate();

                con.commit(); // 4. Confirmar transacción
                cn.desconectar();
            }
        } catch (SQLException ex) {
            System.out.println("Error al modificar Alumno: " + ex.getMessage());
            try {
                con.rollback(); // Deshacer si hay error
            } catch (SQLException ex2) {
                System.out.println("Error en rollback al modificar: " + ex2.getMessage());
            }
        }
    }
}