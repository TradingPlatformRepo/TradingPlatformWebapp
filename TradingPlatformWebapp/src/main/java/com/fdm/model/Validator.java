package com.fdm.model;

public class Validator
{
    public boolean checkUsername(String username)
    {
        if (username.matches("[a-zA-Z\\d]+"))
        {
            return true;
        }
        else
        {
            return false;
        }
        
        
    }
    
    public boolean checkPassword(String password)
    {
        if (password.length() > 7 
            && password.length() < 25 
            && password.matches(".*[a-z]+.*") 
            && password.matches(".*[A-Z]+.*")
            && password.matches(".*[\\d]+.*")
            && password.matches(".*[\\p{Punct}]+.")
            )
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
