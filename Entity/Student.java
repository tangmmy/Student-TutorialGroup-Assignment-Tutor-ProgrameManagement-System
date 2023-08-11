/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author tangm
 */
public class Student {
    private String Name;
    private String studId;

    public Student(String Name, String studId) {
        this.Name = Name;
        this.studId = studId;
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
        return Name.equals(that.Name) && studId.equals(that.studId);
    }
    
}
