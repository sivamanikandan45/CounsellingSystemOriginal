package com.model;

import com.Enum.DepartmentName;

public class Choice {
    private int priority;
    private int counsellingCode;
    private String collegeName;
    private DepartmentName departmentName;

    public Choice(int priority, int counsellingCode, String collegeName, DepartmentName departmentName){
        //initializes the Choice details
        this.priority =priority;
        this.counsellingCode=counsellingCode;
        this.collegeName=collegeName;
        this.departmentName=departmentName;
    }

    public String getCollegeName() {
        //returns college Name in the choice
        return collegeName;
    }

    public DepartmentName getDepartmentName() {
        //returns Department name in the Choice
        return departmentName;
    }

    public int getPriority() {
        //returns priority of the Choice
        return priority;
    }

    public int getCounsellingCode() {
        //returns counselling code in the Choice
        return counsellingCode;
    }

    public void setPriority(int priority) {
        //sets priority for the Choice
        this.priority = priority;
    }
}
