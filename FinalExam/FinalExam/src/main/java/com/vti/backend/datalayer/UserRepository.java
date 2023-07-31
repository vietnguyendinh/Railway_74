package com.vti.backend.datalayer;

import com.vti.entity.User;
import com.vti.utils.JdbcUtils;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class UserRepository {

    public List<User> getAllUsers() throws SQLException, IOException, ClassNotFoundException {
        List<User> users = new ArrayList<>();
        JdbcUtils jdbcUtils = new JdbcUtils();
        Connection connection = jdbcUtils.getConnection();
        try {
            String sql = "SELECT * FROM User";
            PreparedStatement pstm = connection.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String fullName = rs.getString("full_name");
                String email = rs.getString("email");
                String password = rs.getString("password");
                Integer expInYear = (Integer) rs.getObject("exp_in_year");
                String proSkill = rs.getString("pro_skill");
                Integer projectId = (Integer) rs.getObject("project_id");
                String role = rs.getString("role");

                User user = new User(id, fullName, email, password, expInYear, proSkill, projectId, role);
                users.add(user);
            }

            rs.close();
            pstm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public List<User> getEmployeesByProjectId(int projectId) throws SQLException, IOException, ClassNotFoundException {
        List<User> employees = new ArrayList<>();
        JdbcUtils jdbcUtils = new JdbcUtils();
        Connection connection = jdbcUtils.getConnection();
        try {
            String sql = "SELECT * FROM User WHERE role = 'employee' AND project_id = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, projectId);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String fullName = rs.getString("full_name");
                String email = rs.getString("email");
                String password = rs.getString("password");
                Integer expInYear = (Integer) rs.getObject("exp_in_year");
                String proSkill = rs.getString("pro_skill");
                Integer projectIdFromDb = (Integer) rs.getObject("project_id");
                String role = rs.getString("role");

                User employee = new User(id, fullName, email, password, expInYear, proSkill, projectIdFromDb, role);
                employees.add(employee);
            }

            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }

    public List<User> getAllManagers() throws SQLException, IOException, ClassNotFoundException {
        List<User> managers = new ArrayList<>();
        JdbcUtils jdbcUtils = new JdbcUtils();
        Connection connection = jdbcUtils.getConnection();
        try {
            String sql = "SELECT * FROM User WHERE role = 'manager'";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt("id");
                String fullName = rs.getString("full_name");
                String email = rs.getString("email");
                String password = rs.getString("password");
                Integer expInYear = (Integer) rs.getObject("exp_in_year");
                String proSkill = rs.getString("pro_skill");
                Integer projectId = (Integer) rs.getObject("project_id");
                String role = rs.getString("role");

                User manager = new User(id, fullName, email, password, expInYear, proSkill, projectId, role);
                managers.add(manager);
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return managers;
    }

    public User getManagerByEmailAndPassword(String email, String password) throws SQLException, IOException, ClassNotFoundException {
        User manager = null;
        JdbcUtils jdbcUtils = new JdbcUtils();
        Connection connection = jdbcUtils.getConnection();
        try {
            String sql = "SELECT * FROM User WHERE role = 'manager' AND email = ? AND password = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, email);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("id");
                String fullName = rs.getString("full_name");
                String passwordFromDb = rs.getString("password");
                Integer expInYear = (Integer) rs.getObject("exp_in_year");
                String proSkill = rs.getString("pro_skill");
                Integer projectId = (Integer) rs.getObject("project_id");
                String role = rs.getString("role");

                manager = new User(id, fullName, email, passwordFromDb, expInYear, proSkill, projectId, role);
            }

            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return manager;
    }

}

