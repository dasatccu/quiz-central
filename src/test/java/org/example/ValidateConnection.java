package org.example;

import com.qc.userauth.repository.DBConnection;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ValidateConnection {

    @Test
    public void validateConnection(){
        assertNotNull(DBConnection.getConnectionInstance());
    }
}
