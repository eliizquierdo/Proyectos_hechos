package modelo.dao;

import modelo.conexion.Conexion;
import modelo.vo.GuerreroVO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GuerreroDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public List<GuerreroVO> listarGuerreros() {
        List<GuerreroVO> lista = new ArrayList<>();
        String sql = "SELECT * FROM guerrero";
        try {
            if (cn.conectar()) {
                con = cn.getConnection();
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    GuerreroVO g = new GuerreroVO(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getInt("fuerza"),
                        rs.getInt("nivel")
                    );
                    lista.add(g);
                }
                cn.desconectar();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    public void agregarGuerrero(GuerreroVO g) {
        String sql = "INSERT INTO guerrero(nombre, fuerza, nivel) VALUES (?,?,?)";
        try {
            if (cn.conectar()) {
                Connection acceDB = cn.getConnection();
                PreparedStatement ps = acceDB.prepareStatement(sql);

                ps.setString(1, g.getNombre());
                ps.setInt(2, g.getFuerza());
                ps.setInt(3, g.getNivel());

                ps.executeUpdate();

                cn.desconectar();
            }
        } catch (SQLException e) {
            e.getMessage();
        } catch (Exception e) {
            e.getMessage();
        }
    }
}
