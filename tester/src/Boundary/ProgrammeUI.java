/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Boundary;

/**
 *
 * @author acerc
 */
import Control.ProgrammeControl;
import Entity.Programme;
import java.util.*;

public class ProgrammeUI extends UI{
    private ProgrammeControl control;
    private Scanner scanner;
    
    public ProgrammeUI(){
        this.control = new ProgrammeControl();
        this.scanner = new Scanner(System.in);
    }
    
    public void displayPMUI(){
        int choice = 0;
        do{
        Scanner scan = new Scanner(System.in);

        System.out.print("\n==================================================");
        System.out.print("\n|              Programme Management              |");
        System.out.print("\n|                     System                     |");
        System.out.print("\n==================================================");
        System.out.print("\n");
        System.out.print("\n==================================================");
        System.out.print("\n| 1.Add A New Programme                          |");
        System.out.print("\n| 2.Remove A Programme                           |");
        System.out.print("\n| 3.Find Programme                               |");
        System.out.print("\n| 4.Amend Programme Details                      |");
        System.out.print("\n| 5.List All Programmes                          |");
        System.out.print("\n| 6.Add A Tutorial Group to A Programme          |");
        System.out.print("\n| 7.Remove A Tutorial Group From A Programme     |");
        System.out.print("\n| 8.List All Tutorial Group For A Programme      |");
        System.out.print("\n| 9.Generate Report                              |");
        System.out.print("\n| 10.Return to Main Menu                         |");
        System.out.print("\n==================================================");
        System.out.print("\n");
        System.out.print("\nEnter Choice (1-10): ");
        choice=scan.nextInt();
        
        switch (choice) {
                case 1 -> addProg();
                case 2 -> removeProg();
                case 3 -> findProg();
                case 4 -> amendProg();
                case 5 -> listProg();
                case 6 -> addTutGrpToProg();
                case 7 -> removeTutGrpFromProg();
                case 8 -> listTutGrp();
                case 9 -> genReport();
                case 10 -> {
                    System.out.println("\nExiting...");
                    return;
                }
                default -> {
                    System.out.print("\n==ERROR===========================================");
                    System.out.print("\n|                 Invalid input!                 |");
                    System.out.print("\n==================================================");
                    System.out.print("\n");
                }
        }
        }while (choice != 10);
    }
    
    private void addProg() {
        boolean cont = true;
        do{
            System.out.print("\n==================================================");
            System.out.print("\n|            Ex. Software Development            |");
            System.out.print("\n==================================================");
            System.out.print("\n");
            System.out.print("\nEnter ProgName: ");
            String progName = scanner.nextLine();

            System.out.print("\n==================================================");
            System.out.print("\n|     F - Foundation, D - Diploma, R - Degree    |");
            System.out.print("\n==================================================");
            System.out.print("\n");
            System.out.print("\nEnter EduLevel: ");
            String eduLvl = scanner.nextLine();

            control.addProg(progName, eduLvl);

            System.out.print("\nDo you want to add more programme(s)? (Y/N): ");
            String bool = scanner.nextLine().toUpperCase();
            if("N".equals(bool)){
                cont = false;
            }
            else if("Y".equals(bool)){
            }
            else{
                System.out.print("\n==ERROR===========================================");
                System.out.print("\n|                 Invalid input!                 |");
                System.out.print("\n==================================================");
                System.out.print("\n");
            }
        }while (cont != false);
    }

    private void removeProg() {
        boolean cont = true;
        do{
            System.out.print("\n==================================================");
            System.out.print("\n|                    Ex. RSD                     |");
            System.out.print("\n==================================================");
            System.out.print("\n");
            System.out.print("\nEnter ProgID: ");
            String progID = scanner.nextLine();

            control.removeProg(progID);
            
            System.out.print("\nDo you want to delete more programme(s)? (Y/N): ");
            String bool = scanner.nextLine().toUpperCase();
            if("N".equals(bool)){
                cont = false;
            }
            else if("Y".equals(bool)){
            }
            else{
                System.out.print("\n==ERROR===========================================");
                System.out.print("\n|                 Invalid input!                 |");
                System.out.print("\n==================================================");
                System.out.print("\n");
            }
        }while(cont!=false);
    }
    
    private void findProg(){
        boolean cont = true;
        do{
            System.out.print("\n==================================================");
            System.out.print("\n|                    Ex. RSD                     |");
            System.out.print("\n==================================================");
            System.out.print("\n");
            System.out.print("Enter ProgID:");
            String progID = scanner.nextLine();
            
            Programme prog = control.findProg(progID);
            
            if(prog!=null){
                System.out.print("\n==INFO============================================");
                System.out.print("\n|                Programme Found.                |");
                System.out.print("\n==================================================");
                System.out.print("\n");
            }
            else{
                System.out.print("\n==ERROR===========================================");
                System.out.print("\n|              Programme Not Found!              |");
                System.out.print("\n==================================================");
                System.out.print("\n");
            }
        }while(cont!=false);
        
    }
    
    private void amendProg() {
        System.out.print("\n==================================================");
        System.out.print("\n|                    Ex. RSD                     |");
        System.out.print("\n==================================================");
        System.out.print("\n");
        System.out.print("Enter ProgID: ");
        String progID = scanner.nextLine();
        
        System.out.print("\n==================================================");
        System.out.print("\n|     F - Foundation, D - Diploma, R - Degree    |");
        System.out.print("\n==================================================");
        System.out.print("\n");
        System.out.print("Enter EduLvl: ");
        String eduLvl = scanner.nextLine();
        System.out.print("\n==================================================");
        System.out.print("\n|            Ex. Software Development            |");
        System.out.print("\n==================================================");
        System.out.print("\n");
        System.out.print("Enter new ProgName: ");
        String newProgName = scanner.nextLine();

        boolean amended = control.amendProg(progID, eduLvl, newProgName);
        
        if (amended) {
            System.out.print("\n==INFO============================================");
            System.out.print("\n|        Programme amended successfully.         |");
            System.out.print("\n==================================================");
            System.out.print("\n");
        } 
        else {
            System.out.print("\n==ERROR===========================================");
            System.out.print("\n|              Programme not found.              |");
            System.out.print("\n==================================================");
            System.out.print("\n");
        }
    }

    private void listProg() {
        System.out.print("\n==================================================");
        System.out.print("\n|               List of Programmes:              |");
        System.out.print("\n==================================================");
        System.out.print("\n");
        
        control.listProg();
    }
    
    private void addTutGrpToProg(){
        System.out.print("\n==================================================");
        System.out.print("\n|                    Ex. RSD                     |");
        System.out.print("\n==================================================");
        System.out.print("\n");
        System.out.print("Enter ProgID: ");
        String progID = scanner.nextLine();
        System.out.print("\n==================================================");
        System.out.print("\n|                  Ex. Group 1                   |");
        System.out.print("\n==================================================");
        System.out.print("\n");
        System.out.print("Enter Group: ");
        String grpName = scanner.nextLine();
        
        control.addTutGrpToProg(grpName, progID);
    }
         
    private void removeTutGrpFromProg(){
        System.out.print("\n==================================================");
        System.out.print("\n|                    Ex. RSD                     |");
        System.out.print("\n==================================================");
        System.out.print("\n");
        System.out.print("Enter ProgID: ");
        String progID = scanner.nextLine();
        System.out.print("\n==================================================");
        System.out.print("\n|                  Ex. Group 1                   |");
        System.out.print("\n==================================================");
        System.out.print("\n");
        System.out.print("Enter Group: ");
        String grpName = scanner.nextLine();
        
        control.removeTutGrpFromProg(grpName, progID);
    }
    
    private void listTutGrp(){
        System.out.print("\n==================================================");
        System.out.print("\n|               List of Groups:                  |");
        System.out.print("\n==================================================");
        System.out.print("\n");
        control.listTutGrp();
    }
    
    private void genReport(){
        System.out.print("\n==================================================");
        System.out.print("\n|               List of Groups:                  |");
        System.out.print("\n==================================================");
        System.out.print("\n");
        control.genReport();
    }
}
