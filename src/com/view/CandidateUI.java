package com.view;

import com.Enum.*;
import com.controller.*;
import com.model.*;

import java.text.SimpleDateFormat;
import java.util.*;

public class CandidateUI implements Menu{
    private AllotmentMenu allotmentMenu;
    private ChoiceListMenu choiceListHandler;
    private CollegeList collegeList;
    private CandidateList candidateList;
    Scanner sc=new Scanner(System.in);

    public CandidateUI(CollegeList collegeList, CandidateList candidateList, AllotmentMenu handler, ChoiceListMenu choiceListHandler) {
        allotmentMenu =handler;
        this.choiceListHandler=choiceListHandler;
        this.candidateList=candidateList;
        this.collegeList=collegeList;
    }

    public void displayLandingPage(){
        System.out.println("\n***Student Main Page***");
        int mainOption = this.getMainMenuOption();
        CandidateMainMenuOption mainMenuOption=CandidateMainMenuOption.values()[mainOption-1];
        switch (mainMenuOption) {
            case LOGIN:
                String userName =this.getUserName();
                String password = this.getPassword();
                Login candidateLogin = new CandidateLogin();
                if (candidateLogin.login(userName, password)) {
                    System.out.println("Login successful");
                    Strategy candidateStrategy =new CandidateStrategy(this,candidateList,collegeList, allotmentMenu,userName);
                    candidateStrategy.execute();
                }else {
                    System.out.println("Invalid login credentials");
                }
                break;
            case REGISTER:
                this.displayRegistrationPage();
                break;
        }
    }

    public String getUserName() {
        while(true){
            System.out.println("Enter Username(mail id):");
            sc.nextLine();
            if(sc.hasNext("\\b[\\w.%-]+@[-.\\w]+\\.[A-Za-z]{2,4}\\b")){
                return sc.nextLine();
            }else{
                System.out.println("Enter valid Email id!!!");
                sc.next();
            }
        }
    }

    public String getPassword() {
        System.out.println("Enter Password:");
        return sc.nextLine();
    }

    public DepartmentName getDepartmentName() {
        while(true){
            System.out.println("Enter the Department");
            DepartmentName[] departmentNames = DepartmentName.values();
            for (int i = 0; i <departmentNames.length; i++) {
                System.out.println((i+1) + ". " + departmentNames[i]);
            }
            if(sc.hasNext("[1-6]")){
                int option=sc.nextInt();
                return DepartmentName.values()[option-1];
            }
            else{
                System.out.println("Enter the valid option");
                sc.next();
            }
        }
    }

    public int getCollegeCode() {
        while(true){
            System.out.println("Enter the Counselling code of the college:");
            if(sc.hasNext("[0-9][0-9][0-9][0-9]")){
                return sc.nextInt();
            }
            else{
                System.out.println("Enter the valid option");
                sc.next();
            }
        }
    }

    public int getMainMenuOption() {
        while(true){
            System.out.println("Select option \n 1. Login \n 2. Register");
            if(sc.hasNext("[1-2]")){
                return sc.nextInt();
            }
            else{
                System.out.println("Enter the valid option");
                sc.next();
            }
        }
    }

    public PersonalDetails getPersonalDetails(){
        SimpleDateFormat formatter=new SimpleDateFormat("dd/MM/yyyy");
        String name="Siva";
        String dob="14/02/2001";
        CommunityType community= CommunityType.BC;
        try{
            return new PersonalDetails(name,formatter.parse(dob),community);
        }catch(Exception e){
            return null;
        }
    }

    public AcademicDetails getAcademicDetails(){
        int HSCRegNo=12345678;
        boolean firstGraduate=true;
        int chemistry=186;
        int physics=185;
        int maths=187;
        /*int chemistry=200;
        int physics=200;
        int maths=200*/
        return new AcademicDetails(HSCRegNo,firstGraduate, chemistry,physics,maths,1128);
    }

    public boolean fillApplication(CandidateList candidateList, Candidate s, String email){
        if(!s.isApplicationFilled()){
            s.setPersonalDetails(this.getPersonalDetails());
            s.setAcademicDetails(this.getAcademicDetails());
            s.setMailId(email);
            return candidateList.addCandidate(s);
        }
        return false;
    }

    public int getCandidateMenuOption() {
        while(true){
            System.out.println("\n1. Fill Application\n2. My Profile\n3. Fill ChoiceList\n4. Tentative allotment\n5. Final Allotment\n6. Logout");
            if(sc.hasNext("[1-6]")){
                return sc.nextInt();
            }
            else{
                System.out.println("Enter the valid option");
                sc.next();
            }
        }
    }

    public void displayProfile(Candidate candidate){
        if(candidate.isApplicationFilled()){
            AcademicDetails academicDetails=candidate.getAcademicDetails();
            PersonalDetails personalDetails=candidate.getPersonalDetails();
            System.out.println("\nApplication No: " + candidate.getApplicationNo() +
                    "\n***Personal Details***\n" +
                    "Name: " + personalDetails.getName()+
                    "\nDate of Birth: " + candidate.getDob()+
                    "\nCommunity: " + personalDetails.getCommunityType()+
                    "\nEmail ID:"+candidate.getMailId()+
                    "\n***Academic Details***\n"+
                    "\nFirst Graduate: " + (academicDetails.isFirstGraduate()?"Yes":"No") +
                    "\nChemistry: " + academicDetails.getChemistryMark() +
                    "\nPhysics: " + academicDetails.getPhysicsMark() +
                    "\nMaths: " + academicDetails.getMathsMark()+
                    "\nCutoff: " + (academicDetails.isCutOffGenerated()?String.valueOf(academicDetails.getCutoff()):"Not Assigned")+
                    "\nRandom No: " + (academicDetails.isRandomNoAssigned()?String.valueOf(academicDetails.getRandomNo()):"Not Assigned")+
                    "\nRank: " + (academicDetails.isRankAssigned()?String.valueOf(academicDetails.getRank()):"Not Assigned"));
        }
        else{
            System.out.println("Kindly fill the application");
        }
    }

    public void getAddChoiceDetails(CollegeList colleges, Candidate candidate){
        CommunityType community= candidate.getCommunity();
        System.out.println("Remaining Choice: "+ candidate.getMyChoices().getRemainingChoice());
        this.displayAvailability(colleges,community);
        int code=this.getCollegeCode();
        DepartmentName departmentEnum=this.getDepartmentName();

        //System.out.println((candidate.getMyChoices()).addChoice(colleges,code,departmentEnum)?"Choice is added":"Unable to add");
        System.out.println(choiceListHandler.addChoice(candidate,colleges,code,departmentEnum)?"Choice is added":"Unable to add");
    }

    private void displayAvailability(CollegeList colleges, CommunityType community) {
        for (College college: colleges.getCollegeList()) {
            System.out.println("\nCounselling Code: "+college.getCounsellingCode()+" College Name: "+college.getCollegeName());
            HashMap<DepartmentName, HashMap> departmentWiseVacancy=college.getSeatAvailability(community);
            for (Map.Entry<DepartmentName,HashMap> entry:departmentWiseVacancy.entrySet()) {
                System.out.print(entry.getKey()+"\t");//ln
                HashMap<CommunityType,Integer> categoryWiseVacancy=entry.getValue();
                for (Map.Entry<CommunityType,Integer> communityVacancyPair: categoryWiseVacancy.entrySet()) {
                    System.out.print(communityVacancyPair.getKey()+": "+communityVacancyPair.getValue()+"\t");
                }
                System.out.println();
            }
        }
    }

    public void displayChoiceListMenu(CollegeList collegeList, Candidate candidate) {
        if(candidate.getAcademicDetails().isRankAssigned()&&candidate.getAcademicDetails().isCutOffGenerated()&&candidate.getAcademicDetails().isRandomNoAssigned()){
            if(candidate.isApplicationFilled()){
                label:
                while(true){
                    int choiceListOption=this.getChoiceListMenuOption();
                    ChoiceListOption option=ChoiceListOption.values()[choiceListOption-1];
                    switch (option) {
                        case VIEW_CHOICE_LIST:
                            this.displayChoiceList(candidate);
                            break;
                        case ADD_CHOICE:
                            this.displayAddChoicePage(collegeList, candidate);
                            break;
                        case REMOVE_CHOICE:
                            this.displayDeleteChoicePage(candidate);
                            break;
                        case REORDER_CHOICE:
                            this.displayReorderPage(candidate);
                            break;
                        case LOCK_CHOICE:
                            System.out.println(choiceListHandler.isLocked(candidate) ? "ALREADY LOCKED" : choiceListHandler.lockChoice(collegeList, candidate) ? "Choice is Locked" : "Unable to lock!! Kindly fill the Choice list");
                            break;
                        case BACK:
                            break label;
                    }
                }
            }
            else{
                System.out.println("Kindly fill the Application");
            }
        } else{
            System.out.println("CutOff/Random No/Rank list is not published");
        }
    }

    private void displayReorderPage(Candidate candidate) {
        if(choiceListHandler.isEmpty(candidate)){
            System.out.println("Choice list is empty...!!!");
        }else{
            if(candidate.getMyChoices().isLocked()){
                System.out.println("Choice list is locked...!!!");
            }else{
                int[] sequence =this.getReorderSequence(candidate);
                int lengthOfSequence= candidate.getMyChoices().getPreferredChoices().size();
                //System.out.println(!this.isValidSequence(sequence,lengthOfSequence)?"Invalid Order Sequence": candidate.getMyChoices().reOrderChoice(sequence)?"Successfully Reordered":"Unable to re Order");
                System.out.println(!this.isValidSequence(sequence,lengthOfSequence)?"Invalid Order Sequence": choiceListHandler.reOrderChoice(candidate,sequence)?"Successfully Reordered":"Unable to re Order");
            }
        }
    }

    private void displayDeleteChoicePage(Candidate candidate) {
        if(choiceListHandler.isLocked(candidate)){
            System.out.println("Choice list is locked...!!!");
        }else if(choiceListHandler.isEmpty(candidate)){
            System.out.println("Choice list is empty...!!!");
        }else{
            this.getChoiceToDelete(candidate);
        }
    }

    private void displayAddChoicePage(CollegeList collegeList, Candidate candidate) {
        if(choiceListHandler.isLocked(candidate)){
            System.out.println("Choice list is locked...!!!");
        }else{
            this.getAddChoiceDetails(collegeList, candidate);
        }
    }

    private boolean isValidSequence(int[] sequence, int length) {
        for(int i=0;i<length;i++){
            if(sequence[i]>length||sequence[i]<=0){
                return false;
            }
        }
        return true;
    }

    private int getChoiceListMenuOption() {
        while(true){
            System.out.println("1. View Choice List\n2. Add choice\n3. Remove Choice\n4. ReOrder Choice list\n5. Lock Choice\n6. Back");
            if(sc.hasNext("[1-6]")){
                return sc.nextInt();
            }
            else{
                System.out.println("Enter the valid option");
                sc.next();
            }
        }
    }

    private void displayChoiceList(Candidate candidate) {
        //ArrayList<Choice> preferredChoices = candidate.getMyChoices().getPreferredChoices();
        if(choiceListHandler.isEmpty(candidate)){
            System.out.println("Choice List is empty");
        }else{
            System.out.println("Remaining Choice: "+ candidate.getMyChoices().getRemainingChoice());
            System.out.println("Priority\tCounselling Code\tCollege Name\tDepartment");
            for (Choice choice : choiceListHandler.getPreferredChoices(candidate)) {
                System.out.println(choice.getPriority()+"\t\t\t"+ choice.getCounsellingCode()+"\t\t\t\t"+ choice.getCollegeName()+"\t\t\t"+ choice.getDepartmentName());
            }
        }
    }

    private int[] getReorderSequence(Candidate candidate) {
        System.out.println("Enter the new Order:");
        int[] sequence =new int[3];
        try{
        for(int index = 0; index< choiceListHandler.getPreferredChoices(candidate).size(); index++){
            sequence[index]=sc.nextInt();
        }
        }catch (InputMismatchException exception){
            //System.out.println("exception");
            return sequence;
        }
        return sequence;
    }

    public void getChoiceToDelete(Candidate candidate){
        System.out.println("Priority\tCounselling Code\tCollege Name\tDepartment");
        for (Choice choice : choiceListHandler.getPreferredChoices(candidate)) {
            System.out.println(choice.getPriority()+"\t\t\t"+ choice.getCounsellingCode()+"\t\t\t\t"+ choice.getCollegeName()+"\t\t\t"+ choice.getDepartmentName());
        }
        int code=this.getCollegeCode();
        DepartmentName departmentName=this.getDepartmentName();
        //System.out.println((candidate.getMyChoices()).removeChoice(code,departmentName)?"Choice is deleted":"Unable to delete");
        System.out.println(choiceListHandler.removeChoice(candidate,code,departmentName)?"Choice is deleted":"Unable to delete");
    }

    public void displayTentativeAllotmentMenu(Candidate candidate) {
        if(!(candidate.getAcademicDetails().isRankAssigned()&&candidate.getAcademicDetails().isCutOffGenerated()&&candidate.getAcademicDetails().isRandomNoAssigned())) {
            System.out.println("CutOff/Random No/Rank list is not published");
        }
        else if(!candidate.isTentativeAllotmentAssigned()){
            System.out.println("Tentative Allotment is not published");
        }
        else if(!choiceListHandler.isLocked(candidate)){
            System.out.println("Kindly fill and lock the choice list");
        }else{
            String collegeName=null;
            DepartmentName department=null;
            CommunityType category=null;
            CollegeType type=null;
            College college=null;
            if(!candidate.isTentativeConfirmed()){
                if(candidate.getTentativeAllotment()==null){
                    System.out.println("Fill the choice list");
                }else{
                    HashMap<College, HashMap> allotment= candidate.getTentativeAllotment();
                    for (Map.Entry<College,HashMap> entry:allotment.entrySet()) {
                        college=entry.getKey();
                        collegeName=entry.getKey().getCollegeName();
                        type=entry.getKey().getType();
                        System.out.println("College Name:"+collegeName);
                        HashMap<DepartmentName, CommunityType> details=entry.getValue();
                        for (Map.Entry<DepartmentName, CommunityType> departmentNameCategoryNameEntry:details.entrySet()) {
                            department=departmentNameCategoryNameEntry.getKey();
                            category=departmentNameCategoryNameEntry.getValue();
                            System.out.println("Department:"+department);
                            System.out.println("Category:"+category);
                        }
                    }
                    int confirmation=this.getConfirmation();
                    Confirmation confirm=Confirmation.values()[confirmation-1];
                    switch (confirm) {
                        case ACCEPT:
                            candidate.acceptOffer();
                            System.out.println("You have accepted the Tentative allotment");
                            allotmentMenu.handleConfirmedAllotment(candidate, collegeName, department, category, type, college);
                            break;
                        case REJECT:
                            allotmentMenu.handleRejectedAllotment(candidate);
                            System.out.println("You have rejected the Tentative allotment");
                            break;
                    }
                }
            }else{
                System.out.println("You've already responded to the Tentative Allotment");
            }
        }
    }

    private int getConfirmation() {
        while(true){
            System.out.println("1. Accept Offer\n2. Reject Offer\nEnter your Choice:");
            if(sc.hasNext("[1-2]")){
                return sc.nextInt();
            }
            else{
                System.out.println("Enter the valid option");
                sc.next();
            }
        }
    }

    public void displayFinalAllotment(Candidate candidate) {
        System.out.println(!candidate.isApplicationFilled()?"Kindly fill the Application":!candidate.getMyChoices().isLocked()?"Kindly fill and lock the choice list":!candidate.isTentativeConfirmed()?"Kindly respond to the Tentative allotment": candidate.isTentativeAccepted()? candidate.getFinalAllotment().toString():"You have rejected the tentative allotment");
    }

    public void displayRegistrationPage() {
        String userName,password = null,reEnteredPassword;
        boolean valid=false;
        while(true){
            System.out.println("Enter Username(mail id):");
            sc.nextLine();
            if(sc.hasNext("\\b[\\w.%-]+@[-.\\w]+\\.[A-Za-z]{2,4}\\b")){
                userName=sc.nextLine();
                break;
            }else{
                System.out.println("Enter valid Email id!!!");
                sc.next();
            }
        }
        /*System.out.println("Enter Username(e-mail id):");
        sc.nextLine();*/

        //userName=sc.nextLine();

        while(!valid){
            System.out.println("Enter Password:");
            password=sc.nextLine();
            System.out.println("Re-enter Password:");
            reEnteredPassword=sc.nextLine();
            if(!password.equals(reEnteredPassword)){
                System.out.println("Password not matching!!!");
                continue;
            }
            valid=true;
        }
        Register candidateRegister =new CandidateRegister();
        System.out.println(candidateRegister.registerAccount(userName,password)?"Successfully created":"Unable to process");
    }

    @Override
    public int getOption() {
        return this.getCandidateMenuOption();
    }
}
