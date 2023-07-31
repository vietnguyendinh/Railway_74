package com.vti.frontend;

import com.vti.backend.presentationlayer.UserController;

import java.io.IOException;
import java.sql.SQLException;

public class Program {
    public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException {
        UserController userController = new UserController();
        userController.program();
    }
}
