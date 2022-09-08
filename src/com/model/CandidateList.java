package com.model;

import com.Enum.CommunityType;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class CandidateList {
    private ArrayList<Candidate> candidateList;
    private SimpleDateFormat formatter=new SimpleDateFormat("dd/MM/yyyy");

    public CandidateList(){
        candidateList=new ArrayList<Candidate>(){
            {
                try{
                add(new Candidate(new PersonalDetails("John",formatter.parse("12/01/2000"), CommunityType.BC),new AcademicDetails(12345678,false,186,189,200,1150),"john@gmail.com"));
                add(new Candidate(new PersonalDetails("John",formatter.parse("12/01/2000"), CommunityType.BC),new AcademicDetails(12345678,false,186,189,200,1150),"john1@gmail.com"));
                add(new Candidate(new PersonalDetails("Jill",formatter.parse("12/01/2001"), CommunityType.MBCV),new AcademicDetails(12345678,false,186,189,200,1150),"jill@gmail.com"));
                add(new Candidate(new PersonalDetails("Jack",formatter.parse("02/02/2001"), CommunityType.OC),new AcademicDetails(13345678,false,185,187,195,1137),"jack@gmail.com"));
                add(new Candidate(new PersonalDetails("Jeff",formatter.parse("11/04/2001"), CommunityType.DNC),new AcademicDetails(56785678,true,186,184,187,1114),"jeff@gmail.com"));
                add(new Candidate(new PersonalDetails("Joel",formatter.parse("04/01/2001"), CommunityType.SCA),new AcademicDetails(12348765,true,190,109,187,972),"joel@gmail.com"));
                add(new Candidate(new PersonalDetails("Jacob",formatter.parse("24/06/2001"), CommunityType.BC),new AcademicDetails(12654378,false,170,199,200,1138),"jacob@gmail.com"));
                add(new Candidate(new PersonalDetails("Jose",formatter.parse("12/01/2001"), CommunityType.ST),new AcademicDetails(12345678,true,186,189,200,1150),"jim@gmail.com"));
                }catch(ParseException e){
                    System.out.println("Error while Parsing...");
                }
            }
        };
    }

    public ArrayList<Candidate> getCandidateList() {
        return candidateList;
    }

    public boolean addCandidate(Candidate candidate) {
        //adds new candidate to the candidate list after filling the application
        this.candidateList.add(candidate);
        return true;
    }

    public boolean isCandidateAvailable(String userName) {
        //returns true if the candidate available in the candidate list else returns false
        for (Candidate candidate : candidateList) {
            if(candidate.getMailId().equals(userName)){
                return true;
            }
        }
        return false;
    }

    public Candidate getCandidateData(String mail){
        //returns object of the candidate who filled the application
        for (Candidate candidate : candidateList) {
            if(candidate.getMailId().equals(mail)){
                return candidate;
            }
        }
        return new Candidate();
    }

}
