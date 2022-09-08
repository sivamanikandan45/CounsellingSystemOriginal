package com.model;

import com.Enum.CollegeType;
import com.Enum.CommunityType;
import com.Enum.DepartmentName;

import java.util.UUID;

public class Allotment {
    private int applicationNo;
    private String candidateName;
    private CommunityType communityType;
    private CollegeType type;
    private DepartmentName departmentName;
    private String collegeName;
    private String quota;
    private UUID admissionID;

    public Allotment(int applicationNo, String candidateName, CommunityType communityType, String collegeName, DepartmentName departmentName, CollegeType type, CommunityType quota){
        //initializes the Allotment details
        this.applicationNo=applicationNo;
        this.candidateName = candidateName;
        this.communityType = communityType;
        this.departmentName =departmentName;
        this.collegeName =collegeName;
        this.type = type;
        this.quota=quota+"-ACADEMIC";
        this.admissionID=UUID.randomUUID();
    }

    @Override
    public String toString() {
        return "***Allotment***" +
                "\nApplication No: " + applicationNo +
                "\nCandidate Name: " + candidateName +
                "\nCommunity: " + communityType +
                "\nCategory: " + type +
                "\nCourse: " + departmentName +
                "\nCollege: " + collegeName +
                "\nQuota: " + quota  +
                "\nAdmission ID: " + admissionID;
    }

    public String getQuota() {
        return quota;
    }

    public UUID getAdmissionID() {
        return admissionID;
    }

    public int getApplicationNo() {
        return applicationNo;
    }

    public DepartmentName getDepartment() {
        return departmentName;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public String getCollegeName() {
        return collegeName;
    }
}
