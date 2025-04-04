package com.qc.userauth.repository;

import com.qc.userauth.service.SHA256Hashing;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.qc.userauth.repository.DBQueries.*;

/**
 * The type User dao.
 */
public class UserDAO {
    private static Logger logger = LogManager.getLogger(UserDAO.class);

    /**
     * Create user boolean.
     *
     * @param userName the user name
     * @param password the password
     * @return the boolean
     */
    public static boolean createUser(String userName, String password){
        boolean status = false;
        try {
            if(checkUserPresent(userName).getFetchSize()==0) {
                PreparedStatement statement = DBConnection.getConnectionInstance()
                        .prepareStatement(CREATE_USER);
                statement.setString(1, userName);
                statement.setString(2, SHA256Hashing.hashPassword(password));
                status = statement.execute();
                logger.info("Create user record created :: " + !status);
                logger.info("User created with username :: " + userName);
                status =  true;
                return status;
            }else{
                return status;
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
        } finally {
            DBConnection.closeConnection();
            return status;
        }
    }

    /**
     * Fetch password string.
     *
     * @param userName the user name
     * @return the string
     * @throws SQLException the sql exception
     */
    public static String fetchPassword(String userName) throws SQLException {
        ResultSet resultSet = null;
        try {
            PreparedStatement statement = DBConnection.getConnectionInstance()
                    .prepareStatement(GET_PASSWORD);
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

    /**
     * Check user present result set.
     *
     * @param userName the user name
     * @return the result set
     * @throws SQLException the sql exception
     */
    public static ResultSet checkUserPresent(String userName) throws SQLException{
        ResultSet resultSet = null;
        try {
            PreparedStatement statement = DBConnection.getConnectionInstance()
                    .prepareStatement(CHECK_USER_PRESENT);
            logger.info("Fetching password from DB for username :: {}",userName);
            statement.setString(1,userName);
            resultSet = statement.executeQuery();
            resultSet.next();
            logger.info("Password fetched from DB :: {}",resultSet);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return resultSet;
    }

    /**
     * Fetch admin password string.
     *
     * @param userName the user name
     * @return the string
     * @throws SQLException the sql exception
     */
    public static String fetchAdminPassword(String userName) throws SQLException {
        ResultSet resultSet = null;
        try {
            PreparedStatement statement = DBConnection.getConnectionInstance()
                    .prepareStatement(GET_ADMIN_PASSWORD);
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
