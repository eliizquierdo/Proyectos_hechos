package modelo.dao;

import modelo.conexion.Conexion;
//import modelo.vo.AlumnoVO;
import modelo.vo.DisciplinaVO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class DisciplinaDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public List<DisciplinaVO> listarDisciplina(){
        List<DisciplinaVO> lista = new ArrayList<>();
        String sql = "SELECT * FROM disciplina";
        try{
            if(cn.conectar()){
                Connection acceBD = cn.getConnection();
                PreparedStatement ps = acceBD.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    DisciplinaVO Disciplina = new DisciplinaVO(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getInt("cupo"));
                    lista.add(Disciplina);
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

    //METODO PARA TRAER A UN SOLO Disciplina EN BASE A SU ID, DEBE LLAMARSE obtenerDisciplina()
    public void agregarDisciplina(DisciplinaVO m) {
        String sql= "INSERT INTO disciplina(id, nombre, cupo) VALUES (?, ?, ?)";
        try{
            if(cn.conectar()){
                Connection acceDB = cn.getConnection();
                PreparedStatement ps = acceDB.prepareStatement(sql);

                ps.setInt(1, m.getid());
                ps.setString(2, m.getnombre());
                ps.setInt(3,m.getcupo());

                ps.executeUpdate();
                cn.desconectar();
            }
        } catch (SQLException e) {
            e.getMessage();
        } catch (Exception e) {
            e.getMessage();
        }
        
    }

    public void eliminarDisciplina(int id) {
        String sql = "DELETE FROM Disciplina WHERE id = ?";
        try {
            if (cn.conectar()) {
                Connection acceDB = cn.getConnection();
                PreparedStatement ps = acceDB.prepareStatement(sql);

                ps.setInt(1, id);

                ps.executeUpdate();

                cn.desconectar();
            }
        } catch (SQLException e) {
            e.getMessage();
        } catch (Exception e) {
            e.getMessage();
        }
    }

     public void modificarDisciplina(DisciplinaVO g) {
        String sql = "UPDATE Disciplina SET nombre = ?, cupo = ? WHERE id = ?";
        try {
            if(cn.conectar()){
                Connection acceBD = cn.getConnection();
                PreparedStatement ps = acceBD.prepareStatement(sql);

                ps.setString(1, g.getnombre());
                ps.setInt(2, g.getcupo());
                ps.setInt(3, g.getid());

                ps.executeUpdate();

                cn.desconectar();
            }
        } catch (SQLException e) {
            e.getMessage();
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public DisciplinaVO obtenerDisciplina(int id) {
    DisciplinaVO disciplina = null;
    String sql = "SELECT * FROM disciplina WHERE id = ?";
    try {
        if (cn.conectar()) {
            Connection acceBD = cn.getConnection();
            PreparedStatement ps = acceBD.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                disciplina = new DisciplinaVO(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getInt("cupo")
                );
            }
            cn.desconectar();
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return disciplina;
    }
/*
    public void mostrarAsistencias(){
        String sql = "SELECT disciplina INNER JOIN personas ON disciplina.id = personas.ci";
        try {
            if(cn.conectar()){
                Connection acceBD = cn.getConnection();
                PreparedStatement ps = acceBD.prepareStatement(sql);

                ?

                ps.executeUpdate();

                cn.desconectar();
            }
        } catch (SQLException e) {
            e.getMessage();
        } catch (Exception e) {
            e.getMessage();
        }
    }*/
}