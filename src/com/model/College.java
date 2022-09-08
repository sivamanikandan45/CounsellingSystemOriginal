package com.model;

import com.Enum.CollegeType;
import com.Enum.CommunityType;
import com.Enum.DepartmentName;

import java.util.ArrayList;
import java.util.HashMap;

public class College {
    private int counsellingCode;
    private String collegeName;
    private ArrayList<Department> departments;
    private ArrayList<Candidate> admittedCandidates;
    private String district;
    private CollegeType type;
    private String mail;

    public College(int counsellingCode, String collegeName, ArrayList<Department> departments, ArrayList<Candidate> admittedCandidates, String district, CollegeType type, String mail){
        //initializes the college details
        this.counsellingCode=counsellingCode;
        this.collegeName=collegeName;
        this.departments=departments;
        this.admittedCandidates = admittedCandidates;
        this.district=district;
        this.type= type;
        this.mail=mail;
    }

public College(){

}
    public int getCounsellingCode() {
        //returns counselling code of the college
        return counsellingCode;
    }

    public String getCollegeName() {
        //returns name of the college
        return collegeName;
    }

    public Department getDept(DepartmentName deptName) {
        //returns the details of the department
        for (Department department: departments) {
            if(department.getDeptName()==deptName){
                return department;
            }
        }
        return null;
    }

    public CollegeType getType() {
        //returns college category
        return type;
    }

    public HashMap getSeatAvailability(CommunityType community) {
        //returns seat availability in each department
        HashMap<DepartmentName, HashMap> departmentSeats = new HashMap<>();
        for(Department department:departments){
            HashMap<CommunityType, Integer> seats = new HashMap<>();
            seats.put(CommunityType.OC,department.getVacancy(CommunityType.OC));
            seats.put(community,department.getVacancy(community));
            departmentSeats.put(department.getDeptName(),seats);
        }
        return departmentSeats;
    }

    public ArrayList<Department> getDepartments() {
        return departments;
    }

    public ArrayList<Candidate> getAdmittedStudents() {
        return admittedCandidates;
    }

    public boolean addStudent(Candidate candidate){
        //adds student to the admitted student list of the college and returns true
        admittedCandidates.add(candidate);
        return true;
    }

    public String getMail() {
        return mail;
    }

    public String getDistrict() {
        return district;
    }
}
