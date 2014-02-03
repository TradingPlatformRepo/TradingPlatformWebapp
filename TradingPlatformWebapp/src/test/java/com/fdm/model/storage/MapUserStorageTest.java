package com.fdm.model.storage;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.fdm.model.storage.MapUserStorage;

public class MapUserStorageTest
{

    MapUserStorage mus;
    
    @Before
    public void setUp() throws Exception
    {
        mus = MapUserStorage.getInstance();
    }

    @Test
    public void testGetInstanceReturnAMapUserStorageInstanceWhenYouCallGetInstance()
    {
        //fail("Not yet implemented");
//        if (mus != null)
//        {
//            assertTrue(mus instanceof MapUserStorage);
//        }
//        else
//        {
//            fail();
//        }
        assertNotNull(mus);
    }

    @Test
    public void testGetInstanceReturnsTheSameMapUserStorageInstanceWhenCalledTwice()
    {
        MapUserStorage mus2 = MapUserStorage.getInstance();   
//        assertTrue(mus == mus2);
        assertEquals(mus, mus2);
//        assertSame(mus, mus2);
    }
    
    @Test
    public void testGetInstanceReturnAMapInstanceWhenGetInstanceIsCalled()
    {
        HashMap<String, User> hmap = new HashMap<String, User>();
        
        mus.setMap(hmap);
        
        assertNotNull(mus.getMap());
        assertTrue(mus.getMap() instanceof Map);
    }
       
    @Test
    public void testAddUserVerifiesThatPutIsCalled()
    {
        Map<String, User> mapMock = mock(HashMap.class);
        mus.setMap(mapMock);
        User userMock = mock(User.class);
        when(userMock.getUsername()).thenReturn("bob");
        mus.addUser(userMock);
        //verify(mapMock).put(userMock.getUsername(), userMock);
        verify(mapMock, times(1)).put("bob", userMock);
    }
    
    @Test
    public void testGetUserVerifiesThatGetIsCalled()
    {
        Map<String, User> mapMock = mock(HashMap.class);
        mus.setMap(mapMock);
        mus.getUser("bob");
        verify(mapMock, times(1)).get("bob");
    }
    
    @Test
    public void testRemoveUserVerifiesThatRemoveIsCalled()
    {
        Map<String, User> mapMock = mock(HashMap.class);
        mus.setMap(mapMock);
        mus.removeUser("alice");
        verify(mapMock, times(1)).remove("alice");
    }
}
