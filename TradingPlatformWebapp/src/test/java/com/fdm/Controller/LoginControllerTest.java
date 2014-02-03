package com.fdm.Controller;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.fdm.controller.LoginController;
import com.fdm.model.Login;
import com.fdm.model.Validator;
import com.fdm.view.LoginGUI;

import static org.mockito.Mockito.*;

public class LoginControllerTest
{

    LoginController logCon;
    Validator valMock;
    Login logMock;
    LoginGUI guiMock;
    
    @Before
    public void setUp() throws Exception
    {
        valMock = mock(Validator.class);
        logMock = mock(Login.class);
        guiMock = mock(LoginGUI.class);
        
        logCon = new LoginController(valMock, logMock, guiMock);
    }

//    @Test
//    public void test()
//    {
//        fail("Not yet implemented");
//    }

    @Test
    public void testLoginControllerVerifyGetUsernameIsCalled()
    {
        logCon.loginHandler();
        verify(guiMock).getUsername();
    }
    
    @Test
    public void testLoginControllerVerifyGetPasswordIsCalled()
    {
        logCon.loginHandler();
        verify(guiMock).getPassword();
    }
    
    @Test
    public void testLoginControllerVerifyCheckUsernameIsCalled()
    {
        logCon.loginHandler();
        verify(valMock, atLeast(1)).checkUsername(null);
    }
    
    @Test
    public void testLoginControllerVerifyCheckPasswordIsCalled()
    {
        logCon.loginHandler();
        verify(valMock, atLeast(1)).checkPassword(null);
    }
    
    @Test
    public void testLoginControllerVerifyAuthenticateIsCalledWhenAValidUsernameAndPasswordIsProvided()
    {
        when(guiMock.getUsername()).thenReturn("Bob");
        when(guiMock.getPassword()).thenReturn("Test123456!&");
        when(valMock.checkUsername("Bob")).thenReturn(true);
        when(valMock.checkPassword("Test123456!&")).thenReturn(true);
        logCon.loginHandler();
        verify(logMock).authenticate("Bob", "Test123456!&");
    }
    
    @Test
    public void testLoginControllerVerifyAuthenticateIsNotCalledWhenAInvalidUsernameIsProvided()
    {
        when(guiMock.getUsername()).thenReturn("Bo b");
        when(guiMock.getPassword()).thenReturn("Test123456!&");
        when(valMock.checkUsername("Bo b")).thenReturn(false);
        when(valMock.checkPassword("Test123456!&")).thenReturn(true);
        logCon.loginHandler();
        verify(logMock, times(0)).authenticate("Bo b", "Test123456!&");
    }
    
    @Test
    public void testLoginHandlerReturnTrueWhenCorrectUserNameAndPasswordIsProvided()
    {
        String name = "Bob";
        String pass = "Test123456!&";
        when(guiMock.getUsername()).thenReturn(name);
        when(guiMock.getPassword()).thenReturn(pass);
        when(valMock.checkUsername(name)).thenReturn(true);
        when(valMock.checkPassword(pass)).thenReturn(true);
        assertTrue(logCon.loginHandler());
    }
    
    @Test
    public void testLoginHandlerReturnFalseWhenFalseUsernameIsProvided()
    {
        String name = "Bob";
        String pass = "Test123456!&";
        when(guiMock.getUsername()).thenReturn("aFalseUsername");
        when(guiMock.getPassword()).thenReturn(pass);
        when(valMock.checkUsername(name)).thenReturn(true);
        when(valMock.checkPassword(pass)).thenReturn(true);
        assertFalse(logCon.loginHandler());
    }
    
    @Test
    public void testLoginHandlerReturnFalseWhenFalsePasswordIsProvided()
    {
        String name = "Bob";
        String pass = "Test123456!&";
        when(guiMock.getUsername()).thenReturn(name);
        when(guiMock.getPassword()).thenReturn("blafalse");
        when(valMock.checkUsername(name)).thenReturn(true);
        when(valMock.checkPassword(pass)).thenReturn(true);
        assertFalse(logCon.loginHandler());
    }
}
