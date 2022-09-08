package com.controller;

import com.Enum.DepartmentName;
import com.model.*;

import java.util.ArrayList;

public class ChoiceListHandler implements ChoiceListMenu{
    private int priority = 1;

    public boolean addChoice(Candidate candidate, CollegeList colleges, int counsellingCode, DepartmentName department) {
        //adds choice to the choice list and returns true if successful
        College college = null;
        ChoiceList choiceList = candidate.getMyChoices();
        if (choiceList.getRemainingChoice() != 0) {
            for (College college1 : colleges.getCollegeList()) {
                if (college1.getCounsellingCode() == counsellingCode) {
                    college = college1;
                }
            }
            if (college != null) {
                if (!choiceList.isAvailable(counsellingCode, department)) {
                    choiceList.getPreferredChoices().add(new Choice(priority, counsellingCode, college.getCollegeName(), department));
                    choiceList.setPriority(++priority);
                    choiceList.decrementRemainingChoice();
                    return true;
                } else {
                    return false;
                }
            }
        } else {
            return false;
        }
        return false;
    }

    public boolean removeChoice(Candidate candidate, int counsellingCode, DepartmentName dept) {
        //removes choice from the choice list and returns true if successful
        ChoiceList choices = candidate.getMyChoices();
        for (Choice choice : choices.getPreferredChoices()) {
            if (choice.getDepartmentName().equals(dept) && counsellingCode == choice.getCounsellingCode()) {
                choices.getPreferredChoices().remove(choice);
                choices.incrementRemainingChoice();
                this.reAllocatePriority(choices.getPreferredChoices());
                return true;
            }
        }
        return false;
    }

    public void reAllocatePriority(ArrayList<Choice> choices) {
        //reallocates priority in the choice list
        int priority = 0;
        for (Choice choice : choices) {
            choice.setPriority(++priority);
        }
        this.priority = ++priority;
    }

    public boolean reOrderChoice(Candidate candidate,int[] newOrder) {
        //reorders choice in the choice list
        ChoiceList choiceList=candidate.getMyChoices();
        ArrayList<Choice> choices=choiceList.getPreferredChoices();
        ArrayList<Choice> temp=new ArrayList<>();
        try{
            for (int j : newOrder) {
                temp.add(choices.get(j - 1));
            }
        }catch(ArrayIndexOutOfBoundsException e){
            //
        }
        this.reAllocatePriority(temp);
        choiceList.setChoices(temp);
        return true;
    }

    public boolean lockChoice(CollegeList collegeList, Candidate candidate) {
        //locks the choice list
        ChoiceList choiceList=candidate.getMyChoices();
        if (!choiceList.getPreferredChoices().isEmpty()) {
            choiceList.setLocked(true);
            return true;
        }
        return false;
    }
    public boolean isLocked(Candidate candidate) {
        return candidate.getMyChoices().isLocked();
    }


    public boolean isEmpty(Candidate candidate) {
        return  candidate.getMyChoices().getPreferredChoices().isEmpty();
    }


    public ArrayList<Choice> getPreferredChoices(Candidate candidate) {
        return candidate.getMyChoices().getPreferredChoices();
    }
}
