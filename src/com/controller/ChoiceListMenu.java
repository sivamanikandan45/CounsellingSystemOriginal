package com.controller;

import com.Enum.DepartmentName;
import com.model.Candidate;
import com.model.Choice;
import com.model.CollegeList;

import java.util.ArrayList;

public interface ChoiceListMenu {
    boolean addChoice(Candidate candidate, CollegeList colleges, int counsellingCode, DepartmentName department);
    boolean removeChoice(Candidate candidate, int counsellingCode, DepartmentName dept);
    void reAllocatePriority(ArrayList<Choice> choices);
    boolean reOrderChoice(Candidate candidate,int[] newOrder);
    boolean lockChoice(CollegeList collegeList, Candidate candidate);
    boolean isLocked(Candidate candidate);
    boolean isEmpty(Candidate candidate);
    ArrayList<Choice> getPreferredChoices(Candidate candidate);
}
