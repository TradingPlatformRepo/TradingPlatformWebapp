package com.fdm.view;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.fdm.view.LoginGUI;

import static org.mockito.Mockito.*;

public class LoginGUITest
{

    //LoginGUI logGui;
    
    
    @Before
    public void setUp() throws Exception
    {
        //logGui = new LoginGUI();
        
    }

    @After
    public void knockDown() throws Exception
    {
        
    }
//    @Test
//    public void test()
//    {
//        fail("Not yet implemented");
//    }

//    @Test
//    public void testGetUsernameVerifiesNextLineIsCalled()
//    {
//        Scanner scanMock = mock(Scanner.class);
//        logGui.setScan(scanMock);
//        logGui.getUsername();
//        verify(scanMock).nextLine();
//    }
    
      @Test
      public void testGetUsernameReturnsUsernameCorrectly()
      {
//          LoginGUI uiSpy = spy(new LoginGUI(new Scanner(System.in)));
          LoginGUI uiSpy = spy(new LoginGUI());
          uiSpy.setScan(new Scanner(new ByteArrayInputStream("bla\n1".getBytes())));
          when(uiSpy.getInput()).thenReturn("Test");
          assertTrue(uiSpy.getUsername().equals("Test"));
      }
      
      @Test
      public void testGetPasswordReturnsPasswordCorrectly()
      {
//          LoginGUI uiSpy = spy(new LoginGUI(new Scanner(System.in)));
          LoginGUI uiSpy = spy(new LoginGUI());
          uiSpy.setScan(new Scanner(new ByteArrayInputStream("bla\n1".getBytes())));
          when(uiSpy.getInput()).thenReturn("testpass");
          assertTrue(uiSpy.getPassword().equals("testpass"));
      }
}
