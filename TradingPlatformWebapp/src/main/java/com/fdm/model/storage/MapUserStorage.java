package com.fdm.model.storage;

import java.util.HashMap;
import java.util.Map;

public class MapUserStorage implements IUserStorage
{
    private static Map<String, User> map;
    private static MapUserStorage instance = new MapUserStorage();
//    private static MapUserStorage instance;
    
      private MapUserStorage()
      {
          
      }
    
//    private MapUserStorage(Map<String, User> map)
//    {
//        this.map = map;
//    }
    
    public static MapUserStorage getInstance()
    {
//        if (instance == null)
//        {
//            return instance = new MapUserStorage();
//        }
        return instance;
    }

    public void addUser(User user)
    {
        map.put(user.getUsername(), user);
    }

    public User getUser(String username)
    {
        return map.get(username);
    }

    public void removeUser(String username)
    {
        map.remove(username);
    }

    public void setMap(Map<String, User> map)
    {
        this.map = map;
    }

    public Map<String, User> getMap()
    {
        return map;
    }
}
