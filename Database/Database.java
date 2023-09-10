/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

/**
 *
 * @author tangm
 */
import ADT.LinkedList;
import java.util.Scanner;
import java.io.*;
import ADT.*;
import Entity.*;

public class Database {
    
    private String staff_path = "./src/Database/staff.txt";
    private String student_path="./src/Database/student.txt";

    private File staff;
    private Scanner staff_scanner ;
    private File student;
    private Scanner student_scanner;

    public Database(){
        initReader();
    }

    public Database(char act){
        if (act == 'w'){}
        else initReader();
    }

    private void initReader(){
        try {
            staff = new File(staff_path);
            staff_scanner = new Scanner(staff);
            student = new File(student_path);
            student_scanner = new Scanner(student);

            

        } catch (FileNotFoundException e) {
            System.out.println("\nAn error occurred when constructing Database object.");
            e.printStackTrace();
        }
    }

    
    
    
    
    
    public String getStaffPwd(String uid){ ///////////////
        String s_staffInfo;
        String [] staffInfo;
        
        //LinkedList<Staff> staffInfo=new LinkedList<Staff>();
        while(staff_scanner.hasNextLine()){
            s_staffInfo = staff_scanner.nextLine();

            // Parse member info by ','.
            // <uid>,<pwd>,<name>
            staffInfo = s_staffInfo.split(",");
            if (uid.equals(staffInfo[0])){
                return staffInfo[1];
            }

        }

        return null;
    }
    public void getStudentInTutorialGroup(String groupName,LinkedList<Student> tutorialGroup){
        String s_studInfo;
        String [] studInfo;
        
        //LinkedList<Staff> staffInfo=new LinkedList<Staff>();
        while(student_scanner.hasNextLine()){
            s_studInfo = student_scanner.nextLine();

            // Parse member info by ','.
            // <uid>,<pwd>,<name>
            studInfo = s_studInfo.split(",");
            if (groupName.equals(studInfo[2])){
                Student S=new Student(studInfo[0],studInfo[1]);
                tutorialGroup.addFirst(S);
            }

        }

        
    }
    
    
    
}
