/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

/**
 *
 * @author tangm
 */
import ADT.ListIterator;
import ADT.LinkedList;
import Entity.Student;
import ADT.*;
import java.util.Scanner;
import Database.Database;
public class TutorialManageStudentControl {
    private LinkedList<Student> tutorialGroup;
    private String groupName;
    
   
    public TutorialManageStudentControl(LinkedList<Student> tutorialGroup) {
        this.tutorialGroup = tutorialGroup;
    }

    public TutorialManageStudentControl(LinkedList<Student> tutorialGroup,String groupName) {
        
        
        this.groupName = groupName;
        Database database=new Database();
        database.getStudentInTutorialGroup(groupName, tutorialGroup);
    }

    public LinkedList<Student> getTutorialGroup() {
        return tutorialGroup;
    }

    public void setTutorialGroup(LinkedList<Student> tutorialGroup) {
        this.tutorialGroup = tutorialGroup;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
    
    
    
    
    
    public void addStudent(String Name,String Id){
        Student S=new Student(Name,Id);
        tutorialGroup.addFirst(S);
    }
    public void deleteStudent(String Name,String Id){
        Student S=new Student(Name,Id);
        tutorialGroup.remove(S);
    }
    public Student findStudent(Student S){
        return S;
    }
    public void updateStudent(Student S){
        
    }
    public void printGroup(){
        ListIterator<Student> x=tutorialGroup.listIterator();
        while(x.hasNext()){
            Student element=x.next();
            System.out.print(element.toString()+" ");
        }
    }
    
}
