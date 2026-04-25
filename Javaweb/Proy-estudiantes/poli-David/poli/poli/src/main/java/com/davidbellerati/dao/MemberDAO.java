package com.davidbellerati.dao;

import com.davidbellerati.interfaces.GenericDAO;
import com.davidbellerati.util.MySQLAdapter;
import com.davidbellerati.vo.MemberVO;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import com.davidbellerati.*;

public class MemberDAO implements GenericDAO<MemberVO> {

    @Override
    public List<MemberVO> getAll() {
        List<MemberVO> list = new ArrayList<>();
        String sql = "SELECT H.id, H.ci, H.dateOfBirth, H.phoneNumber, H.name, " +
                     "H.homeAddress, H.emergencyService " +
                     "FROM HUMAN H " +
                     "JOIN MEMBER M ON H.id = M.id";

        try (Connection c = MySQLAdapter.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(mapMember(rs));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public MemberVO getFromId(int id) {
        String sql = "SELECT H.id, H.ci, H.dateOfBirth, H.phoneNumber, H.name, " +
                     "H.homeAddress, H.emergencyService " +
                     "FROM HUMAN H " +
                     "JOIN MEMBER M ON H.id = M.id " +
                     "WHERE H.id = ?";

        try (Connection c = MySQLAdapter.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) return mapMember(rs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void add(MemberVO m) {
        String sqlHuman = "INSERT INTO HUMAN (ci, dateOfBirth, phoneNumber, name, homeAddress, emergencyService) " +
                          "VALUES (?, ?, ?, ?, ?, ?)";

        String sqlMember = "INSERT INTO MEMBER (id) VALUES (?)";

        try (Connection c = MySQLAdapter.getConnection()) {
            c.setAutoCommit(false);

            try (PreparedStatement psHuman = c.prepareStatement(sqlHuman, Statement.RETURN_GENERATED_KEYS)) {
                psHuman.setInt(1, m.getCI());
                psHuman.setDate(2, m.getDateOfBirth() != null ? Date.valueOf(m.getDateOfBirth()) : null);
                psHuman.setInt(3, m.getPhoneNumber());
                psHuman.setString(4, m.getName());
                psHuman.setString(5, m.getHomeAddress());
                psHuman.setString(6, m.getEmergencyService());
                psHuman.executeUpdate();

                try (ResultSet keys = psHuman.getGeneratedKeys()) {
                    if (keys.next()) m.setId(keys.getInt(1));
                }
            }

            try (PreparedStatement psMember = c.prepareStatement(sqlMember)) {
                psMember.setInt(1, m.getId());
                psMember.executeUpdate();
            }

            c.commit();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(MemberVO m) {
        String sql = "UPDATE HUMAN h " +
                     "JOIN MEMBER m ON h.id = m.id " +
                     "SET ci = ?, dateOfBirth = ?, phoneNumber = ?, name = ?, homeAddress = ?, emergencyService = ? " +
                     "WHERE h.id = ?";

        try (Connection c = MySQLAdapter.getConnection()) {
            c.setAutoCommit(false);

            try (PreparedStatement ps = c.prepareStatement(sql)) {
                ps.setInt(1, m.getCI());
                ps.setDate(2, m.getDateOfBirth() != null ? Date.valueOf(m.getDateOfBirth()) : null);
                ps.setInt(3, m.getPhoneNumber());
                ps.setString(4, m.getName());
                ps.setString(5, m.getHomeAddress());
                ps.setString(6, m.getEmergencyService());
                ps.setInt(7, m.getId());
                ps.executeUpdate();
            }

            c.commit();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void remove(MemberVO m) {
        String sqlMember = "DELETE FROM MEMBER WHERE id = ?";
        String sqlHuman = "DELETE FROM HUMAN WHERE id = ?";

        try (Connection c = MySQLAdapter.getConnection()) {
            c.setAutoCommit(false);

            try (PreparedStatement psMember = c.prepareStatement(sqlMember)) {
                psMember.setInt(1, m.getId());
                psMember.executeUpdate();
            }

            try (PreparedStatement psHuman = c.prepareStatement(sqlHuman)) {
                psHuman.setInt(1, m.getId());
                psHuman.executeUpdate();
            }

            c.commit();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Integer getIdByCI(int ci) {
        String sql = "SELECT m.id FROM MEMBER m " +
                     "JOIN HUMAN h ON m.id = h.id " +
                     "WHERE h.ci = ?";

        try (Connection c = MySQLAdapter.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setInt(1, ci);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) return rs.getInt("id");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private MemberVO mapMember(ResultSet rs) throws SQLException {
        MemberVO m = new MemberVO();
        m.setId(rs.getInt("id"));
        m.setCI(rs.getInt("ci"));

        Date dob = rs.getDate("dateOfBirth");
        m.setDateOfBirth(dob != null ? dob.toLocalDate() : null);

        m.setPhoneNumber(rs.getInt("phoneNumber"));
        m.setName(rs.getString("name"));
        m.setHomeAddress(rs.getString("homeAddress"));
        m.setEmergencyService(rs.getString("emergencyService"));

        return m;
    }
}