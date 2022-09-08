package com.controller;

import java.io.IOException;

public class AdminLogin extends Login {
    @Override
    public boolean login(String userName, String password) {
        //allows admin to login into the system and returns true
        Authenticator authenticator =new Authenticator("admin.properties");
        try{
            return authenticator.isValid(userName, password);
        }
        catch(IOException e){
            return false;
        }
    }
}
