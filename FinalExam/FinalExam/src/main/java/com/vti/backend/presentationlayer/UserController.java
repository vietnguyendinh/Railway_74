package com.vti.backend.presentationlayer;

import com.vti.backend.businesslayer.UserService;
import com.vti.entity.User;
import com.vti.utils.ScannerUtils;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class UserController {
    private static UserService userService;

    public UserController() throws SQLException, IOException, ClassNotFoundException {
        userService = new UserService();
    }
    public void program() throws SQLException, IOException, ClassNotFoundException {
        int choice;
        do {
            showMenu();
            choice = ScannerUtils.readInt("CHỌN THAO TÁC: ");
            MenuChoice(choice);
        } while (choice != 0);
    }

    private static void showMenu() {
        System.out.println("========== HỆ THỐNG QUÁN LÝ USER ==========");
        System.out.println("1. Hiện tất cả User");
        System.out.println("2. Hiện tất cả Employee theo Project Id");
        System.out.println("3. Hiện tất cả Manager");
        System.out.println("4. Login vào Manager");
//        System.out.println("5. Add a new user");
        System.out.println("0. Exit");
        System.out.println("============================================");
    }

    private static void MenuChoice(int choice) throws SQLException, IOException, ClassNotFoundException {
        switch (choice) {
            case 1:
                showAllUsers();
                break;
            case 2:
                showEmployeesByProjectId();
                break;
            case 3:
                showAllManagers();
                break;
            case 4:
                loginManager();
                break;
            case 0:
                System.out.println("Đã thoát");
                break;
            default:
                System.out.println("Lựa chọn không đúng. Nhập lại.");
                break;
        }
    }

    private static void showAllUsers() throws SQLException, IOException, ClassNotFoundException {
        List<User> users = userService.getAllUsers();
        printUserTable(users);
    }

    private static void showEmployeesByProjectId() throws SQLException, IOException, ClassNotFoundException {
        int projectId = ScannerUtils.readInt("Nhập Project ID: ");
        List<User> employees = userService.getEmployeesByProjectId(projectId);
        printUserTable(employees);
    }

    private static void showAllManagers() throws SQLException, IOException, ClassNotFoundException {
        List<User> managers = userService.getAllManagers();
        printUserTable(managers);
    }

    private static void loginManager() throws SQLException, IOException, ClassNotFoundException {
        User manager = userService.loginManager();
        if (manager != null) {
            System.out.println("Đăng Nhập Thành Công " + manager.getFullName() + "!");
        } else {
            System.out.println("Đăng Nhập Thất Bại. Email hoặc Password không đúng.");
        }
    }

    private static void printUserTable(List<User> users) {
        System.out.println("=========== Danh Sách User ===========");
        System.out.printf("%-5s %-20s %-30s %-10s %-15s %-10s %-10s %s\n",
                "ID", "Full Name", "Email", "Password", "ExpInYear", "ProSkill", "ProjectID", "Role");
        for (User user : users) {
            System.out.printf("%-5d %-20s %-30s %-10s %-15s %-10s %-10s %s\n",
                    user.getId(), user.getFullName(), user.getEmail(), user.getPassword(),
                    user.getExpInYear(), user.getProSkill(), user.getProjectId(), user.getRole());
        }
        System.out.println("=================================");
    }

}