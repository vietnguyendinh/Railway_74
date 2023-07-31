package com.vti.backend.businesslayer;

import com.vti.backend.datalayer.UserRepository;
import com.vti.entity.User;
import com.vti.utils.ScannerUtils;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class UserService {
    private UserRepository userRepository;

    public UserService() throws SQLException, IOException, ClassNotFoundException {
        userRepository = new UserRepository();
    }
    public List<User> getAllUsers() throws SQLException, IOException, ClassNotFoundException {
        return userRepository.getAllUsers();
    }

    public List<User> getEmployeesByProjectId(int projectId) throws SQLException, IOException, ClassNotFoundException {
        return userRepository.getEmployeesByProjectId(projectId);
    }

    public List<User> getAllManagers() throws SQLException, IOException, ClassNotFoundException {
        return userRepository.getAllManagers();
    }

    public User loginManager() throws SQLException, IOException, ClassNotFoundException {
        System.out.println("Đăng nhập vào Manager:");
        String email = ScannerUtils.readEmail("Nhập email: ");
        String password = ScannerUtils.readPassword("Nhập password: ");
        return userRepository.getManagerByEmailAndPassword(email, password);
    }

}
