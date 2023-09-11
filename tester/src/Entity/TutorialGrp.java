 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author HoKianHou 22WMR04120 RSD2 Group 1
 */

import ADT.*;
    public class TutorialGrp implements Comparable<TutorialGrp>{
    private LinkedList<Student> tutorialGrp;
    private String grpName;

    public TutorialGrp() {
        this.tutorialGrp=new LinkedList<Student>();
        this.grpName=null;
    }

    public TutorialGrp(String grpName) {
        this.grpName = grpName;
    }

    public LinkedList<Student> getTutorialGrp() {
        return tutorialGrp;
    }

    public void setTutorialGrp(LinkedList<Student> tutorialGrp) {
        this.tutorialGrp = tutorialGrp;
    }

    public String getGrpName() {
        return grpName;
    }

    public void setGrpName(String grpName) {
        this.grpName = grpName;
    }
    
    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TutorialGrp that = (TutorialGrp) o;
        return grpName.equals(that.grpName);
    }
    
    @Override
    public String toString() {
        return "Group " + grpName; // + ", " + eduName + " in " + progName;
    }
    
    @Override
    public int compareTo(TutorialGrp T){
        return this.grpName-T.grpName;
    }
    
}
