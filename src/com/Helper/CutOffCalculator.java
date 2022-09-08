package com.Helper;

public class CutOffCalculator {
    public double calculateCutOff(double maths, double chem, double physics){
        //calculates and returns cutoff
        return ((maths*100)/200)+((chem*50)/200)+((physics*50)/200);
    }
}
