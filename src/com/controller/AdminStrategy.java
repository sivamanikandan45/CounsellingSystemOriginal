package com.controller;

import com.Enum.CollegeType;
import com.Enum.CommunityType;
import com.Enum.DepartmentName;
import com.Helper.CutOffCalculator;
import com.model.*;
import com.Enum.AdminOption;
import com.view.AdminUI;

import java.util.*;

public class AdminStrategy implements Strategy{
    private final AdminUI ui;
    private CandidateList candidates;
    private CollegeList colleges;
    /*private boolean randomNoAssigned;
    private boolean rankGenerated=false;
    private boolean seatAllotted=false;
    private boolean cutoffAssigned=false;*/
    private AllotmentMenu handler;
    private AdminState state;
    private CutOffCalculator cutOffCalculator;
    public AdminStrategy(AdminUI adminUI, CandidateList candidates, CollegeList colleges, AllotmentMenu handler, AdminState state) {
        this.ui = adminUI;
        this.candidates=candidates;
        this.colleges=colleges;
        this.handler=handler;
        this.state=state;
        cutOffCalculator=new CutOffCalculator();
    }
    @Override
    public void execute() {
        /*System.out.println("Admin login");
        String userName = ui.getUserName();
        String password = ui.getPassword();
        Login adminLogin =new AdminLogin();
        if (adminLogin.login(userName, password)) {
            System.out.println("Login successful");*/
            Admin admin=(state.getAdminStatus()==null)?new Admin(): state.getAdminStatus();
            //Admin admin=new Admin();
            label:
            while (true) {
                int adminOption = ui.getOption();
                AdminOption option=AdminOption.values()[adminOption-1];
                switch (option) {
                    case ADD_COLLEGE:
                        System.out.println(this.addCollege(colleges.getCollegeList()) ? "Successfully added" : "Unable to Add");
                        break;
                    case VIEW_COLLEGE:
                        int code = ui.getCollegeCode();
                        ui.displayCollegeDetails(colleges.getCollegeDetails(code));
                        break;
                    case VIEW_STUDENTS:
                        ui.displayStudentList(candidates);
                        break;
                    case VIEW_ALL_COLLEGES:
                        ui.displayCollegeList(colleges);
                        break;
                    case GENERATE_CUTOFF:
                        checkAndAssignCutOff(admin);
                        break;
                    case GENERATE_RANDOM_NO:
                        checkAndAssignRandomNo(admin);
                        break;
                    case GENERATE_RANK:
                        checkAndAssignRank(admin);
                        break;
                    case ALLOCATE_SEAT:
                        checkAndAllocateSeat(admin);
                        break;
                    case VIEW_FINAL_ALLOTMENTS:
                        viewFinalAllotment(admin);
                        break;
                    case LOGOUT:
                        state.saveState(admin);
                        break label;
                }
            }
       /* } else {
            System.out.println("Invalid login credentials");
        }*/
    }

    private boolean addCollege(ArrayList<College> collegeList) {
        ArrayList<Candidate> msecAdmittedCandidates =new ArrayList<>();
        ArrayList<ReservationCommunity> msecCseCategories=new ArrayList<ReservationCommunity>(){{
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
        ArrayList<ReservationCommunity> msecItCategories=new ArrayList<ReservationCommunity>(){{
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
        ArrayList<ReservationCommunity> msecEeeCategories=new ArrayList<ReservationCommunity>(){{
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
        ArrayList<ReservationCommunity> msecEceCategories=new ArrayList<ReservationCommunity>(){{
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
        ArrayList<ReservationCommunity> msecMechCategories=new ArrayList<ReservationCommunity>(){{
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
        ArrayList<ReservationCommunity> msecCivilCategories=new ArrayList<ReservationCommunity>(){{
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
        ArrayList<Department> mecDepartmentList=new ArrayList<Department>(){{
            add(new Department(DepartmentName.CSE,60,60,0,msecCseCategories));
            add(new Department(DepartmentName.ECE,120,120,0,msecEceCategories));
            add(new Department(DepartmentName.IT,60,60,0,msecItCategories));
            add(new Department(DepartmentName.EEE,60,60,0,msecEeeCategories));
            add(new Department(DepartmentName.CIVIL,60,60,0,msecCivilCategories));
            add(new Department(DepartmentName.MECH,60,60,0,msecMechCategories));

        }};
        collegeList.add(new College(1319,"MSEC",mecDepartmentList, msecAdmittedCandidates,"Chennai", CollegeType.SELF_FINANCE,"msec@gmail.com"));
        //Registers a new college user and username and password
        String username="msec@gmail.com";
        String password="1234";

        Register collegeRegister=new CollegeRegister();
        return collegeRegister.registerAccount(username,password);
    }

    private void checkAndAllocateSeat(Admin admin) {
        if(admin.isCutoffAssigned()&&admin.isRandomNoAssigned()&&admin.isRankGenerated()){
            if(!admin.isSeatAllotted()){
                if(this.allocateSeat(colleges,candidates)){
                    System.out.println("Seats Allotted Successfully");
                    admin.setSeatAllotted(true);
                }else{
                    System.out.println("Error while allotting..");
                }
            }else{
                System.out.println("Already allotted");
            }
        }else{
            System.out.println("Generate Random no / Rank");
        }
    }

    private boolean allocateSeat(CollegeList colleges, CandidateList candidates) {
            for(Candidate candidate:candidates.getCandidateList()){
                ArrayList<Choice> choiceOfStudent = candidate.getMyChoices().getPreferredChoices();
                for(Choice choice : choiceOfStudent){
                    if(!candidate.isTentativeAllotmentAssigned()){
                        int code= choice.getCounsellingCode();
                        College college=colleges.getCollegeDetails(code);
                        HashMap<DepartmentName, HashMap> departmentWiseSeats=college.getSeatAvailability(candidate.getCommunity());
                        HashMap<CommunityType,Integer> categoryWiseSeats=departmentWiseSeats.get(choice.getDepartmentName());
                        for (Map.Entry<CommunityType,Integer> availableSeats: categoryWiseSeats.entrySet()) {
                            if(availableSeats.getValue()>0){
                                HashMap<College,HashMap> tentative=new HashMap<>();
                                HashMap<DepartmentName, CommunityType> DepartmentAndCategory=new HashMap<>();
                                DepartmentAndCategory.put(choice.getDepartmentName(),availableSeats.getKey());
                                tentative.put(college,DepartmentAndCategory);
                                candidate.setTentativeAllotment(tentative);
                                break;
                                //return true;
                            }
                        }
                    }
                }
            }
            return true;
    }

    private void checkAndAssignRank(Admin admin) {
        if(admin.isCutoffAssigned()&&admin.isRandomNoAssigned()){
            if(!admin.isRankGenerated()){
                this.allocateRank(candidates);
                System.out.println("Rank generated successfully");
                admin.setRankGenerated(true);
                //rankGenerated=true;
            }else{
                System.out.println("Already generated");
            }
        }else{
            System.out.println("Random Number/Cutoff is not assigned");
        }
    }

    private void allocateRank(CandidateList candidates) {
        ArrayList<Candidate> candidateList=candidates.getCandidateList();
        Collections.sort(candidateList, Comparator.comparing(Candidate::getCutoff).thenComparing(Candidate::getTotalMark).reversed().thenComparing(Candidate::getDob).reversed().thenComparing(Candidate::getRandomNo).reversed());//
        int rank=1;
        for (Candidate candidate :candidateList) {
            candidate.getAcademicDetails().setRank(rank++);
        }
    }

    private void checkAndAssignRandomNo(Admin admin) {
        if(!admin.isRandomNoAssigned()){
            if(this.generateRandomNo(candidates)){
                System.out.println("Random Number assigned to each student successfully");
                //randomNoAssigned=true;
                admin.setRandomNoAssigned(true);
            }else{
                System.out.println("Error while Assigning");
            }
        }else{
            System.out.println("Already assigned");
        }
    }

    private boolean generateRandomNo(CandidateList candidates) {
        for(Candidate candidate: candidates.getCandidateList()){
            int randomNo=(int)(Math.random()*(1000-900+1)+1000);
            candidate.getAcademicDetails().setRandomNo(randomNo);
        }
        return true;
    }

    private void viewFinalAllotment(Admin admin){
        if(admin.isCutoffAssigned()&&admin.isRandomNoAssigned()&&admin.isRankGenerated()){
            if(admin.isSeatAllotted()){
                if(handler.isEmptyAllotmentList()){
                    System.out.println("No records found");
                }else{
                    System.out.println("ApplicationNo\tName\tCollegeName\tDepartment\tQuota\t\tAdmissionID");
                    for(Allotment allotment:handler.getSeatAllottedStudents()){
                        System.out.println(allotment.getApplicationNo()+"\t\t"+ allotment.getCandidateName()+"\t"+ allotment.getCollegeName()+"\t\t\t"+allotment.getDepartment()+"\t\t\t"+ allotment.getQuota()+"\t"+ allotment.getAdmissionID());
                    }
                }
            }else{
                System.out.println("Seats should be allocated");
            }
        }else{
            System.out.println("Generate Random no / Rank / Cut- Off");
        }
    }

    private void checkAndAssignCutOff(Admin admin) {
        if(!admin.isCutoffAssigned()){
            if(this.calculateAndAssignCutOff(candidates)){
                System.out.println("Cut-Off assigned Successfully");
                //cutoffAssigned=true;
                admin.setCutoffAssigned(true);
            }else{
                System.out.println("Error while Assigning");
            }
        }else{
            System.out.println("Already assigned");
        }
    }

    private boolean calculateAndAssignCutOff(CandidateList candidates) {
        for(Candidate candidate: candidates.getCandidateList()){
            AcademicDetails academic=candidate.getAcademicDetails();
            double cutoff=cutOffCalculator.calculateCutOff(academic.getMathsMark(),academic.getChemistryMark(), academic.getPhysicsMark());
            candidate.getAcademicDetails().setCutoff(cutoff);
        }
        return true;
    }
}