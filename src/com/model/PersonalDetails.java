package com.model;

import com.Enum.CommunityType;

import java.util.Date;

public class PersonalDetails {
    private String name;
    private Date dob;
    private CommunityType communityType;

    public PersonalDetails(String name, Date dob, CommunityType communityType){
        //initializes the personal details of the student
        this.name=name;
        this.dob=dob;
        this.communityType =communityType;
    }

    public Date getDob() {
        //returns DOB of the student
        return dob;
    }

    public String getName() {
        //returns Name of the student
        return name;
    }

    public CommunityType getCommunityType() {
        //returns community of the student
        return communityType;
    }
}
