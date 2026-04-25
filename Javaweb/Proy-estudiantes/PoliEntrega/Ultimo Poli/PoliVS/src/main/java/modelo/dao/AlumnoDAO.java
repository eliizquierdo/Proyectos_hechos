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

    public List<AlumnoVO> listarAlumno(){
        List<AlumnoVO> lista = new ArrayList<>();
        String sql = "SELECT p.ci, p.nombre, p.telefono, a.edad, a.calle, a.nro FROM personas p INNER JOIN Alumno a ON p.ci = a.ciA;";
        try{
            if(cn.conectar()){
                Connection acceBD = cn.getConnection();
                PreparedStatement ps = acceBD.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    AlumnoVO Alumno = new AlumnoVO(
                        rs.getInt("ci"),
                        rs.getString("nombre"),
                        rs.getInt("telefono"),
                        rs.getInt("edad"),
                        rs.getString("calle"),
                        rs.getInt("nro"));
                    lista.add(Alumno);
                }
                cn.desconectar();
            }
        } catch (SQLException e) {
            e.getMessage();
        } catch (Exception e) {
            e.getMessage();
        }
        return lista;
    }

    //METODO PARA TRAER A UN SOLO Alumno EN BASE A SU ID, DEBE LLAMARSE obtenerAlumno()
    public void agregarAlumno(AlumnoVO m) {
        String sql = "INSERT INTO personas(ci, nombre, telefono) VALUES (?, ?, ?)";
        try{
            if(cn.conectar()){
                Connection acceDB = cn.getConnection();
                PreparedStatement ps = acceDB.prepareStatement(sql);
                ps.setInt(1, m.getCedula());
                ps.setString(2, m.getNombre());
                ps.setInt(3,m.getTelefono());
                ps.executeUpdate();
                cn.desconectar();
            }
        }catch(SQLException e){
            e.getMessage();
        }
        sql = "INSERT INTO Alumno(ciA, edad, calle, nro) VALUES (?,?,?,?)";
        try{
            if(cn.conectar()){
                Connection acceDB = cn.getConnection();
                PreparedStatement ps = acceDB.prepareStatement(sql);
                ps.setInt(1, m.getCedula());
                ps.setInt(2, m.getedad());
                ps.setString(3, m.getcalle());
                ps.setInt(4, m.getnro());
                ps.executeUpdate();
        
            }
        }catch(SQLException e){
            e.getMessage();
        }
    }

    public void eliminarAlumno(int cedula) {
        String sql = "DELETE FROM personas WHERE ci = ?";
        String sql2 = "DELETE FROM Alumno WHERE ciA = ?";
        try {
            if (cn.conectar()) {
                Connection acceDB = cn.getConnection();
                PreparedStatement ps = acceDB.prepareStatement(sql);
                PreparedStatement ps2 = acceDB.prepareStatement(sql2);

                ps.setInt(1, cedula);
                ps2.setInt(1, cedula);

                ps.executeUpdate();
                ps2.executeUpdate();

                cn.desconectar();
            }
        } catch (SQLException e) {
            e.getMessage();
        }
         catch (Exception e){
            e.getMessage();
        }
    }

     public void modificarAlumno(AlumnoVO g) {
        String sql = "UPDATE personas SET nombre = ?, telefono = ? WHERE ci = ?";
        String sql2 = "UPDATE Alumno SET edad = ?, calle = ?, nro = ? WHERE ciA = ?"; //JOIN Personas per ON a.ciP = per.ci SET per.nombre = ?, per.telefono = ?, a.edad = ?,  a.calle = ?, a.nro = ?  WHERE a.ciA = ?;";
        try {
            if(cn.conectar()){
                Connection acceBD = cn.getConnection();
                PreparedStatement ps = acceBD.prepareStatement(sql);
                PreparedStatement ps2 = acceBD.prepareStatement(sql2);

                ps.setString(1, g.getNombre());
                ps.setInt(2, g.getTelefono());
                ps.setInt(3, g.getCedula());

                ps2.setInt(1, g.getedad());
                ps2.setString(2, g.getcalle());
                ps2.setInt(3, g.getnro());
                ps2.setInt(4, g.getCedula());
                
                ps.executeUpdate();
                ps2.executeUpdate();

                cn.desconectar();

            }
        
        } catch (SQLException e) {
            e.getMessage();
        }
         catch (Exception e){
            e.getMessage();
        }
    }

    public AlumnoVO obtenerAlumno(int cedula) {
    AlumnoVO Alumno = null;
    String sql = "SELECT ci, nombre, telefono FROM personas WHERE ci = ?"; //p INNER JOIN Alumno a ON p.ci = a.ciA where p.ci=?;";
    String sql2 = "SELECT ciA, edad, calle, nro FROM alumno WHERE ciA = ?";
    try {
        if (cn.conectar()) {
            Connection acceBD = cn.getConnection();
            PreparedStatement ps = acceBD.prepareStatement(sql);
            PreparedStatement ps2 = acceBD.prepareStatement(sql2);
            ps.setInt(1, cedula);
            ps2.setInt(1, cedula);
            ResultSet rs = ps.executeQuery();
            ResultSet rs2 = ps2.executeQuery();
        
            if (rs.next() && rs2.next()) {
                Alumno = new AlumnoVO(
                    rs.getInt("ci"),
                    rs.getString("nombre"),
                    rs.getInt("telefono"),
                    rs2.getInt("edad"),
                    rs2.getString("calle"),
                    rs2.getInt("nro")
                );
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return Alumno;
    }
}

    
    
    





