package com.qc.userauth.repository;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final Logger logger = LogManager.getLogger(DBConnection.class);
    private static Connection connection=null;

    private DBConnection(){
        try{
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(Constants.URL,
                    Constants.USERNAME,Constants.PASSWORD);
            logger.info("Connection Instance :: "+connection);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    public static Connection getConnectionInstance(){
        if(connection == null){
            DBConnection dbConnection = new DBConnection();
            logger.info("Connection Instance :: "+dbConnection);
            return connection;
        } else{
            return connection;
        }
    }

    public static void closeConnection(){
        if(connection != null){
            try {
                connection.close();
                logger.info("Connection closed");
            } catch (SQLException e) {
                logger.error(e.getMessage());
            }
        }
    }
}
