package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.conexion.Conexion;
import modelo.vo.ArqueroVO;

public class ArqueroDAO {
    
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public List<ArqueroVO> listarArquero(){
        List<ArqueroVO> lista = new ArrayList<>();
        String sql = "SELECT * FROM arquero";
        try {
            if (cn.conectar()) {
                con = cn.getConnection();
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    ArqueroVO a = new ArqueroVO(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getInt("cat_Flechas"),
                        rs.getInt("nivel")
                    );
                    lista.add(a);
                }
                cn.desconectar();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    public void agregarArquero(ArqueroVO a){

        String sql = "INSERT INTO arquero(nombre, cat_Flechas, nivel) VALUES(?,?,?)";

        try {
            
            if(cn.conectar()){
                Connection acceDB = cn.getConnection();
                PreparedStatement ps = acceDB.prepareStatement(sql);

                ps.setString(1, a.getNombre());
                ps.setInt(2, a.getCat_Flechas());
                ps.setInt(3, a.getNivel());

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
