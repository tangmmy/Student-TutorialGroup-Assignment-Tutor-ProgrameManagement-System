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
    private LinkedList<TutorialGrp> tutGrp;
    private Scanner scan = new Scanner(System.in);

    public ProgrammeControl() {
        this.programmeLists = new LinkedList<>();
        this.tutGrp = new LinkedList<>();
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
            System.out.println("\nTutorial Group created successfully.");
        } else {
            System.out.println("\nProgram with ID " + progID + " not found.");
        }
    }
    
    public void removeTutGrpFromProg(String grpName, String progID) {
    //boolean programFound = false; // Flag to check if the program was found
    Programme prog = null;
    ListIterator<Programme> iterator = programmeLists.listIterator();
    
    while (iterator.hasNext()) {
        Programme currentProg = iterator.next();

        //String str = prog.getProgID();
        System.out.println(progID);
        if (currentProg.getProgID().equals(progID)) {
            //programFound = true; // Program found, set the flag to true
            prog = currentProg;
            System.out.println("?");
            /*ListIterator<TutorialGrp> Titerator = tutGrp.listIterator();
            System.out.println(Titerator);
            while (Titerator.hasNext()) {
                TutorialGrp grpName = Titerator.next();
                String grp = grpName.getGrpName();
                System.out.println(grp);
                if (grp.equals(tutToFind)) {
                    Titerator.remove(); // Remove the tutorial group
                    System.out.println("Deleted");
                    break; // Exit the inner loop since the group was found and removed
                }
            }*/
        }
    } 
    
    if(prog !=null){
            String grp = grpName;
            TutorialGrp grpToRemove = new TutorialGrp(grp);
            prog.removeTutorialGroup(grpToRemove);
            System.out.println("Deleted");
    }
    else{
        System.out.println("Program not found");        
    }
}

    public void listTutGrp() {
    int i = 0;
    ListIterator<Programme> progIterator = programmeLists.listIterator();
    
    while(progIterator.hasNext()){
        Programme prog = progIterator.next();
        ListIterator<TutorialGrp> iterator = prog.getTutGrp().listIterator();
        
        while(iterator.hasNext()){
            TutorialGrp grpName = iterator.next();
            
            i++;
            System.out.println(i + "." + grpName + ", " + prog);
        }
    }
}

}
