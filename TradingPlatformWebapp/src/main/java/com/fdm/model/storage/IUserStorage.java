package com.fdm.model.storage;

public interface IUserStorage
{
    public void addUser(User user);
    public User getUser(String username);
    public void removeUser(String username);
}
