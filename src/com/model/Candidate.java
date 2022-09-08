package com.model;

import com.Enum.CommunityType;

import java.text.SimpleDateFormat;
import java.util.HashMap;

public class Candidate {
    private String mailId;
    private int applicationNo=(int)(Math.random()*(Integer.MAX_VALUE-10000000+1)+10000000);
    private PersonalDetails personalDetails;
    private AcademicDetails academicDetails;
    private boolean applicationFilled=false;

    private HashMap<College,HashMap> tentativeAllotment=new HashMap<>();//
    private boolean tentativeAllotmentAssigned=false;
    private boolean tentativeAccepted;
    private boolean tentativeConfirmed =false;

    private ChoiceList myChoices=new ChoiceList();
    private Allotment finalAllotment=null;

    public Candidate(){

    }

    public Candidate(PersonalDetails personalDetails, AcademicDetails academicDetails, String mailId){
        this.setPersonalDetails(personalDetails);
        this.setAcademicDetails(academicDetails);
        this.mailId=mailId;
        applicationFilled=true;
    }

    public boolean acceptOffer(){
        //accepts offer and return true
        tentativeAccepted=true;
        tentativeConfirmed =true;
        return true;
    }

    public boolean rejectOffer(){
        //rejects offer and returns true
        tentativeAccepted=false;
        tentativeConfirmed =true;
        return true;
    }

    public void setPersonalDetails(PersonalDetails personalDetails) {
        //sets personal details of the student
        this.personalDetails = personalDetails;
    }

    public void setAcademicDetails(AcademicDetails academicDetails) {
        //sets Academic details of the student
        this.academicDetails = academicDetails;
        applicationFilled=true;
    }

    public double getCutoff() {
        //returns cutoff of the student
        return academicDetails.getCutoff();
    }

    public HashMap<College, HashMap> getTentativeAllotment() {
        //returns tentative allotment of the student
        return tentativeAllotment;
    }

    public ChoiceList getMyChoices() {
        //returns choice list
        return myChoices;
    }

    public boolean isApplicationFilled() {
        //returns true if the application is filled
        return applicationFilled;
    }

    public void setTentativeAllotment(HashMap tentativeAllotment) {
        //initializes tentative allotment
        this.tentativeAllotment = tentativeAllotment;
        this.tentativeAllotmentAssigned=true;
    }
    public String getName(){
        //returns name of the student
        return this.personalDetails.getName();
    }
    public CommunityType getCommunity(){
        //returns community of the student
        return this.personalDetails.getCommunityType();
    }

    public int getApplicationNo() {
        //returns application number of the student
        return applicationNo;
    }

    public void setMailId(String mailId) {
        this.mailId = mailId;
    }

    public String getMailId() {
        return mailId;
    }

    public boolean isTentativeAccepted() {
        return tentativeAccepted;
    }

    public boolean isTentativeConfirmed() {
        return tentativeConfirmed;
    }

    public void setFinalAllotment(Allotment finalAllotment) {
        this.finalAllotment = finalAllotment;
    }

    public Allotment getFinalAllotment() {
        return finalAllotment;
    }

    public int getRank() {
        return academicDetails.getRank();
    }

    public String getDob(){
        SimpleDateFormat formatter=new SimpleDateFormat("dd/MM/yyyy");
        return formatter.format(personalDetails.getDob());
    }

    public double getTotalMark(){
        return this.academicDetails.getTotalMarks();
    }

    public AcademicDetails getAcademicDetails() {
        return academicDetails;
    }

    public PersonalDetails getPersonalDetails() {
        return personalDetails;
    }

    public boolean isTentativeAllotmentAssigned() {
        return tentativeAllotmentAssigned;
    }

    public int getRandomNo(){
        return academicDetails.getRandomNo();
    }
}
