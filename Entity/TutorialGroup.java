/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author tangm
 */
import ADT.BinarySearchTree;
import Database.*;
public class TutorialGroup {
    
    private BinarySearchTree<Student> tutorialGroup;
    private String groupName;
    
    public TutorialGroup() {
        this.tutorialGroup=new BinarySearchTree<Student>();
        this.groupName=null;
    }

    public TutorialGroup(BinarySearchTree<Student> tutorialGroup, String groupName) {
        this.tutorialGroup = tutorialGroup;
        this.groupName = groupName;
    }

    public BinarySearchTree<Student> getTutorialGroup() {
        return tutorialGroup;
    }

    public void setTutorialGroup(BinarySearchTree<Student> tutorialGroup) {
        this.tutorialGroup = tutorialGroup;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
    
    public void addStudent(Student S){
        tutorialGroup.insert(S);
    }
    public void removeStudent(Student S){
        tutorialGroup.delete(S);
    }
    public void listAllStudent(){
        tutorialGroup.printTree(); 
    }
    public Student findStudent(String Id){
        Student S=new Student(Id),P;
        P=tutorialGroup.find(S);
        return P;
    }
}
