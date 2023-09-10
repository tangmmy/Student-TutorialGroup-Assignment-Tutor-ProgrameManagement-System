/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

/**
 *
 * @author acerc
 */
import ADT.LinkedList;
import ADT.ListIterator;
import Entity.Programme;
import Entity.TutorialGrp;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ProgrammeControl {
    private LinkedList<Programme> programmeLists;
    private LinkedList<TutorialGrp> tutorialGrp;
    private Scanner scan = new Scanner(System.in);

    public ProgrammeControl() {
        this.programmeLists = new LinkedList<>();
    }
    
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

    public String genProgID(String progName, String eduLvl) {
        String initials = getInitials(progName);
        if (eduLvl.equals("F") || eduLvl.equals("D") || eduLvl.equals("R")) {
            String progID = eduLvl + initials;
            return progID;
        } else {
            return null;
        }
    }

    public String getInitials(String progName) {
        int idxLastWhitespace = progName.lastIndexOf(' ');
        return progName.substring(0, 1) + progName.substring(idxLastWhitespace + 1, idxLastWhitespace + 2);
    }

    public String genEduName(String eduLvl){
        String eduName;
        if(eduLvl.equals("F")){
            return eduName = "Foundation";
        }
        else if(eduLvl.equals("D")){
            return eduName = "Diploma";
        }
        else if(eduLvl.equals("R")){
            return eduName = "Degree";
        }
        else return eduName = null;
    }
    
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
    
    public void listProg(){
        ListIterator<Programme> iterator = programmeLists.listIterator();
       
        while(iterator.hasNext()){
            Programme progID = iterator.next();
            int i=0; i++;
            System.out.println(i + ". " + progID);
        }
    }
    
    /*public void addTutGrpToProg(String grpName, String progID){
        
        TutorialGrp group = findGrp(grpName);
        if (grpName != null) {
            TutorialGrp newGrp = new TutorialGrp(grpName);
            tutorialGrp.addFirst(newGrp);
            System.out.println("\nTutorial Group created successfully.");
            
        } else {
            System.out.println("\nInvalid input!");
        
        }
        
        ListIterator<Programme> iterator = programmeLists.listIterator();
        Programme prog;
        while(iterator.hasNext()){
            prog=iterator.next();
            
            if(prog.getProgID().equals(progID)){
                break;
            }

        }
        TutorialGrp tutGrp=new TutorialGrp(grpName);
        prog.addTutorialGroup(tutGrp);
        
    }*/
    
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
        TutorialGrp tutGrp = new TutorialGrp(grpName);
        prog.addTutorialGroup(tutGrp);
        System.out.println("\nTutorial Group created successfully.");
    } else {
        System.out.println("\nProgram with ID " + progID + " not found.");
    }
}

}
