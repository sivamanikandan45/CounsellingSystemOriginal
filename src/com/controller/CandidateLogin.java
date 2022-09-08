package com.controller;

import java.io.IOException;

public class CandidateLogin extends Login {
    @Override
    public boolean login(String userName, String password) {
        Authenticator authenticator =new Authenticator("candidate.properties");
        //allows user to log in to the system
        try{
            return authenticator.isValid(userName, password);
        }
        catch(IOException e){
            return false;
        }
    }
}
