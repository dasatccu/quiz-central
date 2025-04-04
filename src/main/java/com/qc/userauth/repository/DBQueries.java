package com.qc.userauth.repository;

/**
 * The type Db queries.
 */
public class DBQueries {
    /**
     * The constant CHECK_USER_PRESENT.
     */
    public static String CHECK_USER_PRESENT = "select \"password\" from \"centralUserPortal\" where \"username\" = (?)";
    /**
     * The constant CREATE_USER.
     */
    public static String CREATE_USER = "insert into \"centralUserPortal\" values (?,?)";
    /**
     * The constant GET_PASSWORD.
     */
    public static String GET_PASSWORD = "select \"password\" from \"centralUserPortal\" where \"username\" = (?)";
    private static String CREATE_ADMIN = "insert into \"adminTable\" values (?,?)";
    /**
     * The constant GET_ADMIN_PASSWORD.
     */
    public static String GET_ADMIN_PASSWORD = "select \"password\" from \"adminTable\" where \"username\" = (?)";
}
