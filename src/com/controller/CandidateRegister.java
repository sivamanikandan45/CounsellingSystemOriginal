package com.controller;

import java.io.IOException;

public class CandidateRegister extends Register {
    private Authenticator authenticator;
    @Override
    public boolean registerAccount(String uname, String pass) {
        //Registers a new user and uname and password as an array
        authenticator =new Authenticator("candidate.properties");
        try{
            return authenticator.addUserCredentials(uname, pass);
        }
        catch(IOException obj){
            return false;
        }
    }
}
