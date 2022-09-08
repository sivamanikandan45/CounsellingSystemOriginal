package com.controller;

import java.io.IOException;

public class CollegeRegister extends Register {
    private Authenticator authenticator=new Authenticator("college.properties");
    @Override
    public boolean registerAccount(String username, String password) {
        try{
            return authenticator.addUserCredentials(username,password);
        }
        catch(IOException obj){
            return false;
        }
    }
}
