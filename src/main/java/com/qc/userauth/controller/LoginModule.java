package com.qc.userauth.controller;

import com.qc.userauth.repository.UserDAO;
import com.qc.userauth.service.SHA256Hashing;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;

/**
 * The type Login module.
 */
public class LoginModule {
    private static Logger logger = LogManager.getLogger(LoginModule.class);

    /**
     * Registration module boolean.
     *
     * @param username the username
     * @param password the password
     * @return the boolean
     */
    public static boolean registrationModule(String username, String password){
        logger.info("registration module called");
        return UserDAO.createUser(username,password);
    }

    /**
     * Check login boolean.
     *
     * @param username the username
     * @param password the password
     * @return the boolean
     * @throws SQLException the sql exception
     */
    public static boolean checkLogin(String username, String password) throws SQLException {
        if(SHA256Hashing.hashPassword(password).equalsIgnoreCase(UserDAO.fetchPassword(username))){
            return true;
        }else{
            return false;
        }
    }

    /**
     * Check admin login boolean.
     *
     * @param username the username
     * @param password the password
     * @return the boolean
     * @throws SQLException the sql exception
     */
    public static boolean checkAdminLogin(String username, String password) throws SQLException {
        if(SHA256Hashing.hashPassword(password)
                .equalsIgnoreCase(UserDAO.fetchAdminPassword(username))){
            return true;
        }else{
            return false;
        }
    }
}
