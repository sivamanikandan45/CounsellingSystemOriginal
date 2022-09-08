package com.controller;

import com.Enum.CollegeType;
import com.Enum.CommunityType;
import com.Enum.DepartmentName;
import com.model.Allotment;
import com.model.Candidate;
import com.model.College;

import java.util.ArrayList;

public interface AllotmentMenu {
    void handleConfirmedAllotment(Candidate candidate, String collegeName, DepartmentName department, CommunityType category, CollegeType type, College college);
    void handleRejectedAllotment(Candidate candidate);
    boolean isEmptyAllotmentList();
    ArrayList<Allotment> getSeatAllottedStudents();
}
