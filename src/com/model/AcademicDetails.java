package com.model;

public class AcademicDetails {
    private int HSCRegNo;
    private boolean firstGraduate;
    private double totalMarks;
    private double chemistryMark;
    private double physicsMark;
    private double mathsMark;
    private double cutoff;
    private int rank;
    private int randomNo;

    private boolean CutOffGenerated=false;
    private boolean rankAssigned=false;
    private boolean randomNoAssigned=false;

    public AcademicDetails(int HSCRegNo,boolean firstGraduate,double chemistry,double physics,double maths,double total){
        //initializes the academic details of the student
        this.HSCRegNo=HSCRegNo;
        this.firstGraduate =firstGraduate;
        chemistryMark =chemistry;
        physicsMark =physics;
        mathsMark =maths;
        totalMarks=total;
    }

    public double getPhysicsMark() {
        //return marks obtained in physics
        return physicsMark;
    }

    public double getMathsMark() {
        //return marks obtained in Maths
        return mathsMark;
    }

    public double getChemistryMark() {
        //return marks obtained in Chemistry
        return chemistryMark;
    }

    public double getTotalMarks() {
        return totalMarks;
    }

    public int getRank() {
        return rank;
    }

    public int getRandomNo() {
        return randomNo;
    }

    public double getCutoff() {
        return cutoff;
    }

    public void setRandomNo(int randomNo) {
        this.randomNo = randomNo;
        this.randomNoAssigned=true;
    }

    public void setRank(int rank) {
        this.rank = rank;
        this.rankAssigned=true;
    }

    public void setCutoff(double cutoff) {
        this.cutoff = cutoff;
        this.CutOffGenerated=true;
    }

    public boolean isCutOffGenerated() {
        return this.CutOffGenerated;
    }

    public boolean isRandomNoAssigned() {
        return randomNoAssigned;
    }

    public boolean isRankAssigned() {
        return rankAssigned;
    }

    public boolean isFirstGraduate() {
        return firstGraduate;
    }

}
