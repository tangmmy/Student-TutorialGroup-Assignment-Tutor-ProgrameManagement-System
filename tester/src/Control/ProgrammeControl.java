/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

/**
 *
 * @author HoKianHou 22WMR04120 RSD2 Group 1
 */
import ADT.LinkedList;
import ADT.ListIterator;
import Entity.Programme;
import Entity.TutorialGrp;
import java.util.Scanner;

public class ProgrammeControl {
    private LinkedList<Programme> programmeLists;
    private LinkedList<TutorialGrp> tutGrp;
    private Scanner scan = new Scanner(System.in);

    public ProgrammeControl() {
        this.programmeLists = new LinkedList<>();
        this.tutGrp = new LinkedList<>();
    }
    
    //Adding a New Programme
    public void addProg(String progName, String eduLvl) {
        String progID = genProgID(progName, eduLvl);
        if (progID != null) {
            Programme newProg = new Programme(progID);
            programmeLists.addFirst(newProg);
            System.out.print("\n==INFO============================================");
            System.out.print("\n|        Programme created successfully.         |");
            System.out.print("\n==================================================");
            System.out.print("\n");
        } else {
            System.out.print("\n==ERROR===========================================");
            System.out.print("\n|                 Invalid input!                 |");
            System.out.print("\n==================================================");
            System.out.print("\n");
            while (true) {
                System.out.print("\nEnter EduLevel: ");
                eduLvl = scan.nextLine();
                progID = genProgID(progName, eduLvl);
                if (progID != null) {
                    Programme newProg = new Programme(progID);
                    programmeLists.addFirst(newProg);
                    System.out.print("\n==INFO============================================");
                    System.out.print("\n|        Programme created successfully.         |");
                    System.out.print("\n==================================================");
                    System.out.print("\n");
                    break; // Exit the loop if a valid input is provided
                }else {
                    System.out.print("\n==ERROR===========================================");
                    System.out.print("\n|                 Invalid input!                 |");
                    System.out.print("\n==================================================");
                    System.out.print("\n");
                }
            }
        }
    }
    
    //Generating ProgrammeID through Prompted Programme Name and Education Level
    public String genProgID(String progName, String eduLvl) {
        String initials = getInitials(progName);
        if (eduLvl.equals("F") || eduLvl.equals("D") || eduLvl.equals("R")) {
            String progID = eduLvl + initials;
            return progID;
        } else {
            return null;
        }
    }

    //Getting the initials of Programme Name
    public String getInitials(String progName) {
        int idxLastWhitespace = progName.lastIndexOf(' ');
        return progName.substring(0, 1) + progName.substring(idxLastWhitespace + 1, idxLastWhitespace + 2);
    }
    
    //Removing Programme
    public boolean removeProg(String progID) {
        Programme progToRemove = findProg(progID);
            if (progToRemove != null) {
                System.out.print("\n==INFO============================================");
                System.out.print("\n|    Removing Programme with ProgrammeID: " + progID + "    |");
                System.out.print("\n==================================================");
                System.out.print("\n");
                programmeLists.remove(progToRemove);
                return true;
            }
        System.out.print("\n==ERROR===========================================");
        System.out.print("\n|    Program with ProgrammeID: " + progID + " not found.    |");
        System.out.print("\n==================================================");
        System.out.print("\n");
        return false;
    }
    
    //Finding Programme with Prompted Programme ID
    public Programme findProg(String progToFind) {
        ListIterator<Programme> iterator = programmeLists.listIterator();
        while(iterator.hasNext()){
            Programme prog = iterator.next();
            String str=prog.getProgID();
            if(str.equals(progToFind)){
                return prog;
            }
        }
        return null;
    }
    
    //Amending Specified Programme, Changing ProgrammeName and Education Level
    public boolean amendProg(String progID, String eduLvl, String newProgName){
        Programme progToAmend = findProg(progID);
        
        if (progToAmend != null) {
            System.out.print("\n==INFO============================================");
            System.out.print("\n|        Amending program with progID: " + progID + "       |");
            System.out.print("\n==================================================");
            String newProgID = genProgID(newProgName, eduLvl);
            progToAmend.setProgID(newProgID);
            return true;
        }
        return false;
    }
    
    //Listing all the Existing Programme
    public void listProg(){
        ListIterator<Programme> iterator = programmeLists.listIterator();
        int i=0;
        while(iterator.hasNext()){
            Programme progID = iterator.next();
            i++;
            System.out.println(i + ". " + progID);
        }
    }
    
    //Adding a Tutorial Group to A Programme
    public void addTutGrpToProg(String grpName, String progID) {
    Programme prog = null; // Initialize prog to null
    ListIterator<Programme> iterator = programmeLists.listIterator();

        while (iterator.hasNext()) {
            Programme currentProg = iterator.next();

            if (currentProg.getProgID().equals(progID)) {
                prog = currentProg; // Set prog to the matching program
                break;
            }
        }
        if (prog != null) {
            String grp = grpName;
            TutorialGrp newTutGrp = new TutorialGrp(grp); // Initialize tutGrp
            prog.addTutorialGroup(newTutGrp); // Add newTutGrp to the Programme's tutGrp field
            System.out.print("\n==INFO============================================");
            System.out.print("\n|       Tutorial Group created successfully.      |");
            System.out.print("\n==================================================");
            System.out.print("\n");
        } else {
            System.out.print("\n==ERROR===========================================");
            System.out.print("\n|    Program with ProgrammeID: " + progID + " not found.    |");
            System.out.print("\n==================================================");
            System.out.print("\n");
        }
    }
    
    //Remove a Tutorial Group from A Programme
    public void removeTutGrpFromProg(String grpName, String progID) {
    Programme prog = null;
    ListIterator<Programme> iterator = programmeLists.listIterator();
    
    while (iterator.hasNext()) {
        Programme currentProg = iterator.next();
        if (currentProg.getProgID().equals(progID)) {
            prog = currentProg;
        }
    } 
    
    if(prog !=null){
            String grp = grpName;
            TutorialGrp grpToRemove = new TutorialGrp(grp);
            prog.removeTutorialGroup(grpToRemove);
            System.out.print("\n==INFO============================================");
            System.out.print("\n|      Tutorial Group deleted successfully.      |");
            System.out.print("\n==================================================");
            System.out.print("\n");
    }
    else{
        System.out.print("\n==ERROR===========================================");
        System.out.print("\n|           Tutorial Group not found.            |");
        System.out.print("\n==================================================");
        System.out.print("\n");      
    }
}

    //List Existing Tutorial Groups
    public void listTutGrp(String progID) {
    int i = 0;
    ListIterator<Programme> progIterator = programmeLists.listIterator();
    Programme prog = null;
    while(progIterator.hasNext()){
        Programme currentProg = progIterator.next();
        if (currentProg.getProgID().equals(progID)) {
            prog = currentProg;
        }
        
        ListIterator<TutorialGrp> iterator = prog.getTutGrp().listIterator();
        
        while(iterator.hasNext()){
            TutorialGrp grpName = iterator.next();
            i++;
            System.out.println(i + "." + grpName);
        }
    }
}    
    //Generate Report
    public void genReport(){
        int i = 0;
        ListIterator<Programme> progIterator = programmeLists.listIterator();
    
        while(progIterator.hasNext()){
            Programme prog = progIterator.next();
            ListIterator<TutorialGrp> iterator = prog.getTutGrp().listIterator();
            while(iterator.hasNext()){
                TutorialGrp grpName = iterator.next();
                i++;
                System.out.println(i + ". " + prog +  ", " +grpName);
            }
        }
    }
}

