package com.qc.userauth.repository;

import java.sql.Connection;

public class UserDAO {
    private Connection connection;

    public UserDAO(){
        this.connection = DBConnection.getConnectionInstance();
    }
}
