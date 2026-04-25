package modelo.dao;

import modelo.conexion.Conexion;
import modelo.vo.EmpleadoVO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public List<EmpleadoVO> listarEmpleado() {
        List<EmpleadoVO> lista = new ArrayList<>();
        // 1. SELECT: Usamos 'empleados', 'categoria' y 'sueldo'
        String sql = "SELECT p.ci, p.nombre, p.telefono, a.categoria, a.sueldo " +
                "FROM personas p INNER JOIN empleados a ON p.ci = a.ciE";
        try {
            if (cn.conectar()) {
                con = cn.getConnection();
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    EmpleadoVO empleado = new EmpleadoVO(
                            rs.getInt("ci"),
                            rs.getString("nombre"),
                            rs.getInt("telefono"),
                            rs.getString("categoria"),
                            rs.getDouble("sueldo") // Usamos getDouble
                    );
                    lista.add(empleado);
                }
                cn.desconectar();
            }
        } catch (SQLException e) {
            System.out.println("Error al listar: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error general al listar: " + e.getMessage());
        }
        return lista;
    }

    public void agregarEmpleado(EmpleadoVO m) {
        String sql = "INSERT INTO personas(ci, nombre, telefono) VALUES (?, ?, ?)";
        // 2. INSERT: Usamos 'empleados', 'categoria' y 'sueldo'
        String sql2 = "INSERT INTO empleados(ciE, categoria, sueldo) VALUES(?,?,?)";

        try {
            if (cn.conectar()) {
                con = cn.getConnection();
                con.setAutoCommit(false); // Iniciar transacción

                // 1. Insertar en tabla personas
                ps = con.prepareStatement(sql);
                ps.setInt(1, m.getCedula());
                ps.setString(2, m.getNombre());
                ps.setInt(3, m.getTelefono());
                ps.executeUpdate();

                // 2. Insertar en tabla empleados
                ps = con.prepareStatement(sql2);
                ps.setInt(1, m.getCedula());
                ps.setString(2, m.getCategoria());
                ps.setDouble(3, m.getSueldo()); // Usamos setDouble
                ps.executeUpdate();

                con.commit(); // Confirmar transacción
                cn.desconectar();
            }
        } catch (SQLException e) {
            System.out.println("Error al agregar: " + e.getMessage());
            try {
                con.rollback(); // Deshacer si hay error
            } catch (SQLException ex) {
                System.out.println("Error en rollback: " + ex.getMessage());
            }
        }
    }

    // Método para eliminar (depende de PersonaDAO para eliminar la persona,
    // pero si usaste ON DELETE CASCADE en el script, solo necesitas eliminar la
    // persona)
    // Dejamos este método para eliminar directamente la fila de empleado y luego la
    // de persona (si no se usa CASCADE)
    public void eliminarEmpleado(int cedula) {
        // En tu script SQL tienes ON DELETE CASCADE, lo que significa que al eliminar
        // de 'personas'
        // automáticamente se elimina de 'empleados'. Pero para ser seguro, podemos
        // hacerlo en el DAO.
        String sql = "DELETE FROM empleados WHERE ciE = ?";
        String sql2 = "DELETE FROM personas WHERE ci = ?";
        try {
            if (cn.conectar()) {
                con = cn.getConnection();
                con.setAutoCommit(false);

                // 1. Eliminar de tabla empleados
                ps = con.prepareStatement(sql);
                ps.setInt(1, cedula);
                ps.executeUpdate();

                // 2. Eliminar de tabla personas
                ps = con.prepareStatement(sql2);
                ps.setInt(1, cedula);
                ps.executeUpdate();

                con.commit();
                cn.desconectar();
            }
        } catch (SQLException e) {
            System.out.println("Error al eliminar: " + e.getMessage());
            try {
                con.rollback();
            } catch (SQLException ex) {
                System.out.println("Error en rollback al eliminar: " + ex.getMessage());
            }
        }
    }

    public void modificarEmpleado(EmpleadoVO e) {
        String sql = "UPDATE personas SET nombre = ?, telefono = ? WHERE ci = ?";
        // 3. UPDATE: Usamos 'empleados', 'categoria' y 'sueldo'
        String sql2 = "UPDATE empleados SET categoria = ?, sueldo = ? WHERE ciE = ?";

        try {
            if (cn.conectar()) {
                con = cn.getConnection();
                con.setAutoCommit(false); // Iniciar transacción

                // 1. Actualizar tabla personas
                ps = con.prepareStatement(sql);
                ps.setString(1, e.getNombre());
                ps.setInt(2, e.getTelefono());
                ps.setInt(3, e.getCedula());
                ps.executeUpdate();

                // 2. Actualizar tabla empleados
                ps = con.prepareStatement(sql2);
                ps.setString(1, e.getCategoria());
                ps.setDouble(2, e.getSueldo()); // Usamos setDouble
                ps.setInt(3, e.getCedula());
                ps.executeUpdate();

                con.commit(); // Confirmar transacción
                cn.desconectar();
            }
        } catch (SQLException ex) {
            System.out.println("Error al modificar: " + ex.getMessage());
            try {
                con.rollback(); // Deshacer si hay error
            } catch (SQLException ex2) {
                System.out.println("Error en rollback al modificar: " + ex2.getMessage());
            }
        }
    }

    public EmpleadoVO obtenerEmpleado(int cedula) {
        EmpleadoVO empleado = null;
        // 4. SELECT: Usamos 'empleados', 'categoria' y 'sueldo'
        String sql = "SELECT p.ci, p.nombre, p.telefono, a.categoria, a.sueldo " +
                "FROM personas p INNER JOIN empleados a ON p.ci = a.ciE WHERE p.ci = ?";

        try {
            if (cn.conectar()) {
                con = cn.getConnection();
                ps = con.prepareStatement(sql);
                ps.setInt(1, cedula);
                rs = ps.executeQuery();

                if (rs.next()) {
                    empleado = new EmpleadoVO(
                            rs.getInt("ci"),
                            rs.getString("nombre"),
                            rs.getInt("telefono"),
                            rs.getString("categoria"),
                            rs.getDouble("sueldo")); // Usamos getDouble
                }
                cn.desconectar();
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener: " + e.getMessage());
        }
        return empleado;
    }
}