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

        public List<ProfesorVO> listarProfesor(){
        List<ProfesorVO> lista = new ArrayList<>();
        String sql = "SELECT p.ci, p.nombre, p.telefono, pr.especialidad FROM personas p INNER JOIN profesor pr ON p.ci = pr.ciP;";
        try{
            if(cn.conectar()){
                Connection acceBD = cn.getConnection();
                PreparedStatement ps = acceBD.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
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
            e.getMessage();
        } catch (Exception e) {
            e.getMessage();
        }
        return lista;
    }

    //METODO PARA TRAER A UN SOLO Profesor EN BASE A SU ID, DEBE LLAMARSE obtenerProfesor()
    public void agregarProfesor(ProfesorVO m) {
        String sql= "INSERT INTO personas(ci, nombre, telefono) VALUES (?,?,?)";
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
        sql= "INSERT INTO profesor(ciP, especialidad) VALUES (?,?)";
        try{
            if(cn.conectar()){
                Connection acceDB = cn.getConnection();
                PreparedStatement ps = acceDB.prepareStatement(sql);
                ps.setInt(1, m.getCedula());
                ps.setString(2, m.getespecialidad());
                ps.executeUpdate();
        
            }
        }catch(SQLException e){
            e.getMessage();
        }
    }

    public void eliminarProfesor(int cedula) {
        String sql = "DELETE FROM personas WHERE ci = ?";
        String sql2 = "DELETE FROM profesor WHERE ciP = ?";
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

     public void modificarProfesor(ProfesorVO g) {
        String sql = "UPDATE personas SET nombre = ?, telefono = ? WHERE ci = ?";
        String sql2 = "UPDATE profesor SET especialidad = ? WHERE ciP = ?"; //JOIN Personas per ON a.ciP = per.ci SET per.nombre = ?, per.telefono = ?, a.edad = ?,  a.calle = ?, a.nro = ?  WHERE a.ciA = ?;";
        try {
            if(cn.conectar()){
                Connection acceBD = cn.getConnection();
                PreparedStatement ps = acceBD.prepareStatement(sql);
                PreparedStatement ps2 = acceBD.prepareStatement(sql2);

                ps.setString(1, g.getNombre());
                ps.setInt(2, g.getTelefono());
                ps.setInt(3, g.getCedula());

                ps2.setString(1, g.getespecialidad());
                ps2.setInt(2, g.getCedula());
                
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

    public ProfesorVO obtenerProfesor(int cedula) {
    ProfesorVO profesor = null;
    String sql = "SELECT ci, nombre, telefono FROM personas WHERE ci = ?"; //p INNER JOIN Profesor pr ON p.ci = pr.ciP where p.ci=?;";
    String sql2 = "SELECT especialidad FROM profesor WHERE ciP = ?";
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
                profesor = new ProfesorVO(
                    rs.getInt("ci"),
                    rs.getString("nombre"),
                    rs.getInt("telefono"),
                    rs2.getString("especialidad")
                );
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return profesor;

    }
}