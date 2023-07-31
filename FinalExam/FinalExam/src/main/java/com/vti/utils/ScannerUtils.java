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
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        return email.matches(emailRegex);
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
        return password.length() >= 6 && password.length() <= 12;
    }
}
