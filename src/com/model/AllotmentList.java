package com.model;

import java.util.ArrayList;

public class AllotmentList {
    private ArrayList<Allotment> seatAllottedStudents=new ArrayList<>();
    public ArrayList<Allotment> getSeatAllottedStudents() {
        return new ArrayList<>(seatAllottedStudents);
    }
    public boolean isEmpty(){
        return seatAllottedStudents.isEmpty();
    }
    public void addAllotment(Allotment newAllotment){
        seatAllottedStudents.add(newAllotment);
    }

}
