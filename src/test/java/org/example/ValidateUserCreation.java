package org.example;

import com.qc.userauth.repository.DBConnection;
import com.qc.userauth.repository.UserDAO;
import org.junit.Test;

public class ValidateUserCreation {
    @Test
    public void testUserCreation(){
        String username = "tyt";
        String password = "ttyet";
        UserDAO userDAO = new UserDAO();
        userDAO.createUser(username,password);
        DBConnection.closeConnection();
    }
}
