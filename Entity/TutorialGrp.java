 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author acerc
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
    public String toString() {
        return "Group " + grpName; 
    }
 
    @Override
    public int compareTo(TutorialGrp T){
        return this.grpName-T.grpName;
    }
    
}
