package com.model;

import com.Enum.CollegeType;
import com.Enum.CommunityType;
import com.Enum.DepartmentName;

import java.util.ArrayList;

public class CollegeList {
    private ArrayList<College> collegeList =new ArrayList<>();
    public CollegeList(){
        ArrayList<Candidate> sjceAdmittedCandidates =new ArrayList<>();
        ArrayList<Candidate> rmkAdmittedCandidates =new ArrayList<>();
        ArrayList<Candidate> coeAdmittedCandidates =new ArrayList<>();

        ArrayList<ReservationCommunity> sjceCseReservation=new ArrayList<ReservationCommunity>(){{
            add(new ReservationCommunity(CommunityType.OC,19,19));
            add(new ReservationCommunity(CommunityType.BC,16,16));
            add(new ReservationCommunity(CommunityType.BCM,2,2));
            add(new ReservationCommunity(CommunityType.MBCV,6,6));
            add(new ReservationCommunity(CommunityType.DNC,4,4));
            add(new ReservationCommunity(CommunityType.MBC,2,2));
            add(new ReservationCommunity(CommunityType.SC,9,9));
            add(new ReservationCommunity(CommunityType.SCA,1,1));
            add(new ReservationCommunity(CommunityType.ST,1,1));
        }};
        ArrayList<ReservationCommunity> sjceItReservation=new ArrayList<ReservationCommunity>(){{
            add(new ReservationCommunity(CommunityType.OC,19,19));
            add(new ReservationCommunity(CommunityType.BC,16,16));
            add(new ReservationCommunity(CommunityType.BCM,2,2));
            add(new ReservationCommunity(CommunityType.MBCV,6,6));
            add(new ReservationCommunity(CommunityType.DNC,4,4));
            add(new ReservationCommunity(CommunityType.MBC,2,2));
            add(new ReservationCommunity(CommunityType.SC,9,9));
            add(new ReservationCommunity(CommunityType.SCA,1,1));
            add(new ReservationCommunity(CommunityType.ST,1,1));
        }};
        ArrayList<ReservationCommunity> sjceCivilReservation=new ArrayList<ReservationCommunity>(){{
            add(new ReservationCommunity(CommunityType.OC,19,19));
            add(new ReservationCommunity(CommunityType.BC,16,16));
            add(new ReservationCommunity(CommunityType.BCM,2,2));
            add(new ReservationCommunity(CommunityType.MBCV,6,6));
            add(new ReservationCommunity(CommunityType.DNC,4,4));
            add(new ReservationCommunity(CommunityType.MBC,2,2));
            add(new ReservationCommunity(CommunityType.SC,9,9));
            add(new ReservationCommunity(CommunityType.SCA,1,1));
            add(new ReservationCommunity(CommunityType.ST,1,1));
        }};
        ArrayList<ReservationCommunity> sjceMechReservation=new ArrayList<ReservationCommunity>(){{
            add(new ReservationCommunity(CommunityType.OC,19,19));
            add(new ReservationCommunity(CommunityType.BC,16,16));
            add(new ReservationCommunity(CommunityType.BCM,2,2));
            add(new ReservationCommunity(CommunityType.MBCV,6,6));
            add(new ReservationCommunity(CommunityType.DNC,4,4));
            add(new ReservationCommunity(CommunityType.MBC,2,2));
            add(new ReservationCommunity(CommunityType.SC,9,9));
            add(new ReservationCommunity(CommunityType.SCA,1,1));
            add(new ReservationCommunity(CommunityType.ST,1,1));
        }};
        ArrayList<ReservationCommunity> sjceEeeReservation=new ArrayList<ReservationCommunity>(){{
            add(new ReservationCommunity(CommunityType.OC,19,19));
            add(new ReservationCommunity(CommunityType.BC,16,16));
            add(new ReservationCommunity(CommunityType.BCM,2,2));
            add(new ReservationCommunity(CommunityType.MBCV,6,6));
            add(new ReservationCommunity(CommunityType.DNC,4,4));
            add(new ReservationCommunity(CommunityType.MBC,2,2));
            add(new ReservationCommunity(CommunityType.SC,9,9));
            add(new ReservationCommunity(CommunityType.SCA,1,1));
            add(new ReservationCommunity(CommunityType.ST,1,1));
        }};
        ArrayList<ReservationCommunity> sjceEceReservation=new ArrayList<ReservationCommunity>(){{
            add(new ReservationCommunity(CommunityType.OC,37,37));
            add(new ReservationCommunity(CommunityType.BC,32,32));
            add(new ReservationCommunity(CommunityType.BCM,4,4));
            add(new ReservationCommunity(CommunityType.MBCV,13,13));
            add(new ReservationCommunity(CommunityType.DNC,8,8));
            add(new ReservationCommunity(CommunityType.MBC,3,3));
            add(new ReservationCommunity(CommunityType.SC,18,18));
            add(new ReservationCommunity(CommunityType.SCA,4,4));
            add(new ReservationCommunity(CommunityType.ST,1,1));
        }};
        ArrayList<ReservationCommunity> rmkItReservation=new ArrayList<ReservationCommunity>(){{
            add(new ReservationCommunity(CommunityType.OC,19,19));
            add(new ReservationCommunity(CommunityType.BC,16,16));
            add(new ReservationCommunity(CommunityType.BCM,2,2));
            add(new ReservationCommunity(CommunityType.MBCV,6,6));
            add(new ReservationCommunity(CommunityType.DNC,4,4));
            add(new ReservationCommunity(CommunityType.MBC,2,2));
            add(new ReservationCommunity(CommunityType.SC,9,9));
            add(new ReservationCommunity(CommunityType.SCA,1,1));
            add(new ReservationCommunity(CommunityType.ST,1,1));
        }};
        ArrayList<ReservationCommunity> rmkCivilReservation=new ArrayList<ReservationCommunity>(){{
            add(new ReservationCommunity(CommunityType.OC,19,19));
            add(new ReservationCommunity(CommunityType.BC,16,16));
            add(new ReservationCommunity(CommunityType.BCM,2,2));
            add(new ReservationCommunity(CommunityType.MBCV,6,6));
            add(new ReservationCommunity(CommunityType.DNC,4,4));
            add(new ReservationCommunity(CommunityType.MBC,2,2));
            add(new ReservationCommunity(CommunityType.SC,9,9));
            add(new ReservationCommunity(CommunityType.SCA,1,1));
            add(new ReservationCommunity(CommunityType.ST,1,1));
        }};
        ArrayList<ReservationCommunity> rmkEceReservation=new ArrayList<ReservationCommunity>(){{
            add(new ReservationCommunity(CommunityType.OC,56,56));
            add(new ReservationCommunity(CommunityType.BC,48,48));
            add(new ReservationCommunity(CommunityType.BCM,6,6));
            add(new ReservationCommunity(CommunityType.MBCV,19,19));
            add(new ReservationCommunity(CommunityType.DNC,12,12));
            add(new ReservationCommunity(CommunityType.MBC,5,5));
            add(new ReservationCommunity(CommunityType.SC,27,27));
            add(new ReservationCommunity(CommunityType.SCA,5,5));
            add(new ReservationCommunity(CommunityType.ST,2,2));
        }};
        ArrayList<ReservationCommunity> rmkMechReservation=new ArrayList<ReservationCommunity>(){{
            add(new ReservationCommunity(CommunityType.OC,56,56));
            add(new ReservationCommunity(CommunityType.BC,48,48));
            add(new ReservationCommunity(CommunityType.BCM,6,6));
            add(new ReservationCommunity(CommunityType.MBCV,19,19));
            add(new ReservationCommunity(CommunityType.DNC,12,12));
            add(new ReservationCommunity(CommunityType.MBC,5,5));
            add(new ReservationCommunity(CommunityType.SC,27,27));
            add(new ReservationCommunity(CommunityType.SCA,5,5));
            add(new ReservationCommunity(CommunityType.ST,2,2));
        }};
        ArrayList<ReservationCommunity> rmkEeeReservation=new ArrayList<ReservationCommunity>(){{
            add(new ReservationCommunity(CommunityType.OC,56,56));
            add(new ReservationCommunity(CommunityType.BC,48,48));
            add(new ReservationCommunity(CommunityType.BCM,6,6));
            add(new ReservationCommunity(CommunityType.MBCV,19,19));
            add(new ReservationCommunity(CommunityType.DNC,12,12));
            add(new ReservationCommunity(CommunityType.MBC,5,5));
            add(new ReservationCommunity(CommunityType.SC,27,27));
            add(new ReservationCommunity(CommunityType.SCA,5,5));
            add(new ReservationCommunity(CommunityType.ST,2,2));
        }};
        ArrayList<ReservationCommunity> cegCseReservation=new ArrayList<ReservationCommunity>(){{
            add(new ReservationCommunity(CommunityType.OC,19,19));
            add(new ReservationCommunity(CommunityType.BC,16,16));
            add(new ReservationCommunity(CommunityType.BCM,2,2));
            add(new ReservationCommunity(CommunityType.MBCV,6,6));
            add(new ReservationCommunity(CommunityType.DNC,4,4));
            add(new ReservationCommunity(CommunityType.MBC,2,2));
            add(new ReservationCommunity(CommunityType.SC,9,9));
            add(new ReservationCommunity(CommunityType.SCA,1,1));
            add(new ReservationCommunity(CommunityType.ST,1,1));
        }};
        ArrayList<ReservationCommunity> cegItReservation=new ArrayList<ReservationCommunity>(){{
            add(new ReservationCommunity(CommunityType.OC,19,19));
            add(new ReservationCommunity(CommunityType.BC,16,16));
            add(new ReservationCommunity(CommunityType.BCM,2,2));
            add(new ReservationCommunity(CommunityType.MBCV,6,6));
            add(new ReservationCommunity(CommunityType.DNC,4,4));
            add(new ReservationCommunity(CommunityType.MBC,2,2));
            add(new ReservationCommunity(CommunityType.SC,9,9));
            add(new ReservationCommunity(CommunityType.SCA,1,1));
            add(new ReservationCommunity(CommunityType.ST,1,1));
        }};
        ArrayList<ReservationCommunity> cegEceReservation=new ArrayList<ReservationCommunity>(){{
            add(new ReservationCommunity(CommunityType.OC,19,19));
            add(new ReservationCommunity(CommunityType.BC,16,16));
            add(new ReservationCommunity(CommunityType.BCM,2,2));
            add(new ReservationCommunity(CommunityType.MBCV,6,6));
            add(new ReservationCommunity(CommunityType.DNC,4,4));
            add(new ReservationCommunity(CommunityType.MBC,2,2));
            add(new ReservationCommunity(CommunityType.SC,9,9));
            add(new ReservationCommunity(CommunityType.SCA,1,1));
            add(new ReservationCommunity(CommunityType.ST,1,1));
        }};
        ArrayList<ReservationCommunity> cegCivilReservation=new ArrayList<ReservationCommunity>(){{
            add(new ReservationCommunity(CommunityType.OC,19,19));
            add(new ReservationCommunity(CommunityType.BC,16,16));
            add(new ReservationCommunity(CommunityType.BCM,2,2));
            add(new ReservationCommunity(CommunityType.MBCV,6,6));
            add(new ReservationCommunity(CommunityType.DNC,4,4));
            add(new ReservationCommunity(CommunityType.MBC,2,2));
            add(new ReservationCommunity(CommunityType.SC,9,9));
            add(new ReservationCommunity(CommunityType.SCA,1,1));
            add(new ReservationCommunity(CommunityType.ST,1,1));
        }};
        ArrayList<ReservationCommunity> cegEeeReservation=new ArrayList<ReservationCommunity>(){{
            add(new ReservationCommunity(CommunityType.OC,19,19));
            add(new ReservationCommunity(CommunityType.BC,16,16));
            add(new ReservationCommunity(CommunityType.BCM,2,2));
            add(new ReservationCommunity(CommunityType.MBCV,6,6));
            add(new ReservationCommunity(CommunityType.DNC,4,4));
            add(new ReservationCommunity(CommunityType.MBC,2,2));
            add(new ReservationCommunity(CommunityType.SC,9,9));
            add(new ReservationCommunity(CommunityType.SCA,1,1));
            add(new ReservationCommunity(CommunityType.ST,1,1));
        }};
        ArrayList<ReservationCommunity> cegMechReservation=new ArrayList<ReservationCommunity>(){{
            add(new ReservationCommunity(CommunityType.OC,37,37));
            add(new ReservationCommunity(CommunityType.BC,32,32));
            add(new ReservationCommunity(CommunityType.BCM,4,4));
            add(new ReservationCommunity(CommunityType.MBCV,13,13));
            add(new ReservationCommunity(CommunityType.DNC,8,8));
            add(new ReservationCommunity(CommunityType.MBC,3,3));
            add(new ReservationCommunity(CommunityType.SC,18,18));
            add(new ReservationCommunity(CommunityType.SCA,4,4));
            add(new ReservationCommunity(CommunityType.ST,1,1));
        }};

        ArrayList<Department> sjceDepartmentList=new ArrayList<Department>(){{
            add(new Department(DepartmentName.CSE,60,60,0,sjceCseReservation));
            add(new Department(DepartmentName.ECE,120,120,0,sjceEceReservation));
            add(new Department(DepartmentName.IT,60,60,0,sjceItReservation));
            add(new Department(DepartmentName.CIVIL,60,60,0,sjceCivilReservation));
            add(new Department(DepartmentName.EEE,60,60,0,sjceEeeReservation));
            add(new Department(DepartmentName.MECH,60,60,0,sjceMechReservation));
        }};

        ArrayList<Department> rmkDepartmentList=new ArrayList<Department>(){{
            add(new Department(DepartmentName.CSE,180,180,0,sjceCseReservation));
            add(new Department(DepartmentName.ECE,180,180,0,rmkEceReservation));
            add(new Department(DepartmentName.IT,60,60,0,rmkItReservation));
            add(new Department(DepartmentName.CIVIL,60,60,0,rmkCivilReservation));
            add(new Department(DepartmentName.EEE,180,180,0,rmkEeeReservation));
            add(new Department(DepartmentName.MECH,180,180,0,rmkMechReservation));
        }};

        ArrayList<Department> cegDepartmentList=new ArrayList<Department>(){{
            add(new Department(DepartmentName.CSE,60,60,0,cegCseReservation));
            add(new Department(DepartmentName.ECE,60,60,0,cegEceReservation));
            add(new Department(DepartmentName.IT,60,60,0,cegItReservation));
            add(new Department(DepartmentName.CIVIL,60,60,0,cegCivilReservation));
            add(new Department(DepartmentName.EEE,60,60,0,cegEeeReservation));
            add(new Department(DepartmentName.MECH,120,120,0,cegMechReservation));
        }};

        collegeList.add(new College(1317,"SJCE",sjceDepartmentList, sjceAdmittedCandidates,"Chennai", CollegeType.SELF_FINANCE,"sjce@gmail.com"));
        collegeList.add(new College(1113,"RMK",rmkDepartmentList, rmkAdmittedCandidates,"Chennai",CollegeType.AUTONOMOUS,"rmk@gmail.com"));
        collegeList.add(new College(1000,"CEG",cegDepartmentList, coeAdmittedCandidates,"Chennai",CollegeType.UNIVERSITY_DEPT,"ceg@annauniv.edu.in"));
    }

    public College getCollegeData(String mail){
        for (College college: collegeList) {
            if(college.getMail().equals(mail)){
                return college;
            }
        }
        return new College();
    }

    public College getCollegeDetails(int code){
        for(College college:collegeList){
            if(college.getCounsellingCode()==code){
                return college;
            }
        }
        return null;
    }

    public ArrayList<College> getCollegeList() {
        return collegeList;
    }

}
