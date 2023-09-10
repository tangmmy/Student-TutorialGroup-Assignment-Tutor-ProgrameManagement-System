/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

/**
 *
 * @author tangm
 */
import Entity.Student;
import Entity.TutorialGroup;
import ADT.*;
import java.util.Scanner;
import Database.Database;
public class TutorialManageStudentControl {
    private TutorialGroup tutGrp;
    private String groupName;
    
   
    public TutorialManageStudentControl(TutorialGroup tutGrp) {
        this.tutGrp = tutGrp;
    }

    public TutorialManageStudentControl(TutorialGroup tutGrp,String groupName) {
        
        
        this.groupName = groupName;
        Database database=new Database();
        database.getStudentInTutorialGroup(groupName, tutGrp);
    }

    public TutorialGroup getTutorialGroup() {
        return tutGrp;
    }

    public void setTutorialGroup(TutorialGroup tutGrp) {
        this.tutGrp = tutGrp;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
    
    
    
    
    
    public void addStudent(String Name,String Id){
        Student S=new Student(Name,Id);
        tutGrp.addStudent(S);
    }
    public void deleteStudent(String Name,String Id){
        Student S=new Student(Name,Id);
        tutGrp.removeStudent(S);
    }
    public Student findStudent(String Id){
        Student S;
        S=tutGrp.findStudent(Id);
        return S;
    }
    public void updateStudent(Student S){
        
    }
    public void printGroup(){
        this.tutGrp.listAllStudent();
    }
    
}
