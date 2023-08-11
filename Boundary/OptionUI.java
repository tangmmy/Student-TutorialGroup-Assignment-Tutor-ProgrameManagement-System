/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Boundary;

/**
 *
 * @author tangm
 */
import java.util.Scanner;
import Entity.Student;
public class OptionUI extends UI{
    private int choice;
    
    public void start(){
        System.out.print("\nOption Page");
        
    }
    public OptionUI(){
        this.choice=0;
    }
    public int getChoice(){
        return this.choice;
    }
    public void displayOptionUI(){
        Scanner scan = new Scanner(System.in);

        System.out.print("\n1.Manage a tutorial group");
        System.out.print("\n100.Exit ");
        System.out.print("\nEnter choice:");
        this.choice=scan.nextInt();
        System.out.println();
    }

    public void makeOption(){
        Scanner scan=new Scanner(System.in);
        displayOptionUI();
        String Name;
        if(this.choice==1){
            System.out.print("\nEnter the tutorial group name (Ex:RSD1G1): ");
            Name=scan.next();
            TutorialManageStudentUI tmui=new TutorialManageStudentUI(Name);
            
            tmui.doSomething();
        }
        else{
            System.out.print("Not done yet!\n");
        }
        
        

    }

    
}
