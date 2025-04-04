package com.qc.userauth.view;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

import static com.qc.userauth.controller.LoginModule.registrationModule;

/**
 * The type User registration module.
 */
public class UserRegistrationModule {
    private static Scanner scanner = new Scanner(System.in);
    private static Logger logger = LogManager.getLogger(UserRegistrationModule.class);

    /**
     * Register user.
     */
    public static void registerUser() {
        System.out.println("=== User Registration ===");

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
        boolean success = registrationModule(username, password);

        // Display registration status
        if (success) {
            System.out.println("Registration successful!");
            logger.info("Registration successful for :: {}",username);
        } else {
            System.out.println("Registration failed. Username may already exist.");
            logger.error("Registration failed. {} may already exist.",username);
        }
    }
}
