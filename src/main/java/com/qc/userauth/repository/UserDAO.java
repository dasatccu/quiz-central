package com.qc.userauth.repository;

import com.qc.userauth.service.SHA256Hashing;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
    private Connection connection;
    private static Logger logger = LogManager.getLogger(UserDAO.class);
    private static String CREATE_USER = "insert into \"centralUserPortal\" values (?,?)";
    private static String GET_PASSWORD = "select \"password\" from \"centralUserPortal\" where \"username\" = (?)";

    public UserDAO(){
        this.connection = DBConnection.getConnectionInstance();
    }

    public void createUser(String userName, String password){
        try {
            PreparedStatement statement = this.connection.prepareStatement(CREATE_USER);
            statement.setString(1,userName);
            statement.setString(2, SHA256Hashing.hashPassword(password));
            boolean status = statement.execute();
            logger.info("Create user record created :: "+!status);
            logger.info("User created with username :: "+ userName);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    public String fetchPassword(String userName) throws SQLException {
        ResultSet resultSet = null;
        try {
            PreparedStatement statement = this.connection.prepareStatement(GET_PASSWORD);
            logger.info("Fetching password from DB for username :: {}",userName);
            statement.setString(1,userName);
            resultSet = statement.executeQuery();
            resultSet.next();
            logger.info("Password fetched from DB :: {}",resultSet);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

        assert resultSet != null;
        return resultSet.getString(1);
    }
}
