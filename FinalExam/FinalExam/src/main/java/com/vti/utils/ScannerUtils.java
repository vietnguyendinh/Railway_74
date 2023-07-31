package com.vti.utils;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Scanner;

public class ScannerUtils {
    private static Scanner scanner = new Scanner(System.in);

    public static int readInt(String message) {
        System.out.print(message);
        while (!scanner.hasNextInt()) {
            System.out.print("Sai định dạng! Vui lòng nhập lại: ");
            scanner.next();
        }
        int value = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        return value;
    }

    public static String readString(String message) {
        System.out.print(message);
        return scanner.nextLine();
    }

    public static String readEmail(String message) {
        String email;
        do {
            email = readString(message);
            if (!isValidEmail(email)) {
                System.out.println("Định dạng email không hợp lệ. Vui lòng nhập lại.");
            }
        } while (!isValidEmail(email));
        return email;
    }

    public static boolean isValidEmail(String email) {
        // Kiểm tra định dạng email bằng Regular Expression
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        return email.matches(emailRegex);
    }

    public static String readFullName(String message) {
        String fullName;
        do {
            fullName = readString(message);
            if (!isValidFullName(fullName)) {
                System.out.println("Họ và tên chỉ chứa chữ và không chứa bất kỳ kí tự đặc biệt nào.");
            }
        } while (!isValidFullName(fullName));
        return fullName;
    }

    public static boolean isValidFullName(String fullName) {
        // Kiểm tra xem fullName chỉ chứa chữ và không chứa bất kỳ kí tự đặc biệt nào
        String fullNameRegex = "^[a-zA-Z\\s]+$";
        return fullName.matches(fullNameRegex);
    }

    public static String readPassword(String message) {
        String password;
        do {
            password = readString(message);
            if (!isValidPassword(password)) {
                System.out.println("Mật khẩu phải có từ 6 đến 12 ký tự.");
            }
        } while (!isValidPassword(password));
        return password;
    }

    public static boolean isValidPassword(String password) {
        // Kiểm tra xem password có từ 6 đến 12 ký tự
        return password.length() >= 6 && password.length() <= 12;
    }
}
