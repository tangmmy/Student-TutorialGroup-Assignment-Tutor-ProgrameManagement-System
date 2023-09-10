/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author tangm
 */
import java.util.Comparator; //Comparable doesnt use Comparator so this import is actually useless
public class Student implements Comparable<Student> {
    private String Name;
    private String studId;
    private String groupName;
    public Student(String studId){
        this.Name=null;
        this.studId=studId;
        this.groupName=null;
    }
    public Student(String Name, String studId) {
        this.Name = Name;
        this.studId = studId;
    }

    public Student(String Name, String studId, String groupName) {
        this.Name = Name;
        this.studId = studId;
        this.groupName = groupName;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
    

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getStudId() {
        return studId;
    }

    public void setStudId(String studId) {
        this.studId = studId;
    }
    @Override
    public String toString(){
        return this.Name+" "+this.studId;
    }
    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student that = (Student) o;
        return studId.equals(that.studId);
    }
    @Override
    public int compareTo(Student A){
        return (this.studId).compareTo(A.studId);
    }
    
}
