package modelo.dao;

import modelo.conexion.Conexion;
import modelo.vo.MagoVO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MagoDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public List<MagoVO> listarMagos() {
        List<MagoVO> lista = new ArrayList<>();
        String sql = "SELECT * FROM mago";
        try {
            if (cn.conectar()) {
                con = cn.getConnection();
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    MagoVO m = new MagoVO(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getInt("poder"),
                        rs.getInt("nivel")
                    );
                    lista.add(m);
                }
                cn.desconectar();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    public void agregarMago(MagoVO m) {
        String sql = "INSERT INTO mago(nombre, poder, nivel) VALUES(?,?,?)";
        try {
            if(cn.conectar()){
                Connection acceDB = cn.getConnection();
                PreparedStatement ps = acceDB.prepareStatement(sql);

                ps.setString(1, m.getNombre());
                ps.setInt(2, m.getPoder());
                ps.setInt(3, m.getNivel());

                ps.executeUpdate();

                cn.desconectar();
            }
        }
        catch(SQLException e){
            e.getMessage();
        }
         catch (Exception e) {
            e.getMessage();
        }
    }
}
