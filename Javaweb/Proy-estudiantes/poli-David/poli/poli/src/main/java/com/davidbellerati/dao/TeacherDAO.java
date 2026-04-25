package com.davidbellerati.dao;

import com.davidbellerati.interfaces.GenericDAO;
import com.davidbellerati.util.MySQLAdapter;
import com.davidbellerati.vo.TeacherVO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TeacherDAO implements GenericDAO<TeacherVO> {

    @Override
    public List<TeacherVO> getAll() {
        List<TeacherVO> list = new ArrayList<>();
            String sql = "SELECT H.id, H.name, H.ci, H.dateOfBirth, H.phoneNumber, H.homeAddress, H.emergencyService, T.salary " +
             "FROM HUMAN H " +
             "LEFT JOIN TEACHER T ON H.id = T.id " +
             "WHERE T.salary IS NOT NULL";


        try (Connection c = MySQLAdapter.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(mapTeacher(rs));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public TeacherVO getFromId(int id) {
        String sql = "SELECT H.id, H.name, H.ci, H.dateOfBirth, H.phoneNumber, H.homeAddress, H.emergencyService, T.salary " +
                     "FROM HUMAN H " +
                     "JOIN TEACHER T ON H.id = T.id " +
                     "WHERE H.id = ?";

        try (Connection c = MySQLAdapter.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) return mapTeacher(rs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void add(TeacherVO teacher) {
        String sqlHuman = "INSERT INTO HUMAN (ci, name, dateOfBirth, phoneNumber, homeAddress, emergencyService) " +
                          "VALUES (?, ?, ?, ?, ?, ?)";
        String sqlTeacher = "INSERT INTO TEACHER (id, salary) VALUES (?, ?)";

        try (Connection c = MySQLAdapter.getConnection()) {
            c.setAutoCommit(false);

            try (PreparedStatement psHuman = c.prepareStatement(sqlHuman, Statement.RETURN_GENERATED_KEYS)) {
                psHuman.setInt(1, teacher.getCI());
                psHuman.setString(2, teacher.getName());
                psHuman.setDate(3, Date.valueOf(teacher.getDateOfBirth()));
                psHuman.setInt(4, teacher.getPhoneNumber());
                psHuman.setString(5, teacher.getHomeAddress());
                psHuman.setString(6, teacher.getEmergencyService());
                psHuman.executeUpdate();

                try (ResultSet keys = psHuman.getGeneratedKeys()) {
                    if (keys.next()) teacher.setId(keys.getInt(1));
                }
            }

            try (PreparedStatement psTeacher = c.prepareStatement(sqlTeacher)) {
                psTeacher.setInt(1, teacher.getId());
                psTeacher.setFloat(2, teacher.getSalary());
                psTeacher.executeUpdate();
            }

            c.commit();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(TeacherVO teacher) {
        String sqlHuman = "UPDATE HUMAN SET ci=?, name=?, dateOfBirth=?, phoneNumber=?, homeAddress=?, emergencyService=? " +
                          "WHERE id=?";
        String sqlTeacher = "UPDATE TEACHER SET salary=? WHERE id=?";

        try (Connection c = MySQLAdapter.getConnection()) {
            c.setAutoCommit(false);

            try (PreparedStatement psHuman = c.prepareStatement(sqlHuman)) {
                psHuman.setInt(1, teacher.getCI());
                psHuman.setString(2, teacher.getName());
                psHuman.setDate(3, Date.valueOf(teacher.getDateOfBirth()));
                psHuman.setInt(4, teacher.getPhoneNumber());
                psHuman.setString(5, teacher.getHomeAddress());
                psHuman.setString(6, teacher.getEmergencyService());
                psHuman.setInt(7, teacher.getId());
                psHuman.executeUpdate();
            }

            try (PreparedStatement psTeacher = c.prepareStatement(sqlTeacher)) {
                psTeacher.setFloat(1, teacher.getSalary());
                psTeacher.setInt(2, teacher.getId());
                psTeacher.executeUpdate();
            }

            c.commit();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void remove(TeacherVO teacher) {
        String sqlTeacher = "DELETE FROM TEACHER WHERE id=?";
        String sqlHuman = "DELETE FROM HUMAN WHERE id=?";

        try (Connection c = MySQLAdapter.getConnection()) {
            c.setAutoCommit(false);

            try (PreparedStatement psTeacher = c.prepareStatement(sqlTeacher)) {
                psTeacher.setInt(1, teacher.getId());
                psTeacher.executeUpdate();
            }

            try (PreparedStatement psHuman = c.prepareStatement(sqlHuman)) {
                psHuman.setInt(1, teacher.getId());
                psHuman.executeUpdate();
            }

            c.commit();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public TeacherVO getByCI(int ci) {
        String sql = "SELECT T.id, H.name, H.ci, H.dateOfBirth, H.phoneNumber, H.homeAddress, H.emergencyService, T.salary " +
                     "FROM TEACHER T " +
                     "JOIN HUMAN H ON T.id = H.id " +
                     "WHERE H.ci = ?";

        try (Connection c = MySQLAdapter.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setInt(1, ci);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) return mapTeacher(rs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public Integer getIdByCI(int ci) {
        TeacherVO t = getByCI(ci);
        return t != null ? t.getId() : null;
    }

    private TeacherVO mapTeacher(ResultSet rs) throws SQLException {
        TeacherVO t = new TeacherVO();
        t.setId(rs.getInt("id"));
        t.setName(rs.getString("name"));
        t.setCI(rs.getInt("ci"));
        Date dob = rs.getDate("dateOfBirth");
        if (dob != null) t.setDateOfBirth(dob.toLocalDate());
        t.setPhoneNumber(rs.getInt("phoneNumber"));
        t.setHomeAddress(rs.getString("homeAddress"));
        t.setEmergencyService(rs.getString("emergencyService"));
        t.setSalary(rs.getFloat("salary"));
        return t;
    }
}
