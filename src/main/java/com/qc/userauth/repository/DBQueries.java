package com.qc.userauth.repository;

public class DBQueries {
    public static String CHECK_USER_PRESENT = "select \"password\" from \"centralUserPortal\" where \"username\" = (?)";
    public static String CREATE_USER = "insert into \"centralUserPortal\" values (?,?)";
    public static String GET_PASSWORD = "select \"password\" from \"centralUserPortal\" where \"username\" = (?)";
}
