package modelo.dao;

import modelo.conexion.Conexion;
import modelo.vo.AlumnoVO;
import modelo.vo.PersonaVO;
import modelo.vo.ProfesorVO;
import modelo.vo.EmpleadoVO;
//import modelo.vo.DisciplinaVO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonaDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public List<PersonaVO> listarPersonas(String tipo) {
        List<PersonaVO> lista = new ArrayList<>();
        String sql = "";

        if (tipo.equals("alumno")) {
            sql = "SELECT * FROM alumno";
        } else if (tipo.equals("profesor")) {
            sql = "SELECT * FROM profesor";
        } else if (tipo.equals("empleado")) {
            sql = "SELECT * FROM " + tipo;
        }

        try {
            if (cn.conectar()) {
                Connection acceBD = cn.getConnection();
                ps = acceBD.prepareStatement(sql);
                rs = ps.executeQuery();

                while (rs.next()) {
                    if (tipo.equals("alumno")) {
                        AlumnoVO alumno = new AlumnoVO(
                                rs.getInt("cedula"),
                                rs.getString("nombre"),
                                rs.getInt("telefono"),
                                rs.getInt("edad"),
                                rs.getString("calle"),
                                rs.getInt("nro"));
                        lista.add(alumno);
                    } else if (tipo.equals("profesor")) {
                        ProfesorVO profesor = new ProfesorVO(
                                rs.getInt("cedula"),
                                rs.getString("nombre"),
                                rs.getInt("telefono"),
                                rs.getString("especialidad"));
                        lista.add(profesor);
                    } else if (tipo.equals("empleado")) {
                        EmpleadoVO empleado = new EmpleadoVO(
                                rs.getInt("cedula"),
                                rs.getString("nombre"),
                                rs.getInt("telefono"),
                                rs.getString("categoria"),
                                rs.getDouble("sueldo"));
                        lista.add(empleado);
                    }
                }
                cn.desconectar();
            }
        } catch (SQLException e) {
            System.err.println("Error en listarPersonas: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error general en listarPersonas: " + e.getMessage());
        }
        return lista;
    }

    public PersonaVO obtenerPersona(int id, String tipo) {
        PersonaVO persona = null;
        String sql = "";

        if (tipo.equals("alumno")) {
            sql = "SELECT * FROM alumno WHERE cedula = ?";
        } else if (tipo.equals("profesor")) {
            sql = "SELECT * FROM profesor WHERE cedula = ?";
        } else if (tipo.equals("empleado")) {
            sql = "SELECT * FROM " + tipo + " WHERE ci = ?";
        }

        try {
            if (cn.conectar()) {
                Connection acceBD = cn.getConnection();
                ps = acceBD.prepareStatement(sql);
                ps.setInt(1, id);
                rs = ps.executeQuery();

                if (rs.next()) {
                    if (tipo.equals("alumno")) {
                        persona = new AlumnoVO(
                                rs.getInt("cedula"),
                                rs.getString("nombre"),
                                rs.getInt("telefono"),
                                rs.getInt("edad"),
                                rs.getString("calle"),
                                rs.getInt("nro"));
                    } else if (tipo.equals("profesor")) {
                        persona = new ProfesorVO(
                                rs.getInt("cedula"),
                                rs.getString("nombre"),
                                rs.getInt("telefono"),
                                rs.getString("especialidad"));
                    } else if (tipo.equals("profesor")) {
                        persona = new ProfesorVO(
                                rs.getInt("cedula"),
                                rs.getString("nombre"),
                                rs.getInt("telefono"),
                                rs.getString("especialidad"));
                    } else if (tipo.equals("empleado")) {
                        persona = new EmpleadoVO(
                                rs.getInt("cedula"),
                                rs.getString("nombre"),
                                rs.getInt("telefono"),
                                rs.getString("categoria"),
                                rs.getDouble("sueldo"));
                            }
                }
                cn.desconectar();
            }
        } catch (SQLException e) {
            System.err.println("Error en obtenerPersona: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error general en obtenerPersona: " + e.getMessage());
        }
        return persona;
    }

    public void agregarPersona(PersonaVO m, String tipo) {
        String sql = "";

        if (tipo.equals("alumno")) {
            sql = "insert into alumno ( ciA = ?, edad = ?, calle = ?, nro = ?";
        } else if (tipo.equals("profesor")) {
            sql = "insert into profesor (ciP = ?, especialidad = ?)";
        } else if (tipo.equals("empleado")) {
            sql = "insert into " + tipo + " (ci = ?, categoria = ?)";
        }
        try {
            if (cn.conectar()) {
                Connection acceBD = cn.getConnection();
                ps = acceBD.prepareStatement(sql);

                if (tipo.equals("alumno")) {
                    AlumnoVO alumno = (AlumnoVO) m;
                    sql = "insert into personas (ci, nombre, telefono) values (?, ?, ?)";
                    ps = acceBD.prepareStatement(sql);
                    ps.setInt(1, alumno.getCedula());
                    ps.setString(2, alumno.getNombre());
                    ps.setInt(3, alumno.getTelefono());
                    ps.executeUpdate();
                    sql = "insert into alumno (ciA, edad, calle, nro) values (?, ?, ?, ?)";
                    ps = acceBD.prepareStatement(sql);
                    ps.setInt(1, alumno.getCedula());
                    ps.setInt(2, alumno.getedad());
                    ps.setString(3, alumno.getcalle());
                    ps.setInt(4, alumno.getnro());
                    ps.executeUpdate();
                } else if (tipo.equals("profesor")) {
                    ProfesorVO profesor = (ProfesorVO) m;
                    sql = "insert into personas (ci, nombre, telefono) values (?, ?, ?)";
                    ps = acceBD.prepareStatement(sql);
                    ps.setInt(1, profesor.getCedula());
                    ps.setString(2, profesor.getNombre());
                    ps.setInt(3, profesor.getTelefono());
                    ps.executeUpdate();
                    sql = "insert into profesor (ciP, especialidad) values (?, ?)";
                    ps = acceBD.prepareStatement(sql);
                    ps.setInt(1, profesor.getCedula());
                    ps.setString(2, profesor.getespecialidad());

                    ps.executeUpdate();
                } else if (tipo.equals("empleado")) {
                    EmpleadoVO empleado = (EmpleadoVO) m;
                    sql = "insert into personas (ci, nombre, telefono) values (?, ?, ?)";
                    ps = acceBD.prepareStatement(sql);
                    ps.setInt(1, empleado.getCedula());
                    ps.setString(2, empleado.getNombre());
                    ps.setInt(3, empleado.getTelefono());
                    ps.executeUpdate();
                    sql = "insert into "+tipo+" (ci, categoria, sueldo) values (?, ?, ?)";
                    ps = acceBD.prepareStatement(sql);
                    ps.setInt(1, empleado.getCedula());
                    ps.setString(2, empleado.getCategoria());
                    ps.setDouble(3, empleado.getSueldo());

                    ps.executeUpdate();

                }
                cn.desconectar();
            }
        } catch (SQLException e) {
            System.err.println("Error en modificarPersona: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error general en modificarPersona: " + e.getMessage());
        }
    }

    public void modificarPersona(PersonaVO m, String tipo) {
        String sql = "";

        if (tipo.equals("alumno")) {
            sql = "UPDATE alumno SET edad = ?, calle = ?, nro = ? WHERE ciA = ?";
        } else if (tipo.equals("profesor")) {
            sql = "UPDATE profesor SET especialidad = ? WHERE ciP = ?";
        } else if (tipo.equals("empleado")) {
            sql = "UPDATE " + tipo + " SET categoria = ?, sueldo = ? WHERE ci = ?";
        }
        try {
            if (cn.conectar()) {
                Connection acceBD = cn.getConnection();
                ps = acceBD.prepareStatement(sql);

                if (tipo.equals("alumno")) {
                    AlumnoVO alumno = (AlumnoVO) m;
                    ps.setInt(1, alumno.getedad());
                    ps.setString(2, alumno.getcalle());
                    ps.setInt(3, alumno.getnro());
                    ps.setInt(4, alumno.getCedula());
                    ps.executeUpdate();
                    sql = "UPDATE personas SET nombre = ?, telefono = ? WHERE ci = ?";
                    ps = acceBD.prepareStatement(sql);
                    ps.setString(1, alumno.getNombre());
                    ps.setInt(2, alumno.getTelefono());
                    ps.setInt(3, alumno.getCedula());
                    ps.executeUpdate();

                } else if (tipo.equals("profesor")) {
                    ProfesorVO profesor = (ProfesorVO) m;
                    ps.setString(1, profesor.getespecialidad());
                    ps.setInt(2, profesor.getCedula());
                    ps.executeUpdate();
                    sql = "UPDATE personas SET nombre = ?, telefono = ? WHERE ci = ?";
                    ps = acceBD.prepareStatement(sql);
                    ps.setString(1, profesor.getNombre());
                    ps.setInt(2, profesor.getTelefono());
                    ps.setInt(3, profesor.getCedula());
                    ps.executeUpdate();

                } else if (tipo.equals("empleado")) {
                    EmpleadoVO empleado = (EmpleadoVO) m;
                    ps.setString(1, empleado.getCategoria());
                    ps.setInt(2, empleado.getCedula());
                    ps.executeUpdate();
                    sql = "UPDATE personas SET nombre = ?, telefono = ? WHERE ci = ?";
                    ps = acceBD.prepareStatement(sql);
                    ps.setString(1, empleado.getNombre());
                    ps.setInt(2, empleado.getTelefono());
                    ps.setInt(3, empleado.getCedula());
                    ps.executeUpdate();

                }
                cn.desconectar();
            }
        } catch (SQLException e) {
            System.err.println("Error en modificarPersona: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error general en modificarPersona: " + e.getMessage());
        }
    }

    public void eliminarPersona(int id, String tipo) {
        String sql = "";

        if (tipo.equals("alumno")) {
            sql = "DELETE FROM alumno WHERE ciA = ?";
        } else if (tipo.equals("profesor")) {
            sql = "DELETE FROM Profesor WHERE ciP = ?";
        } else if (tipo.equals("empleado")) {
            sql = "DELETE FROM" + tipo + "WHERE ci = ?";
        }

        try {
            if (cn.conectar()) {
                Connection acceBD = cn.getConnection();
                ps = acceBD.prepareStatement(sql);
                ps.setInt(1, id);
                sql = "DELETE FROM personas WHERE ci = ?";
                ps = acceBD.prepareStatement(sql);
                ps.setInt(1, id);
                ps.executeUpdate();
                cn.desconectar();
            }
        } catch (SQLException e) {
            System.err.println("Error en eliminarPersona: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error general en eliminarPersona: " + e.getMessage());
        }
    }
}
