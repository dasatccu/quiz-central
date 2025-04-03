package org.example;

import com.qc.userauth.service.SHA256Hashing;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CheckHashing {
    @Test
    public void checkhashingpassword(){
        String actual = SHA256Hashing.hashPassword("XYZ");
        String expected = SHA256Hashing.hashPassword("XYZ");
        assertEquals(actual,expected);
    }
}
