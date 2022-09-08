package com.controller;

import com.model.*;
import com.Enum.CollegeOption;
import com.view.CollegeUI;

import java.util.ArrayList;

public class CollegeStrategy implements Strategy{
    private final CollegeUI ui;
    private CollegeList collegeList;
    private String userName;
    public CollegeStrategy(CollegeUI collegeUI, CollegeList collegeList, String userName) {
        this.ui = collegeUI;
        this.collegeList=collegeList;
        this.userName=userName;
    }

    @Override
    public void execute() {
        /*System.out.println("***College***");
        System.out.println("Institutional login");
        String userName = ui.getUserName();
        String password = ui.getPassword();
        Login collegeLogin =new CollegeLogin();
        if (collegeLogin.login(userName, password)) {
            College college=collegeList.getCollegeData(userName);
            System.out.println("Login successful");*/
            College college=collegeList.getCollegeData(userName);
            label:
            while (true) {
                int collegeMenuOption = ui.getOption();
                CollegeOption option=CollegeOption.values()[collegeMenuOption-1];
                switch (option) {
                    case DISPLAY_DETAILS:
                        ui.displayCollegeDetails(college);
                        break;
                    case DISPLAY_DEPT_DETAILS:
                        ui.displayDepartmentWiseDetails(college);
                        break;
                    case VIEW_ADMITTED_STUDENTS:
                        ArrayList<Candidate> admittedCandidate = college.getAdmittedStudents();
                        ui.displayAdmittedStudents(admittedCandidate);
                        break;
                    case LOGOUT:
                        break label;
                }
            }
        /*} else {
            System.out.println("Invalid login credentials");
        }*/
    }
}