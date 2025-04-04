package com.qc.userauth.view;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

import static com.qc.userauth.view.UserLoginModule.loginAdmin;
import static com.qc.userauth.view.UserLoginModule.loginUser;

/**
 * The type Welcome page.
 */
public class WelcomePage {
    private static final Logger logger = LogManager.getLogger(WelcomePage.class);
    private static int welcomePage() throws IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        System.out.println("====================================");
        System.out.println("      Welcome to Quiz-Central     ");
        System.out.println("====================================");
        System.out.println("1. Register as User");
        System.out.println("2. Login as User");
        System.out.println("3. Login as Admin");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");

        int choice = Integer.parseInt(reader.readLine());

        switch (choice) {
            case 1:
                logger.info("User selected: Register as User");
                System.out.println("Redirecting to user registration...");
                UserRegistrationModule.registerUser();
                break;
            case 2:
                logger.info("User selected: Login as User");
                System.out.println("Redirecting to user login...");
                try {
                    loginUser();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case 3:
                logger.info("User selected: Login as Admin");
                System.out.println("Redirecting to admin login...");
                try {
                    loginAdmin();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case 0:
                logger.info("User selected: Exit");
                System.out.println("Exiting Quiz-Central. Goodbye!");
                break;
            default:
                logger.error("Invalid choice entered: " + choice);
                System.out.println("Invalid choice! Please try again.");
        }
        return choice;
    }

    /**
     * Launch welcome page.
     */
    public static void launchWelcomePage(){
        int choice = 1;
        while(choice!=0){
            try {
                choice = welcomePage();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
