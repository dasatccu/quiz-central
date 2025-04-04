package org.example;

import com.qc.userauth.controller.LoginModule;
import com.qc.userauth.view.WelcomePage;
import org.junit.Test;

import java.io.IOException;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;

public class TestUserCreationAndLogin {
    @Test
    public void testUserCreationAndLogin() throws SQLException, IOException {
        WelcomePage.welcomePage();
    }
}
