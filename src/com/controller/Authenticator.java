package com.controller;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class Authenticator {
    private Set set;
    private Properties properties =new Properties();

    private FileReader readableFile;
    private FileWriter writableFile;

    public Authenticator(String filename){
        //loads the DB(Properties file)
        try{
        readableFile =new FileReader(filename);
        properties.load(readableFile);
        set = properties.entrySet();
        writableFile = new FileWriter(filename,true);
        }
        catch (Exception obj){
            obj.printStackTrace();
        }
    }

    public boolean isValid(String userName,String password) throws IOException {
        //returns true of the Credentials present in the file else false
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry)iterator.next();
            if(entry.getKey().equals(userName)&&entry.getValue().equals(password)){
                return true;
            }
        }
        return false;
    }

    public boolean addUserCredentials(String userName, String password) throws IOException {
        //adds new Candidate's credentials into the file and returns true
        writableFile.write("\n"+userName+"="+password);
        writableFile.close();
        return true;
    }

}
