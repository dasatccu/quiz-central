package org.example;

import com.qc.userauth.service.SHA256Hashing;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CheckHashing {
    @Test
    public void checkhashingpassword(){
        String actual = SHA256Hashing.hashPassword("password");
        String expected = SHA256Hashing.hashPassword("password");
        assertEquals(actual,expected);
    }
}
