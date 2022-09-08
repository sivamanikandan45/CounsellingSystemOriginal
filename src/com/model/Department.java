package com.model;

import com.Enum.CommunityType;
import com.Enum.DepartmentName;

import java.util.ArrayList;

public class Department {
    private DepartmentName deptName;
    private int approvedIntake;
    private int availableSeats;
    private int filledSeats;
    private ArrayList<ReservationCommunity> reservationCommunityWiseList;

    public Department(DepartmentName deptName,int approvedIntake,int availableSeats,int filledSeats,ArrayList<ReservationCommunity> reservationCommunityWiseList){
        //initializes the department details
        this.deptName=deptName;
        this.approvedIntake =approvedIntake;
        this.availableSeats =availableSeats;
        this.filledSeats =filledSeats;
        this.reservationCommunityWiseList =reservationCommunityWiseList;
    }

    public DepartmentName getDeptName() {
        //returns department name
        return deptName;
    }

    public int getVacancy(CommunityType communityType) {
        //returns seat availability for each category in the department
        for(ReservationCommunity reservationCommunity : reservationCommunityWiseList){
            if(communityType.equals(reservationCommunity.getCommunityType())){
                return reservationCommunity.getAvailableSeats();
            }
        }
        return 0;
    }
    public ReservationCommunity getReservationCommunity(CommunityType communityType) {
        //returns community
        for(ReservationCommunity reservationCommunity: reservationCommunityWiseList){
            if(communityType.equals(reservationCommunity.getCommunityType())){
                return reservationCommunity;
            }
        }
       return null;
    }

    public ArrayList<ReservationCommunity> getCommunityWiseList() {
        return reservationCommunityWiseList;
    }

    public int getApprovedIntake() {
        return approvedIntake;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public int getFilledSeats() {
        return filledSeats;
    }

    public void updateAvailableSeats() {
        availableSeats=availableSeats-1;
    }

    public void updateFilledSeats() {
        filledSeats=filledSeats+1;
    }
}
