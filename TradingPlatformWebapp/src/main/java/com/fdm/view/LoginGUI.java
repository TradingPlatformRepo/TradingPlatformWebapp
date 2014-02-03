package com.fdm.view;

import java.util.Scanner;

public class LoginGUI implements ILoginGUI
{
    
    private Scanner scan = new Scanner(System.in);
    
//    public LoginGUI(Scanner scan)
//    {
//        this.scan = scan;
//    }
    
    public String getUsername()
    {
        return getInput();
    }
    
    public String getPassword()
    {
        return getInput();   
    }
    
    public String getInput()
    {
        return scan.nextLine();
//        return null;
    }

//    public Scanner getScan()
//    {
//        return scan;
//    }

    public void setScan(Scanner scan)
    {
        this.scan = scan;
    }
}
