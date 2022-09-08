package com.controller;

import com.Enum.CollegeType;
import com.Enum.CommunityType;
import com.Enum.DepartmentName;
import com.model.*;

import java.util.ArrayList;

public class AllotmentHandler implements AllotmentMenu {
    private AllotmentList allotmentList=new AllotmentList();
    public void handleConfirmedAllotment(Candidate candidate, String collegeName, DepartmentName department, CommunityType category, CollegeType type, College college) {
        college.addStudent(candidate);
        Department allottedDepartment= college.getDept(department);
        ReservationCommunity allottedDeptReservationCommunity =allottedDepartment.getReservationCommunity(category);
        allottedDeptReservationCommunity.updateAvailableSeats();
        allottedDepartment.updateAvailableSeats();
        allottedDepartment.updateFilledSeats();
        Allotment newAllotment=new Allotment(candidate.getApplicationNo(), candidate.getName(), candidate.getCommunity(), collegeName, department, type, category);
        //candidate.setFinalAllotment(new Allotment(candidate.getApplicationNo(), candidate.getName(), candidate.getCommunity(),collegeName,department,type,category));
        candidate.setFinalAllotment(newAllotment);
        allotmentList.addAllotment(newAllotment);
    }

    public boolean isEmptyAllotmentList() {
        return allotmentList.isEmpty();
    }

    public ArrayList<Allotment> getSeatAllottedStudents() {
        return allotmentList.getSeatAllottedStudents();
    }

    public void handleRejectedAllotment(Candidate candidate) {
        candidate.rejectOffer();
    }

}
