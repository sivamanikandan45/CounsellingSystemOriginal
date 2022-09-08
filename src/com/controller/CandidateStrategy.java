package com.controller;

import com.model.*;
import com.Enum.CandidateOption;
import com.view.CandidateUI;


public class CandidateStrategy implements Strategy {
    private CandidateUI ui;
    private CandidateList candidateList;
    private CollegeList collegeList;
    private ChoiceListMenu choiceListHandler=new ChoiceListHandler();
    private String userName;

    public CandidateStrategy(CandidateUI candidateUI, CandidateList candidateList, CollegeList collegeList, AllotmentMenu handler, String userName) {
        this.ui =candidateUI;
        this.candidateList = candidateList;
        this.collegeList=collegeList;
        this.userName=userName;
    }

    @Override
    public void execute() {
        /*System.out.println("\n***Student Main Page***");
        int mainOption = ui.getMainMenuOption();
        CandidateMainMenuOption mainMenuOption=CandidateMainMenuOption.values()[mainOption-1];
        switch (mainMenuOption) {
            case LOGIN:
                String userName = ui.getUserName();
                String password = ui.getPassword();
                Login candidateLogin = new CandidateLogin();
                if (candidateLogin.login(userName, password)) {
                    System.out.println("Login successful");*/
                    Candidate candidate = candidateList.isCandidateAvailable(userName) ? candidateList.getCandidateData(userName) : new Candidate();
                    label:
                    while (true) {
                        int candidateOption = ui.getOption();
                        CandidateOption option = CandidateOption.values()[candidateOption - 1];
                        switch (option) {
                            case FILL_APPLICATION:
                                System.out.println(ui.fillApplication(candidateList, candidate, userName) ? "Application submitted" : "Already filled");
                                break;
                            case VIEW_PROFILE:
                                ui.displayProfile(candidate);
                                break;
                            case FILL_CHOICE_LIST:
                                ui.displayChoiceListMenu(collegeList, candidate);
                                break;
                            case TENTATIVE_ALLOTMENT:
                                ui.displayTentativeAllotmentMenu(candidate);
                                break;
                            case FINAL_ALLOTMENT:
                                ui.displayFinalAllotment(candidate);
                                break;
                            case LOGOUT:
                                break label;
                        }
                    }
                /*} else {
                    System.out.println("Invalid login credentials");
                }
                break;
            case REGISTER:
                ui.displayRegistrationPage();
                break;*/
        //}
    }
}