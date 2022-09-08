package com.model;

import com.Enum.DepartmentName;

import java.util.ArrayList;


public class ChoiceList {
    private int remainingChoice =3;
    private int priority=1;
    private ArrayList<Choice> choices =new ArrayList<>();
    private boolean locked=false;

    public boolean isLocked() {
        return locked;
    }

    public boolean isAvailable(int counsellingCode, DepartmentName department){
        //returns true if the college is present in the choice list else false
        for (Choice choice : choices) {
            if(choice.getDepartmentName().equals(department)&&counsellingCode== choice.getCounsellingCode())
                return true;
        }
        return false;
    }

    public ArrayList<Choice> getPreferredChoices() {
        //returns preference list
        return choices;
    }

    public int getRemainingChoice() {
        return remainingChoice;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public void decrementRemainingChoice() {
        this.remainingChoice = remainingChoice-1;
    }

    public void incrementRemainingChoice() {
        this.remainingChoice = remainingChoice+1;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public void setChoices(ArrayList<Choice> choices) {
        this.choices = choices;
    }
}
