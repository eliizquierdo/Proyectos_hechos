package com.davidbellerati.dao;

import com.davidbellerati.interfaces.GenericDAO;
import com.davidbellerati.util.MySQLAdapter;
import com.davidbellerati.vo.EmployeeVO;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;

public class EmployeeDAO implements GenericDAO<EmployeeVO> {

    @Override
    public List<EmployeeVO> getAll() {
        List<EmployeeVO> list = new ArrayList<>();

        String sql =
            "SELECT H.id, H.ci, H.dateOfBirth, H.phoneNumber, H.name, " +
            "H.homeAddress, H.emergencyService, E.salary, E.category " +
            "FROM HUMAN H " +
            "JOIN EMPLOYEE E ON H.id = E.id";

        try (Connection c = MySQLAdapter.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(mapEmployee(rs));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public EmployeeVO getFromId(int id) {
        String sql =
            "SELECT H.id, H.ci, H.dateOfBirth, H.phoneNumber, H.name, " +
            "H.homeAddress, H.emergencyService, E.salary, E.category " +
            "FROM HUMAN H " +
            "JOIN EMPLOYEE E ON H.id = E.id " +
            "WHERE H.id = ?";

        try (Connection c = MySQLAdapter.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) return mapEmployee(rs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }


    @Override
    public void add(EmployeeVO e) {

        String sqlHuman =
            "INSERT INTO HUMAN (ci, dateOfBirth, phoneNumber, name, homeAddress, emergencyService) " +
            "VALUES (?, ?, ?, ?, ?, ?)";

        String sqlEmployee =
            "INSERT INTO EMPLOYEE (id, salary, category) VALUES (?, ?, ?)";

        try (Connection c = MySQLAdapter.getConnection()) {

            c.setAutoCommit(false);

            try (PreparedStatement psHuman = c.prepareStatement(sqlHuman, Statement.RETURN_GENERATED_KEYS)) {

                psHuman.setInt(1, e.getCI());
                psHuman.setDate(2, e.getDateOfBirth() != null ? Date.valueOf(e.getDateOfBirth()) : null);
                psHuman.setInt(3, e.getPhoneNumber());
                psHuman.setString(4, e.getName());
                psHuman.setString(5, e.getHomeAddress());
                psHuman.setString(6, e.getEmergencyService());
                psHuman.executeUpdate();

                try (ResultSet keys = psHuman.getGeneratedKeys()) {
                    if (keys.next()) e.setId(keys.getInt(1));
                }
            }

            try (PreparedStatement psEmployee = c.prepareStatement(sqlEmployee)) {
                psEmployee.setInt(1, e.getId());
                psEmployee.setDouble(2, e.getSalary());
                psEmployee.setString(3, e.getCategory());
                psEmployee.executeUpdate();
            }

            c.commit();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }


    @Override
    public void update(EmployeeVO e) {

        String sql =
            "UPDATE HUMAN h " +
            "JOIN EMPLOYEE emp ON h.id = emp.id " +
            "SET h.ci = ?, h.dateOfBirth = ?, h.phoneNumber = ?, h.name = ?, " +
            "h.homeAddress = ?, h.emergencyService = ?, emp.salary = ?, emp.category = ? " +
            "WHERE h.id = ?";

        try (Connection c = MySQLAdapter.getConnection()) {

            c.setAutoCommit(false);

            try (PreparedStatement ps = c.prepareStatement(sql)) {

                ps.setInt(1, e.getCI());
                ps.setDate(2, e.getDateOfBirth() != null ? Date.valueOf(e.getDateOfBirth()) : null);
                ps.setInt(3, e.getPhoneNumber());
                ps.setString(4, e.getName());
                ps.setString(5, e.getHomeAddress());
                ps.setString(6, e.getEmergencyService());
                ps.setDouble(7, e.getSalary());
                ps.setString(8, e.getCategory());
                ps.setInt(9, e.getId());

                ps.executeUpdate();
            }

            c.commit();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }


    @Override
    public void remove(EmployeeVO e) {

        String sqlEmployee = "DELETE FROM EMPLOYEE WHERE id = ?";
        String sqlHuman   = "DELETE FROM HUMAN WHERE id = ?";

        try (Connection c = MySQLAdapter.getConnection()) {

            c.setAutoCommit(false);

            try (PreparedStatement psEmp = c.prepareStatement(sqlEmployee)) {
                psEmp.setInt(1, e.getId());
                psEmp.executeUpdate();
            }

            try (PreparedStatement psHum = c.prepareStatement(sqlHuman)) {
                psHum.setInt(1, e.getId());
                psHum.executeUpdate();
            }

            c.commit();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }


    public Integer getIdByCi(int ci) {
        String sql =
            "SELECT e.id FROM EMPLOYEE e " +
            "JOIN HUMAN h ON e.id = h.id " +
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


    public EmployeeVO mapEmployee(ResultSet rs) throws SQLException {

        EmployeeVO e = new EmployeeVO();

        e.setId(rs.getInt("id"));
        e.setCI(rs.getInt("ci"));

        Date dob = rs.getDate("dateOfBirth");
        e.setDateOfBirth(dob != null ? dob.toLocalDate() : null);

        e.setPhoneNumber(rs.getInt("phoneNumber"));
        e.setName(rs.getString("name"));
        e.setHomeAddress(rs.getString("homeAddress"));
        e.setEmergencyService(rs.getString("emergencyService"));

        e.setSalary(rs.getDouble("salary"));
        e.setCategory(rs.getString("category"));

        return e;
    }
}
