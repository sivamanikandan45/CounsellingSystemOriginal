package com.view;

import com.model.*;

import java.util.ArrayList;
import java.util.Scanner;

public class SystemUI implements Menu{
    Scanner sc=new Scanner(System.in);
    public int getLoginOption() {
        while(true){
            System.out.println("***Welcome to Single Window Engineering Admission System***");
            System.out.println("\nSelect option \n1. Candidate Login \n2. Institutional Login\n3. Admin Login");
            if(sc.hasNext("[1-3]")){
                return sc.nextInt();
            }
            else{
                System.out.println("Enter the valid option");
                sc.next();
            }
        }
    }

    @Override
    public int getOption() {
        return this.getLoginOption();
    }
}
