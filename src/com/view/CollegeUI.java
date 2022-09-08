package com.view;

import com.controller.CollegeLogin;
import com.controller.CollegeStrategy;
import com.controller.Login;
import com.controller.Strategy;
import com.model.*;

import java.util.ArrayList;
import java.util.Scanner;

public class CollegeUI implements Menu{
    Scanner sc=new Scanner(System.in);
    private CollegeList collegeList;

    public CollegeUI(CollegeList collegeList) {
        this.collegeList=collegeList;
    }

    public String getUserName() {
        /*System.out.println("Enter Username:");
        return sc.nextLine();*/
        while(true){
            //sc.nextLine();
            System.out.println("Enter Username(mail id):");
            if(sc.hasNext("\\b[\\w.%-]+@[-.\\w]+\\.[A-Za-z]{2,4}\\b")){
                return sc.nextLine();
            }else{
                System.out.println("Enter valid Email id!!!");
                sc.nextLine();
            }
        }
    }

    public String getPassword() {
        System.out.println("Enter Password:");
        return sc.nextLine();
    }

    public void displayCollegeDetails(College college) {
        if(college!=null){
            System.out.println("Counselling Code: " + college.getCounsellingCode() +
                    "\nCollege Name: " + college.getCollegeName() +
                    "\nMail id: " + college.getMail() +
                    "\nDistrict: " + college.getDistrict());
        }else{
            System.out.println("No records found");
        }
    }

    public int getCollegeMenuOption() {
        while(true){
            System.out.println("\n1. View College Details\n2. View Department wise Details\n3. View Admitted Students\n4. Logout");
            if(sc.hasNext("[1-4]")){
                return sc.nextInt();
            }
            else{
                System.out.println("Enter the valid option");
                sc.next();
            }
        }
    }

    public void displayDepartmentWiseDetails(College college) {
        for(Department department:college.getDepartments()){
            System.out.println("\nDepartment Name: " + department.getDeptName()+
                    "\nApproved Intake: " + department.getApprovedIntake() +
                    "\nAvailable Seats:" + department.getAvailableSeats() +
                    "\nFilled seats: " + department.getFilledSeats());
            System.out.println("Category\tApprovedIntake\tAvailable Seats");
            for(ReservationCommunity reservationCommunity :department.getCommunityWiseList()){
                System.out.println(reservationCommunity.getCommunityType()+"\t\t\t"+ reservationCommunity.getApprovedIntake()+"\t\t\t\t"+ reservationCommunity.getAvailableSeats());
            }
        }
    }

    public void displayAdmittedStudents(ArrayList<Candidate> admittedCandidates) {
        if(admittedCandidates.isEmpty()){
            System.out.println("No records found");
        }else{
            System.out.println("ApplicationNo\tName\tDepartment\tQuota\t\t\tAdmissionID");
            for(Candidate candidate : admittedCandidates){
                System.out.println(candidate.getFinalAllotment().getApplicationNo()+"\t\t"+ candidate.getName()+"\t\t"+ candidate.getFinalAllotment().getDepartment()+"\t\t\t"+ candidate.getFinalAllotment().getQuota()+"\t"+ candidate.getFinalAllotment().getAdmissionID());
            }
        }
    }

    public void displayLandingPage() {
        System.out.println("***College***");
        System.out.println("Institutional login");
        String userName = this.getUserName();
        String password = this.getPassword();
        Login collegeLogin =new CollegeLogin();
        if (collegeLogin.login(userName, password)) {
            System.out.println("Login successful");
            Strategy collegeStrategy = new CollegeStrategy(this,collegeList,userName);
            collegeStrategy.execute();
        }else{
            System.out.println("Invalid login credentials");
        }
    }

    @Override
    public int getOption() {
        return this.getCollegeMenuOption();
    }
}
