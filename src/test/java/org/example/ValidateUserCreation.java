package org.example;

import com.qc.userauth.repository.DBConnection;
import com.qc.userauth.repository.UserDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.assertEquals;

public class ValidateUserCreation {
    private static Logger logger = LogManager.getLogger(ValidateUserCreation.class);
    UserDAO userDAO = new UserDAO();
    @Test
    public void testUserCreation(){
        String username = "tyt";
        String password = "ttyet";
        userDAO.createUser(username,password);
        DBConnection.closeConnection();
    }

    @Test
    public void testGetPassword(){
        String actualPassword = null;
        try {
            actualPassword = userDAO.fetchPassword("tyt");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        logger.info("Password fetched :: {}",actualPassword);
        assertEquals("A+YkNWx98OlWRf5mCp3JCzF0YNAl8UA1pau/VNf00sQ=",actualPassword);
    }
}
