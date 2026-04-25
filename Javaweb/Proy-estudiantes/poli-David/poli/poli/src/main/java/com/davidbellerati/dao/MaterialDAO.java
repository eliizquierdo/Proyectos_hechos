package com.davidbellerati.dao;

import com.davidbellerati.interfaces.GenericDAO;
import com.davidbellerati.util.MySQLAdapter;
import com.davidbellerati.vo.MaterialVO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MaterialDAO implements GenericDAO<MaterialVO> {

    @Override
    public List<MaterialVO> getAll() {
        List<MaterialVO> list = new ArrayList<>();
        String sql = "SELECT id, name, amount FROM MATERIAL";

        try (Connection c = MySQLAdapter.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                MaterialVO m = new MaterialVO();
                m.setId(rs.getInt("id"));
                m.setName(rs.getString("name"));
                m.setAmount(rs.getInt("amount"));
                list.add(m);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public MaterialVO getFromId(int id) {
        String sql = "SELECT id, name, amount FROM MATERIAL WHERE id=?";
        try (Connection c = MySQLAdapter.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    MaterialVO m = new MaterialVO();
                    m.setId(rs.getInt("id"));
                    m.setName(rs.getString("name"));
                    m.setAmount(rs.getInt("amount"));
                    return m;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void add(MaterialVO material) {
        String sql = "INSERT INTO MATERIAL (name, amount) VALUES (?, ?)";
        try (Connection c = MySQLAdapter.getConnection();
             PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, material.getName());
            ps.setInt(2, material.getAmount());
            ps.executeUpdate();

            try (ResultSet keys = ps.getGeneratedKeys()) {
                if (keys.next()) material.setId(keys.getInt(1));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(MaterialVO material) {
        String sql = "UPDATE MATERIAL SET name=?, amount=? WHERE id=?";
        try (Connection c = MySQLAdapter.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setString(1, material.getName());
            ps.setInt(2, material.getAmount());
            ps.setInt(3, material.getId());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void remove(MaterialVO material) {
        String sql = "DELETE FROM MATERIAL WHERE id=?";
        try (Connection c = MySQLAdapter.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setInt(1, material.getId());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
