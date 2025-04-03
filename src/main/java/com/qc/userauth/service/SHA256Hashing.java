package com.qc.userauth.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 * The type Sha 256 hashing.
 */
public class SHA256Hashing {
    private static Logger logger = LogManager.getLogger(SHA256Hashing.class);
    /**
     * Hash password string.
     *
     * @param password the password
     * @return the string
     */
    public static String hashPassword(String password){
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        byte[] hash = md.digest(password.getBytes());
        String hashCode = Base64.getEncoder().encodeToString(hash);
        logger.info("Hashed Code :: "+hashCode);
        return hashCode;
    }
}
