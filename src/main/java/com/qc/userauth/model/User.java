package com.qc.userauth.model;

/**
 * The type User.
 */
public class User implements UserModel{
    private String userName;
    private String userPassword;

    @Override
    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @Override
    public String getUserName() {
        return this.userName;
    }

    @Override
    public String getUserPassword() {
        return this.userPassword;
    }
}
