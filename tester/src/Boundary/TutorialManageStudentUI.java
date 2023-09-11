/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Boundary;

/**
 *
 * @author tangm
 */
import ADT.LinkedList;
import Entity.Student;
import ADT.*;
import Control.TutorialManageStudentControl;
import java.util.Scanner;

public class TutorialManageStudentUI {
    private LinkedList<Student> tutorialGroup;
    private String groupName;
    private int choice;
    public TutorialManageStudentUI() {
        
    }
    
    public TutorialManageStudentUI(String groupName) {
        this.tutorialGroup = new LinkedList<Student>();
        this.groupName = groupName;
        this.choice=0;
        TutorialManageStudentControl tmsc=new TutorialManageStudentControl(tutorialGroup,groupName); 
        
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
    public void start(){
        System.out.print("\nNow You Are In Manage "+this.groupName+" Page\n");
    }
    
    
    public void displayOption(){
        Scanner scan=new Scanner(System.in);
        
        start();
        System.out.print("\n1.Create student");
        System.out.print("\n2.Delete student");
        System.out.print("\n3.Find student");
        System.out.print("\n4.Update student");
        System.out.print("\n5.Print all students");
        System.out.print("\n6.Exit this page");
        System.out.print("\nEnter a selection: ");
        this.choice=scan.nextInt();
    }
    public void doSomething(){
        
        Scanner scan=new Scanner(System.in);
        TutorialManageStudentControl tmsc=new TutorialManageStudentControl(tutorialGroup);
        while(this.choice!=6){
            displayOption();
            String name,id;
            switch(this.choice){
                case 1://create student
                    
                    
                    //String name,id;
                    System.out.print("\nEnter Name: ");
                    name=scan.nextLine();
                    System.out.print("\nEnter id: ");
                    id=scan.nextLine();
                    tmsc.addStudent(name,id);
                    break;
                
                case 2://delete student
                    
                    //String name,id;
                    System.out.print("\nEnter Name: ");
                    name=scan.nextLine();
                    System.out.print("\nEnter id: ");
                    id=scan.nextLine();
                    tmsc.deleteStudent(name,id);
                    
                    
                    break;
                    
                
                case 3://find student
                    System.out.print("\nNot done yet!\n");
                    break;
                case 4:// update student
                    System.out.print("\nNot done yet!\n");
                    break;
                case 5://print all students
                    tmsc.printGroup();
                    break;
                        
                
                
                
            }
            
            
        }   
    }   
}