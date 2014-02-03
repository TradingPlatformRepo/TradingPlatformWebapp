package com.fdm.model.storage;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.fdm.model.service.ConnectionPool;

import static org.mockito.Mockito.*;


public class DBUserStorageTest
{

    DBUserStorage store;
    
    @Before
    public void setUp() throws Exception
    {
        store = spy(new DBUserStorage());
//        store = new DBUserStorage();
    }
    
    @After
    public void tearDown()
    {
   
    }

//    @Test
//    public void test()
//    {
//        fail("Not yet implemented");
//    }
    
//    @Test
//    public void testAddUserVerifyCheckoutIsCalled() throws SQLException
//    {
//        ConnectionPool cpMock = mock(ConnectionPool.class);
////        Connection conMock = mock(Connection.class);
//        when(store.getCP()).thenReturn(cpMock);
//        store.c = mock(Connection.class);
//        User userMock = mock(User.class);
//        verify(cpMock).checkout();
//    } 
    
//    @Test
//    public void notATest() throws SQLException
//    {
//        User test = new User("testacc", "testpass", "test@test.test", "testfirst", "testlast", "0000", false);
//        store.addUser(test);
//    }
    
//    @Test
//    public void notATest2() throws SQLException
//    {
//        store.removeUser("testacc");
//    }
    
//    @Test
//    public void notATest3() throws SQLException
//    {
//        User test = store.getUser("testacc");
//        System.out.println(test.getFirstname());
//    }
}
