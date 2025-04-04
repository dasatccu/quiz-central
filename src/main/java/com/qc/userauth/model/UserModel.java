package com.qc.userauth.model;

/**
 * The interface User model.
 */
public interface UserModel {
     /**
      * Sets user name.
      *
      * @param userName the user name
      */
     void setUserName(String userName);

     /**
      * Sets user password.
      *
      * @param userPassword the user password
      */
     void setUserPassword(String userPassword);

     /**
      * Gets user name.
      *
      * @return the user name
      */
     String getUserName();

     /**
      * Gets user password.
      *
      * @return the user password
      */
     String getUserPassword();
}
