package com.model;

import com.Enum.CommunityType;

public class ReservationCommunity {
    private CommunityType communityType;
    private int approvedIntake;
    private int availableSeats;
    public ReservationCommunity(CommunityType communityType, int approved, int vacancy){
        //initializes the category wise details
        approvedIntake=approved;
        this.communityType = communityType;
        availableSeats=vacancy;
    }

    public CommunityType getCommunityType() {
        //returns name of the Category
        return communityType;
    }

    public int getAvailableSeats() {
        //returns count of the available seats
        return availableSeats;
    }

    public int getApprovedIntake() {
        //returns count of approved Intake of the Category
        return approvedIntake;
    }

    public void updateAvailableSeats() {
        //updates count of available seats of the Category
        this.availableSeats = availableSeats-1;
    }
}
