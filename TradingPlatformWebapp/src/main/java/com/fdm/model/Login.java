package com.fdm.model;

import com.fdm.model.storage.IUserStorage;
import com.fdm.model.storage.User;

public class Login
{
    
    private IUserStorage store;
    
    public Login(IUserStorage store)
    {
        this.store = store;
    }
    
    public boolean authenticate(String username, String password)
    {
        User u = store.getUser(username);
        if (u != null && u.getPassword().equals(password))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

//    public IUserStorage getStore()
//    {
//        return store;
//    }

//    public void setStore(IUserStorage store)
//    {
//        this.store = store;
//    }
}
