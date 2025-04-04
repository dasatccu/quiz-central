package com.qc.userauth.controller;

import com.qc.userauth.repository.UserDAO;
import com.qc.userauth.service.SHA256Hashing;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;

public class LoginModule {
    private static Logger logger = LogManager.getLogger(LoginModule.class);

    public static boolean registrationModule(String username, String password){
        logger.info("registration module called");
        return UserDAO.createUser(username,password);
    }

    public static boolean checkLogin(String username, String password) throws SQLException {
        if(SHA256Hashing.hashPassword(password).equalsIgnoreCase(UserDAO.fetchPassword(username))){
            return true;
        }else{
            return false;
        }
    }
}
