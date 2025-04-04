package com.qc.userauth.view;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.util.Scanner;

import static com.qc.userauth.controller.LoginModule.checkLogin;

/**
 * The type User login module.
 */
public class UserLoginModule {
    private static Scanner scanner = new Scanner(System.in);
    private static Logger logger = LogManager.getLogger(UserLoginModule.class);

    /**
     * Login user.
     *
     * @throws SQLException the sql exception
     */
    public static void loginUser() throws SQLException {
        System.out.println("=== User Login Page ===");

        // Prompt for username
        System.out.print("Enter username: ");
        String username = scanner.nextLine().trim();

        // Prompt for password
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        // Validate inputs
        if (username.isEmpty() || password.isEmpty()) {
            System.out.println("Username and password cannot be empty.");
            return;
        }

        // Call the registration method
        boolean success = checkLogin(username, password);

        // Display registration status
        if (success) {
            System.out.println("Login successful!");
            logger.info("Login successful for :: {}",username);
        } else {
            System.out.println("Login failed. Username and password combination is incorrect.");
            logger.error("Login failed. Username and password combination is incorrect.");
        }
    }

    /**
     * Login admin.
     *
     * @throws SQLException the sql exception
     */
    public static void loginAdmin() throws SQLException {
        System.out.println("=== User Admin Page ===");

        // Prompt for username
        System.out.print("Enter username: ");
        String username = scanner.nextLine().trim();

        // Prompt for password
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        // Validate inputs
        if (username.isEmpty() || password.isEmpty()) {
            System.out.println("Username and password cannot be empty.");
            return;
        }

        // Call the registration method
        boolean success = checkLogin(username, password);

        // Display registration status
        if (success) {
            System.out.println("Login successful!");
            logger.info("Login successful for :: {}",username);
        } else {
            System.out.println("Login failed. Username and password combination is incorrect.");
            logger.error("Login failed. Username and password combination is incorrect.");
        }
    }
}
