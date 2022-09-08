package com.view;

import com.controller.*;
import com.model.*;

import java.util.Scanner;

public class AdminUI implements Menu{
    Scanner sc=new Scanner(System.in);
    private CandidateList candidateList;
    private CollegeList collegeList;
    private AllotmentMenu allotmentMenu;
    private AdminState state;

    public AdminUI(CandidateList candidateList, CollegeList collegeList, AllotmentMenu handler, AdminState state) {
        this.candidateList=candidateList;
        this.collegeList=collegeList;
        this.state=state;
        this.allotmentMenu =handler;
    }

    public String getUserName() {
        System.out.println("Enter Username:");
        return sc.nextLine();
    }

    public String getPassword() {
        System.out.println("Enter Password:");
        return sc.nextLine();
    }

    public int getCollegeCode() {
        while(true){
            System.out.println("Enter the Counselling code of the college:");
            if(sc.hasNext("[0-9][0-9][0-9][0-9]")){
                return sc.nextInt();
            }
            else{
                System.out.println("Enter the valid option");
                sc.next();
            }
        }
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

    public int getAdminMenuOption() {
        while(true){
            System.out.println("\n1. Add College\n2. View College Details\n3. View All Students\n4. View All Colleges\n5. Generate Cutoff\n6. Generate Random number\n7. Generate Rank\n8. Allocate Seat\n9. View Final Allotment Details\n10. Logout");
            if(sc.hasNext("[0-1]?[0-9]")){
                return sc.nextInt();
            }
            else{
                System.out.println("Enter the valid option");
                sc.next();
            }
        }
    }

    public void displayCollegeList(CollegeList colleges) {
        System.out.println("CounsellingCode\tName\tMail\t\tDistrict");
        for(College college:colleges.getCollegeList()){
            System.out.println(college.getCounsellingCode()+"\t\t\t"+college.getCollegeName()+"\t\t"+college.getMail()+"\t"+college.getDistrict());
        }
    }

    public void displayStudentList(CandidateList candidates) {
        System.out.println("ApplicationNo\tRank\tName\tCategory\tCutOff\tTotalMark\tDOB\t\t\tRandomNo");
        for(Candidate candidate :candidates.getCandidateList()){
            System.out.println(candidate.getApplicationNo()+"\t\t"+ candidate.getRank()+"\t\t"+ candidate.getName()+"\t"+ candidate.getCommunity()+"\t\t\t"+ candidate.getCutoff()+"\t"+candidate.getTotalMark()+"\t\t"+candidate.getDob()+"\t"+ candidate.getAcademicDetails().getRandomNo());
        }
    }

    public void displayLandingPage() {
        System.out.println("Admin login");
        String userName = this.getUserName();
        String password = this.getPassword();
        Login adminLogin =new AdminLogin();
        if (adminLogin.login(userName, password)) {
            System.out.println("Login successful");
            Strategy adminStrategy=new AdminStrategy(this,candidateList,collegeList, allotmentMenu,state);
            adminStrategy.execute();
        } else {
        System.out.println("Invalid login credentials");
        }
    }

    @Override
    public int getOption() {
        return this.getAdminMenuOption();
    }
}
