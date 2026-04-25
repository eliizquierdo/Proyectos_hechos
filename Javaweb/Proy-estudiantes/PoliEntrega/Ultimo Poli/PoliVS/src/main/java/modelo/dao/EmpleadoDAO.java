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

    public List<EmpleadoVO> listarEmpleado(){
        List<EmpleadoVO> lista = new ArrayList<>();
        String sql = "SELECT p.ci, p.nombre, p.telefono, e.categoria, e.sueldo FROM personas p INNER JOIN empleado e ON p.ci = e.ci";
        try{
            if(cn.conectar()){
                Connection acceBD = cn.getConnection();
                PreparedStatement ps = acceBD.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    EmpleadoVO empleado = new EmpleadoVO(
                        rs.getInt("ci"),
                        rs.getString("nombre"),
                        rs.getInt("telefono"),
                        rs.getString("categoria"),
                        rs.getDouble("sueldo"));
                    lista.add(empleado);
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
}
