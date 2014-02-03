package com.fdm.model;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

import com.fdm.model.storage.IUserStorage;
import com.fdm.model.storage.User;

public class LoginTest
{

    Login login;

    @Before
    public void setUp() throws Exception
    {
        
        IUserStorage storeMock = mock(IUserStorage.class);
        login = new Login(storeMock);
//        login.setStore(storeMock);
        User userMock = mock(User.class);
        when(storeMock.getUser("Bob")).thenReturn(userMock);
        when(userMock.getPassword()).thenReturn("Test1234&*");
    }

//    @Test
//    public void test()
//    {
//        fail("Not yet implemented");
//    }
    
        
    @Test
    public void testAuthenticateReturnsTrueIfCorrectUsernameAndPasswordIsChecked()
    {
        String correctName = "Bob";
        String correctPW = "Test1234&*";
        assertTrue(login.authenticate(correctName, correctPW));
    }
    
    @Test
    public void testAuthenticateReturnsFalseIfCorrectUsernameAndWrongPasswordIsChecked()
    {
        String correctName = "Bob";
        String correctPW = "Test1234&notright*";
        assertFalse(login.authenticate(correctName, correctPW));
    }
    
    @Test
    public void testAuthenticateReturnsFalseIfFalseUsernameIsChecked()
    {
        String wrongName = "NotBob";
        assertFalse(login.authenticate(wrongName, "whatsoever"));
    }

}
