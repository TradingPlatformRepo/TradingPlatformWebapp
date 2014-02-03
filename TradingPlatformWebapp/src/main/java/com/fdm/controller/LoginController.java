package com.fdm.controller;

import java.util.Scanner;

import com.fdm.model.Login;
import com.fdm.model.Validator;
import com.fdm.model.storage.IUserStorage;
import com.fdm.view.ILoginGUI;
import com.fdm.view.LoginGUI;

public class LoginController
{
    private Validator v;
    private Login l;
    private ILoginGUI lgui;
    private IUserStorage store;
//    private Scanner scan = new Scanner(System.in);
    
//    public LoginController()
//    {
//        this.v = new Validator();
//        this.l = new Login(store);
//        this.lgui = new LoginGUI(scan);
//    }
    
    public LoginController(Validator v, Login l, ILoginGUI lgui)
    {
        this.v = v;
        this.l = l;
        this.lgui = lgui;
//        this.lgui.setScan(scan);
    }
    
    /*
     * testcomment for test
     */
    
    public IUserStorage getStore()
    {
        return store;
    }
    
    public void setStore(IUserStorage store)
    {
        this.store = store;
    }
    
    public Boolean loginHandler()
    {
        String user = lgui.getUsername();
        String pass = lgui.getPassword();
//        v.checkUsername(user);
//        v.checkPassword(pass);
        if (v.checkUsername(user) & v.checkPassword(pass))
        {
            l.authenticate(user, pass);
            return true;
        }       
        return false;
    }
}

