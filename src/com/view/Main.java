package com.view;

import com.Enum.LoginType;
import com.controller.*;
import com.model.*;


public class Main {

    public static void main(String[] args) {
        SystemUI ui=new SystemUI();
        CollegeList collegeList=new CollegeList();
        CandidateList candidateList=new CandidateList();
        AllotmentMenu handler=new AllotmentHandler();
        AdminState state=new AdminState();

        /*Strategy candidateStrategy =new CandidateStrategy(candidateList,collegeList,handler);
        Strategy collegeStrategy=new CollegeStrategy(collegeList);
        Strategy adminStrategy=new AdminStrategy(candidateList,collegeList,handler,state);
        HashMap<Integer,Strategy> context=new HashMap<Integer,Strategy>(){{
                put(1,candidateStrategy);
                put(2,collegeStrategy);
                put(3,adminStrategy);
            }};

        while(true){
            int loginOption=ui.getLoginOption();
            context.get(loginOption).execute();
        }*/
        while(true)
        {
            int loginOption=ui.getOption();
            LoginType type=LoginType.values()[loginOption-1];
            switch(type){
                case CANDIDATE:
                    CandidateUI candidateUI=new CandidateUI(collegeList,candidateList,handler,new ChoiceListHandler());
                    candidateUI.displayLandingPage();
                    /*Strategy candidateStrategy =new CandidateStrategy(candidateList,collegeList,handler);
                    candidateStrategy.execute();*/
                    break;
                case COLLEGE:
                    CollegeUI collegeUI=new CollegeUI(collegeList);
                    collegeUI.displayLandingPage();
                    /*Strategy collegeStrategy=new CollegeStrategy(collegeList);
                    collegeStrategy.execute();*/
                    break;
                case ADMIN:
                    AdminUI adminUI=new AdminUI(candidateList,collegeList,handler,state);
                    adminUI.displayLandingPage();
                    /*Strategy adminStrategy=new AdminStrategy(candidateList,collegeList,handler,state);
                    adminStrategy.execute();*/
                    break;
            }
        }
    }

}
