package com.davidbellerati.dao;



import com.davidbellerati.interfaces.GenericDAO;

import com.davidbellerati.util.MySQLAdapter;

import com.davidbellerati.vo.ActivityVO;

import com.davidbellerati.vo.MemberVO;

import com.davidbellerati.vo.TeacherVO;



import java.sql.*;

import java.util.ArrayList;

import java.util.List;



public class ActivityDAO implements GenericDAO<ActivityVO> {



    @Override

    public List<ActivityVO> getAll() {

        List<ActivityVO> list = new ArrayList<>();

        String sql = "SELECT A.id, A.name, A.entryHour, A.departHour, " +

                     "T.id AS teacherId, H.name AS teacherName, H.ci, H.dateOfBirth, H.phoneNumber, H.homeAddress, H.emergencyService, T.salary " +

                     "FROM ACTIVITY A " +

                     "LEFT JOIN TEACHER T ON A.teacher_id = T.id " +

                     "LEFT JOIN HUMAN H ON T.id = H.id";



        try (Connection c = MySQLAdapter.getConnection();

             PreparedStatement ps = c.prepareStatement(sql);

             ResultSet rs = ps.executeQuery()) {



            while (rs.next()) {

                ActivityVO a = new ActivityVO();

                a.setId(rs.getInt("id"));

                a.setName(rs.getString("name"));

                a.setEntryHour(rs.getString("entryHour"));

                a.setDepartHour(rs.getString("departHour"));



                int teacherId = rs.getInt("teacherId");

                if (!rs.wasNull()) {

                    TeacherVO t = new TeacherVO();

                    t.setId(teacherId);

                    t.setName(rs.getString("teacherName"));

                    t.setCI(rs.getInt("ci"));

                    Date dob = rs.getDate("dateOfBirth");

                    if (dob != null) t.setDateOfBirth(dob.toLocalDate());

                    t.setPhoneNumber(rs.getInt("phoneNumber"));

                    t.setHomeAddress(rs.getString("homeAddress"));

                    t.setEmergencyService(rs.getString("emergencyService"));

                    t.setSalary(rs.getFloat("salary"));

                    a.setAsignedTeacher(t);

                }



                a.setAsignedMembers(getMembersByActivity(a.getId()));



                list.add(a);

            }



        } catch (SQLException e) {

            e.printStackTrace();

        }



        return list;

    }



    private List<MemberVO> getMembersByActivity(int activityId) {

        List<MemberVO> members = new ArrayList<>();

        String sql = "SELECT H.id, H.name FROM MEMBER M " +

                     "JOIN ACTIVITY_MEMBER AM ON M.id = AM.member_id " +

                     "JOIN HUMAN H ON M.id = H.id " +

                     "WHERE AM.activity_id = ?";



        try (Connection c = MySQLAdapter.getConnection();

             PreparedStatement ps = c.prepareStatement(sql)) {



            ps.setInt(1, activityId);

            try (ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {

                    MemberVO m = new MemberVO();

                    m.setId(rs.getInt("id"));

                    m.setName(rs.getString("name"));

                    members.add(m);

                }

            }



        } catch (SQLException e) {

            e.printStackTrace();

        }



        return members;

    }



    @Override

    public ActivityVO getFromId(int id) {

        for (ActivityVO a : getAll()) {

            if (a.getId() == id) return a;

        }

        return null;

    }



    @Override

    public void add(ActivityVO activity) {

        String sql = "INSERT INTO ACTIVITY (name, entryHour, departHour, teacher_id) VALUES (?, ?, ?, ?)";

        try (Connection c = MySQLAdapter.getConnection();

             PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {



            ps.setString(1, activity.getName());

            ps.setString(2, activity.getEntryHour());

            ps.setString(3, activity.getDepartHour());

            ps.setInt(4, activity.getAsignedTeacher().getId());

            ps.executeUpdate();



            try (ResultSet keys = ps.getGeneratedKeys()) {

                if (keys.next()) activity.setId(keys.getInt(1));

            }



        } catch (SQLException e) {

            e.printStackTrace();

        }

    }



    @Override

    public void update(ActivityVO activity) {

        String sql = "UPDATE ACTIVITY SET name=?, entryHour=?, departHour=?, teacher_id=? WHERE id=?";

        try (Connection c = MySQLAdapter.getConnection();

             PreparedStatement ps = c.prepareStatement(sql)) {



            ps.setString(1, activity.getName());

            ps.setString(2, activity.getEntryHour());

            ps.setString(3, activity.getDepartHour());

            ps.setInt(4, activity.getAsignedTeacher().getId());

            ps.setInt(5, activity.getId());

            ps.executeUpdate();



        } catch (SQLException e) {

            e.printStackTrace();

        }

    }



    @Override

    public void remove(ActivityVO activity) {

        String sql = "DELETE FROM ACTIVITY WHERE id=?";

        try (Connection c = MySQLAdapter.getConnection();

             PreparedStatement ps = c.prepareStatement(sql)) {



            ps.setInt(1, activity.getId());

            ps.executeUpdate();



        } catch (SQLException e) {

            e.printStackTrace();

        }

    }



    public void addMemberToActivity(int activityId, int memberId) {

        String sql = "INSERT INTO ACTIVITY_MEMBER (activity_id, member_id) VALUES (?, ?)";

        try (Connection c = MySQLAdapter.getConnection();

             PreparedStatement ps = c.prepareStatement(sql)) {



            ps.setInt(1, activityId);

            ps.setInt(2, memberId);

            ps.executeUpdate();



        } catch (SQLException e) {

            e.printStackTrace();

        }

    }



    public void removeMemberFromActivity(int activityId, int memberId) {

        String sql = "DELETE FROM ACTIVITY_MEMBER WHERE activity_id=? AND member_id=?";

        try (Connection c = MySQLAdapter.getConnection();

             PreparedStatement ps = c.prepareStatement(sql)) {



            ps.setInt(1, activityId);

            ps.setInt(2, memberId);

            ps.executeUpdate();



        } catch (SQLException e) {

            e.printStackTrace();

        }

    }

}